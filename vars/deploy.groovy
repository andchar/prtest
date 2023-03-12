def call(body) {
  def pipelineParams = [:]
  def testsTags = ''
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
            testsTags = '@golden-run'
            println testTags
          }
        }
      }
    }
  }
}
