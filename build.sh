#!/bin/bash

./mvnw clean package
rm -rf build
unzip target/graalvm-blank-*.jar -d build

mvn -N io.takari:maven:wrapper
docker run --rm \
           -v "$PWD":/usr/src \
           -v "$HOME/.m2":/root/.m2 \
           -w /usr/src \
           oracle/graalvm-ce:19.2.0.1 \
           ./mvnw package -Pgraal
