#FROM openjdk:11.0.2-jre-slim
FROM openjdk:11
RUN apt -y update && apt -y upgrade
RUN apt -y install net-tools && apt -y install iputils-ping && apt -y install dnsutils
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

#CMD java -Xmx400m -Xms400m -XX:TieredStopAtLevel=1 -noverify -jar -Dspring.profiles.active=integration app.jar
ENTRYPOINT ["java", "-Xms400m", "-XX:TieredStopAtLevel=1", "-noverify", "-jar", "/app.jar"]
EXPOSE 8080