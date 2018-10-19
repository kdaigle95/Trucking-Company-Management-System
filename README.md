# Trucking-Company-Management-System
CS499 senior project

When pulling down master, you will have to create a new netbeans project from exisitng sources.
When you start with folders --> (hidden) .git, src, web, .gitignore, and this readme.

Steps:
1. Create New Project
2. Select Java Web --> Web Application with Existing Sources --> Next
3. Set the "Location" path to the root of the git repositiory (this could be nested - look for the hidden .git folder) --> Next
	3a. If necessary, specify "Project Name" and "Project Folder" location for the new project, but these should auto populate
4. Server and Settings 
	4a. Server: GlassFish Server 4.1.1
	4b. Java EE version: Java EE 7 Web
	4c. Context Path: /Trucking-Company-Management-System --> (this should auto populate)
5. Existing Sources and Libraries
	5a. Path for "Web Pages Folder" should auto populate - check path
	5b. Set path for "WEB-INF Content" - if folder is not there create it
	5c. don't worry about libraries folder for now
6. Click Finish and test a build