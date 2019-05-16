import fastcsv.*;

/**
 * Filters the dataset to small dogs. 
 *
 * @author Shirley Lei, Willa Sun, Emily Yin
 * @version May 15 2019
 */

public class FilterToS implements FilterPredicate<Row>
{
    /**
     * Determines whether the dog is of small size. 
     *
     * @param element the row to be filtered
     * @return boolean true if the size of the dog is small, false otherwise 
     */
    public boolean apply(Row element){
        return element.getSize().equals("S");
    }
}
