
package edu.ucalgary.ensf409;

public class GUIFamily extends JFrame implements ActionListener, MouseListener{
  
  private int numMales;
  private int numFemales;
  private int numChildU8;
  private int numChildO8; //might have to be strings then use Integer.parseInt()?
  
   private JLabel instructions;
   private JLabel mLabel;
   private JLabel fLabel;
   private JLabel U8Label;
   private JLabel O8Label;
    
   private JTextField mInput;
   private JTextField fInput;
   private JTextField U8Input;
   private JTextField O8Input;


    
  public GUIPetID(){
        super("Create a Family");
        setupGUI();
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
   
  }
  
  public void setupGUI(){
        instructions = new JLabel("Please enter your information to generate an identifier.");
        mLabel = new JLabel("Amount of adult males:");
        fLabel = new JLabel("Amount of adult females:");
        U8Label = new JLabel("Amount of children under 8:");
        O8Label = new JLabel("Amount of children over 8");
    
    
        mInput = new JTextField("e.g. 1", 3);
        fInput = new JTextField("e.g. 1", 3);
        U8Input = new JTextField("e.g. 1", 3);
        O8Input = new JTextField("e.g. 1", 3);
     
        mInput.addMouseListener(this);
        fInput.addMouseListener(this);
        U8Input.addMouseListener(this);
        O8Input.addMouseListener(this);
    
    
        JButton submitInfo = new JButton("Create Hamper");
        submitInfo.addActionListener(this);
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
    
        headerPanel.add(instructions);
        clientPanel.add(mLabel);
        clientPanel.add(mInput);
        clientPanel.add(fLabel);
        clientPanel.add(fInput);
        clientPanel.add(U8Label);
        clientPanel.add(U8Input);
        clientPanel.add(O8Label);
        clientPanel.add(O8Input);
        submitPanel.add(submitInfo);
    
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
  }
  
  public void actionPerformed(ActionEvent event){
        numMales = mInput.getText();
        numFemales = fInput.getText();
        numChildU8 = U8Input.getText();
        numChildO8 = O8Input.getText();
        
        if(validateInput()){
            String petID = idProcessing();
            JOptionPane.showMessageDialog(this, "Your pet's clinic ID is " + petID);
        }
    }
  
    
    public void mouseClicked(MouseEvent event){
        
        if(event.getSource().equals(mInput))
            mInput.setText("");

        if(event.getSource().equals(fInput))
            fInput.setText("");

        if(event.getSource().equals(U8Input))
            U8Input.setText("");

        if(event.getSource().equals(O8Input))
            O8Input.setText("");
                
    }
  
 

   public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
        
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){
        
    }

  private int[] idProcessing(){

        int[] family = {mInput, fInput, U8Input, O8Intput};
        
        return int[];
    }    

  //update boundary conditions
  private boolean validateInput(){
        
        boolean allInputValid = true;
        
        if(!Character.isUpperCase(firstName.charAt(0)) || firstName.length() < 2 || firstName.length() > 26){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, firstName + " is an invalid name input.");
        }
        
        if(!Character.isUpperCase(lastName.charAt(0)) || lastName.length() < 2 || lastName.length() > 26){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, lastName + " is an invalid name input.");
        }

        if(!Character.isUpperCase(petName.charAt(0)) || petName.length() < 2 || petName.length() > 26){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, petName + " is an invalid name input.");
        }

        if(birthYear < 1922 || birthYear > 2022){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, birthYear + " is an invalid birth year. Pets must be born between 1922 and 2022.");
        }
        
        return allInputValid;
        
    }
  
   public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new GUIFamily().setVisible(true);        
        });
    }
}
