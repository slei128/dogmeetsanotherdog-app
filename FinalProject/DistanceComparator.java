import java.util.Comparator;
/**
 * This class sorts the data by eviction rate (in ascending order).
 *
 * @ Anneli Xie & Willa Sun
 * @ 04/20/2019
 */
public class DistanceComparator implements Comparator<Row>  {
    /**
     * Sorts the data by eviction rate (in ascending order).
     *
     * @param row 1     The first row to be compared.
     * @param row 2     The second row to be compared.
     * @return int      a negative integer, zero, or a positive integer as the 
     * first argument is less than, equal to, or greater than the second.
     */
    
    public int compare(Row row1, Row row2)  {
        //int distDiff = (row1.getDistance() - 
          //                      row2.getDistance());
        //return distDiff > 0.0 ? 1 :
          //     distDiff == 0.0 ? 0 : -1;
          return 5;
    }
}