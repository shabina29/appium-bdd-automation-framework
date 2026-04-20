pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK17'
    }

    environment {
        ENV = 'QA'
        DEVICE = 'ANDROID'
        APPIUM_SERVER = 'http://127.0.0.1:4723'
    }

    triggers {
        githubPush()
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Clean Workspace') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Build & Execute Tests') {
            steps {
                bat "mvn test -Denv=%ENV% -Ddevice=%DEVICE%"
            }
        }

        stage('Generate Reports') {
            steps {
                echo 'Reports generated (TestNG / Extent)'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'test-output/**', fingerprint: true
            }
        }
    }

    post {

        always {
            echo 'Execution Completed'
        }

        success {
            echo 'Build SUCCESS ✅'
        }

        failure {
            echo 'Build FAILED ❌'
        }
    }
}