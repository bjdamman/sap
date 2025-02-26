pipeline {
 agent {
  dockerfile true
 }
 stages {
  stage('Use image') {
    steps {
        script{
            sh "uname -a"
        }
    }
  }
 }
}