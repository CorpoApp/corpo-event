FROM openjdk:11-jre-slim
ENV TZ Europe/Paris
ARG JAR_FILE=target/*-runner.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]