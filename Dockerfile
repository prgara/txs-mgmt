FROM eclipse-temurin:21-jre-alpine
EXPOSE 8080
ADD target/txsmgmt.jar txsmgmt.jar
ENTRYPOINT ["java","-jar","txsmgmt.jar"]