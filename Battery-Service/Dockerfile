FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/battery-service.jar battery-service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","battery-service.jar"]
