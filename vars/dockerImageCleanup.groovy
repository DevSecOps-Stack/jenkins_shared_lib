
def call(String project, String ImageTag, String hubUser){
    
   sh """
      sh "docker rmi ${acrurl}/${appname}:${ImageTag}"
    sh "docker rmi ${acrurl}/${appname}:latest"
  """
}

