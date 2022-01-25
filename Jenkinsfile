pipeline {
    options {
        
        timeout(time: 60, unit: 'MINUTES')
    }    
    agent {node {label 'Linux'}}
    environment {
        //TODO: Customize these variables for your environment
        MAVEN_PATH    = "/myvagrant/apache-maven-3.8.4/bin"
        PIPELINE_NAME = "java_microservices_cars_cd"
        STAGE_PROJECT = "cars-stage"
        APP_GIT_URL   = "https://github.com/VictorinCondei/java_microservices_cars_cd.git"
        NEXUS_SERVER  = "http://nexus-common.apps.cluster.domain.example.com/repository/java"

        
        // DO NOT CHANGE THE GLOBAL VARS BELOW THIS LINE
        APP_NAME = "cars"
    }    
    stages {
        stage('Static Code Analysis') {
            steps {
                echo '### Checking Static Code Style  ###'
                sh '''
                        export PATH=${MAVEN_PATH}:$PATH
                        cd /var/lib/jenkins/workspace/StageTwo/${PIPELINE_NAME}
                        echo $PATH
                        mvn clean
                        mvn checkstyle:check
                   '''
            }
        }
        stage('Run Unit Tests') {
            steps {
                echo '### Running unit tests ###'
                sh '''
                        export PATH=${MAVEN_PATH}:$PATH
                        mvn clean test
                   '''
            }
        }

        stage('Create WAR file') {
            steps {
                echo '### Creating War File ###'
                sh '''
                        export PATH=${MAVEN_PATH}:$PATH
                        mvn clean package -DskipTests=true
                   '''
            }
        }
        stage('Promote to Staging Env') {
            steps {
                timeout(time: 60, unit: 'MINUTES') {
                    input message: "Do you want to Promote to Staging?"
                }
                sh '''
                        export PATH=${MAVEN_PATH}:$PATH
                        mvn clean 
                        mvn wildfly:deploy -DskipTests=true
                        echo "Check http://34.125.211.47:8081/cars"
                   '''
            }
        }

    }
}