pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            sh 'mvn -B -DskipTests clean install'
        }
        stage('Deliver') {
            sh 'mvn dockerfile:build'
            sh 'mvn dockerfile:push'
        }
    }
}