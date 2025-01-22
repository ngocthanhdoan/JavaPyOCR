# Stage 1: Build the Java application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copy only the necessary files for dependency resolution
COPY pom.xml .
RUN mvn dependency:resolve

# Copy the source code
COPY src ./src

# Build the application
RUN mvn clean install -B

# Stage 2: Create a runtime image
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/ocrweb-0.0.1-SNAPSHOT.jar /app/ocrweb.jar

# Expose the application's port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "ocrweb.jar"]
