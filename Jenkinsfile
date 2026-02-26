pipeline {
    agent any

    parameters {

        string(
                name: 'BRANCH_NAME',
                // choices: ['main', 'develop'], // doesn't need branch parameter for MultiBranch Pipeline
                defaultValue: 'main',
                description: 'Git branch to build'
            )

        choice(
            name: 'testSuite',
            choices: ['smoke.xml', 'regression.xml', 'bothSmokeRegression.xml'],
            description: 'Select TestNG suite to run'
        )
    }

    tools {
            maven 'Maven'   // must match Jenkins Maven config name
    }


    stages {
        stage('Checkout') {
            steps {
                git branch: "${params.BRANCH_NAME}",
                   url: 'https://github.com/IshaniShashikala/SeleniumTestAutomation_Project.git'
            }
        }

        stage('Run Maven Tests') {
            steps {
                // Use Maven wrapper if available, otherwise use mvn
//                 sh "./mvnw clean test -DtestSuiteXmlFile=${params.testSuite}"
                sh "mvn clean test -DsuiteXmlFile=${params.testSuite}"
                // OR on Windows: bat "mvnw.cmd clean test -DsuiteXmlFile=${params.SUITE}"
            }
        }
    }

     post {
            always {
                junit '**/target/surefire-reports/*.xml'
            }
        }
}
