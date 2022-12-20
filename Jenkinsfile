pipeline {
    agent { label "CEG-Centos-Andrii"}
/*
    parameters {
        string(name: 'tests_filter_tags', defaultValue: '@client-management or @tenant-management and not @skip', description: 'Filter test tags to run')
    }
*/
    stages {
        stage('env') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh "env | grep -i 'branch\|change\|git\|tag'"                       
                }
            }
        }

        // stage('git env') {
        //     steps {
        //         catchError(buildResult: 'SUCCESS', stageResult: 'SUCCESS') {
        //             sh """
        //                 printenv BRANCH_NAME;
        //                 printenv BRANCH_IS_PRIMARY;
        //                 printenv CHANGE_ID;
        //                 printenv CHANGE_URL;
        //                 printenv CHANGE_TITLE;
        //                 printenv CHANGE_AUTHOR;
        //                 printenv CHANGE_AUTHOR_DISPLAY_NAME;
        //                 printenv CHANGE_AUTHOR_EMAIL;
        //                 printenv CHANGE_TARGET;
        //                 printenv CHANGE_BRANCH;
        //                 printenv CHANGE_FORK;
        //                 printenv TAG_NAME;
        //                 printenv TAG_TIMESTAMP;
        //                 printenv TAG_UNIXTIME;
        //                 printenv TAG_DATE;
        //                 printenv GIT_COMMIT;
        //                 printenv GIT_PREVIOUS_COMMIT;
        //                 printenv GIT_PREVIOUS_SUCCESSFUL_COMMIT;
        //                 printenv GIT_BRANCH;
        //                 printenv GIT_LOCAL_BRANCH;
        //                 printenv GIT_CHECKOUT_DIR;
        //                 printenv GIT_URL;
        //                 printenv GIT_COMMITTER_NAME;
        //                 printenv GIT_AUTHOR_NAME;
        //                 printenv GIT_COMMITTER_EMAIL;
        //                 printenv GIT_AUTHOR_EMAIL;
        //             """
        //             cleanWs()
        //         }
        //     }
        // }

    }
}
