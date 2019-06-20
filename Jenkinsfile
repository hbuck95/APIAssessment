pipeline{
        agent any
        stages{
                stage('---clean---'){
                        steps{
                                sh "pwd"
                                sh "mvn clean"
                        }
                }
                stage('--test--'){
                        steps{
                                sh "mvn test"
                        }
                }
				stage('--package--'){
                        steps{
                                sh "mvn package"
                        }
                }
		stage('--sonar--'){
                        steps{
                                sh "mvn sonar:sonar"
                        }
                }
		stage('--verify--'){
                        steps{
                                sh "mvn verify"
                        }
                }
		stage('--deploy--'){
                        steps{
				sh "sudo cp -r /var/lib/jenkins/workspace/SoloProjectPipe/target/APIAssessment.war /home/h_a_buck_1995/wildfly-10.1.0.Final/standalone/deployments/"
                        }
                }
        }
}