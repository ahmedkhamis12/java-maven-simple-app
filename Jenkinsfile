// using parameters
def groovyfile
pipeline {
    agent any
    parameters {
        // string(name: 'VERSION', defaultValue: '1.0.0', description: 'version to deploy')
        choice(name: 'VERSION', choices: ['1.0.0', '1.0.1', '1.0.2'], description: 'choice a specific version')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'execute/skip test stage')
    }
    stages {
        stage('init') {
            steps {
                script{
                    groovyFile = load 'script.groovy'
                }
            }
        }
        stage('build') {
            
            steps {
                script{
                    groovyFile.buildApp()
                }
            }
        }
        stage('test') {
            when{
                expression{
                    params.executeTests == true //no need to use == true // you can also use !params.executeTests
                }
            }

            steps {
                script{
                    groovyFile.testApp()
                }
            }
        }    

        stage('deploy') {
            input{
                message "select an Env to deploy the application"
                ok "Okay"
                parameters{
                    choice(name: 'Env', choices:['Dev','Stagging','Production'], description: 'pick an env to deploy the application')
                }
            }
            steps{
                script{
                    groovyFile.deployApp()
                    echo "Deploying the version ${params.VERSION} to env ${ENV}"
                }
            }
        }    
    }
}