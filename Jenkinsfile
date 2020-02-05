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
        		echo "spring.datasource.driver-class-name=org.h2.Driver" > ../ubuntu/Project-2-DevOps/src/main/resources/application.properties
				echo "spring.datasource.url=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1" >> ../ubuntu/Project-2-DevOps/src/main/resources/application.properties
				echo "spring.datasource.username=admin" >> ../ubuntu/Project-2-DevOps/src/main/resources/application.properties
				echo "spring.datasource.password=password" >> ../ubuntu/Project-2-DevOps/src/main/resources/application.properties
				echo "server.servlet.context-path=/RecipeStore" >> ../ubuntu/Project-2-DevOps/src/main/resources/application.properties
				echo "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect" >> ../ubuntu/Project-2-DevOps/src/main/resources/application.properties
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
