def call(body) {
  def pipelineParams = [:]
  pipelineParams['testTags'] = '@all'
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = pipelineParams
  body()
  pipeline {
    agent { 
      label 'CEG-Centos-Andrii'
    }
    
    environment {
      TEST_TAGS = ${params.testTags}
    }

    stages {
      stage('Test print') {
        steps {
          script {
            // def env = System.getenv()
            // env.each{
            //   println it
            // } 
            //def testsTags = '@golden-run'
            // println testTags
            sh "env"
          }
        }
      }
    }
  }
}