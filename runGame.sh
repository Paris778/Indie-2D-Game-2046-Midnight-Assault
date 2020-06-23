#!/bin/bash

#Compiling 
echo "1"
find . -name '*.java' > s
echo "3"
javac -cp src:$1 -d "./" @s
if [ -z "$2"];
then
    ./makeJar.sh $1 test.jar
    java -cp $1 -jar test.jar 
else
    ./makeJar.sh $1 $2
    java -cp $1 -jar $2
fi
  

read -p "hit return"
