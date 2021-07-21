node {
tools {
    maven 'M3'
  }
  stage('SCM') {
    checkout scm
  }
  
  stage('SonarQube Analysis') {
    def mvn = tool 'Default maven';
    withSonarQubeEnv() {
      sh "mvn sonar:sonar"
    }
  }
}