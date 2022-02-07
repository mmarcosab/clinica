FROM openjdk:15-alpine
MAINTAINER github/mmarcosab
COPY ./target/app-0.0.1-SNAPSHOT.jar /app/app-0.0.1-SNAPSHOT.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app-0.0.1-SNAPSHOT.jar"]