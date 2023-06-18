//def call(String project, String ImageTag, String hubUser){
   // withCredentials([usernamePassword(
   // credentialsId: "docker",
   // usernameVariable: "USER",
   //        passwordVariable: "PASS"
 //  )]) {
   //     sh "docker login -u '$USER' -p '$PASS'"
 //  }
    //sh "docker image push ${hubUser}/${project}:${ImageTag}"
   // sh "docker image push ${hubUser}/${project}:latest"   
//}


//  def call(String aws_account_id, String region, String ecr_repoName){
//      sh """
//          aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
//          docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
//    """
//}

def call(String appname, String acrurl, String ImageTag){
    withCredentials([usernamePassword(credentialsId: 'acr', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh '''
        az login --service-principal --username f7c46375-3af5-4aeb-b4a9-6b1d8fa12165 --password aoA8Q~Hy2xhbJ4yVF7KwJfHg23Cr5e26_c~fPcvX --tenant 4c6f1364-8db1-4e57-95ef-b3cf7dd7d4c9
        az acr login --name ${acrurl} --username ${USER} --password ${PASS}
        '''
    }
    sh "docker push ${acrurl}/${appname}:${ImageTag}"
    sh "docker push ${acrurl}/${appname}:latest"
}
