import java.util.Comparator;
/**
 * Sorts the dataset by age (in ascending order).
 *
 * @author Shirley Lei, Willa Sun, Emily Yin
 * @ May 15 2019
 */

public class AgeComparator implements Comparator<Row>  {
    /**
     * Sorts the data by age in ascending order. 
     *
     * @param row 1 The first row to be compared
     * @param row 2 The second row to be compared
     * @return int a negative integer, zero, or a positive integer depending on whether the 
     * first argument is less than, equal to, or greater than the second argument
     */
    public int compare(Row row1, Row row2)  {
        int ageDiff = (row1.getAge() - 
                                row2.getAge());
        return ageDiff > 0.0 ? 1 :
               ageDiff == 0.0 ? 0 : -1;
    }
}