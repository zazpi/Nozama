pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root.m2:/root/.m2'
            args '-e REGISTRY_PASSWORD=${REGISTRY_PASSWORD}'
            args '-e REGISTRY_USERNAME=${REGISTRY_USERNAME}'
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