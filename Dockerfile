# Use a base image with Java 17
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven build artifact (jar file) to the working directory
COPY target/pos-supplier-service-0.0.1-SNAPSHOT.jar pharmacy-pos-supplier-service.jar

# Expose the port the application runs on
EXPOSE 8082

# Run the jar file
ENTRYPOINT ["java", "-jar", "pharmacy-pos-supplier-service.jar"]