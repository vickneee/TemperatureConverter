FROM maven:latest

LABEL authors="victoriavavulina"

WORKDIR /app

COPY pom.xml /app

COPY . /app

RUN mvn package

CMD ["java", "-jar", "target/TemperatureConverter.jar"]