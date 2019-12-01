FROM openjdk:8-jdk-alpine
ENV APP_FILE MyCustomerDemo-2-0.0.1-SNAPSHOT.jar 
EXPOSE 8090
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]