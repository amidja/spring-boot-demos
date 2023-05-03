# - - - To build and run the app in a jdk container - - - -
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
#mvn packag
#podman build --build-arg JAR_FILE=target/*.jar -t amidja/springboot/native-reactive-rest:2.7.7 .
#podman push quay.io/qja266/springboot/ative-reactive-rest:2.7.7
#podman pull quay.io/qja266/springboot/ative-reactive-rest:2.7.7
#podman run -d -p 8080:9090 --name=reactive-rest quay.io/qja266/springboot/native-reactive-rest:2.7.7
#curl http://localhost:8080/greeting
#
#podman generate kube reactive-rest -f reactive-rest.yaml

FROM docker.io/library/eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} latest-app.jar
ENTRYPOINT ["java","-jar","/latest-app.jar"]