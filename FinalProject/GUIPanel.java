
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIPanel extends JPanel {
    private Dog dog;
    
    private JPanel allDogsDiv,filteredDogsDiv;
    
    private JLabel nameLabel;
    private JLabel sexLabel;
    private JLabel ageLabel;
    private JLabel breedLabel;
    private JLabel boroughLabel;
    private JLabel sizeLabel;
    private JLabel areaLabel;
    private JLabel phoneLabel;
    private JLabel confirmationLabel, resultsLabel,clickedGraphLabel,filterInstruction;
    private JLabel filteredLabel;
    
    private JTextField nameField;
    private JTextField sexField;
    private JTextField ageField;
    private JTextField breedField;
    private JTextField boroughField;
    private JTextField sizeField;
    private JTextField areaField;
    private JTextField phoneField;
    

    private JButton submitButton,generateGraphButton,sameSexButton,sameAgeButton,sameBoroughButton,sameSizeButton;
    private JPanel createPanel;
    private JPanel buttonPanel;
    private String name,sex,breed,borough,size,area,phone;
    private int age;
    
    private Dog daisy;
    
    private DogCollection allDogs;
    
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
        
        filterInstruction = new JLabel("Filter results that match on your dog! Based on...");
        sameSexButton = new JButton("Same sex");
        sameSexButton.addActionListener(new ButtonListener());
        
        sameBoroughButton = new JButton("Same borough");
        sameBoroughButton.addActionListener(new ButtonListener());
        
        sameSizeButton = new JButton("Same size");
        sameSizeButton.addActionListener(new ButtonListener());
        
        sameAgeButton = new JButton("Same age");
        sameAgeButton.addActionListener(new ButtonListener());
        
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
        
        generateGraphButton = new JButton("Generate dog connections graph!");
        generateGraphButton.addActionListener(new ButtonListener());
        clickedGraphLabel = new JLabel("");
        
        setPreferredSize(new Dimension(700,500));
        setBackground(Color.pink);
        //add(nameLabel);
        add(createPanel);
    }
    

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //System.out.println("WOW, YOU KNOW HOW TO CLICK A BUTTON! good for you.");
            if (e.getSource() == submitButton){
                add(filterInstruction);
                add(sameSexButton);
                add(sameBoroughButton);
                add(sameSizeButton);
                add(sameAgeButton);
                
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
                
                allDogsDiv = new JPanel();
                //EDIT
                filteredDogsDiv = new JPanel();
                //add(vertical);
                //dogScroller.setAlignmentX(LEFT_ALIGNMENT);
                allDogs = new DogCollection("datasets/dogs_100_size.csv");
                //FavoriteDogs fDogs = new FavoriteDogs("datasets/dogs_100_size.csv", daisy);
                //fDogs.sortByCriteria("age");
                //Sorting.mergeSort(fDogs.getSubset(),new AgeComparator());
                //fDogs.hashing();
                //System.out.println(fDogs);
                //for (Dog d: fDogs.getHash().get(daisy)) {
                for (Dog d: allDogs.getCollection()){
                    //create individual panel
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
                    
                    dogDiv.setBorder(BorderFactory.createLineBorder(Color.black));
                    allDogsDiv.add(dogDiv);
                
                }
                
                //create scroller
                JScrollPane dogScroller = new JScrollPane(allDogsDiv);
                dogScroller.setPreferredSize(new Dimension(2000, 200));
                dogScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                //add scroller to canvas
                add(dogScroller);
                
                //1. make sex a drop down
                //2. make seperate buttons for each sort (e.g sort to same age 
                //as Daisy, sort to same location as Daisy)
                //3. make fDogs a global variable so it doesnt get recreated 
                //everytime (slow), and sorted by a specfici dimension only 
                //if that speciic button is clicked
                //4. dont need to pass Dog into gui
                
                add(generateGraphButton);
                add(clickedGraphLabel);
                
            }
            
            if (e.getSource() == sameSexButton){
                FilterableDataset sameSex = allDogs.filterCollection("sex",daisy.getData("sex").toString());
                //filteredLabel = new JLabel("hi");
                filteredLabel = new JLabel(sameSex.toString());
                //FavoriteDogs sameSexSubset = new FavoriteDogs(allDogs.getCollection(),daisy);
                //FavoriteDogs fDogs = new FavoriteDogs("datasets/dogs_100_size.csv", daisy);
                //fDogs.sortByCriteria("age");
                //Sorting.mergeSort(fDogs.getSubset(),new AgeComparator());
                
                filteredDogsDiv.add(filteredLabel);
                add(filteredDogsDiv);
                //allDogsDiv.add(filteredLabel);
            }
            
            
            
            //if (e.getSource() == generateGraphButton){
                //JPanel dogGraph = new JPanel();
                    //clickedGraphLabel.setText("Your dog graph is saved to your computer"); 
                    //AllDogsGraph dogConnections = new AllDogsGraph();
                    //System.out.println("Clicked");
                    //saves tgf ??
                    //dogGraph.add(dogConnections);
                    //add(dogGraph);
                //}
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