import java.util.LinkedList;
import java.util.Vector;
import java.util.Hashtable;
/**
 * Sorts a dog's favourite dogs list by preferences
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FavoriteDogs
{
    // instance variables - replace the example below with your own
    //private Hashtable<Dog, Vector<Dog>> hash;
    private Vector<Dog> filteredDogCollection;
    private Dog owndog;
    private FilterableDataset inputDS;

    /**
     * Constructor for objects of class FavoriteDogs
     */
    public FavoriteDogs(FilterableDataset inputDS, Dog owndog)
    {

        //DogCollection collection = new DogCollection(filename);
        //vectorDogs = collection.getCollection();
        this.owndog = owndog;
        this.inputDS = inputDS;
        //this.hash = new Hashtable<Dog, Vector<Dog>>();
        //filter by criterion specified earlier by the user
        //filteredDogCollection = new Vector<Dog>();
        //subset = collection.getFilteredDataset();
        //sortByCriteria("age");
        //Sorting.mergeSort(subset,new AgeComparator());
        //GUIPanel gp = new GUIPanel();
        //owndog = gp.getOwnDog();
        //owndog = new Dog ("Daisy", "F", 5, "Bulldog", "Manhattan", "S");
        //this.owndog = owndog;
        //System.out.println(owndog);
        //in hashtable, put the user's dog and the filtered results from before
        //hash.put(owndog,filteredCollection);
    }
    
    public FilterableDataset sortByCriteria(String criteria){
        System.out.println("called sort");
        if (criteria.equals("age")){
            System.out.println(inputDS);
            Sorting.mergeSort(inputDS,new AgeComparator());
        }
        return inputDS;
    }
    
    public Vector<Dog> getCollection(){
        for (Row dog: inputDS){
            Dog current = new Dog(dog.getName(),dog.getSex(), 
                dog.getAge(),dog.getBreed(),dog.getBorough(),dog.getSize(),
                dog.getArea(),dog.getPhone());
            this.filteredDogCollection.add(current);
        }
        return filteredDogCollection;
    }
    
    /*
    public void hashing(){
        for (Row dog: inputDS){
            System.out.println("current dog is " + dog);
            Dog current = new Dog(dog.getName(),dog.getSex(), 
                dog.getAge(),dog.getBreed(),dog.getBorough(),dog.getSize(),
                dog.getArea(),dog.getPhone());
            this.filteredDogCollection.add(current);
            System.out.println("now our filtered dog collection looks like: " + filteredDogCollection);
        }
        hash.put(owndog,filteredDogCollection);
    }
    */
    
   
    public String toString(){
        String s = "";
        for (Row dog: inputDS){
            s += dog.getName() + dog.getSex() + dog.getAge() + dog.getBreed() + dog.getBorough() + dog.getSize();
            s += dog.getArea() + dog.getPhone() + "\n";
        }
        return s;
    }
    
    public FilterableDataset getSubset(){
        return inputDS;
    }
    
    
    
    // public static void main(String[] args){
        // FavoriteDogs fDogs = new FavoriteDogs("datasets/dogs_100_size.csv",
                // new Dog("Daisy","F",12,"Bulldog","L","A","A","A"));
        // System.out.println(fDogs);

        // fDogs.sortByCriteria("age");
        // Sorting.mergeSort(fDogs.getSubset(),new AgeComparator());
        // fDogs.hashing();
        // System.out.println(fDogs);
    // }
}
