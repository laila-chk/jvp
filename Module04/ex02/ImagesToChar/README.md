### make sure to run the following commands from ImagesToChar dir, which is the root of the project

generating the target folder and the .class's
```
javac -d target src/java/fr/_42/printer/*/*.java
```
copying the resource folder in target
```
cp -r src/resources target
```
creating the jar using the already existing manifest
```
jar cfmv target/images-to-chars-printer.jar src/manifest.txt -C target fr -C target resources
```
running the jar
```
java -jar target/images-to-chars-printer.jar S ' '
```
+++++++++
cd target/
jar xfv ../lib/jcommander-4.0.jar
cd ..
cp src/resources target -r 
jar cfmv target/images-to-chars-printer.jar src/manifest.txt -C target fr -C target resources -C target/ com 
