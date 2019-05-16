import fastcsv.*;

/**
 * Filters the dataset to the dogs who live in Brooklyn. 
 *
 * @author Shirley Lei, Willa Sun, Emily Yin
 * @version May 15 2019
 */

public class FilterToBrooklyn implements FilterPredicate<Row>
{
    /**
     * Determines whether the borough location corresponds to Brooklyn. 
     *
     * @param element the row to be filtered
     * @return boolean true if the borough of the dog is Brooklyn, false otherwise 
     */
    public boolean apply(Row element){
        // System.out.println("Called brooklyn filter.");
        // System.out.println("current element is: " + element.getName());
        // System.out.println("current element locaiton is: " + element.getBorough());
        // System.out.println("whether it equals brooklyn is: " + element.getBorough().toLowerCase().equals("brooklyn"));
        return element.getBorough().toLowerCase().equals("brooklyn");
    }
}