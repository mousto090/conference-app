FROM openjdk:13-alpine
ARG JAR_FILE=target/*.jar
#copy the jar file as conference-app.jar 
COPY ${JAR_FILE} conference-app.jar 
ENTRYPOINT ["java","-jar","/conference-app.jar"]