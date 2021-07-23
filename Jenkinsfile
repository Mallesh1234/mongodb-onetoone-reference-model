pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
            //sh 'mvn clean verify'
              sh 'mvn clean verify sonar:sonar -Dsonar.login=0d1d9c720ad3b3b79b7beb3315c7d0415cc616c7 -Dsonar.host.url=http://192.168.0.100:3000'
            }
       }
      }
    }