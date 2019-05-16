import fastcsv.*;

/**
 * Write a description of class FilterToManhattan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FilterToBrooklyn implements FilterPredicate<Row>
{
    // instance variables - replace the example below with your own
    public boolean apply(Row element){
        // System.out.println("Called brooklyn filter.");
        // System.out.println("current element is: " + element.getName());
        // System.out.println("current element locaiton is: " + element.getBorough());
        // System.out.println("whether it equals brooklyn is: " + element.getBorough().toLowerCase().equals("brooklyn"));
        return element.getBorough().toLowerCase().equals("brooklyn");
    }
}