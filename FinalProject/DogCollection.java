
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
    private FilterableDataset fd;
    private Vector<Dog> dogCollection;
    private FilterableDataset filteredSet;

    /**
     * Constructor for objects of class DogCollection
     */
    public DogCollection(String fileName)
    {
        try {
            Reader r = new Reader (fileName);
            this.fd = r.getDataset();
            this.dogCollection = new Vector<Dog>();
            //create a copy of the original dataset so it can be used for other
            //filtering criterion
            this.filteredSet = new FilterableDataset();
            for (Row row: fd){
                filteredSet.add(row);
            }
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
        } else if (category.equals("age")){
            if (criteria.equals("Old"))
                filteredSet.filterBy(new FilterToOld());
            else if (criteria.equals("Young"))
                filteredSet.filterBy(new FilterToYoung());
        } else if (category.equals("sex")){
            if (criteria.equals("F"))
                filteredSet.filterBy(new FilterToFemale());
            else if (criteria.equals("M"))
                filteredSet.filterBy(new FilterToMale());
        }
        //can also filter by size

        //Sorting.mergeSort(subset,new AgeComparator());
        return filteredSet;
    }
    
    public FilterableDataset getFilteredDataset(){
        return filteredSet;
    }
    
    
    public Vector<Dog> getCollection(){
        for (Row dog: filteredSet){
            Dog current = new Dog(dog.getName(),dog.getSex(), 
                dog.getAge(),dog.getBreed(),dog.getBorough());
            this.dogCollection.add(current);
        }
        return dogCollection;
    }
    
}
