//def call(credentialsId){

//    withSonarQubeEnv(credentialsId: credentialsId) {
  //       sh 'mvn clean package sonar:sonar'
  //  }
//}
def call(credentialsId){
withVault(configuration: [timeout: 60, vaultCredentialId: 'vault-token', vaultUrl: 'http://40.121.204.190:8200'], vaultSecrets: [[path: 'secret/sonar', secretValues: [[vaultKey: 'credentialsId']]]]) {
    sh 'mvn clean package sonar:sonar'
}
}
