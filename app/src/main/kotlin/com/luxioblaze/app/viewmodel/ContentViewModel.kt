package com.luxioblaze.app.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class ContentViewModel : ViewModel() {
    private val viewModelScope = CoroutineScope(Dispatchers.Main + Job())

    fun generateContent(
        prompt: String,
        style: String,
        onSuccess: (caption: String, hashtags: String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.Default) {
                    generateWithAI(prompt, style)
                }
                onSuccess(result.caption, result.hashtags)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private suspend fun generateWithAI(
        prompt: String,
        style: String
    ): ContentResult {
        return ContentResult(
            caption = "Caption generado para: $prompt en estilo $style",
            hashtags = "#$style #content #viral"
        )
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    data class ContentResult(
        val caption: String,
        val hashtags: String
    )
}
