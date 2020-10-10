# SD27 Homework, Week 7: Film Query Application

### Overview

This program queries a MySQL database containing, among other things, a table of movies for rent. The user can search for movies either by keyword or the film's id in the SQL table using a simple command-line menu, and will either be shown some basic information about the film in question (with the option, via a submenu, to view more) or informed that no film matching their query exists in the table in question.

### Topics

* JDBC API
  - JDBC classes and methods are used for all interactions with the MySQL database.
* SQL queries
  - Queries used for this program make use of SQL's `JOIN` and `WHERE` clauses as part of `SELECT` statements to combine and filter multiple tables.
* Basic SQL security
  - To provide resistance to SQL injection, `PreparedStatement`s objects are used to the exclusion of `Statement` objects for submitting SQL queries to the database.
* Separation of concerns
  - *All* database access code is confined to the methods of the `DatabaseAccessorObject` class via the `DatabaseAccessor` interface.
  - Rather than create a dedicated constructor for this one highly specific method of setting up `Film` objects, new `Film` objects are initialized with the default constructor and their fields filled in (using `Film`'s mutator methods) by dedicated code in `DatabaseAccessorObject`'s methods.
* Maven
  - MySQL-specific drivers for JDBC are loaded by adding them as a Maven dependency.
* Object-relational Mapping
  - Detailed methods are provided to load rows from the table of results as individual `Film` objects with all fields filled in.




### How to Run

1. Compile all `.java` files in `com.skilldistillery.filmquery.app` , `com.skilldistillery.filmquery.entities` and `com.skilldistillery.filmquery.database` with `javac` or load the package in Eclipse or another IDE.
2. Run the class file for `FilmQueryApp` from the command line with `java FilmQueryApp`, or with your IDE's run tools.
3. Enter the inputs requested by the program.
4. ~~PROFIT!~~ Look at console output for the answers you seek.
