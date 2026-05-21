package com.luxioblaze.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.luxioblaze.app.viewmodel.ContentViewModel

@Composable
fun MainScreen(viewModel: ContentViewModel = ContentViewModel()) {
    var selectedStyle by remember { mutableStateOf("Fantasía") }
    var userPrompt by remember { mutableStateOf("") }
    var generatedCaption by remember { mutableStateOf("") }
    var generatedHashtags by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val styles = listOf("Fantasía", "Gótico", "Dark Romance", "Minimalista", "Vibrante")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "✨ LuxioBlaze",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text("Elige tu estilo:", style = MaterialTheme.typography.labelMedium)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            styles.forEach { style ->
                FilterChip(
                    selected = selectedStyle == style,
                    onClick = { selectedStyle = style },
                    label = { Text(style) }
                )
            }
        }

        OutlinedTextField(
            value = userPrompt,
            onValueChange = { userPrompt = it },
            label = { Text("Escribe tu prompt o descripción") },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            maxLines = 5
        )

        Button(
            onClick = {
                isLoading = true
                viewModel.generateContent(
                    prompt = userPrompt,
                    style = selectedStyle,
                    onSuccess = { caption, hashtags ->
                        generatedCaption = caption
                        generatedHashtags = hashtags
                        isLoading = false
                    }
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            enabled = userPrompt.isNotEmpty() && !isLoading
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            } else {
                Text("Generar Contenido")
            }
        }

        if (generatedCaption.isNotEmpty()) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("Caption:", style = MaterialTheme.typography.labelMedium)
                    Text(generatedCaption, style = MaterialTheme.typography.bodyMedium)

                    Divider()

                    Text("Hashtags:", style = MaterialTheme.typography.labelMedium)
                    Text(generatedHashtags, style = MaterialTheme.typography.bodyMedium)

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(onClick = { }, modifier = Modifier.weight(1f)) {
                            Text("Copiar")
                        }
                        OutlinedButton(onClick = { }, modifier = Modifier.weight(1f)) {
                            Text("Guardar")
                        }
                    }
                }
            }
        }
    }
}
