pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                script {
                    // Use the Maven Wrapper (if available) or the installed Maven
                    def mavenCmd = './mvnw' // For Maven Wrapper
                    // def mavenCmd = 'mvn'  // Use this if Maven is installed globally

                    sh "${mavenCmd} clean install"
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    // Use the Maven Wrapper (if available) or the installed Maven
                    def mavenCmd = './mvnw' // For Maven Wrapper
                    // def mavenCmd = 'mvn'  // Use this if Maven is installed globally

                    sh "${mavenCmd} test"
                }
            }
        }
    }

    post {
        success {
            echo 'Build and tests succeeded!'
        }

        failure {
            echo 'Build or tests failed. Please check the logs for details.'
        }
    }
}
