#!/bin/bash
# this script will run the program using maven. Parameter passed to this script will be passed as arguement to the java code.

mvn clean install
if [ -z "$1" ]
  then
    echo "No argument supplied"
    mvn exec:java -Dexec.mainClass="com.myPhonePad.app.App"
else
  mvn exec:java -Dexec.mainClass="com.myPhonePad.app.App" -Dexec.args=$1
fi
