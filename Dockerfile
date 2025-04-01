# Usa a imagem do OpenJDK 24
FROM eclipse-temurin:21-jdk

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado para dentro do container
COPY target/bot.jar /app/bot.jar  # Se usa Maven
# COPY build/libs/bot.jar /app/bot.jar  # Se usa Gradle

# Define a porta para a API
EXPOSE 8080

# Comando para rodar o bot
CMD ["java", "-Xmx512m", "-jar", "zuca-bot.jar"]
