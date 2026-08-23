### make sure to run the following commands from ImagesToChar dir, which is the root of the project
At the end, we need to generate a fat jar (that's what they call it i swear!)
that can be used as a standalone program, thus it must include all the .class files that it needs, in order to run independently.
at the end of this readme, the commented part can be copied and used as a script to save the multiple copy past, but first here's a walk through the commands and their functionallities. 

---
# the following Part can be copied to a script.sh and used to do all the job

``` bash
#!/bin/bash

echo "generating sources.text.."
find src -name "*.java" > sources.txt

echo "downloading jcommander and jcolor jars"
mkdir lib
curl -L -o lib/jcommander-3.0.jar "https://repo1.maven.org/maven2/org/jcommander/jcommander/3.0/jcommander-3.0.jar"
curl -L -o lib/jcolor-5.5.1.jar "https://repo1.maven.org/maven2/com/diogonunes/JColor/5.5.1/JColor-5.5.1.jar"

echo "compiling our classes using the generated file and downloaded libraries"
javac -cp "lib/*" -d target/ @sources.txt

echo "copying resources, jcolor and jcommander .class files into target/"
cp -r src/resources target
cd target/
jar xfv ../lib/jcolor-5.5.1.jar
jar xfv ../lib/jcommander-3.0.jar
cd ..

echo "generating the jar inside target/ and runnig it"
jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target fr -C target resources -C target/ com 
java -jar target/images-to-chars-printer.jar --white=RED --black=BLUE
```
