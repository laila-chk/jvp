#!/bin/bash

echo "generating sources.text.."

find src -name "*.java" > sources.txt

echo "compiling our classes using the generated file and downloaded libraries"
javac -cp "lib/*" -d target/ @sources.txt

echo "copying resources and jcommander classes into target/"

cp -r src/resources target

cd target/
jar xfv ../lib/jcolor-5.5.1.jar
jar xfv ../lib/jcommander-4.0.jar
cd ..

echo "generating the jar inside target/ and runnig it"

jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target fr -C target resources -C target/ com 
java -jar target/images-to-chars-printer.jar --white=RED --black=BLUE

# echo "generating sources.text.."

# find src -name "*.java" > sources.txt

# echo "compiling our classes using the generated file and downloaded libraries"
# javac -cp "lib/*" -d target/ @sources.txt

# echo "copying resources and jcommander classes into target/"

# cp -r src/resources target

# cd target/
# jar xf ../lib/jcommander-4.0.jar
# cd ..

# echo "generating the jar inside target/ and runnig it"

# jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target fr -C target resources -C target/ com 
# java -jar target/images-to-chars-printer.jar --white=0 --black=.

