# Usa a imagem do JDK
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado para dentro do container
COPY target/zuca-bot-0.0.1-SNAPSHOT.jar /app/zuca-bot.jar
# COPY build/libs/bot.jar /app/bot.jar  # Se usa Gradle

# Define a porta para a API
EXPOSE 8080

# Comando para rodar o bot
CMD ["java", "-Xmx512m", "-jar", "zuca-bot.jar"]
