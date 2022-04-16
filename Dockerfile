FROM openjdk:13-ea-27-jdk-alpine3.9

EXPOSE 8080

COPY target/Rest-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]