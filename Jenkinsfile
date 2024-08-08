// using parameters

pipeline {
    agent any
    parameters {
        // string(name: 'VERSION', defaultValue: '1.0.0', description: 'version to deploy')
        choice(name: 'VERSION', choices: ['1.0.0', '1.0.1', '1.0.2'], description: 'choice a specific version')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'execute/skip test stage')
    }
    stages {
        stage('build') {
            steps {
                echo 'Building the application ...'
            }
        }
        stage('test') {
            when {
                expression {
                    params.executeTests == true //no need to use == true   //you can also use !params.executeTests
                }
            }
            steps {
                echo 'Testing the application ...'
            }
        }
        stage('deploy') {
            steps {
                echo 'Deploying the application ...'
                echo "Deploying version ${params.VERSION}"
            }
        }        
    }
}