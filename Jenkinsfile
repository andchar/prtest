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
                // catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    // sh "env | grep -i 'branch\\|change\\|git\\|tag'"                       
                    // sh "env"                       
                    // A PR from any branch to rel/(release-name}-dev will run specific tests suite relevant to the repository.
                    if (env.CHANGE_TARGET.matches("rel/(.*)-dev")){
                        echo "A PR from any branch to rel/(release-name}-dev will run specific tests suite relevant to the repository."
                    } 
                    // A PR from rel/(release-name}-dev to rel/(release-name} will run Silver test suite.
                    else if (env.CHANGE_BRANCH.matches("rel/(.*)-dev") && (env.CHANGE_TARGET.matches("rel/(.*)"))) {
                        echo "A PR from rel/(release-name}-dev to rel/(release-name} will run Silver test suite."
                    } 
                    // A PR from rel/(release-name} to rel/(release-name}@promoted will run Golden test suite,
                    else if (env.CHANGE_BRANCH.matches("rel/(.*)") && (env.CHANGE_TARGET.matches("rel/(.*)@promoted"))) {
                        echo "A PR from rel/(release-name} to rel/(release-name}@promoted will run Golden test suite"
                    } 
                    else {
                        echo "Invalid Branch"
                    }
                // }
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
