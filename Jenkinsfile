pipeline{
    agent any
    environment {
        DOCKER_TAG = getVersion()
    }

    stages{
        stage('checkout scm'){
            steps{
                git branch: 'ansible-docker-container', credentialsId: 'git-hub', 
                url: 'https://github.com/muddassir19/test.git'
            }
        }
        stage('Maven Build'){
            steps{
                sh 'mvn clean package'
            }
        }
        stage('Docker Build'){
            steps{
                // 2.0.0 is static version we need to give dynamic (it commit id by short form used for taging)
                sh "docker build . -t muddassir19/myweb:${DOCKER_TAG} "
            }
        }
        stage('Docker Push'){
            steps{
             withCredentials([string(credentialsId: 'dockertoken', variable: 'DOCKERHUBPASS')]) {
                sh "docker login -u muddassir19 -p ${DOCKERHUBPASS}"   
            }
             sh "docker push  muddassir19/myweb:${DOCKER_TAG} "   
            }
        }
        stage('Docker Deploy'){
            steps{
                ansiblePlaybook credentialsId: 'dev-server', disableHostKeyChecking: true, extras: "-e DOCKER_TAG=${DOCKER_TAG}", installation: 'ansible', inventory: 'dev.inv', playbook: 'deploy-docker.yml'
            }
        }
    }
}
//commit  id is "git rev-parse --short Head"(run this cmd to get  id)
def getVersion(){
    def commitHash = sh label: '', returnStdout: true, script: 'git rev-parse --short HEAD'
    return commitHash
}


