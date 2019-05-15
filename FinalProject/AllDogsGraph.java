
/**
 * Write a description of class DogsGraph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Vector;
import java.util.Hashtable;
public class AllDogsGraph
{
    // instance variables - replace the example below with your own
    private Dog owndog;
    private AdjListsGraph<Dog> graph;
    private FavoriteDogs fDogs;
    private Hashtable<Dog, Vector<Dog>> hash;
    

    /**
     * Constructor for objects of class DogsGraph
     */
    public AllDogsGraph(Dog owndog)
    {
        // initialise instance variables
        graph = new AdjListsGraph<Dog>();
        this.owndog = owndog;
        fDogs = new FavoriteDogs("datasets/dogs_50.csv",owndog);
        System.out.println(fDogs);
        hash = fDogs.getHash();
        for (Dog d:hash.keySet()){
            //System.out.println(d);
            graph.addVertex(d);
            Vector<Dog> favDogs = hash.get(d);
            for (Dog favDog: favDogs){
                graph.addVertex(favDog);
                graph.addArc(d,favDog);
            }
        }
        
        System.out.println(graph);
    }
    
    
    //public static void main(String[] args){
     //   AllDogsGraph test = new AllDogsGraph(new Dog());
    //}
}

