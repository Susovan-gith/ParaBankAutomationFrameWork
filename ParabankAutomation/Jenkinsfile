pipeline {


agent any

tools {

    maven 'Maven'
}

stages {

    stage('Checkout') {

        steps {

            checkout scm
        }
    }

    stage('Build & Test') {

        steps {

            bat 'mvn clean test'
        }
    }
}

post {

    always {

        archiveArtifacts artifacts: 'test-output/**', allowEmptyArchive: true
    }

    success {

        echo 'Automation Suite Passed'
    }

    failure {

        echo 'Automation Suite Failed'
    }
}


}
