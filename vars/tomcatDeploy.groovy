def call(tomcatIP,warName,credId) {

     sshagent(["${credId}"]) {
             
        sh "scp -o StrictHostKeyChecking=no  target/*.war ec2-user@${tomcatIp}:/opt/tomcat8/webapps/${warName}.war"
        //sh "ssh ec2-user@${tomcatIp} /opt/tomcat8/bin/shutdown.sh"
        //sh "ssh ec2-user@${tomcatIp} /opt/tomcat8/bin/startup.sh"
      }
}


    