node {
  agent any
  stage('SCM') {
    checkout scm
  }
   tools {
    maven 'M3'
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'Default maven';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn sonar:sonar"
    }
  }
}