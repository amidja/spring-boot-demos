# - - - To build and run the app in a jdk container - - - -
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
#mvn package
#docker build --build-arg JAR_FILE=target/*.jar -t amidja/springboot/native-reactive-rest:2.7.7 .
#docker run -d -p 8080:8080 amidja/springboot/native-reactive-rest:2.7.7
#curl http://localhost:8080/greeting

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]