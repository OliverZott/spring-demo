# Setup
### Fresh project: Create Maven Project (CLI)
- [Instructions](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

1. `mvn archetype:generate -DgroupId=org.velosaurus.demo -DartifactId=spring-demo -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false`
1. `tree`
1. `mvn clean` and `mvn package`
1. `java -cp target/spring-demo-1.0-SNAPSHOT.jar org.velosaurus.demo.App`

### 