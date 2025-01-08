def buildJar() {
    echo "building the application..."
    sh 'mvn package'
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t kelyunice1419/nginx:jma1.0 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push kelyunice1419/nginx:jma1.0'
    }
}

def deployApp() {
    echo 'deploying the application...'
}

return this

