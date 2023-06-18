def call(String appname, String acrurl, String ImageTag){
    
   sh """
   docker image build -t ${appname} . 
   docker tag ${appname} ${acrurl}/${appname}:${ImageTag}
   docker tag ${appname} ${acrurl}/${appname}:latest
    """
}
