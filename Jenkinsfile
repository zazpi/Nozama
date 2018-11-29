pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
            registryUrl 'http://index.docker.io/v1/'
            registryCredentialsId 'dockerhub_account'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Build image and Deliver') {
            steps {
                sh 'mvn dockerfile:build'
            }
        }
        /*stage('Push image to registry') {
            steps {
                sh 'mvn dockerfile:push' 
            }
        }*/
    }
}