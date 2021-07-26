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
   pipeline {
    agent any
    tools {
        maven 'Maven-Home'
        //jdk 'jdk8'
    }
    stages {
        stage ('Clone') {
            steps {
                git branch: '2021_07', url: "https://github.com/Mallesh1234/mongodb-onetoone-reference-model.git"
            }
        }

        stage ('Artifactory configuration') {
            steps {
                rtServer (
                    id: "ARTIFACTORY_SERVER",
                    url: "http://192.168.0.100:8081/artifactory",
                    credentialsId: "AKCp8jRGQ4EZxLgd9rzUVtz6j45VeW3Sg9CUERgNa6Kvnu4Z52x567EJumXY5FWCeVqj1iZ3t"
                )

                rtMavenDeployer (
                    id: "MAVEN_DEPLOYER",
                    serverId: "ARTIFACTORY_SERVER",
                    releaseRepo: "spring-libs-release-local",
                    snapshotRepo: "spring-libs-snapshot-local"
                )

                rtMavenResolver (
                    id: "MAVEN_RESOLVER",
                    serverId: "ARTIFACTORY_SERVER",
                    releaseRepo: "spring-libs-release-local",
                    snapshotRepo: "spring-libs-snapshot-local"
                )
            }
        }

        stage ('Exec Maven') {
            steps {
                rtMavenRun (
                    //tool: Maven-Home, // Tool name from Jenkins configuration
                    pom: './pom.xml',
                    goals: 'clean install',
                    deployerId: "MAVEN_DEPLOYER",
                    resolverId: "MAVEN_RESOLVER"
                )
            }
        }

        stage ('Publish build info') {
            steps {
                rtPublishBuildInfo (
                    serverId: "ARTIFACTORY_SERVER"
                )
            }
        }
    }
}