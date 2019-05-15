
/**
 * Write a description of class DogCollection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import java.util.Vector;

public class DogCollection
{
    // instance variables - replace the example below with your own
    private String category,criteria;
    private FilterableDataset fd;
    private Vector<Dog> dogCollection;
    private FilterableDataset filteredSet;
    //private FilterableDataset 

    /**
     * Constructor for objects of class DogCollection
     */
    public DogCollection(String fileName)
    {
        try {
            Reader r = new Reader (fileName);
            this.category = category;
            this.criteria = criteria;
            this.fd = r.getDataset();
            this.dogCollection = new Vector<Dog>();
            //create a copy of the original dataset so it can be used for other
            //filtering criterion
            this.filteredSet = new FilterableDataset();
            
            for (Row row: fd){
                //filteredSet1.add(row);
                filteredSet.add(row);
            }
            
            getCollection();
        } catch (IOException e){
            System.out.println(e);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public FilterableDataset filterCollection(String category, String criteria){

        for (Row r: filteredSet){
            filteredSet.add(r);
        }
        //filter by borough
        if (category.equals("borough")){
            if (criteria.equals("Manhattan"))
                filteredSet.filterBy(new FilterToManhattan());
            else if (criteria.equals("Brooklyn"))
                filteredSet.filterBy(new FilterToBrooklyn());
            else if (criteria.equals("Bronx"))
                filteredSet.filterBy(new FilterToBronx());
            else if (criteria.equals("Queens"))
                filteredSet.filterBy(new FilterToQueens());
            else if (criteria.equals("Staten Island"))
                filteredSet.filterBy(new FilterToStatenIsland());
        //filter by age
        } else if (category.equals("age")){
            if (criteria.equals("Old"))
                filteredSet.filterBy(new FilterToOld());
            else if (criteria.equals("Young"))
                filteredSet.filterBy(new FilterToYoung());
        //filter by sex
        } else if (category.equals("sex")){
            if (criteria.equals("F"))
                filteredSet.filterBy(new FilterToFemale());
            else if (criteria.equals("M"))
                filteredSet.filterBy(new FilterToMale());
        //filter by size
        } else if (category.equals("size")){
            if (criteria.equals("L"))
                filteredSet.filterBy(new FilterToL());
            else if (criteria.equals("M"))
                filteredSet.filterBy(new FilterToM());
            else if (criteria.equals("S"))
                filteredSet.filterBy(new FilterToS());
        }

        //Sorting.mergeSort(subset,new AgeComparator());
        return filteredSet;
    }
    
    public FilterableDataset getFilteredDataset(){
        return filteredSet;
    }
    
    public Vector<Dog> getCollection(){
        for (Row dog: filteredSet){
            Dog current = new Dog(dog.getName(),dog.getSex(), 
                dog.getAge(),dog.getBreed(),dog.getBorough(),dog.getSize(),
                dog.getArea(),dog.getPhone());
            this.dogCollection.add(current);
        }
        return dogCollection;
    }
    
    public static void main (String[] args){
        DogCollection test = new DogCollection("datasets/dogs_100_size.csv");
    }
}
