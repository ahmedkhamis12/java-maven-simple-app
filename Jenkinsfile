pipeline{
    agent any
tools{
    maven 'maven-3.6'
}
    stages{
        stage('buildJar')  {
            steps{
                echo "building the application..."
                sh 'mvn package'
            }
} 
stage('buildImage')  {
    steps{
            echo "building the docker image..."
            withCredentials([usernamePassword(credentialsId: 'dockerhub-depi', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            sh 'docker build -t ahmed1612/my-app:jmv-1.0 .'
            sh "echo $PASS | docker login -u $USER --password-stdin"
            sh 'docker push ahmed1612/my-app:jmv-1.0'
            
    }
    }
    
} 

stage('deployApp') {
    steps{

    echo 'deploying the application...'

    }
} 
    }
}