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

    parameters {
      string(name: 'tests_filter_tags', defaultValue: '@all', description: 'Filter test tags to run')
    }

    environment {
      TEST_TAGS = "${params.tests_filter_tags}"
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
            // params.tests_filter_tags = '@golden-run'
            tests_tags = '@golden-run'
            println test_tags
            sh "echo ${test_tags}"
          }
        }
      }
    }

  }
}