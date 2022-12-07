
#docker build --build-arg JAR_FILE=target/*.jar -t amidja/springboot/native:2.7.7 .
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]