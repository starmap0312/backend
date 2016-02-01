FROM ubuntu:14.04
MAINTAINER starmap, "starmap0312@gmail.com"

RUN apt-get update && apt-get clean
RUN apt-get install -q -y openjdk-7-jre-headless && apt-get clean
ADD http://mirrors.jenkins-ci.org/war/latest/jenkins.war /opt/jenkins.war
RUN ln -sf /jenkins /root/.jenkins

ENTRYPOINT ["java", "-jar", "/opt/jenkins.war"]
EXPOSE 8080
VOLUME ["/jenkins"]
CMD [""]
