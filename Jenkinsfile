pipeline{
  agent any 
  
  tools {
    maven 'maven3'
  }
  
  stages {
    stage('git checkout') {
      steps{
         git branch: 'main', credentialsId: 'github-token', url: 'https://github.com/muddassir19/test.git'
      }
    }
    stage('stage2') {
      steps{
        sh 'echo stage2'
      }
    }
  }
}
