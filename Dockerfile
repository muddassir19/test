From tomcat:8
LABEL app=test
COPY target/*.war /usr/local/tomcat/webapps/myweb.war
