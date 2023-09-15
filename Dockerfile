FROM openjdk:17-jdk-alpine AS build

COPY . .
RUN mvn clean package -Pprod -DskipTests



FROM openjdk:17-jdk-alpine
COPY --from=build /target/fortlom-tsp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]