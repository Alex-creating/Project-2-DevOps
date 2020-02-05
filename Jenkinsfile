pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn clean"
            }
        }
        stage('--package--') {
            steps {
                sh "mvn package"
            }
        }
        stage('---deploy---') {
            steps {
                sh "mvn deploy"
            }
        }
        stage('---buildDocker---') {
        steps {
        sh "docker build -t alexr12/atoz ."
        }
        }
                stage('---pushToDocker---') {
        steps {
        withDockerRegistry([ credentialsId: "DockerLog", url: "" ]) {
        sh "docker push alexr12/atoz"
        }
        }
        }
        
    }
}
