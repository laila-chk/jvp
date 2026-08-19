#make sure to run the following commands from ImagesToChar dir, which is the root of the project

javac -d target src/java/fr/_42/printer/*/*.java
cp -r src/resources target
jar cfmv target/images-to-chars-printer.jar src/manifest.txt -C target fr -C target resources
java -jar target/images-to-chars-printer.jar S ' '
