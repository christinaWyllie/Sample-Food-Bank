/**
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: RemoveFromDataBaseFailedException.java
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
 * This class extends the default exception class to create a custom 
 * exception that is thrown when the hamper information obtained 
 * throughout the program is not able to be removed from the database
 * successfully.
 */
 
public class RemoveFromDataBaseFailedException extends Exception{
	/**
	 * This method is the custom exception that extends the exception class
	 * that prints the message "Unsuccessful removal from the DataBase" 
	 * when it is thrown.
	 */
	public RemoveFromDataBaseFailedException(){
		super("Unsuccessful removal from the DataBase");
	}
}
