#!/bin/bash

#Compiling 

find . -name '*.java' > s

javac -cp src:$1 -d "bin/" @s
jar cfvm $2 ./manifest.mf ./app ./sprites ./scripts # compile and pack the class into a JAR file
