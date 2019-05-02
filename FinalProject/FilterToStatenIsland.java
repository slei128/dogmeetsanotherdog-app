import fastcsv.*;

/**
 * Write a description of class FilterToManhattan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FilterToStatenIsland implements FilterPredicate<Row>
{
    // instance variables - replace the example below with your own
    public boolean apply(Row element){
        return element.getBorough().toLowerCase().equals("staten island");
    }
}