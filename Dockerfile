FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_mvm_jrtb_bot
ENV BOT_TOKEN=6671282340:AAFI0j1wioKZ817JiUYanZctexaL3GAlKBU
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]