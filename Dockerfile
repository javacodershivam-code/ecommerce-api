FROM eclipse-temurin:17-jdk

WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy project files
COPY . .

# Build the application
RUN mvn clean package -DskipTests

EXPOSE 8090

CMD ["java", "-jar", "target/*.jar"]
