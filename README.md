<sub> 
    this README file, along the all the code in my repo, was written the traditional way (no AI prompting..)
    so remarques, notes, critisism are welcomed, even though I kinda did the minimum.. :D
</sub>
# Module 00
        This day will help us pick up the syntax of java, and buiding some programs using the bare minimum.

# Module 01
    This Module introduced a handful of interesting and useful concepts (unlike M00)

### Singleton:
    Before giving the definition of singleton, I would like to talk very briefly about **design patterns**.
    **Design patterns** are general, reusable solutions to a commonly occurring problem in many contexts in software design,
    that doesn't mean they are a piece of code that you can just use, they are more like concepts that we can understand,
    and implement in our way in order to overcome a certain issue, so two people are more likely to write different codes
    based on the very same design pattern. 
    
    There are four types of design patterns, that are: creational, structural, behavioral and Concurrency patterns, based
    on what kind of problem they solve, each pattern belongs to one of these groups.

    So now it is clear that a Singleton is a design pattern, but under which of these groups it belongs? what problem does
    it solve? and what is it to beggin with?

    a **Singleton** is a design pattern that limits instantiation (instance creation/objects creation) of a class to one,
    so the whole program is guaranteed to have one and only one object/instance of that class, they are a bit similar to
    global variables, but more manageable and useful, in so many cases they are used as basis or foundation for other design
    patters (the ones that should have a single instance), **Singleton** is a **creational** design pattern, it is all about
    creating a class and controlling the creation of objects from it..

    In this module, we were supposed to create a singleton that generates user IDs, for obvious reasons a single object should
    exist, that will contain the variable that will hold the ID, and keep on incrementing it each time the class is called, now
    there are multiple ways to creat a singleton, but all of them should guarantee the singularity.

### Interface:
    Interfaces are more of a blueprints, they are classes that are abstract and their methods have no definitions, only declared
    without a body, in order to use them they should be **implemented** by other classes via the keyword implements, in java a
    class cannot inherit from multiple ones at once, but it could implement multiple interfaces at once, this exercice wasn't a
    great example of interfaces, we could've used an abstract class since we're only implementing once, but in cases where we'll
    need to force a bunch of classes to define a set of methods for example, we can make them all implement the same interface..

### ArrayList & LinkedList
    ArrayList and LinkedList implement List interface.. they all are provided by **Java Collections Framework**
    We were asked to create a class that is similar to ArrayList, and implements the Interface we defined earlier for it, and 
    a LinkedList class that implemets the already defined linkedlist interface. so we had to take a look at how they behave so 
    we can code a similar behaviour.
    there are two core or root interfaces : *Map* and *Collection*, List, Queue and set implement Collection Interface, meanwhile
    HashMap, SortedMap.. implement the Map interface.
    In this Module the focus was mainly on the List Interface and exactly on ArrayList and LinkedList.
    LinkedList -(implements)-> List -(extends)-> Collection.
    ArrayList -(implements)-> List -(extends)-> Collection.

### Exceptions
    We worked here with RuntimeException, which is an Unchecked exception, we implemented it to create our own custom exception for
    when a user or a transaction aren't found.
    there are mainly two types of exceptions: checked and Unchecked ones, RuntimeException and all the classes inheriting from it
    are **Unchecked**, and that means we don't necessarily have to handle the exception in case it occured, by wrapping it in a try_catch
    or by adding the throws keyword to the methods that throws. as if we're considering it as something that could generally prevented
    programatically (by checking for a certain condition, ex: ArrayIndexOutOfBoundException can be avoided by checking if the index < size)
    with Unchecked exception, the program will be executed and until the exception happens and thrown, we'll know about it, unlike the
    **checked exception** if not inside a try_catch, and not marked with throws, the program will not compile, it forces us to handle it
    Unchecked exceptions are more tidy and result in a cleaner code and classes, which makes them prefered.
       
