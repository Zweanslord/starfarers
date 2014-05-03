Starfarers
==========

Setting up a web application for the Starfarers strategy roleplaying game.

Starfarers latest roleplaying game: http://www.myth-weavers.com/forumdisplay.php?f=28138

Technologies used:
- Java 7
- Maven
- Spring
- Hibernate
- MySql
- JSP
- HTML

Tools used (to be installed):
 - Spring Tool Suite, an Eclipse workspace, includes server (Tomcat-based) to run web application
 - Toad Extension for Eclipse in Spring Tool Suite for database connection
 - XAMPP with its MySQL Database
 - Maven for dependency management
 
 Setup:
 - Checkout project from GitHub
 - Through Apache (XAMPP) set up user/database (password to be used see database.properties)
 - Setup Toad Extension with jdbc lib from maven
 - Run SQL (in /sql) on database with Toad Extension
 - Ensure Spring Tool Suite gets all maven libs: Right-click Project > Maven > Update Project
 - Right-click Project > Properties > Deployment Assembly > Add > Java Build Entires > Maven Dependencies
 - Add project to Spring Tool Suite server
 - Run server