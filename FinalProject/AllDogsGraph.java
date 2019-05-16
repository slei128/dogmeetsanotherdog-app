
/**
 * Write a description of class DogsGraph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Vector;
import java.util.Hashtable;
import java.util.Random;

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
    public AllDogsGraph(Vector<Dog> dogInput,Dog owndog)
    {
        // create an empty graph
        graph = new AdjListsGraph<Dog>();
        
        //this.owndog = owndog;
        //fDogs = new FavoriteDogs("datasets/dogs_100_size.csv",owndog);
        //System.out.println(fDogs);
        graph.addVertex(owndog);
        for (Dog d: dogInput){
            //System.out.println(d);
            graph.addVertex(d);
            graph.addArc(owndog,d);
            Random rand = new Random(); 
            if (!dogInput.get(rand.nextInt(50)).equals(d)){
                graph.addArc(d,dogInput.get(rand.nextInt(50)));
            }
        }
        
        graph.addArc(dogInput.get(0), dogInput.get(1));
        graph.addArc(dogInput.get(3), dogInput.get(5));
        
        graph.saveTGF("DogConnections.tgf"); 
        System.out.println(graph);
    }
    
    public String toString(){
        String s = "---------------toString() from AllDogsGraph------------\n";
       
        for (Dog v: graph.getVertices()){
            s += v + ":";
            s += graph.getSuccessors(v);
        }
        return s;
    }
    
    // public static void main(String[] args){
       // AdjListsGraph<Dog> hack = new AdjListsGraph<Dog>();
       // AllDogsGraph test = new AllDogsGraph(new Dog("Daisy","F",12,"Bulldog","L","A","A","A"));
       
    // }
}

