FROM eclipse-temurin:19-alpine
WORKDIR /app

COPY .mvn/ ./mvn
COPY mvnw pom.xml ./

#RUN mvn package -Dmaven.test.skip
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]