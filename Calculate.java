/**
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: Calculate.java
Date Submitted: April 18th, 2022
@author Sanika Shendye <a href="mailto:sanika.shendye@ucalgary.ca">
	sanika.shendye@ucalgary.ca</a>
@author Sobia Khan <a href="sobia.khan1@ucalgary.ca">
	sobia.khan1@ucalgary.ca</a>
@author Christina Wyllie <a href="christina.wyllie@ucalgary.ca">
	christina.wyllie@ucalgary.ca</a>
@author Maitry Rohit <a href="mailto:maitry.rohit@ucalgary.ca">
	maitry.rohitAucalgary.ca</a>
@version 1.2
@since 1.0
 */

package edu.ucalgary.ensf409;
/**
 * This interface is implemented by family and food, and takes local class variables and calculates the contents 
 * required to be passed to create a nutrition object. The nutrition object is then returned by the method.
 */
interface Calculate{
/**
 * Calculates nutrition information using class variables. The method then returns
 * a nutrition object containing this information.
 * 
 * @return Nutrition	a nutrition object containing caloric information
 */

  Nutrition calculateContent(); 
}
