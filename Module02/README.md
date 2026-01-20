## Module 02

**IO package, Files** — *In this module you will learn how to use input/output
in Java and implement programs to manipulate a file system. ~ the subject*

---

This module is all about file manipulation, which we can put in two groups,
manipulating the bytes (data) of the file, or the file itself (creating,
deleting, copying.. a file).

### File data reading and writing

for the first part, we can either use `FileInputStream`, `BufferedReader`… 
for reading the bytes of the file, `FileOutputStream`, `BufferedWriter`
for writing into the the files. for example:

```jsx
...
 try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
...
```

```jsx
...
 try (FileInputStream fis = new FileInputStream("example.txt")) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
...
```

**BufferedReader** allows reading line by line, as well as reading a single character,
meanwhile **FileInputStream** have mainly the **`read`** method, that allows either 
reading a single byte each time, or `b.length` bytes of data in case of using **`read**(byte[] b)`.

### Files creation, moving and more

for this purpose we’ll be using File class and Files class

Files class consists exclusively of static methods that operate on files, directories,
or other types of files. meanwhile File is an abstract representation of file and 
directory pathnames.
we’ll need to work with Path class too while dealing with Files, which get passed 
as a parameter in so many cases, Thus the need to use Paths, a class with mainly two 
methods(get(…)) for converting a String(or URI) into a path object that we can pass 
to the Files methods
