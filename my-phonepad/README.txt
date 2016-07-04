To run the given program just run the script given inside called runProgram.sh on any UNIX machine which has maven installed and added to the path.
Grant the permission to the shell script so that it can run using the following command.

#chmod u+x ./runProgram.sh

In case of copy paste please exclude "#"

You can the run the program by passing the parameter to the script itself:
ex:
#./runProgram.sh 23456
or without parameters 
ex:
#./runProgram.sh


Instead of script if you want to run the program using maven instead of script you can run the following command on terminal within the root directory of the project where pom.xml file exists.

first clean and compile it.
ex:
#mvn clean install

then run the below command.
ex:(you can change the arguement values 12345 to anything else for other outputs)
#mvn exec:java -Dexec.mainClass="com.myPhonePad.app.App" -Dexec.args="12345"
