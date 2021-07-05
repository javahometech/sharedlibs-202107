def call(nexusRepo){
    def pom = readMavenPom file: 'pom.xml'
    def repo = nexusRepo
    def groupId = pom.groupId
    def artifactId = pom.artifactId
    nexusArtifactUploader artifacts: [[artifactId: artifactId, classifier: '', file: "target/${artifactId}-${pom.version}.war", type: 'war']], 
      credentialsId: 'nexus3', 
      groupId: groupId, 
      nexusUrl: '172.31.43.180:8081', 
      nexusVersion: 'nexus3', 
      protocol: 'http', 
      repository: repo, 
      version: pom.version
    
    echo pom.dependencies[0].version
}
