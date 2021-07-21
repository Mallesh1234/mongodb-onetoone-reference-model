node {
  stage('SCM') {
    checkout scm
  }
  tools
  	{
	maven 'maven 3'
	jdk 'java 11'
	}
  stage('SonarQube Analysis') {
    def mvn = tool 'Default Maven';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn sonar:sonar"
    }
  }
}