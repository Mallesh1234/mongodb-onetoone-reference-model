//pipeline {
    //agent any
    //stages {
      //  stage('Build') {
           // steps {
            //sh 'mvn clean verify'
            //  sh 'mvn clean i sonar:sonar -Dsonar.login=0d1d9c720ad3b3b79b7beb3315c7d0415cc616c7 -Dsonar.host.url=http://192.168.0.100:3000'
            //}
       //}
      //}
   // }
   node {
    def server
    def rtMaven = Artifactory.newMavenBuild()
    def buildInfo

    stage ('Clone') {
        git url: 'https://github.com/Mallesh1234/mongodb-onetoone-reference-model.git'
    }

    stage ('Artifactory configuration') {
        // Obtain an Artifactory server instance, defined in Jenkins --> Manage Jenkins --> Configure System:
        server = Artifactory.server 'jfrog'

        // Tool name from Jenkins configuration
        rtMaven.tool = 'Maven-Home'
        rtMaven.deployer releaseRepo: 'spring-libs-release-local', snapshotRepo: 'spring-libs-snapshot-local', server: server
        rtMaven.resolver releaseRepo: 'spring-libs-release-local', snapshotRepo: 'spring-libs-snapshot-local', server: server
        buildInfo = Artifactory.newBuildInfo()
    }

    stage ('Exec Maven') {
        rtMaven.run pom: 'pom.xml', goals: 'clean install', buildInfo: buildInfo
    }

    stage ('Publish build info') {
        server.publishBuildInfo buildInfo
    }
}
 