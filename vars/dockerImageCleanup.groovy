
def call(String appname, String acrurl, String ImageTag){
    
   sh """
    sh "docker rmi ${appname}:${ImageTag}"
    sh "docker rmi ${appname}:latest"
  """
}

