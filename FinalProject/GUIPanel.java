
/**
 * GUIPanel creates the main panel in the graphical interface of DogMeetsAnotherDog.
 *
 * @author (Shirley Lei, Willa Sun, Emily Yin)
 * @version (16 May 2019)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIPanel extends JPanel {
    //create variables for components for the GUI
    private JPanel allDogsDiv,filteredDogsDiv,headerDiv, subHeaderDiv;
    private FilterableDataset filteredOutput;

    private JLabel nameLabel, headerLabel, subheaderLabel,sexLabel,ageLabel,breedLabel,boroughLabel,sizeLabel,areaLabel,phoneLabel;
    private JLabel confirmationLabel, resultsLabel,clickedGraphLabel,filterInstruction, filterConfirmLabel,filteredLabel, clickedSortLabel,confirmFilter;
    private JTextField nameField, sexField, ageField, breedField, boroughField, sizeField, areaField, phoneField;
    private JButton submitButton,generateGraphButton,sameSexButton,sameBoroughButton,sameSizeButton, sortButton;
    private JPanel createPanel, filterConfirmPanel,buttonPanel;
    
    private String name,sex,breed,borough,size,area,phone;
    private int age;

    private Dog daisy; //daisy is the variable name for the dog that the user is prompted to created from the GUI
    private DogCollection allDogs,originalDogs;
    private JScrollPane filterScroller,sortScroller;
    private FavoriteDogs favList;

    /**
     * Constructor for GUIPanel()
     * 
     */
    public GUIPanel(){
        //instantiate components on the GUI
        
        //add header
        headerDiv = new JPanel();
        headerDiv.setPreferredSize(new Dimension(1200,40));
        headerLabel = new JLabel("DogMeetsAnotherDogTM");
        headerLabel.setFont(new Font("SanSerif", Font.PLAIN, 20));
        headerDiv.add(headerLabel);
        add(headerDiv);
        
        //add main panel where the creation of user's input dog takes place
        createPanel = new JPanel();
        createPanel.setPreferredSize(new Dimension(500,400));
        
        //add subheader
        subHeaderDiv = new JPanel();
        subHeaderDiv.setPreferredSize(new Dimension(500,40));
        subheaderLabel = new JLabel("Create your dog profile!");
        subheaderLabel.setFont(new Font("SanSerif", Font.PLAIN, 14));
        subHeaderDiv.add(subheaderLabel);
        createPanel.add(subHeaderDiv);

        //make labels for user input
        nameLabel = new JLabel("Name:");
        createPanel.add(nameLabel);
        nameField = new JTextField(5);
        createPanel.add(nameField);

        sexLabel = new JLabel("Sex(F/M):");
        createPanel.add(sexLabel);
        sexField = new JTextField(5);
        createPanel.add(sexField);

        ageLabel = new JLabel("Age:");
        createPanel.add(ageLabel);
        ageField = new JTextField(5);
        createPanel.add(ageField);

        breedLabel = new JLabel("Breed:");
        createPanel.add(breedLabel);
        breedField = new JTextField(5);
        createPanel.add(breedField);

        boroughLabel = new JLabel("Borough:");
        createPanel.add(boroughLabel);
        boroughField = new JTextField(5);
        createPanel.add(boroughField);

        sizeLabel = new JLabel("Size (S/M/L):");
        createPanel.add(sizeLabel);
        sizeField = new JTextField(5);
        createPanel.add(sizeField);

        areaLabel = new JLabel("Area code (XXX):");
        createPanel.add(areaLabel);
        areaField = new JTextField(5);
        createPanel.add(areaField);

        phoneLabel = new JLabel("Phone number (XXX-XXXX):");
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

        submitButton = new JButton("Submit!");
        submitButton.addActionListener(new ButtonListener());
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(500,50));
        buttonPanel.setBackground (new Color(249, 129, 69));
        buttonPanel.add(submitButton);
        createPanel.add(buttonPanel);
        confirmationLabel = new JLabel("");
        add(confirmationLabel);
        resultsLabel = new JLabel("");
        add(resultsLabel);

        sortButton = new JButton("Show filtered results (sorted by age)");
        sortButton.addActionListener(new ButtonListener());
        clickedSortLabel = new JLabel("");
        
        JPanel filterConfirmPanel = new JPanel();
        filterConfirmLabel = new JLabel("");
        filterConfirmPanel.add(filterConfirmLabel);
        add(filterConfirmPanel);

        generateGraphButton = new JButton("Generate dog connections graph!");
        generateGraphButton.addActionListener(new ButtonListener());
        clickedGraphLabel = new JLabel("");

        setPreferredSize(new Dimension(700,500));
        setBackground(new Color(247,209,96));
        //add(nameLabel);
        add(createPanel);
        allDogs = new DogCollection("datasets/dogs_100_size.csv");
        originalDogs = new DogCollection("datasets/dogs_100_size.csv");
        //System.out.println(originalDogs.getCollection());
        
    }
    
    /**
     * Inner class ButtonListener defines events that are triggered by clicking various buttons. 
     * 
     */
    private class ButtonListener implements ActionListener {
        /**
         * ActionPerformed takes events and checks which button triggered the event, and defines appropriate action after button click
         * @param e the event
         */
        public void actionPerformed(ActionEvent e) {
            //System.out.println("WOW, YOU KNOW HOW TO CLICK A BUTTON! good for you.");
            //if the source of the even was the Submit Button (when the user submits the user's created dog to the program)
            if (e.getSource() == submitButton){
                //add appropriate components that provide instructions/allow user to filter and sort
                add(filterInstruction);
                add(sameSexButton);
                add(sameBoroughButton);
                add(sameSizeButton);
                
                //create a Dog object from the user's inputs
                name = nameField.getText();
                sex = sexField.getText();
                age = Integer.parseInt(ageField.getText());
                breed = breedField.getText();
                borough = boroughField.getText();
                size = sizeField.getText();
                area = areaField.getText();
                phone = phoneField.getText();
                //store that user created Dog object in daisy
                daisy = new Dog(name,sex,age,breed,borough,size,area,phone);
                
                //confirmation message for user that profile is created
                JPanel dogIntroDiv = new JPanel();
                dogIntroDiv.setPreferredSize(new Dimension(1000,40));
                confirmationLabel.setLocation(900,1000);
                confirmationLabel.setText("Your dog profile for " + daisy.getData("name") + " is created! " + 
                    "We got that " + daisy.getData("name")  + " is a " + daisy.getData("age")  + " year old " + daisy.getData("breed")  + " from " 
                     + daisy.getData("location")  + "!");
                dogIntroDiv.add(confirmationLabel);
                add(dogIntroDiv);
                remove(createPanel);
                
                //create empty panel to eventually hold all dogs
                allDogsDiv = new JPanel();
                //create empty panel to eventually hold filtered dogs
                filteredDogsDiv = new JPanel(new BorderLayout());
                filteredDogsDiv.setLayout(new BoxLayout(filteredDogsDiv, BoxLayout.PAGE_AXIS));
                filteredDogsDiv.setPreferredSize(new Dimension(1000,800));
                
                //for each dog in all dogs, create a GUI "card" that contains that dog's information
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
                    //add current dog's panel to all dogs
                    allDogsDiv.add(dogDiv);

                }

                //create scroller
                JScrollPane dogScroller = new JScrollPane(allDogsDiv);
                dogScroller.setPreferredSize(new Dimension(2000, 200));
                dogScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                //add scroller to canvas
                add(dogScroller);
                //add more components for perform actions
                add(generateGraphButton);
                add(clickedGraphLabel);
                add(sortButton);
                add(clickedSortLabel);
            }
            //if the source of the event is the click of the filter to same sex button
            if (e.getSource() == sameSexButton){
                //filteredOutput = allDogs.filterCollection("sex",daisy.getData("sex"));
                favList = new FavoriteDogs((allDogs.filterCollection("sex",daisy.getData("sex"))),daisy); //set favList to this filter
                //add(filterConfirmLabel);
                filterConfirmLabel.setText("Filter set to sex!"); //set the current filter label to sex
                //add(filterConfirmPanel);
            }
            if (e.getSource() == sameBoroughButton){ //if the source of the event is the click of the filter to same borough button
                 //favList = new FavoriteDogs((allDogs.filterCollection("borough",daisy.getData("borough"))),daisy);
                favList = new FavoriteDogs((allDogs.filterCollection("borough",daisy.getData("location"))),daisy);
                filterConfirmLabel.setText("Filter set to borough!");//set the current filter label to borough
            }
            if (e.getSource() == sameSizeButton){//if the source of the event is the click of the filter to same size button
                favList = new FavoriteDogs((allDogs.filterCollection("size",daisy.getData("size"))),daisy);
                filterConfirmLabel.setText("Filter set to size!");
            }
            if (e.getSource() == sortButton){//if the source of the event is the click of the sort button
                //System.out.println("Clickedd");
                //System.out.println("fav list is " + favList);
                
                //Sort the favList by age
                FilterableDataset result = favList.sortByCriteria("age");
                //System.out.println("result is " + result);
                //FilterableDataset result = Sorting.mergeSort(favList.getCollection(),new AgeComparator());
                //create a new empty panel
                JPanel sortedDogsDiv = new JPanel();
                //for each row (containing information about each dog) in the resulting filerableDataset, create a "card" visual and add to the sortedDogsDiv
                for (Row row: result) {
                    JPanel rowDiv = new JPanel(new BorderLayout());
                    //get information from the row
                    rowDiv.setLayout(new BoxLayout(rowDiv, BoxLayout.PAGE_AXIS));
                    JLabel nameLabel = new JLabel(row.getName());
                    JLabel sexLabel = new JLabel(row.getSex());
                    JLabel ageLabel = new JLabel(String.valueOf(row.getAge()));
                    JLabel breedLabel = new JLabel(row.getBreed());
                    JLabel locationLabel = new JLabel(row.getBorough());
                    JLabel sizeLabel = new JLabel(row.getSize());
                    JLabel areaLabel = new JLabel(row.getArea());
                    JLabel phoneLabel = new JLabel(row.getPhone());
                    //add information from the row to the labels
                    rowDiv.add(nameLabel);
                    rowDiv.add(sexLabel);
                    rowDiv.add(ageLabel);
                    rowDiv.add(breedLabel);
                    rowDiv.add(locationLabel);
                    rowDiv.add(sizeLabel);
                    rowDiv.add(areaLabel);
                    rowDiv.add(phoneLabel);
                    rowDiv.add(Box.createRigidArea(new Dimension(0,5)));

                    rowDiv.setBorder(BorderFactory.createLineBorder(Color.black));
                    //add rows to the overall panel
                    sortedDogsDiv.add(rowDiv);
                }
                //sortScroller.add(sortedDogsDiv); 
                clickedSortLabel.setText("Sorted!"); //provide confirmation text
                sortScroller = new JScrollPane(sortedDogsDiv);
                sortScroller.setPreferredSize(new Dimension(1000, 200));
                sortScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                add(sortScroller);
            }
            //if the source of the event is the click of the generate graph button:
            if (e.getSource() == generateGraphButton){
                //System.out.println(favList);
                clickedGraphLabel.setText("Your dog graph is saved to your computer"); 
                //saves tgf to user's computer
                AllDogsGraph dogConnections = new AllDogsGraph(originalDogs.getCollection(),daisy);
                //System.out.println("dogConnection \n" + dogConnections);
                //System.out.println("Clicked");
            }
        }
    } 
}