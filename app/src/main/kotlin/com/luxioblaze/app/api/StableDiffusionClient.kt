package com.luxioblaze.app.api

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import com.google.gson.Gson
import com.google.gson.JsonObject
import android.graphics.Bitmap
import android.util.Base64

class StableDiffusionClient(private val apiKey: String) {
    private val client = OkHttpClient()
    private val gson = Gson()

    suspend fun generateImage(
        prompt: String,
        style: String,
        width: Int = 512,
        height: Int = 512
    ): Bitmap? {
        val styledPrompt = createStyledPrompt(prompt, style)
        
        val json = JsonObject().apply {
            addProperty("prompt", styledPrompt)
            addProperty("height", height)
            addProperty("width", width)
            addProperty("num_inference_steps", 50)
            addProperty("guidance_scale", 7.5)
            addProperty("num_outputs", 1)
        }

        val request = Request.Builder()
            .url("https://api.stability.ai/v1/generation/stable-diffusion-xl-1024-v1-0/text-to-image")
            .addHeader("authorization", "Bearer $apiKey")
            .addHeader("content-type", "application/json")
            .post(json.toString().toRequestBody())
            .build()

        return try {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val body = response.body?.string() ?: ""
                parseImageResponse(body)
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun createStyledPrompt(userPrompt: String, style: String): String {
        val styleDescriptions = mapOf(
            "Fantasía" to "mystical, magical, fantasy art, enchanted, ethereal, dreamlike",
            "Gótico" to "gothic, dark, Victorian, moody, mysterious, haunting",
            "Dark Romance" to "dark romance, romantic, gothic beauty, sensual, mysterious love",
            "Minimalista" to "minimalist, clean lines, simple, modern, elegant, white space",
            "Vibrante" to "vibrant colors, bright, colorful, energetic, dynamic, vivid"
        )

        val styleDescription = styleDescriptions[style] ?: "artistic"
        return "$userPrompt, $styleDescription, high quality, professional art, trending on artstation"
    }

    private fun parseImageResponse(jsonResponse: String): Bitmap? {
        return try {
            val json = gson.fromJson(jsonResponse, JsonObject::class.java)
            val artifacts = json.getAsJsonArray("artifacts")
            if (artifacts != null && artifacts.size() > 0) {
                val base64String = artifacts.get(0).asJsonObject.get("base64").asString
                val imageBytes = Base64.decode(base64String, Base64.DEFAULT)
                android.graphics.BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
