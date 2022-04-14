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
	private boolean applicationExists = false;
	private ArrayList<int[]> family = new ArrayList<int[]>();

	public GUIFinalProject(){
        super("Create an Order Form Application"); //Calling the constructor of Jframe to set up a title for the window 
        setupGUI();
        setSize(1100,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }
	
	public void setupGUI(){
        
        instructions = new JLabel("Please enter your family information to generate a hamper. If you wish to add another family to your application click the button below or exit by pressing X in the top right corner.");
        aMLabel = new JLabel("How many Adult Males? ");
        aFLabel = new JLabel("How many Adult Females? ");
        cO8Label = new JLabel("How many Children Over 8?");
		cU8Label = new JLabel("How many Children Under 8? ");
        
        aMInput = new JTextField("e.g. 1", 10);
        aFInput = new JTextField("e.g. 0", 10);
        cU8Input = new JTextField("e.g. 2", 10);
        cO8Input = new JTextField("e.g. 5", 10);    
        
        aMInput.addMouseListener(this);
        aFInput.addMouseListener(this);
        cU8Input.addMouseListener(this);
        cO8Input.addMouseListener(this);
        
     
		addHamper = new JButton("Add Another Family Unit");
		addHamper.addActionListener(this);
		terminate = new JButton("Submit Application");
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
	
	 public void actionPerformed(ActionEvent event){
		boolean valid = validateInput();
		if(valid){
			adultM = Integer.parseInt(aMInput.getText());
			adultF = Integer.parseInt(aFInput.getText());
			childO8 = Integer.parseInt(cO8Input.getText());
			childU8 = Integer.parseInt(cU8Input.getText());
			
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
			if(!valid) {
				JOptionPane.showMessageDialog(this, "Submission for most recent unit was unsuccessful. Must submit valid entry to submit.");
			}

			else {
				
				try{
					Application application1 = new Application(family);
					/* LinkedList<Food> test = application1.getHamper(1);
					Nutrition test1 = application1.getFamily(0).getTotal();
					System.out.println(test1.getGrain());
					System.out.println(test1.getFV());
					System.out.println(test1.getProtein());
					System.out.println(test1.getOther());
					System.out.println(test1.getCalories());
					
					for(Food food : test) {
						System.out.println(food.getName());
					}
					 */
				}

				catch(NotEnoughInventoryException e){
					e.printStackTrace();
					System.exit(1);
				}
				
				catch(RemoveFromDataBaseFailedException e) {
					e.printStackTrace();
					System.exit(1);
				}
				
				
				
				
				super.dispose();
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
	
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new GUIFinalProject().setVisible(true); //Create everything and put it in then set the visibility to true 
        });
    }
}

