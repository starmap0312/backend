FROM ubuntu:14.04
MAINTAINER starmap, "starmap0312@gmail.com"

# General
RUN echo deb http://archive.ubuntu.com/ubuntu precise universe >> /etc/apt/sources.list
RUN apt-get update && apt-get clean
RUN apt-get install -q -y wget
RUN apt-get install -q -y unzip

# JDK
RUN apt-get install -q -y openjdk-7-jre-headless && apt-get clean
ENV JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64

# GIT
RUN apt-get install -q -y git

# Gradle
RUN apt-get install gradle

# Jenkins
ADD http://mirrors.jenkins-ci.org/war/latest/jenkins.war /opt/jenkins.war
RUN ln -sf /jenkins /root/.jenkins

ENTRYPOINT ["java", "-jar", "/opt/jenkins.war"]
EXPOSE 8080
VOLUME ["/jenkins"]
CMD [""]
