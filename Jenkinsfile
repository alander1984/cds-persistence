#!groovy
// -*- coding: utf-8; mode: Groovy; -*-
def project_token = 'ASabadMQiBYLyPpAlzVVmZDnyyk1M8ZP39M'

properties([
    buildDiscarder (logRotator (artifactDaysToKeepStr: '', artifactNumToKeepStr: '10', daysToKeepStr: '', numToKeepStr: '10')),
    disableConcurrentBuilds (),
    gitLabConnection('GitLab'),
    pipelineTriggers([
        [
            $class: 'GitLabPushTrigger',
            branchFilterType: 'All',
            triggerOnPush: true,
            triggerOnMergeRequest: false,
            triggerOpenMergeRequestOnPush: "never",
            triggerOnNoteRequest: true,
            noteRegex: "Jenkins please retry a build",
            skipWorkInProgressMergeRequest: true,
            secretToken: project_token,
            ciSkip: true,
            setBuildDescription: true,
            addNoteOnMergeRequest: true,
            addCiMessage: true,
            addVoteOnMergeRequest: true,
            acceptMergeRequestOnSuccess: false,
            branchFilterType: "NameBasedFilter",
            includeBranchesSpec: "release/qat",
            excludeBranchesSpec: "",
        ]
    ])
])


node ('internet-enabled') {
    timestamps {
        ansiColor('xterm') {
            stage('Checkout') {
                checkout scm
            }

            stage ('Build Image') {
                docker.image('docker.art.lmru.tech/maven:3.6.0-jdk-8-slim').inside() {
                    configFileProvider([configFile(fileId: 'settings-xml', targetLocation: './settings.xml')]) {
                        sh "mvn clean deploy -s settings.xml -B -DskipTests"
                    }
                }
            }

            stage ('Wipe') {
                cleanWs();
            }
        }
    }
}
