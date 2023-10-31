FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dusername=${BOT_NAME}", "-Dtoken=${BOT_TOKEN}", "-jar", "/app.jar"]