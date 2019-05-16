
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
    private FilterableDataset filteredSet,filteredSet1;
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
            //this.filteredSet = new FilterableDataset();
            this.filteredSet1 = new FilterableDataset();
            //populate dataset with all
            for (Row row: fd){
                filteredSet1.add(row);
                //filteredSet.add(row);
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
        FilterableDataset outputFiltered = new FilterableDataset();
        // for (Row r: filteredSet1){
            // filteredSet1.add(r);
        // }
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
        //filter by age
        } else if (category.equals("age")){
            if (criteria.equals("Old"))
                outputFiltered = filteredSet1.filterBy(new FilterToOld());
            else if (criteria.equals("Young"))
                outputFiltered = filteredSet1.filterBy(new FilterToYoung());
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

        //Sorting.mergeSort(subset,new AgeComparator());
        //return filteredSet1
        //System.out.println(outputFiltered + "\n-------");
        return outputFiltered;
    }
    
    public FilterableDataset getFilteredDataset(){
        return filteredSet1;
    }
    
    public Vector<Dog> getCollection(){
        for (Row dog: fd){
            Dog current = new Dog(dog.getName(),dog.getSex(), 
                dog.getAge(),dog.getBreed(),dog.getBorough(),dog.getSize(),
                dog.getArea(),dog.getPhone());
            this.dogCollection.add(current);
        }
        return dogCollection;
    }

    
    public String toString() {
        String s = "";
        //s+="hello + \n";
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
