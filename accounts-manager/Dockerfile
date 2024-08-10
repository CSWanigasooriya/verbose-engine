# Use an official Tomcat image with JDK 21 as a parent image
FROM tomcat:9-jdk21-corretto

# Set the maintainer label
LABEL authors="chamath"

# Remove the default ROOT application and copy the WAR file
RUN rm -rf /usr/local/tomcat/webapps/ROOT
ARG WAR_FILE=build/libs/accounts-manager-0.0.1-SNAPSHOT.war
COPY ${WAR_FILE} /usr/local/tomcat/webapps/ROOT.war

# Expose the port the application runs on
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
