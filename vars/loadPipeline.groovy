#!groovy


def call() {

    def gitPath = 'https://git.devtools.ceca.bi-geek.com/backend/jenkins-pipeline.git'
    def gitBranch = 'master'
    def jenkinsPipeline = 'Jenkinsfile' // ".groovy" extension will be added automatically
    def jenkinsCredentialsId = 'Gitlab'
    def jenkinsNode = '' // Specifies a node to be used for checkout, default value: empty string (runs on any node)
    def pipeline

    stage('load pipeline') {
        pipeline = fileLoader.fromGit(
                jenkinsPipeline,
                gitPath,
                gitBranch,
                jenkinsCredentialsId,
                jenkinsNode
        )
    }

    pipeline.runJenkinsfile()
}

