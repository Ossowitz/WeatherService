FROM openjdk:19-jdk-alpine

# Копируем JAR-файл в образ
COPY target/WeatherDashboard-0.0.1-SNAPSHOT.jar app.jar

# Устанавливаем рабочую директорию
WORKDIR /

# Запускаем JAR-файл
CMD ["java", "-jar", "app.jar"]