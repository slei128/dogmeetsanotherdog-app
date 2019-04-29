import java.io.*; //exceptions, 
/**
 * Write a description of class DogGraphDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DogGraphDriver
{
    // instance variables - replace the example below with your own
    private AdjListsGraph<Dog> dogConnections;
    private Reader r;
    /**
     * Constructor for objects of class DogGraphDriver
     */
    public DogGraphDriver() throws IOException
    {
        this.dogConnections = new AdjListsGraph<Dog>();
        this.r = new Reader("dogs_all.csv");
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args) throws IOException
    {
        DogGraphDriver d = new DogGraphDriver();
        
    }
}
