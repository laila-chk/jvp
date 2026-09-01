this day is about packages and creating jar files.
### java Packages:

whenever we use the keyword "import" in our java code, we are importing a certain class from a certain java package, those packages are **built-in packages** (pre-written libraries) where we can find many classes that are related to each other in each package, so a package is grouping of related classes or interfaces..
in this exercises we were supposed to create our own package, following a given structure, which of course aligns with java docs and rules.
in order to declare a package, we simply need to add "package" to the very top of the file, followed by the correct path, and using '.' as separator, the package usually represents the company domain name in reverse, in our case we have "42.fr" so our package declaration will look like:
```
package fr._42.printer.app;
```
the underscore ( _  ) before 42 is necessary because of the rules of naming.
note that this is declared at top of a class that's located at `../fr/_42/printer/app/`
this is how large java projects should be structured so everything remains organized.

### Jar
This Part is mainly based on [oracle docs](https://docs.oracle.com/javase/tutorial/deployment/jar/index.html) since they cover everything in details.
we can look at a jar as a way to compress an app, so instead of sending the whole code of an app back and forth, we can simply transfer the jar, with its readme file, and based on that the app can be run and tested anywhere.
jars are generated based on .class files, so we need to first compile what we have, and based on a file called manifest, the jar can decide from what class to start executing.

to create a jar:
```
jar cf jarName.jar files.class img.jpeg
```
if we have more than a single image/assets in a folder, we can add the name of the folder and all the files inside it will be automatically included
```
jar cf ImageAudio.jar files/ 
```
the manifest file automatically gets generated under META-INF/MANIFEST.MF, in case we want to use our own manifest file , the following command can be used:
```
jar cmf jarName existing-manifest input-file(s)
```
basically we have :
```
 c : to create the jar file
 f : redirect the output to a file (with the provided name jarName) instead of stdout
 m : use existing manifest file instead of generating a new one
 M : Indicates that the default manifest file should not be produced
-c : To change directories during execution of the command.
```

The manifest file have a form that should be following while writing it, a new line (empty line) at the end is mandatory, else the last line won't be considered, and a space after colons (:)
```
Manifest-Version: 1.0
Main-class: fr._42.printer.app.Main
```

### JCommander & JCDP

the subject demanded that we use these two libraries, so we need to understand what are they for.
in short words, JCommander is a tool that make is easier to *parse the commands* that get passed as args for the main through the command line, the official docs can be found [here](https://jcommander.org/), but in a nutshell we will be declaring a class with annotations that represent the args, and let JCommander parse them. The annotation that'll be used is "Parameter" and it comes from JCommander. The example below is from the officiel Jcommander docs:
```
class Main {
    @Parameter(names={"--length", "-l"})
    int length;
    @Parameter(names={"--pattern", "-p"})
    int pattern;

    public static void main(String ... argv) {
        Main main = new Main();
        JCommander.newBuilder()
            .addObject(main)
            .build()
            .parse(argv);
        main.run();
    }

    public void run() {
        System.out.printf("%d %d", length, pattern);
    }
}
```

```
$ java Main -l 512 --pattern 2
512 2
```

