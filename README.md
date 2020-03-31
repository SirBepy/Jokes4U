# Welcome

The first part of this document is how to start the app.
The second part is the code comments.

## Starting

### Warning

Before doing anything else, make sure you have a database called flyway_demo and a user in charge of it with the following credentials:
username=bob
password=bob123

### Step 1.

Open a terminal and navigate into this folder.

### Step 2.

run java -jar Jokes4U.jar

## Code comments

All of the source code is inside Jokes4U/src/main folder.
The resources folder has all of the HTML/CSS files aswell as the application.properties and data.sql file.

#### Alterations

In the data.sql file you will see that I've added the requested 15 jokes but I've also added approximately 70 more jokes and 2 more categories.
Feel free to uncomment those lines to quickly add more entries to the database.
