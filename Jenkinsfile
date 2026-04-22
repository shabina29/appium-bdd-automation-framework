pipeline {
    agent any 
    // 👉 Run this pipeline on any available Jenkins agent (machine)

    tools {
        maven 'Maven'
        // 👉 Use Maven configured in Jenkins (Global Tool Configuration)

        jdk 'JDK17'
        // 👉 Use JDK 17 configured in Jenkins
    }

    environment {
        ENV = 'QA'
        // 👉 Default environment for test execution (can be overridden)

        DEVICE = 'ANDROID'
        // 👉 Device type (useful for mobile automation)

        APPIUM_SERVER = 'http://127.0.0.1:4723'
        // 👉 Appium server URL (used by driver setup)
    }

    triggers {
        githubPush()
        // 👉 Automatically triggers build when code is pushed to GitHub
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
                // 👉 Pull latest code from GitHub repository (SCM = Source Code Management)
            }
        }

        stage('Clean Workspace') {
            steps {
                bat 'mvn clean'
                // 👉 Cleans previous build files (target folder)
            }
        }

        stage('Build & Execute Tests') {
            steps {
                bat "mvn test -Denv=%ENV% -Ddevice=%DEVICE%"
                // 👉 Runs test cases using Maven
                // 👉 Passes environment and device as runtime parameters
            }
        }

        stage('Generate Reports') {
            steps {
                echo 'Reports generated (TestNG / Extent)'
                // 👉 Informational step (actual report generation happens in framework)
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'test-output/**/*.html', fingerprint: true
                // ✅ FIX: Archive only HTML reports (ensures ExtentReport.html is picked properly)
                // 👉 Stores reports (Extent, TestNG) in Jenkins
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([
                    reportDir: 'test-output',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent Report'
                ])
                // ✅ FIX: This makes Extent Report clickable in Jenkins UI (not just file list)
                // 👉 Requires "HTML Publisher Plugin" installed in Jenkins
            }
        }
    }

    post {

        always {
            echo 'Execution Completed'
            // 👉 This runs regardless of success or failure
        }

        success {
            echo 'Build SUCCESS ✅'
            // 👉 Executes when all stages pass
        }

        failure {
            echo 'Build FAILED ❌'
            // 👉 Executes if any stage fails
        }
    }
}