FROM openjdk:13-alpine
ARG JAR_FILE=target/*.jar
#copy the jar file as conference-app.jar 
COPY ${JAR_FILE} conference-app.jar 
#RUN rm /bin/sh && ln -s /bin/bash /bin/sh

#ENTRYPOINT ["java","-Dserver.port=$PORT", "$JAVA_OPTS", "-jar","/conference-app.jar"]
#ENTRYPOINT not starting web dynos on heroku container registry so use CMD
#this will start the app with /bin/sh
CMD java -Dserver.port=$PORT $JAVA_OPTS -jar /conference-app.jar