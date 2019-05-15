
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
    //private Dog owndog;
    private AdjListsGraph<Dog> graph;
    private FavoriteDogs fDogs;
    private Hashtable<Dog, Vector<Dog>> hash;
    

    /**
     * Constructor for objects of class DogsGraph
     */
    public AllDogsGraph(Hashtable<Dog, Vector<Dog>> inputHash)
    {
        // create an empty graph
        graph = new AdjListsGraph<Dog>();
        
        //this.owndog = owndog;
        //fDogs = new FavoriteDogs("datasets/dogs_100_size.csv",owndog);
        //System.out.println(fDogs);
        hash = inputHash;
        for (Dog d:hash.keySet()){
            //System.out.println(d);
            graph.addVertex(d);
            Vector<Dog> favDogs = hash.get(d);
            for (Dog favDog: favDogs){
                graph.addVertex(favDog);
                graph.addArc(d,favDog);
            }
        }
        graph.saveTGF("TESTER.tgf"); 
        System.out.println(graph);
    }
    
    // public String toString(){
        // String s = "";
        // for (Dog v: graph.getVertices()){
            // s += v;
            // s += v.get
        // }
        // return s;
    // }
    
    // public static void main(String[] args){
       // AdjListsGraph<Dog> hack = new AdjListsGraph<Dog>();
       // AllDogsGraph test = new AllDogsGraph(new Dog("Daisy","F",12,"Bulldog","L","A","A","A"));
       
    // }
}

