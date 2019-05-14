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
    private Hashtable<Dog, Vector<Dog>> hash;
    private Vector<Dog> filteredDogCollection;
    private Dog owndog;
    private FilterableDataset subset;

    /**
     * Constructor for objects of class FavoriteDogs
     */
    public FavoriteDogs(String filename)
    {
        DogCollection collection = new DogCollection(filename);
        this.hash = new Hashtable<Dog, Vector<Dog>>();
        //filter by criterion specified earlier by the user
        filteredDogCollection = new Vector<Dog>();
        subset = collection.getFilteredDataset();
        sortByCriteria("age");
        Sorting.mergeSort(subset,new AgeComparator());
        GUIPanel gp = new GUIPanel();
        owndog = gp.getOwnDog();
        System.out.println(owndog);
        hashing();
        //in hashtable, put the user's dog and the filtered results from before
        //hash.put(owndog,filteredCollection);
    }
    
    public void sortByCriteria(String criteria){
        System.out.println("called sort");
        if (criteria.equals("age")){
            System.out.println(subset);
            Sorting.mergeSort(subset,new AgeComparator());
        }
    }
    
    public void hashing(){
        for (Row dog: subset){
            Dog current = new Dog(dog.getName(),dog.getSex(), 
                dog.getAge(),dog.getBreed(),dog.getBorough(),dog.getSize());
            this.filteredDogCollection.add(current);
        }
        hash.put(owndog,filteredDogCollection);
    }
    
    public String toString(){
        String s = "";
        for (Dog d: hash.keySet()){
            s += d;
            s += hash.get(d);
        }
        return s;
    }
    
    public FilterableDataset getSubset(){
        return subset;
    }
    
    public Hashtable<Dog, Vector<Dog>> getHash(){
        return hash;
    }
    
    public static void main(String[] args){
        FavoriteDogs fDogs = new FavoriteDogs("datasets/dogs_50.csv");
        //System.out.println(fDogs);

        fDogs.sortByCriteria("age");
        Sorting.mergeSort(fDogs.getSubset(),new AgeComparator());
        fDogs.hashing();
        System.out.println(fDogs);
    }
}
