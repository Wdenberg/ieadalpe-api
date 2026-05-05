# Etapa de build
# Usando a imagem oficial do Maven com Java 21 para garantir compatibilidade
FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /app

# Copia primeiro o pom.xml para aproveitar o cache das camadas do Docker
COPY pom.xml .

# Baixa as dependências antes de copiar o código (acelera os próximos builds)
RUN mvn dependency:go-offline -B

COPY src ./src
# Build ignorando testes para agilizar, garantindo o JDK 21
RUN mvn clean package -DskipTests

# Etapa de runtime
# Usando JRE em vez de JDK para manter a imagem leve e segura
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia o jar gerado na etapa anterior
COPY --from=build /app/target/ieadalpeapi-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Adicionando flags de performance para Java 21
ENTRYPOINT ["java", "-XX:+UseParallelGC", "-jar", "app.jar"]