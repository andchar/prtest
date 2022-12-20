pipeline {
    agent { label "CEG-Centos-Andrii"}
/*
    parameters {
        string(name: 'tests_filter_tags', defaultValue: '@client-management or @tenant-management and not @skip', description: 'Filter test tags to run')
    }
*/
    stages {
        stage('test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh 'env'
                    cleanWs()
                }
            }
        }
    }
}
