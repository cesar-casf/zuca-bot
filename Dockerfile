# Usa a imagem do JDK
FROM eclipse-temurin:21-jdk

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado para dentro do container
COPY target/zuca-bot-0.0.1-SNAPSHOT.jar /app/zuca-bot.jar

# Copia a pasta wallet para a imagem
COPY target/classes/wallet /app/oradb/wallet

# Define a variável de ambiente dentro da imagem
ENV TNS_ADMIN=oradb/wallet

# Define a porta para a API
EXPOSE 8080

# Comando para rodar o bot
CMD ["java", "-Xmx512m", "-jar", "zuca-bot.jar"]
