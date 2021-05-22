FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} stock_quote_manager.jar
ENTRYPOINT ["java","-jar","/stock_quote_manager.jar"]