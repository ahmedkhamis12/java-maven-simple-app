def buildJar() {
    echo "Building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-depi', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            sh 'docker build -t ahmed1612/my-app:jmv-1.0 .'
            sh "echo $PASS | docker login -u $USER --password-stdin"
            sh 'docker push ahmed1612/my-app:jmv-1.0'
            
    }
    }


def deployApp() {
        echo 'deploying the application...'

} 

return this