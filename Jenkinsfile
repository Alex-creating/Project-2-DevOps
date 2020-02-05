pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn clean"
            }
        }
        stage('---add in H2---') {
        	steps {
        		echo "spring.datasource.driver-class-name=org.h2.Driver
				spring.datasource.url=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1
				spring.datasource.username=admin
				spring.datasource.password=password
				server.servlet.context-path=/RecipeStore
				spring.jpa.database-platform=org.hibernate.dialect.H2Dialect" > ../ubuntu/Project-2-DevOps/src/main/resources/application.properties
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
