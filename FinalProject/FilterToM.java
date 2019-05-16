import fastcsv.*;

/**
 * Filters the dataset to medium dogs. 
 *
 * @author Shirley Lei, Willa Sun, Emily Yin
 * @version May 15 2019
 */

public class FilterToM implements FilterPredicate<Row>
{
    /**
     * Determines whether the dog is of medium size. 
     *
     * @param element the row to be filtered
     * @return boolean true if the size of the dog is medium, false otherwise 
     */
    public boolean apply(Row element){
        return element.getSize().equals("M");
    }
}
