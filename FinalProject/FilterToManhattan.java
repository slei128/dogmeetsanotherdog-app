import fastcsv.*;

/**
 * Filters the dataset to the dogs who live in Manhattan. 
 *
 * @author Shirley Lei, Willa Sun, Emily Yin
 * @version May 15 2019
 */

public class FilterToManhattan implements FilterPredicate<Row>
{
    /**
     * Determines whether the borough location corresponds to Manhattan.  
     *
     * @param element the row to be filtered
     * @return boolean true if the borough of the dog is Manhattan, false otherwise 
     */
    public boolean apply(Row element){
        return element.getBorough().toLowerCase().equals("manhattan");
    }
}
