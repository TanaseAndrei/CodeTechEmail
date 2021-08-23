FROM openjdk:8
COPY target/CodeTechEmail-0.0.1-SNAPSHOT.jar /
ENTRYPOINT ["java", "-jar", "CodeTechEmail-0.0.1-SNAPSHOT.jar"]
