
/**
 * DogCollection class reads from a file filled with rows of dog information, creates a FilterableDataset from it,
 * and provides method to filter the dataset by certain criteria
 *
 * @author (Shirley Lei, Willa Sun, Emily Yin)
 * @version (16 May 2019)
 */

import java.io.*;
import java.util.Vector;

public class DogCollection {
    
    private String category,criteria;
    private FilterableDataset fd;
    private Vector<Dog> dogCollection;
    private FilterableDataset filteredSet1;

    /**
     * Constructor for objects of class DogCollection
     * 
     * @param fileName - of type String, name of the dataset
     */
    public DogCollection(String fileName)
    {
        try {
            Reader r = new Reader (fileName);
            this.category = category;
            this.criteria = criteria;
            this.fd = r.getDataset();
            this.dogCollection = new Vector<Dog>();
            //create a copy of the original dataset so it can be used for other filtering criterion
            this.filteredSet1 = new FilterableDataset();
            //populate dataset with all
            for (Row row: fd){
                filteredSet1.add(row);
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }

    /**
     * filterCollection() filter the dataset by a criteria within a specified category
     *
     * @param  category  of type String, specifies the data field we are filtering by
     * @param criteria  of type String, value of the data field we are filterting to
     * @return    a filtered FilterableDataset
     */
    public FilterableDataset filterCollection(String category, String criteria){
        //create an empty FilterableDataset
        FilterableDataset outputFiltered = new FilterableDataset();
        //filter by borough
        if (category.equals("borough")){
            if (criteria.equals("Manhattan"))
                outputFiltered = filteredSet1.filterBy(new FilterToManhattan());
            else if (criteria.equals("Brooklyn"))
                outputFiltered = filteredSet1.filterBy(new FilterToBrooklyn());
            else if (criteria.equals("Bronx"))
                outputFiltered = filteredSet1.filterBy(new FilterToBronx());
            else if (criteria.equals("Queens"))
                outputFiltered = filteredSet1.filterBy(new FilterToQueens());
            else if (criteria.equals("Staten Island"))
                outputFiltered = filteredSet1.filterBy(new FilterToStatenIsland());
            //filter by sex
        } else if (category.equals("sex")){
            //System.out.println("got the right catergory");
            if (criteria.equals("F")) {
                //System.out.println("got the right catera");
                outputFiltered = filteredSet1.filterBy(new FilterToFemale());
            }else if (criteria.equals("M")) {
                outputFiltered = filteredSet1.filterBy(new FilterToMale());
            }
            //filter by size
        } else if (category.equals("size")){
            if (criteria.equals("L"))
                outputFiltered = filteredSet1.filterBy(new FilterToL());
            else if (criteria.equals("M"))
                outputFiltered = filteredSet1.filterBy(new FilterToM());
            else if (criteria.equals("S"))
                outputFiltered = filteredSet1.filterBy(new FilterToS());
        }
        //System.out.println(outputFiltered + "\n-------");
        return outputFiltered;
    }
    
    /**
     * getFilteredDataset() - getter for fitered dataset
     *
     * @return   the filtered dataset by category and criteria specified above
     */
    public FilterableDataset getFilteredDataset(){
        return filteredSet1;
    }
    
    /**
     * getCollection() - creates and returns a vector from a FilterableDataset of dogs
     *
     * @return   a vector of dogs contained in the filtered dataset
     */
    public Vector<Dog> getCollection(){
        for (Row dog: fd){
            //create a dog object from a row item in the filtered dataset
            Dog current = new Dog(dog.getName(),dog.getSex(), 
                    dog.getAge(),dog.getBreed(),dog.getBorough(),dog.getSize(),
                    dog.getArea(),dog.getPhone());
            //add the object to the vector
            this.dogCollection.add(current);
        }
        return dogCollection;
    }
    
    /** toString() provides a string representation of the FilterableDataset
     * 
     * @return a String representation
     */
    public String toString() {
        String s = "";
        for (Row v: filteredSet1) {
            //s+=v.getName();
            s+=v.getSex();
            //s+=v.getBorough();
        }
        return s;
    }

    public static void main (String[] args){
        DogCollection test = new DogCollection("datasets/dogs_100_size.csv");

        System.out.println(test.filterCollection("borough", "Brooklyn"));
        // System.out.println(test);
        // System.out.println("____________________________________________");
        // System.out.println(test.getFilteredDataset());
    }
}
