# 1️⃣ Base image (Java 21 – matches your runtime)
FROM eclipse-temurin:21-jdk-jammy

# 2️⃣ App directory inside container
WORKDIR /app

# 3️⃣ Copy JAR
COPY build/libs/*.jar app.jar

# 4️⃣ Expose app port
EXPOSE 8080

# 5️⃣ Run app
ENTRYPOINT ["java", "-jar", "app.jar"]
