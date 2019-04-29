import fastcsv.*;
/**
 * FilterToAField allows filtering multiple dogs by a given criteria
 * (e.g. name of dog has to be "bella")
 */
public class FilterToAField implements FilterPredicate<CsvRow> {
    private final String CRITERIA = "Bella";
    /**
     * Determines whether the eviction rate in a row is less than the threshold for a low eviction rate.
     *
     * @param element the row to be filtered through for its eviction rate
     * @return true if the eviction rate is less than the set threshold in this given row false otherwise
     */
    public boolean apply(CsvRow element) {
        return true;
        //return element.getData("name")==CRITERIA;
    }
}
