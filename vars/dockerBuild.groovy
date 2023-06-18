//def call(String project, String ImageTag, String hubUser){
    
  //  sh """
  //  docker image build -t ${hubUser}/${project} . 
  //  docker image tag ${hubUser}/${project} ${hubUser}/${project}:${ImageTag}
 //   docker image tag ${hubUser}/${project} ${hubUser}/${project}:latest
  //  """
//}

// def call(String aws_account_id, String region, String ecr_repoName){
    
//     sh """
//      docker build -t ${ecr_repoName} .
//      docker tag ${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
//     """
// }

def call(String Project, String azure_registry_name){
   sh """
      docker build -t ${project} .
      docker tag ${project}:latest ${azure_registry_name}.azurecr.io/${project}:latest"
   """
}
