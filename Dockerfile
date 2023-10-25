# Fetching latest version of Java
FROM openjdk:11

# Setting up work directory

WORKDIR /app


# Copy the jar file into our app

COPY ./target/assignment-0.0.1-SNAPSHOT.war /app


# Exposing port 8080
EXPOSE 8081


# Starting the application

CMD ["java", "-jar", "assignment-0.0.1-SNAPSHOT.war"]