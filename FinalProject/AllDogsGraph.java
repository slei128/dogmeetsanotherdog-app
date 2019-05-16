/**
 * AllDogsGraph takes as input a vector of dogs as well as the dog created by the user; from this data, this class creates
 * an adjListsGraph to show all the dogs and their connections with each other
 * 
 * @author (Shirley Lei, Willa Sun, Emily Yin)
 * @version (16 May 2019)
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
     * 
     * @param dogInput - of type Vector<Dog>, dogs from which we are creating the graph from
     * @param owndog - of type Dog, which the user will be prompted to create and will be included in the graph
     */
    public AllDogsGraph(Vector<Dog> dogInput,Dog owndog)
    {
        // create an empty graph
        graph = new AdjListsGraph<Dog>();

        //add owndog to the graph as a vertex
        graph.addVertex(owndog);
        //iterate through all dogs in dogInput, create an arc from owndog to each of the dogs, as well as insert
        //random connections to simulate the relationships between the dogs
        for (Dog d: dogInput){
            //System.out.println(d);
            graph.addVertex(d);
            graph.addArc(owndog,d);
            Random rand = new Random(); 
            //generate random connections
            if (!dogInput.get(rand.nextInt(50)).equals(d)){
                graph.addArc(d,dogInput.get(rand.nextInt(50)));
            }
        }

        //graph.addArc(dogInput.get(0), dogInput.get(1));
        //graph.addArc(dogInput.get(3), dogInput.get(5));

        //save to TGF
        graph.saveTGF("DogConnections.tgf"); 
        //System.out.println(graph);
    }

    public String toString(){
        String s = "---------------toString() from AllDogsGraph------------\n";

        for (Dog v: graph.getVertices()){
            s += v + ":";
            s += graph.getSuccessors(v);
        }
        return s;
    }

}

