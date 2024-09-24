FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY build/libs/goty-0.0.1-SNAPSHOT.jar /app/mi-app.jar

ENTRYPOINT ["java", "-jar", "mi-app.jar"]