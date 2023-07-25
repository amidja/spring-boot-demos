# - - - To build and run the app in a jdk container - - - -
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
#mvn packag
#
## Build With PODMAN
#podman build --build-arg JAR_FILE=target/*.jar -t quay.io/qja266/springboot/native-reactive-rest:latest .
#podman push quay.io/qja266/springboot/native-reactive-rest:latest
#
#podman pull podman quay.io/qja266/springboot/native-reactive-rest:latest
#
#podman run -d -p 8080:9090 --name=reactive-rest native-reactive-rest
#curl http://localhost:8080/greeting
#
#
##Build With DOCKER
#docker build --build-arg JAR_FILE=target/*.jar -t amidja/springboot/native-reactive-rest:latest .
#docker run -d -p 8080:9090 --name=reactive-rest amidja/springboot/native-reactive-rest:latest
#FROM docker.io/library/eclipse-temurin:17-jdk-alpine
FROM docker.io/library/eclipse-temurin:17-jdk-jammy
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} latest-app.jar
ENTRYPOINT ["java","-jar","/latest-app.jar"]