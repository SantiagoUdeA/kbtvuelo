FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/kbtvuelo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
LABEL authors="edison"
ENTRYPOINT ["java", "-jar", "app.jar"]