import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

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
	
	private static boolean applicationExists = false;

	public GUIFinalProject(){
        super("Create an Order Form Application"); //Calling the constructor of Jframe to set up a title for the window 
        setupGUI();
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
	
	public void setupGUI(){
        
        instructions = new JLabel("Please enter your family information to generate a hamper.\n If you wish to add another family to your application click the button below or exit by pressing X in the top right corner.");
        aMLabel = new JLabel("How many Adult Males? ");
        aFLabel = new JLabel("How many Adult Females? ");
        cU8Label = new JLabel("How many Childern Under 8? ");
        cO8Label = new JLabel("How many Childern Over 8?");
        
        aMInput = new JTextField("e.g. 1", 10);
        aFInput = new JTextField("e.g. 0", 10);
        cU8Input = new JTextField("e.g. 2", 10);
        cO8Input = new JTextField("e.g. 5", 10);    
        
        aMInput.addMouseListener(this);
        aFInput.addMouseListener(this);
        cU8Input.addMouseListener(this);
        cO8Input.addMouseListener(this);
        
    //JButton terminateApplication = new JButton("End Application");
		//terminateApplication.addActionListener(this);
		JButton addHamper = new JButton("Add Another Family Unit");
		addHamper.addActionListener(this);
        
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
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }
	
	 public void actionPerformed(ActionEvent event){
        adultM = Integer.parseInt(aMInput.getText());
        adultF = Integer.parseInt(aFInput.getText());
        childO8 = Integer.parseInt(cO8Input.getText());
        childU8 = Integer.parseInt(cU8Input.getText());
        
        if(validateInput()){
           int[] familyArray = {adultM, adultF, childO8, childU8};
		   /* if(!applicationExists) {
				Application application1 = new Application();
			}
			
			else{
				application1.addHamper();
			}
			 */
			String message = "Your family unit is: " + adultM + " Adult Males, " + adultF + " Adult Females, " + childO8 + " Childern Over 8, " + childU8 + " Childern Under 8.";
            JOptionPane.showMessageDialog(this, message);
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
		
        if(adultM < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, adultM + " is not a positive integer. Input must be 0 or greater.");
        }
		
		if(adultF < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, adultM + " is not a positive integer. Input must be 0 or greater.");
        }
		
		if(childU8 < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, adultM + " is not a positive integer. Input must be 0 or greater.");
        }
		
		 if(childO8 < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, adultM + " is not a positive integer. Input must be 0 or greater.");
        }
		
        return allInputValid;
        
    }
	
	
    public static void main(String args[]) {

        EventQueue.invokeLater(() -> {
            new GUIFinalProject().setVisible(true); //Create everything and put it in then set the visibility to true 
        });
    }
}
