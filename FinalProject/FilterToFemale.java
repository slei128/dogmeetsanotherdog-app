import fastcsv.*;

/**
 * Filters the dataset to female dogs.  
 *
 * @author Shirley Lei, Willa Sun, Emily Yin
 * @version May 15 2019
 */

public class FilterToFemale implements FilterPredicate<Row>
{
    /**
     * Determines whether the dog is of female gender.  
     *
     * @param element the row to be filtered
     * @return boolean true if the sex of the dog is female, false otherwise 
     */
    public boolean apply(Row element){
        return element.getSex().equals("F");
    }
}