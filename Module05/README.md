# Module 05

## classes, databases, JDBC, and xml files.. Where should one start?
before diving deeply in any of these, or trying to start coding and figuring out things along the way, maybe one should start from basic understanding and definitions, understanding the relations between these, and then diving in the docs of each of them in the right order.
the exercises of this module will be a walk through of a small app with a database, postgresql to be specific.
the ex00 title is **"Tables and Entities"**, **tables** are what we'll use to store our data in a collection where that data will be related, let's stick with the subject's theme and say we're working on the chat's database, we need multiple tables to keep data organized, so we'll have a table for users, and name it users, all user related data should be kept in this table, the table of users will have ID, Password, login .. and we'll have another table for chatrooms, where we'll have ID, chatroom name, owner.. it won't make sense to smash all this data in one table and have userID setting next to chatroomID and the rest of others, the table should represent the data of a single thing or entity.
Now the second part of the title, "Entities", refers to java classes that sorta represent those tables we were just explaining, (and there's a good reason behind that, we'll get into it) just as we have a users table that have an ID, login and password, the class User will have the same amount of attributes: ID, login and password, now to go from a class to an entity, we need to add the annotation "@Entity" at the top of the class to clarify that it maps to a database table == it is indeed an entity, but that's not enough, we should also clarify to what table this entity should be mapped to! thus we could use `@Table(name = "users")`. The code would look similar to the example below (except there are a few things missing).
	NOTE: the word "annotation" will be mentioned multiple times, if it's making things hard to understand, make sure to clarify things first by reading the official docs,, or taking a peak at [Module 07's README](./Module07/README.md) (if it exists yet).
``` java
@Entity
@Table(name = "users") 
public class Product { 
	@Id //another annotation to mark this field as an id or the primary key
	private Long id;
	//adding @Column annotaion allows enforcing some rules
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	//if @Column isn't added, it maps automatically to a column named password.
	private String password;
	
	//constructor, getters and setter ..	
}
```
Up to now nothing seems interesting *yet!* because I'm trying to serve this as understandable digestible chunks, so far it seems like Entities and their tables mirror each other, but that's not it, in fact they work with each other, based on an Entity class we could Create the table, fill it with data, modify existing one, or remove it, that's what an entity really is for! what's missing now is how to establish a connection between our program (the entities) and the database, here comes the pom.xml file JDBC part.

https://cdn.intra.42.fr/pdf/pdf/87593/en.subject.pdf
https://cdn.intra.42.fr/pdf/pdf/87594/en.subject.pdf
https://cdn.intra.42.fr/pdf/pdf/87595/en.subject.pdf
https://cdn.intra.42.fr/pdf/pdf/87596/en.subject.pdf
https://cdn.intra.42.fr/pdf/pdf/87597/en.subject.pdf
