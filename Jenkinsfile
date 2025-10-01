pipeline {
    agent any
    environment {
        PATH = "/usr/local/bin:${env.PATH}"
        // Define Docker Hub credentials ID
        DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
        // Define Docker Hub repository name
        DOCKERHUB_REPO = 'vickneee/temperature-converter'
        // Define Docker image tag
        DOCKER_IMAGE_TAG = 'latest'
    }
    tools {
        maven 'Maven3'
    }

    stages {
        stage ('Checking') {
            steps {
                git branch: 'main', url: 'https://github.com/vickneee/TemperatureConverter.git'
            }

        }

        stage ('Build') {
            steps {
                  sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
              steps {
                    sh 'mvn test'
              }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t $DOCKERHUB_REPO:$DOCKER_IMAGE_TAG .'
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENTIALS_ID}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                        docker login -u $DOCKER_USER -p $DOCKER_PASS
                        docker push $DOCKERHUB_REPO:$DOCKER_IMAGE_TAG
                    '''
                }
            }
        }
    }

    post {
        always {
            // Only archive if files exist
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
            jacoco execPattern: '**/target/jacoco.exec'
        }
    }
}