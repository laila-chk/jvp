### make sure to run the following commands from ImagesToChar dir, which is the root of the project
At the end, we need to generate a fat jar (that's what they call it i swear!)
that can be used as a standalone program, thus it must include all the .class files that it needs, in order to run independently.
at the end of this readme, the commented part can be copied and used as a script to save the multiple copy past, but first here's a walk through the commands and their functionallities. 

- generate a file of *.java files using this cmd, then generate *.class

find src -name "*.java" > sources.txt
javac -cp "lib/*" -d target/ @sources.txt

- add resources and extacting .class files from jcommander jar inside target

cp -r src/resources target

curl -L -o lib/jcommander-4.0.jar "https://repo1.maven.org/maven2/org/jcommander/jcommander/4.0/jcommander-4.0.jar"
cd target/
jar xfv ../lib/jcommander-4.0.jar
cd ..

- generate the jar and run it

jar cfmv target/images-to-chars-printer.jar src/manifest.txt -C target fr -C target resources -C target/ com 
java -jar target/images-to-chars-printer.jar --white=0 --black=.



---
curl -L -o lib/jcolor-5.5.1.jar "https://repo1.maven.org/maven2/com/diogonunes/JColor/5.5.1/JColor-5.5.1.jar"
