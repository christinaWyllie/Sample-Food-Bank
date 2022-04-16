/**
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: GUIFinalProject.java
Date Submitted: April 18th, 2022
*@author Sanika Shendye <a href="mailto:sanika.shendye@ucalgary.ca">
	sanika.shendye@ucalgary.ca</a>
*@author Sobia Khan <a href="sobia.khan1@ucalgary.ca">
	sobia.khan1@ucalgary.ca</a>
* @author Christina Wyllie <a href="christina.wyllie@ucalgary.ca">
	christina.wyllie@ucalgary.ca</a>
* @author Maitry Rohit <a href="mailto:maitry.rohit@ucalgary.ca">
	maitry.rohitAucalgary.ca</a>
* @version 1.6
* @since 1.0
 */


/**
* GUIFinalProject Class: This class creates an user interface which takes in text arguments for how many individuals belong in a hamper and displays the submitted family unit
* 	Interface supports the creation of multiple hampers by the JButton "hamper" and also causes the termination of the application once submit application is clicked
*	Allows any input however interface asks for resubmission if the JTextField does not translate to a positive integer
*	Displays "error message" when: 
*		User inputs 0's into every text field
*		User inputs a non numeric character
*		User inputs a -1 integer or decimal value
*		User clears the field and submits an empty field
	***In all above cases the program does not terminate, but the GUI prompts for another submission which is valid 
*	
*	Program termination only occurs if the X button is pressed (no valid application will go through) OR
*	"Submit Application" button is pressed (valid application is gone through)
*	
*	NOTE: This is the driver of our entire application submission 
*/

package edu.ucalgary.ensf409;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;
import java.io.*;

public class GUIFinalProject extends JFrame implements ActionListener, MouseListener {
    //Prompts user for 4 client types 
	private int adultM = 0;
    private int adultF = 0;
    private int childU8 = 0;
    private int childO8 = 0;
    
    private JLabel instructions;
    private JLabel aMLabel;
    private JLabel aFLabel;
    private JLabel cU8Label;
    private JLabel cO8Label;
    
    private JTextField aMInput;
    private JTextField aFInput;
    private JTextField cU8Input;
    private JTextField cO8Input;
	
	private JButton addHamper;
	private JButton terminate;

	//Array list that will be submitted to application
	private ArrayList<int[]> family = new ArrayList<int[]>();

	public GUIFinalProject(){
        super("Create an Order Form Application"); //Calling the constructor of Jframe to set up a title for the window 
        setupGUI();
        setSize(1100,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Program Termination
    }
	
	public void setupGUI(){
        
        instructions = new JLabel("Please enter your family information. To add another family click the \"Add Another Family Unit\" button below or submit the application by clicking \"Submit Application\".");
        aMLabel = new JLabel("How many Adult Males? ");
        aFLabel = new JLabel("How many Adult Females? ");
        cO8Label = new JLabel("How many Children Over 8?");
		cU8Label = new JLabel("How many Children Under 8? ");
        
        aMInput = new JTextField("e.g. 1", 10); //Example values (if submitted will display a message and prompt for resubmission)
        aFInput = new JTextField("e.g. 0", 10);
        cU8Input = new JTextField("e.g. 2", 10);
        cO8Input = new JTextField("e.g. 5", 10);    
        
        aMInput.addMouseListener(this);
        aFInput.addMouseListener(this);
        cU8Input.addMouseListener(this);
        cO8Input.addMouseListener(this);
        
     
		addHamper = new JButton("Add Another Family Unit"); //Adds another family aka another hamper
		addHamper.addActionListener(this);
		terminate = new JButton("Submit Application"); //Causes application to go through
		terminate.addActionListener(this);
        
		JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new GridLayout(4,1));

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
		
        headerPanel.add(instructions);
        clientPanel.add(aMLabel);
        clientPanel.add(aMInput);
        clientPanel.add(aFLabel);
        clientPanel.add(aFInput);
        clientPanel.add(cU8Label);
        clientPanel.add(cU8Input);
        clientPanel.add(cO8Label);
        clientPanel.add(cO8Input);
		submitPanel.add(addHamper);
		submitPanel.add(terminate);
		
		headerPanel.setBackground(new Color(233, 205, 208));
		clientPanel.setBackground(new Color(233, 205, 208));
		submitPanel.setBackground(new Color(233, 205, 208));
		addHamper.setBackground(new Color(164, 215, 211));
		terminate.setBackground(new Color(164, 215, 211));
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }
	/**
	* actionPreformed: 1 of 2 buttons is clicked
	*	In general method will always:
	*		Create an integer array of user input and add it to ArrayList<int[]> family object
	*		Then displays a submission for unit successful notification and clears fields for next submission
	*				
	*	terminate button: 
	*		Takes the last family unit created (whatever is currently in text field)
	*		Checks validity of input (if invalid will prompt for another submission and submission will not go through)
	*		As soon as next valid input is created the application will submit the family object and begin the application process
	*		GUI will be disposed and system will exit when orderForm is created 
	*
	* @param ActionEvent event: Will contain what specific button was clicked and preform operation (addHamper or terminate)
	*/
	 public void actionPerformed(ActionEvent event){
		boolean valid = validateInput();
		if(valid){
			adultM = Integer.parseInt(aMInput.getText()); 
			adultF = Integer.parseInt(aFInput.getText());
			childO8 = Integer.parseInt(cO8Input.getText());
			childU8 = Integer.parseInt(cU8Input.getText());
			
			//Checks that user did not submit all 0's (if they did the submission will not go through)
			int check0 = adultM + adultF + childO8 + childU8;
			if( check0 == 0) {
				JOptionPane.showMessageDialog(this, "Your hamper must contain at least 1 family member.");
			}
			
			else{
				int[] familyArray = {adultM, adultF, childO8, childU8};
				family.add(familyArray);
					
				String message = "Your family unit is: " + adultM + " Adult Males, " + adultF + " Adult Females, " + childO8 + " Children Over 8, " + childU8 + " Children Under 8.\nFamily added to order.";
				JOptionPane.showMessageDialog(this, message);
				aMInput.setText("");
				aFInput.setText("");
				cU8Input.setText("");
				cO8Input.setText("");
			}
		}
		
		if(event.getSource() == terminate) {
			if(!valid) { //When invalid but terminate button is clicked the program will not terminate unless the most recent submission is valid 
				JOptionPane.showMessageDialog(this, "Submission for most recent unit was unsuccessful. Must submit valid entry to submit.");
			}

			else {
				
				try{
					Application application1 = new Application(family);
				}

				catch(NotEnoughInventoryException e){
					e.printStackTrace();
					//System.exit(1);
				}
				
				catch(RemoveFromDataBaseFailedException e) {
					e.printStackTrace();
					//System.exit(1);
				}
				super.dispose(); //Hide GUI
			}
		}
    }
	
	public void mouseClicked(MouseEvent event){
        
        if(event.getSource().equals(aMInput))
            aMInput.setText("");

        if(event.getSource().equals(aFInput))
            aFInput.setText("");

        if(event.getSource().equals(cU8Input))
            cU8Input.setText("");

        if(event.getSource().equals(cO8Input))
            cO8Input.setText("");
                
    }
	
	//Need to exist because of interface but they are left blank
    public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
        
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){
        
    }

    // Private method which checks the input for each box
    private boolean validateInput(){
        
        boolean allInputValid = true;
		
        if(!isNumeric(aMInput.getText())){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, aMInput.getText() + " is not a valid input. Must be a positive integer.");
        }
		
		if(!isNumeric(aFInput.getText())){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, aFInput.getText() + " is not a valid input. Must be a positive integer.");
        }
		
		if(!isNumeric(cO8Input.getText())){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, cO8Input.getText() + " is not a valid input. Must be a positive integer.");
        }
		
		 if(!isNumeric(cU8Input.getText())){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, cU8Input.getText() + " is not a valid input. Must be a positive integer.");
        }
		
        return allInputValid;
        
    }
	/*
	* @param String input: Gets the JTextField of specified box and checks whether it is a positive integer
	*/
	// isNumeric method to assert that the input for each box is a valid number
	public boolean isNumeric(String input) {
		boolean result = true;
		try {
			int check = Integer.parseInt(input);
			if(check < 0) {
				result = false;
			}
		}
		catch (Exception e) {
			result = false;
		}
		return result;
	}

	/*
	* @param String ars[]
	*/
	//main method which drives the code
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new GUIFinalProject().setVisible(true); //Create everything and put it in then set the visibility to true 
        });
    }
}


