FROM openjdk:17
COPY . .
RUN  ./mvnw package
ENTRYPOINT ["java", "-war", "target/docker-0.0.1-SNAPHOT.war"]