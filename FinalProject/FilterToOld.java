import fastcsv.*;

/**
 * Write a description of class Fitlter to age here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FilterToOld implements FilterPredicate<Row>
{
    // instance variables - replace the example below with your own
    public boolean apply(Row element){
        return element.getAge() >= (10);
    }
}