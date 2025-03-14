FROM openjdk:21
WORKDIR /app
COPY target/epl-stats-api.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
