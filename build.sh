#!/bin/bash

./mvnw clean package
rm -rf build
unzip target/graalvm-blank-*.jar -d build
# docker run --rm -p 8080:8080 \
#            -v "$PWD":/usr/src \
#            -w /usr/src \
#            oracle/graalvm-ce:1.0.0-rc15 \


mvn -N io.takari:maven:wrapper
docker run --rm \
           -v "$PWD":/usr/src \
           -v "$HOME/.m2":/root/.m2 \
           -w /usr/src \
           oracle/graalvm-ce:1.0.0-rc15 \
           ./mvnw package -Pgraal
