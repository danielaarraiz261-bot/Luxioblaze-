# 🌟 LuxioBlaze - App de Contenido Creativo

**LuxioBlaze** es una aplicación móvil Android para creadores de contenido que te ayuda a generar:
- 🖼️ **Imágenes** con IA (Stable Diffusion)
- ✨ **Captions virales** personalizados
- 🏷️ **Hashtags trending**

Todo personalizado con diferentes **estilos** (Fantasía, Gótico, Dark Romance, Minimalista, Vibrante).

## 🚀 Características

- ✅ Generación de imágenes con Stable Diffusion
- ✅ Captions inteligentes con Claude API
- ✅ Hashtags optimizados para viralizarse
- ✅ Múltiples estilos disponibles
- ✅ Funciona principalmente offline
- ✅ Interfaz moderna con Jetpack Compose
- ✅ Almacenamiento local de favoritos

## 📋 Requisitos

- Android 7.0+ (API 24)
- Android Studio Flamingo o superior
- Kotlin 1.9+

## 🔧 Instalación

### 1. Clonar el repositorio
\`\`\`bash
git clone https://github.com/danielaarraiz261-bot/Luxioblaze-.git
cd Luxioblaze-
\`\`\`

### 2. Configurar APIs

#### Claude API (Anthropic)
1. Ve a [console.anthropic.com](https://console.anthropic.com)
2. Obtén tu API key
3. En el archivo \`local.properties\`, agrega:
\`\`\`properties
CLAUDE_API_KEY=tu_api_key_aqui
\`\`\`

#### Stable Diffusion (Stability AI)
1. Ve a [platform.stability.ai](https://platform.stability.ai)
2. Obtén tu API key
3. En \`local.properties\`, agrega:
\`\`\`properties
STABLE_DIFFUSION_API_KEY=tu_api_key_aqui
\`\`\`

### 3. Compilar y ejecutar
\`\`\`bash
./gradlew build
./gradlew installDebug
\`\`\`

## 📱 Uso

1. **Abre la app** en tu dispositivo Android
2. **Escribe tu prompt** (descripción de la imagen que quieres)
3. **Elige un estilo** (Fantasía, Gótico, Dark Romance, etc.)
4. **Toca "Generar Contenido"**
5. La app generará:
   - 🖼️ Una imagen personalizada
   - 💬 Un caption viral
   - 🏷️ Hashtags optimizados
6. **Copia** el contenido y **comparte** en redes

## 🎨 Estilos Disponibles

| Estilo | Descripción |
|--------|-------------|
| **Fantasía** | Mágico, encantado, etéreo, onírico |
| **Gótico** | Oscuro, Victorian, misterioso, inquietante |
| **Dark Romance** | Romance oscuro, belleza gótica, sensual |
| **Minimalista** | Líneas limpias, simple, moderno, elegante |
| **Vibrante** | Colores brillantes, energético, dinámico |

## 🏗️ Estructura del Proyecto

\`\`\`
Luxioblaze-/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── kotlin/
│   │   │   │   └── com/luxioblaze/app/
│   │   │   │       ├── api/
│   │   │   │       │   ├── ClaudeClient.kt
│   │   │   │       │   └── StableDiffusionClient.kt
│   │   │   │       ├── ui/
│   │   │   │       │   ├── screens/
│   │   │   │       │   │   └── MainScreen.kt
│   │   │   │       │   └── theme/
│   │   │   │       │       └── Theme.kt
│   │   │   │       ├── viewmodel/
│   │   │   │       │   └── ContentViewModel.kt
│   │   │   │       └── MainActivity.kt
│   │   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── settings.gradle.kts
├── build.gradle.kts
└── README.md
\`\`\`

## 🔐 Privacidad y Seguridad

- Las imágenes y textos se almacenan **localmente en tu dispositivo**
- Las llamadas a las APIs son **encriptadas**
- No recopilamos datos personales
- Tus creaciones son **100% tuyas**

## 🐛 Reportar Problemas

¿Encontraste un bug? [Abre un issue aquí](https://github.com/danielaarraiz261-bot/Luxioblaze-/issues)

## 📝 Licencia

Este proyecto está bajo la licencia MIT. Ver [LICENSE](LICENSE) para más detalles.

## 💡 Ideas Futuras

- [ ] Galerías para guardar colecciones
- [ ] Edición de captions y hashtags
- [ ] Exportar directamente a Instagram/TikTok
- [ ] Sincronización con la nube
- [ ] Más estilos personalizados
- [ ] Predicción de engagement
- [ ] Análisis de trending topics

## 🤝 Contribuciones

¿Quieres contribuir? ¡Bienvenido! 
1. Haz un Fork del proyecto
2. Crea una rama para tu feature (\`git checkout -b feature/AmazingFeature\`)
3. Commits tus cambios (\`git commit -m 'Add some AmazingFeature'\`)
4. Push a la rama (\`git push origin feature/AmazingFeature\`)
5. Abre un Pull Request

---

**Hecho con ✨ para creadores de contenido apasionados**
