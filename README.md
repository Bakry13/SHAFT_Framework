# SHAFT_Framework

`How To :`

1- Specify files and tags that should be run from runner class under Test Runner package

2- Configure TestNG.xml file for test environment to run the file as testNG file

3- Every scenario should has its id in its name

4- Every feature file should has tag with its US id

5- If we run FE we write tag @FERegression and if we run api we write tage @APIRegression in feature file

6- Every feature should has 3 files (feature file - step def. - page)

7- Pages should hold locators, strings, actions and assertions and inherits from element actions

8- Feature files should has business scenarios

9- Step def should has technical steps and inherits from pages

10- Assertions uses assertion class

11- We locate element using method in element actions class (getElement()) or use SHAFT commands

12- Variables and methods should start with small letters

13- Write locators, tickets, scenario steps and step def methods in the order of the page under test

14- Step def class should end with _StepDef

15- Do not assert on existence of a certain element if we will assert on its text

16- Do not write any methods if you will not use it

17- Do not make more than 2 then in the scenario except view page scenario

18- For every api we create feature file with its name, endpoint class, extraction class and step def

19- Assertions of api errors is under Assersions_API class

20- Endpoint class, extraction class are under pages package

21- To run using maven commands on SIT environment which is a property in properties file:
mvn test -Denvironment="SIT"
