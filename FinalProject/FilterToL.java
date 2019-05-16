import fastcsv.*;

/**
 * Filters the dataset to large dogs. 
 *
 * @author Shirley Lei, Willa Sun, Emily Yin
 * @version May 15 2019
 */

public class FilterToL implements FilterPredicate<Row>
{
    /**
     * Determines whether the dog is of large size. 
     *
     * @param element the row to be filtered
     * @return boolean true if the size of the dog is large, false otherwise 
     */
    public boolean apply(Row element){
        return element.getSize().equals("L");
    }
}
