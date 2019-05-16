import fastcsv.*;

/**
 * Filters the dataset to male dogs.  
 *
 * @author Shirley Lei, Willa Sun, Emily Yin
 * @version May 15 2019
 */

public class FilterToMale implements FilterPredicate<Row>
{
    /**
     * Determines whether the dog is of male gender.  
     *
     * @param element the row to be filtered
     * @return boolean true if the sex of the dog is male, false otherwise 
     */
    public boolean apply(Row element){
        return element.getSex().equals("M");
    }
}