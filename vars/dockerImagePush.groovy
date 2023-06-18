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



def call(String azure_registry_name, String acr_username, String acr_password){
    withCredentials([usernamePassword
    (credentialsId: 'acr', 
     passwordVariable: 'acr_password', 
     usernameVariable: 'acr_username'), 
                     usernamePassword(credentialsId: '0406be6e-0af5-44f7-ae01-8cf4f655d302', 
                                      passwordVariable: '', 
                                      usernameVariable: 'azure_registry_name'
                                      )]) {
       sh "docker login ${azure_registry_name}.azurecr.io --username ${acr_username} --password ${acr_password}"
}

       sh "docker push ${azure_registry_name}.azurecr.io/${project}:latest"
}
