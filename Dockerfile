# Start with a base image containing Java runtime
FROM maven:3.6-jdk-8

# Add Maintainer Info
LABEL maintainer="diaguilysociete@gmail.com"
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package -DskipTests=true

#FROM tomcat:9.0-jre8-alpine
#COPY --from=MAVEN_TOOL_CHAIN /tmp/target/wizard*.war $CATALINA_HOME/webapps/wizard.war
#HEALTHCHECK --interval=1m --timeout=3s CMD wget --quiet --tries=1 --spider http://localhost:8080/wizard/ || exit
# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8888 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/artisan-service-platform.jar

# Add the application's jar to the container
ADD ${JAR_FILE} artisan-service-platform.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/artisan-service-platform.jar"]