pipeline{
    agent any
    environment {
     DOCKERHUB_CREDENTIALS  = credentials=('dockerusr')
    }

    stages{
        stage('checkout SCM'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/docker-build-push']], extensions: [], userRemoteConfigs: [[credentialsId: 'git-hub', url: 'https://github.com/muddassir19/test.git']]])
            }
        }
        stage('mave build'){
            steps{
                sh 'mvn clean package'
            }
        }
        stage('Build docker image'){
            steps{
                sh 'docker build -t muddassir19/javaapp:1.0.0 .'
            }
        }
        /*stage('Push to docker hub'){
            steps{
                withCredentials([string(credentialsId: 'dockertoken', variable: 'dockerhub')]) {
                sh "docker login --username muddassir19 --password-stdin ${dockerhub}"
                }
                //sh 'sudo docker push muddassir19/javaapp:1.0.0'
            }
        }*/
       /* stage('Docker Login'){
            steps{
                sh 'echo $'DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        stage('push'){
            steps{
                sh 'docker push muddassir19/javaapp:1.0.0'
            }
        } */
    }
}
