import fastcsv.*;

/**
 * Filters the dataset to the dogs who live in Queens. 
 *
 * @author Shirley Lei, Willa Sun, Emily Yin
 * @version May 15 2019
 */

public class FilterToQueens implements FilterPredicate<Row>
{
    /**
     * Determines whether the borough location corresponds to Queens.  
     *
     * @param element the row to be filtered
     * @return boolean true if the borough of the dog is Queens, false otherwise 
     */

    public boolean apply(Row element){
        return element.getBorough().toLowerCase().equals("queens");
    }
}