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
        stage('---SSH into VM---') {
        		steps {
        		sh "ssh -T -i /home/ubuntu/DevOps.pem ubuntu@ec2-18-130-72-242.eu-west-2.compute.amazonaws.com"
        }}
    }
}
