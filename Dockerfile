FROM openjdk:21-slim
WORKDIR /app
COPY build/libs/*-SNAPSHOT.jar app.jar
EXPOSE 9100
ENTRYPOINT ["java","-jar","app.jar"]
