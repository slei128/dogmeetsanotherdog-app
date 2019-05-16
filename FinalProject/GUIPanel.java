
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIPanel extends JPanel {
    private Dog dog;

    private JPanel allDogsDiv,filteredDogsDiv,headerDiv, subHeaderDiv;
    private FilterableDataset filteredOutput;

    private JLabel nameLabel, headerLabel, subheaderLabel;
    private JLabel sexLabel;
    private JLabel ageLabel;
    private JLabel breedLabel;
    private JLabel boroughLabel;
    private JLabel sizeLabel;
    private JLabel areaLabel;
    private JLabel phoneLabel;
    private JLabel confirmationLabel, resultsLabel,clickedGraphLabel,filterInstruction, filterConfirmLabel;
    private JLabel filteredLabel, clickedSortLabel,confirmFilter;

    private JTextField nameField, sexField, ageField, breedField, boroughField, sizeField, areaField, phoneField;

    private JButton submitButton,generateGraphButton,sameSexButton,sameBoroughButton,sameSizeButton, sortButton;
    private JPanel createPanel, filterConfirmPanel;
    private JPanel buttonPanel;
    private String name,sex,breed,borough,size,area,phone;
    private int age;

    private Dog daisy;

    private DogCollection allDogs,originalDogs;
    

    private JScrollPane filterScroller,sortScroller;

    private FavoriteDogs favList;
    
    private FilterableDataset origin;

    public GUIPanel(){
        this.dog = dog;
        
        headerDiv = new JPanel();
        headerDiv.setPreferredSize(new Dimension(1200,40));
        headerLabel = new JLabel("DogMeetsAnotherDogTM");
        headerLabel.setFont(new Font("SanSerif", Font.PLAIN, 20));
        headerDiv.add(headerLabel);
        add(headerDiv);
        
        createPanel = new JPanel();
        createPanel.setPreferredSize(new Dimension(500,400));
        //createPanel.setBorder(BorderFactory.createLineBorder(Color.red, 10));
        
        subHeaderDiv = new JPanel();
        subHeaderDiv.setPreferredSize(new Dimension(500,40));
        subheaderLabel = new JLabel("Create your dog profile!");
        subheaderLabel.setFont(new Font("SanSerif", Font.PLAIN, 14));
        subHeaderDiv.add(subheaderLabel);
        createPanel.add(subHeaderDiv);

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
        //add(submitButton);
        confirmationLabel = new JLabel("");
        add(confirmationLabel);
        resultsLabel = new JLabel("");
        add(resultsLabel);

        
        sortButton = new JButton("Sort by age.");
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
        
        System.out.println("____________________________________________________");
        //origin = new FilterableDataset();
        // origin = originalDogs.getFilteredDataset();
        // System.out.println(origin);
        // System.out.println("___________________________________________________");
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //System.out.println("WOW, YOU KNOW HOW TO CLICK A BUTTON! good for you.");
            if (e.getSource() == submitButton){
                add(filterInstruction);
                add(sameSexButton);
                add(sameBoroughButton);
                add(sameSizeButton);

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

                //Lay out the label and scroll pane from top to bottom.

                allDogsDiv = new JPanel();
                //EDIT
                filteredDogsDiv = new JPanel(new BorderLayout());
                filteredDogsDiv.setLayout(new BoxLayout(filteredDogsDiv, BoxLayout.PAGE_AXIS));
                filteredDogsDiv.setPreferredSize(new Dimension(1000,800));
                //add(vertical);
                //dogScroller.setAlignmentX(LEFT_ALIGNMENT);
                
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
                //filterConfirmPanel = new JPanel();
                
                add(generateGraphButton);
                add(clickedGraphLabel);
                add(sortButton);
                add(clickedSortLabel);
            }

            if (e.getSource() == sameSexButton){
                //filteredOutput = allDogs.filterCollection("sex",daisy.getData("sex"));
                favList = new FavoriteDogs((allDogs.filterCollection("sex",daisy.getData("sex"))),daisy);
                //createFilteredCards("sex",daisy.getData("sex"));
                //add(filterConfirmLabel);
                filterConfirmLabel.setText("Filter set to sex!");
                //add(filterConfirmPanel);
            }
            if (e.getSource() == sameBoroughButton){
                //createFilteredCards("borough",daisy.getData("borough"));
                 //favList = new FavoriteDogs((allDogs.filterCollection("borough",daisy.getData("borough"))),daisy);
                favList = new FavoriteDogs((allDogs.filterCollection("borough",daisy.getData("location"))),daisy);
                filterConfirmLabel.setText("Filter set to borough!");
            }
            if (e.getSource() == sameSizeButton){
                //createFilteredCards("size",daisy.getData("size"));
                 favList = new FavoriteDogs((allDogs.filterCollection("size",daisy.getData("size"))),daisy);
                filterConfirmLabel.setText("Filter set to size!");
            }
            if (e.getSource() == sortButton){
                System.out.println("Clickfefegged");
                //favList = new FavoriteDogs((allDogs.filterCollection("sex","F")),daisy);
                System.out.println("fav list is " + favList);

                FilterableDataset result = favList.sortByCriteria("age");
                System.out.println("result is " + result);
                //FilterableDataset result = Sorting.mergeSort(favList.getCollection(),new AgeComparator());

                JPanel sortedDogsDiv = new JPanel();
                
                //JLabel sortedResults = new JLabel();
                for (Row row: result) {
                    JPanel rowDiv = new JPanel(new BorderLayout());

                    rowDiv.setLayout(new BoxLayout(rowDiv, BoxLayout.PAGE_AXIS));
                    JLabel nameLabel = new JLabel(row.getName());
                    JLabel sexLabel = new JLabel(row.getSex());
                    JLabel ageLabel = new JLabel(String.valueOf(row.getAge()));
                    JLabel breedLabel = new JLabel(row.getBreed());
                    JLabel locationLabel = new JLabel(row.getBorough());
                    JLabel sizeLabel = new JLabel(row.getSize());
                    JLabel areaLabel = new JLabel(row.getArea());
                    JLabel phoneLabel = new JLabel(row.getPhone());

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
                    sortedDogsDiv.add(rowDiv);
                }
                //sortScroller.add(sortedDogsDiv); 
                clickedSortLabel.setText("Sorted!");
                sortScroller = new JScrollPane(sortedDogsDiv);
                sortScroller.setPreferredSize(new Dimension(1000, 200));
                sortScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                add(sortScroller);
            }

            if (e.getSource() == generateGraphButton){
                System.out.println(favList);
                //JPanel dogGraph = new JPanel();
                clickedGraphLabel.setText("Your dog graph is saved to your computer"); 

                AllDogsGraph dogConnections = new AllDogsGraph(originalDogs.getCollection(),daisy);
                System.out.println("dogConnection \n" + dogConnections);
                
                System.out.println("Clicked");
                //saves tgf
                //dogGraph.add(dogConnections);
                //add(dogGraph);
            }

        }
    }
    /*
    private FilterableDataset createFilteredCards(String category, String criteria) {
        filteredOutput = allDogs.filterCollection(category,criteria);

        for (Row row: filteredOutput) {
            JPanel rowDiv = new JPanel(new BorderLayout());

            rowDiv.setLayout(new BoxLayout(rowDiv, BoxLayout.PAGE_AXIS));
            JLabel nameLabel = new JLabel(row.getName());
            JLabel sexLabel = new JLabel(row.getSex());
            JLabel ageLabel = new JLabel(String.valueOf(row.getAge()));
            JLabel breedLabel = new JLabel(row.getBreed());
            JLabel locationLabel = new JLabel(row.getBorough());
            JLabel sizeLabel = new JLabel(row.getSize());
            JLabel areaLabel = new JLabel(row.getArea());
            JLabel phoneLabel = new JLabel(row.getPhone());

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
            filteredDogsDiv.add(rowDiv);
        }

        filterScroller = new JScrollPane(filteredDogsDiv);
        filterScroller.setPreferredSize(new Dimension(1000, 200));
        filterScroller.setVerticalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(filterScroller);
        return filteredOutput;
    }
    */

    public Dog getOwnDog(){
        return daisy;
    }

}