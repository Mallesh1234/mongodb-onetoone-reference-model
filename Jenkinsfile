pipeline {
    node('Centos8-1Client')
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean verify sonar:sonar -Dsonar.host.url=http://192.168.0.100:3000'
            }
       }
      }
    }