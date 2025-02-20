FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN mvn package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/CuentasMovimientosMicroservice-0.0.1-SNAPSHOT.jar /app/CuentasMovimientosMicroservice-0.0.1-SNAPSHOT.jar
EXPOSE 8080

CMD ["java", "-jar", "CuentasMovimientosMicroservice-0.0.1-SNAPSHOT.jar"]
