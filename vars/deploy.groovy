def call(body) {
  def pipelineParams = [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = pipelineParams
  body()
  pipeline {
    agent { 
      label 'CEG-Centos-Andrii'
    }
    stages {
      stage('Test print') {
        steps {
          script {
            def env = System.getenv()
            env.each{
              println it
            } 
            echo "##############################################"
            sh "echo export"
          }
        }
      }
    }
  }
}
