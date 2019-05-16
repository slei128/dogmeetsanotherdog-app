import java.util.LinkedList;
import java.util.Vector;
import java.util.Hashtable;
/**
 * FavoriteDogs represents the favorite dogs of the user-inputed dog, and 
 * provides method for user to sort the order displayed of these dogs.
 *
 * @author (Shirley Lei, Willa Sun, Emily Yin)
 * @version (16 May 2019)
 */
public class FavoriteDogs {   
    private Vector<Dog> filteredDogCollection; //initiate the collection of dogs that is gotten from the sub-dataset
    private Dog owndog; //the dog that the user input creates
    private FilterableDataset inputDS; //the sub-dataset that the constructor takes to sort from
    /**
     * Constructor for objects of class FavoriteDogs
     * @param inputDS the dataset of type FilterableDataset for which sort will be performed later on
     * @param owndog the dog that the user input creates
     */
    public FavoriteDogs(FilterableDataset inputDS, Dog owndog) { 
        this.owndog = owndog;
        this.inputDS = inputDS;
    }
    
    /**
     * Sorts the given dataset of dogs of type FilterableDataset by a given criteria
     * @param criteria the criteria that the given dataset is sorted by
     * @return the sorted FilterableDataset
     */
    public FilterableDataset sortByCriteria(String criteria){
        //System.out.println("called sort");
        if (criteria.equals("age")){ //the sorting criteria is age
            //System.out.println(inputDS);
            Sorting.mergeSort(inputDS,new AgeComparator()); //perform mergesort and use age comparator
        }
        //return the sorted FilterableDataset
        return inputDS;
    }
    
    /**
     * Getter for the collection of dogs in the given dataset 
     * 
     * @return the collection of dogs in the given dataset 
     */
    public Vector<Dog> getCollection(){
        for (Row dog: inputDS){
            Dog current = new Dog(dog.getName(),dog.getSex(), 
                dog.getAge(),dog.getBreed(),dog.getBorough(),dog.getSize(),
                dog.getArea(),dog.getPhone());
            this.filteredDogCollection.add(current);
        }
        return filteredDogCollection;
    }
    
    /**
     * String representation of each row (i.e. dog) in the given dataset
     * 
     * @return a string representation of each row (i.e. dog) in the given dataset
     */
    public String toString(){
        String s = "";
        for (Row dog: inputDS){
            s += dog.getName() + dog.getSex() + dog.getAge() + dog.getBreed() + dog.getBorough() + dog.getSize();
            s += dog.getArea() + dog.getPhone() + "\n";
        }
        return s;
    }
}
