FROM openjdk:20-jdk

WORKDIR /app

COPY build/libs/videoStream-0.0.1-SNAPSHOT.jar app.jar

COPY src/main/resources/static src/main/resources/static

ENTRYPOINT ["java","-jar","app.jar"]
