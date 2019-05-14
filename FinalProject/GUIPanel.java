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
    private JLabel confirmationLabel, resultsLabel;
    
    private JTextField nameField;
    private JTextField sexField;
    private JTextField ageField;
    private JTextField breedField;
    private JTextField boroughField;
    private JTextField sizeField;

    private JButton submitButton;
    private JPanel createPanel;
    private JPanel buttonPanel;
    private String name,sex,breed,borough,size;
    private int age;
    
    private Dog daisy;
    
    public GUIPanel(){
        // Constructor. Notice how it takes an instance of the game as input!
      // public TicTacToePanel(TicTacToe g) {
        // this.game = g;
        
        this.dog = dog;
        
        createPanel = new JPanel();
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
        setPreferredSize(new Dimension(1300,500));
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
                daisy = new Dog(name,sex,age,breed,borough,size);
                confirmationLabel.setText("Your dog profile " + daisy + " is created.");
                
                /*JPanel newPanel = new JPanel();
                remove(createPanel);
                remove(buttonPanel);
                add(newPanel);
                */
               //EDIT
               FavoriteDogs fDogs = new  FavoriteDogs("datasets/dogs_50.csv");
               fDogs.sortByCriteria("age");
                Sorting.mergeSort(fDogs.getSubset(),new AgeComparator());
                fDogs.hashing();
                System.out.println(fDogs);
                resultsLabel.setText(fDogs.toString());
                //1. make sex a drop down
                //2. make seperate buttons for each sort (e.g sort to same age as Daisy, sort to same location as Daisy)
                //3. make fDogs a global variable so it doesnt get recreated everytime (slow), and sorted by a specfici dimension only if that speciic button is clicked
                //4. dont need to pass Dog into gui
            }
        }
    }
    
    public Dog getOwnDog(){
            return daisy;
    }
    
}