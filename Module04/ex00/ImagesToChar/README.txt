this project is devided into two main folders, src where the source files are
located (and seperated in sub-folders according to their functionality) and target
folder that contains the .class files after the compilation of the .java files (that
are too organized the same way as src files, and under the same names)

to compile the .java files, please use the following command from the root dir (ImagesToChar folder)
```
javac -d target src/java/fr/_42/printer/app/Main.java
``` 
make sure that the CLASSPATH env var is correctly set to: "/pathToProject/Module04/ex00/ImagesToChar/target"

if that isn't the case, use this command to do so, from inside the ex00 folder:

```
export CLASSPATH=$PWD/ImagesToChar/target
`` `
