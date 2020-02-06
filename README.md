# DevOps Project

The aim of this project was to create a fully-deployed version of a full-stack OOP application as a team of two. 

## Index

[Requirements](#requirements)

[Solution](#solution)

[Pipeline Architecture](#architecture)

[Testing](#testing)
* [Surefire Report](#surefire)

[Deployment](#deployment)
* [Technology used](#technology)
    
[Front End Design](#frontend)
* [Initial Wireframe Design](#wireframe)
* [Final Design](#final)

[Future Possibilities](#future)

[Authors](#author)

<a name="requirements"></a>
## Requirements

To create a fully-deployed version of a full stack OOP application, with the support of tools such as Jenkins, Docker, Nginx, Nexus and AWS. There should also be use of VPCs and subnets with appropriate security settings. Upon passing unit and integration tests, the application will be deployed through a test environment and onto a live environment.

<a name="solution"></a>
### Solution

Our team created a Jenkins pipeline which would test and run the development branch of our Git repository in an AWS test environment whenever a change was detected. Jenkins would also be sending an image of the current application to both Docker Hub and Nexus. Upon passing unit, integration and selenium tests the changes to the dev Branch would be pulled into the master branch. This change would again be detected by Jenkins and begin another pipeline to test it and deploy it into a live environment for the user to use.

<a name="architecture"></a>
## Pipeline Architecture

![database](https://i.imgur.com/MT8q8AZ.png) ¬!!!!CREATE IMAGE OF PIPELINE 

The above diagram shows the pipeline used to deliver continuous integration. Any changes in the source code are pushed to the dev branch on GitHub. A webhook from Jenkins pulls in the changed project and begins the pipeline as determined by the Jenkinsfile. Jenkins will test the unit and integration tests with a combination of JUnit and Mockito tests, then run mvn package and deploy, storing it in Nexus. IT will then build an image using Docker Build and send this to Docker Hub. 





The diagram above shows both my initial and final structure for the tables in my database. I managed to stick to my initial design and keep all aspects of the recipes, ingredients and categories. The recipe table is the main focus of this project so the ingredients and categories were designed to fit around the requirements of the recipe.
![structure](https://i.imgur.com/ukyCdpL.png)

The above diagram shows the flow of the program, without specific classes. The database used was a H2 database, which was suitable due to its speed of starting up and shutting down. The RESTful API was coded with Java using the Eclipse IDE along with Spring Tool Suite 4. The front end contained HTML, CSS and JavaScript and was coded using Visual Studio Code.

<a name="testing"></a>
## Testing

Testing of this program included using JUnit, Selenium and Mockito, along with SonarQube to help idenfity and remove code smells to aid refactoring.

![junit](https://i.imgur.com/Q9ym4cZ.png)

<a name="surefire"></a>
### Surefire Report

[Surefire Report](./Surefire.pdf)

Test coverage from JUnit testing on Eclipse is 85%, SonarQube line coverage is at 82%, with 0 bugs, vunerabilities or code smells.

<a name="deployment"></a>
## Deployment 

I used Jenkins to build, test and deploy my project. Upon every push to my Git repository Jenkins would automatically begin this process and update my project. The application has been deployed using an Amazon Web Service (AWS) virtual machine (VM).


![CI](https://i.imgur.com/dANrjMY.png)

<a name="technology"></a>
### Technology used

H2 Database - Database
Java - Source Code
Jenkins - CI Server
Maven - Dependency Management
JUnit, Selenium, SonarQube - Testing
Surefire - Test Report
GitHub - Version Control System
Trello - Project Tracking
Amazon Web Service - Live Environment

<a name="frontend"></a>
## Front End Design

<a name="wireframe"></a>
### Initial Wireframe Design

Below shows the initial design of the front page.

![initial](https://i.imgur.com/fHfAZg3.png)

<a name="final"></a>
### FInal Design

Below shows the final result of the front page.

![final](https://i.imgur.com/dOJgQLq.jpg)

<a name="future"></a>
## Future Possibilities

I would like to add several new features to make the application more versatile. A login feature would expand the amount of people who could use the application and open up the possibility of downloading other users recipes and share your own.
I would also like an option to upload an image alongside your recipe to make the application more personal for a user.
Finally, the addition of a shopping list feature would make the app more useful in everyday life. Selecting recipes and collecting their ingredients into a shopping list is something I would like to implement in the future.

<a name="author"></a>
## Authors
Alexander Russo



