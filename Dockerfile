FROM openjdk:11-jre-slim

WORKDIR /app

COPY goty-bff/build/libs/goty-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]