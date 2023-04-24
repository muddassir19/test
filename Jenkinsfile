pipeline{
  agent any 
  
  tools {
    maven 'maven3'
  }
  
  stages {
    stage('git checkout') {
      steps{
         git 'https://github.com/muddassir19/test.git'  
      }
    }
  }
}
