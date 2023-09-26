pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Start Build'
        sh 'mvn clean install -Dlicense.skip=true'
        echo 'Build Done'
      }
    }

    stage('SonarQube Test') {
      steps {
        sh 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000/ -Dlicense.skip=true'
      }
    }

  }
}