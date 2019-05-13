import fastcsv.*;

/**
 * Write a description of class FilterToFemalehere.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FilterToFemale implements FilterPredicate<Row>
{
    // instance variables - replace the example below with your own
    public boolean apply(Row element){
        return element.getSex().equals("F");
    }
}