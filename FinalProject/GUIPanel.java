import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIPanel extends JPanel {
    private Dog dog;
    
    private JLabel nameLabel;
    private JLabel sexLabel;
    private JLabel ageLabel;
    private JLabel breedLabel;
    private JLabel boroughLabel;
    private JLabel sizeLabel;
    private JLabel areaLabel;
    private JLabel phoneLabel;
    private JLabel confirmationLabel, resultsLabel;
    
    private JTextField nameField;
    private JTextField sexField;
    private JTextField ageField;
    private JTextField breedField;
    private JTextField boroughField;
    private JTextField sizeField;
    private JTextField areaField;
    private JTextField phoneField;

    private JButton submitButton;
    private JPanel createPanel;
    private JPanel buttonPanel;
    private String name,sex,breed,borough,size,area,phone;
    private int age;
    
    private Dog daisy;
    
    public GUIPanel(){

        this.dog = dog;

        // Constructor. Notice how it takes an instance of the game as input!
       // public TicTacToePanel(TicTacToe g) {
        // this.game = g;
        
        //setCanvasSize(1000, 1000);
        
        createPanel = new JPanel();
        createPanel.setPreferredSize(new Dimension(500,400));
        //createPanel.setBorder(BorderFactory.createLineBorder(Color.red, 10));
        
        nameLabel = new JLabel("Enter name.");
        createPanel.add(nameLabel);
        nameField = new JTextField(5);
        createPanel.add(nameField);
        
        sexLabel = new JLabel("Enter sex.");
        createPanel.add(sexLabel);
        sexField = new JTextField(5);
        createPanel.add(sexField);

        ageLabel = new JLabel("Enter age.");
        createPanel.add(ageLabel);
        ageField = new JTextField(5);
        createPanel.add(ageField);

        breedLabel = new JLabel("Enter breed.");
        createPanel.add(breedLabel);
        breedField = new JTextField(5);
        createPanel.add(breedField);

        boroughLabel = new JLabel("Enter borough.");
        createPanel.add(boroughLabel);
        boroughField = new JTextField(5);
        createPanel.add(boroughField);
        
        sizeLabel = new JLabel("Enter size.");
        createPanel.add(sizeLabel);
        sizeField = new JTextField(5);
        createPanel.add(sizeField);
        
        areaLabel = new JLabel("Enter area code.");
        createPanel.add(areaLabel);
        areaField = new JTextField(5);
        createPanel.add(areaField);
        
        phoneLabel = new JLabel("Enter phone number.");
        createPanel.add(phoneLabel);
        phoneField = new JTextField(5);
        createPanel.add(phoneField);
        
        submitButton = new JButton("Submit!");
        submitButton.addActionListener(new ButtonListener());
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(250,100));
        buttonPanel.setBackground (Color.blue);
        buttonPanel.add(submitButton);
        createPanel.add(buttonPanel);
        //add(submitButton);
        confirmationLabel = new JLabel("");
        add(confirmationLabel);
        resultsLabel = new JLabel("");
        add(resultsLabel);
        setPreferredSize(new Dimension(700,500));
        setBackground(Color.pink);
        //add(nameLabel);
        add(createPanel);
    }
    

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //System.out.println("WOW, YOU KNOW HOW TO CLICK A BUTTON! good for you.");
            if (e.getSource() == submitButton){
                name = nameField.getText();
                sex = sexField.getText();
                age = Integer.parseInt(ageField.getText());
                breed = breedField.getText();
                borough = boroughField.getText();
                size = sizeField.getText();
                area = areaField.getText();
                phone = phoneField.getText();
                daisy = new Dog(name,sex,age,breed,borough,size,area,phone);
                //confirmationLabel.setPreferredSize(new Dimension(1350,500));
                confirmationLabel.setLocation(900,1000);
                confirmationLabel.setText("Your dog profile " + daisy + " is created.");
                
                remove(createPanel);
                //remove(buttonPanel);
                //add(newPanel);
                
                
                
                
                
                //Lay out the label and scroll pane from top to bottom.
                
                JPanel allDogsDiv = new JPanel();
                //EDIT

        //add(vertical);
                //dogScroller.setAlignmentX(LEFT_ALIGNMENT);
                FavoriteDogs fDogs = new FavoriteDogs("datasets/dogs_50.csv", daisy);
                fDogs.sortByCriteria("age");
                Sorting.mergeSort(fDogs.getSubset(),new AgeComparator());
                fDogs.hashing();
                System.out.println(fDogs);
                for (Dog d: fDogs.getHash().get(daisy)) {
                    JPanel dogDiv = new JPanel(new BorderLayout());
                    
                    dogDiv.setLayout(new BoxLayout(dogDiv, BoxLayout.PAGE_AXIS));
                    JLabel nameLabel = new JLabel(d.getData("name"));
                    JLabel sexLabel = new JLabel(d.getData("sex"));
                    JLabel ageLabel = new JLabel(d.getData("age"));
                    JLabel breedLabel = new JLabel(d.getData("breed"));
                    JLabel locationLabel = new JLabel(d.getData("location"));
                    JLabel sizeLabel = new JLabel(d.getData("size"));
                    JLabel areaLabel = new JLabel(d.getData("area"));
                    JLabel phoneLabel = new JLabel(d.getData("phone"));
                    
                    //create a name card for each dog
                    dogDiv.add(nameLabel);
                    dogDiv.add(sexLabel);
                    dogDiv.add(ageLabel);
                    dogDiv.add(breedLabel);
                    dogDiv.add(locationLabel);
                    dogDiv.add(sizeLabel);
                    dogDiv.add(areaLabel);
                    dogDiv.add(phoneLabel);
                    dogDiv.add(Box.createRigidArea(new Dimension(0,5)));
                    //dogDiv.add(dogScroller);
                    dogDiv.setBorder(BorderFactory.createLineBorder(Color.black));
                    allDogsDiv.add(dogDiv);
                
                }
                
                JScrollPane dogScroller = new JScrollPane(allDogsDiv);
                //dogScroller.ScrolledPane();
                dogScroller.setPreferredSize(new Dimension(1000, 200));
                dogScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                add(dogScroller);
                //dogScroller.add(allDogsDiv);
                
                //resultsLabel.setAlignmentX(LEFT_ALIGNMENT);
                //resultsLabel.setText(fDogs.toString());
                //1. make sex a drop down
                //2. make seperate buttons for each sort (e.g sort to same age 
                //as Daisy, sort to same location as Daisy)
                //3. make fDogs a global variable so it doesnt get recreated 
                //everytime (slow), and sorted by a specfici dimension only 
                //if that speciic button is clicked
                //4. dont need to pass Dog into gui
            }
        }
    }
    
    public class ScrolledPane extends JPanel {
    private JScrollPane vertical;
    private JTextArea console;

    public ScrolledPane()
    {
        setPreferredSize(new Dimension(200, 250));
        console = new JTextArea(15, 15);

        vertical = new JScrollPane(console);
        vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(vertical);
    }


    // public static void main( String args[] )
    // {
        // new JFrame()
        // {{
            // getContentPane().add(new ScrolledPane());
            // pack();
            // setVisible(true);
        // }};
    // }
     }
    
    public Dog getOwnDog(){
            return daisy;
    }
    
}