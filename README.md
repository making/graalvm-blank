# A blank project for GraalVM

Maven archetype to create a pre-configured maven project for a Vanilla GraalVM application (especially for CLI).

## How to use

```
mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=graalvm-blank-archetype\
 -DarchetypeVersion=0.1.1
```

Example

```
mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=graalvm-blank-archetype\
 -DarchetypeVersion=0.1.1\
 -DgroupId=com.example\
 -DartifactId=demo-cli\
 -Dversion=1.0.0-SNAPSHOT\
 -B
```

> GraalVM is required
> 
> ```
> export JAVA_HOME=/path-to-graalvm
> export PATH=$PATH:$JAVA_HOME/bin
> ```
> 
> If you are using SDKMAN, try
> 
> ```
> sdk install java 19.2.1-grl
> sdk use java 19.2.1-grl
> ```

```
cd demo-cli
chmod +x mvnw*
./mvnw clean package -Pgraal
./target/classes/demo-cli-osx-x86_64
```

![image](https://user-images.githubusercontent.com/106908/68075492-b35eff00-fdeb-11e9-80a6-ea54ae6eaa3c.png)


Build a binary for linux with Docker

```
docker run --rm \
   -v "$PWD":/usr/src \
   -v "$HOME/.m2":/root/.m2 \
   -w /usr/src \
   oracle/graalvm-ce:19.2.1 \
   ./mvnw package -Pgraal
```

## License

Licensed under the Apache License, Version 2.0.
