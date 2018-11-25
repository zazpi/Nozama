pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            registryUrl 'https://index.docker.io/v1/'
            registryCredentialsId 'dockerhub_account'
            args '-v /root.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean install'
            }
        }
        stage('Build image and Deliver') {
            steps {
                sh 'mvn dockerfile:build'
            }
        }
        stage('Push image to registry') {
            steps {
                sh 'mvn dockerfile:push'
            }
        }
    }
}