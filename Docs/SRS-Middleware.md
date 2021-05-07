# SRS for middleware - Qiuyu Chen
## Introduction
This project is a genealogy software that helps people to view, organise and update their family tree.
## Purpose
The purpose of this project is to provide a cross-platform application for managing genealogical research.
## Intended Audience
For all those interested in genealogy.
## System Features and Requirements
### Non-functional Requirements:
1. Create a database using the RootsMagic database design
2. Create SQL scripts for all the tables in the the database
3. Identify foreign and primary keys and create relationship
4. Identify NOT NULL fields
5. The program will be developed in Java
6. The program should be implemented using the Model-View-Controller and  design pattern
7. Use the GEDCOM4J library for reading and writing to GEDCOM format
8. Use SQLite as the database
9. Use SpringBoot as the basic framework
10. Use MyBatis as the persistence framework
11. Use Maven as the software project management and comprehension tool
12. Create entities corresponding to the tables in the database
13. Create corresponding methods for adding, deleting, updating and querying data in the database
14. Update the data into the database after parsing the GEDCOM file
15. Exporting data from the database to a GEDCOM file
### Functional Requirements:
* FamilyFacts Middleware is not an application but rather an Application Programming Interface which should expose the following end points:
    1. Create a new database
        1. Specify the database name
        2. Specify the location where the database should be created.
        3. Rename the database
    2. Querying or modifying data in the database
        1. Add a new person
        2. Delete a person
        3. Search a person 
        4. Update a person
        5. Modification of relationships between family members
    3. Import/export a GEDCOM file or .rmgc file
        1. Creating a database and accessing genealogical data by importing files
        2. Export all data as GEDCOM files
        3. Back up the current database
