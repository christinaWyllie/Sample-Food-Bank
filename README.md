# ENSFFinalProjectG01

Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: README
Date Submitted: April 18th, 2022
@author Sanika Shendye <a href="mailto:sanika.shendye@ucalgary.ca">
	sanika.shendye@ucalgary.ca</a>
@author Sobia Khan <a href="sobia.khan1@ucalgary.ca">
	sobia.khan1@ucalgary.ca</a>
@author Christina Wyllie <a href="christina.wyllie@ucalgary.ca">
	christina.wyllie@ucalgary.ca</a>
@author Maitry Rohit <a href="mailto:maitry.rohit@ucalgary.ca">
	maitry.rohitAucalgary.ca</a>
@version 1.0
@since 1.0

ENSF Final Project:
"Food banks provide support for people who are experiencing food insecurity. Working from supplies which are available, volunteers need to create hampers 
of nutritionally balanced food to address the needs of clients. Assembling an appropriate hamper for the number of adults and children in a family, 
for one week, requires knowledge of nutrition and caloric intake needs. To more effectively serve a greater number of people, 
Example Food Bank needs an application to propose ideal hampers based on current inventory." 

  - From ENSF409 W22 Project Handout https://d2l.ucalgary.ca/d2l/le/content/425075/viewContent/5224951/View

Our purpose is to take input from the user that specifies the type of indivudal and how many of them there are in a certain "family unit". 
Each family unit will recieve a corresponding "food hamper" that is based off of the nutritional needs of the individuals in that certain family. 
The user may create as many family units before submitting their application and it will subsequently return an "Order Form" that outlines the criteria 
they gave and their respective hamper. 

Contained Java Files: 
	Class Files:
 			GUIFinalProject.java
			Application.java
  		HamperNutrition.java
  		Family.java
  		Nutrition.java
  		OrderForm.java
  		Inventory.java
  		Food.java
  		DataBase.java
	Interface Files:
  		Calculate.java 
			FormatString.java
	Junit Test Files:
			TestApplication.java
			TestHamperNutrition.java
  		TestFamily.java
  		TestNutrition.java
  		TestOrderForm.java
  		TestInventory.java
  		TestFood.java
  		TestDataBase.java
	User Created Exception Files:
			NotEnoughInventoryException.java
			RemoveFromDataBaseFailedException.java
			
			
Compilation Instructions (Windows System):
			Program Compilation:
					javac -cp .;lib/mysql-connector-java-8.0.23.jar edu\ucalgary\ensf409\*.java 
					java -cp .;lib/mysql-connector-java-8.0.23.jar edu.ucalgary.ensf409.GUIFinalProject   
			Junit Compilation:
					javac -cp .lib;junit-4.13.2.jar;hamcrest-core-1.3.jar;.;lib/mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/Insert_Specified_Test_File.java
					java -cp .lib;junit-4.13.2.jar:hamcrest-core-1.3.jar;.;lib/mysql-connector-java-8.0.23.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.Insert_Specified_Test_File
			
Compilation Instructions (Mac System):
			Program Complilation:
					javac -cp .:lib/mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/*.java
					java -cp .:lib/mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/GUIFinalProject  
			Junit Compilation:
					javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar:.:lib/mysql-connector-java-8.0.23.jar 		edu/ucalgary/ensf409/Insert_Specified_Test_File.java
					java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar:.:lib/mysql-connector-java-8.0.23.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.Insert_Specified_Test_File






  
