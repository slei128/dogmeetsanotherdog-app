/**
 * filename: Sorting.java
 * date: 01/16/19
 * description: In-place sorting methods that can sort Row objects. 
 *              Contains the following sorting algorithms:
 *              ==> selectionSort(Vector<Row> data, Comparator<Row> c)
 *              ==> quickSort(Vector<Row> data, Comparator<Row> c)
 * @author Angelina Li; javafoundations
 *
 * NOTE: Do NOT modify this class.
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import fastcsv.*;

public class Sorting {
    
    /**
     * Sorts a Vector of Row objects in-place using the merge sort 
     * algorithm. Will leave data sorted in ascending order.
     * @param data - Vector of Rows representing the data to be sorted
     * @param c - Comparator specifying a method to compare between two 
     *            Row objects
     */
    public static void mergeSort(Vector<Row> data, Comparator<Row> c) {
        mergeSortRecursive(data, c, 0, data.size() - 1);
    }

    public static void mergeSortRecursive (Vector<Row> data, Comparator<Row> c, int min, int max) {
        if (min < max) {
            int mid = (min + max) / 2;
            mergeSortRecursive (data, c, min, mid);
            mergeSortRecursive (data, c, mid+1, max);
            merge (data, c, min, mid, max);
        }
    }

    public static void merge(Vector<Row> data, Comparator<Row> c, int first, int mid, int last) {
        Vector<Row> temp = new Vector<Row>();
        int first1 = first, last1 = mid; // endpoints of first subarray
        int first2 = mid + 1, last2 = last; // endpoints of second subarray
        
        while(first1 <= last1 && first2 <= last2) {
            if(c.compare(data.get(first1), data.get(first2)) < 0) {
                temp.add(data.get(first1));
                first1++;
            } else {
                temp.add(data.get(first2));
                first2++;
            }
        }
        // Copy remaining elements from first subarray, if any
        while(first1 <= last1) {
            temp.add(data.get(first1));
            first1++;
        }
        // Copy remaining elements from second subarray, if any
        while(first2 <= last2) {
            temp.add(data.get(first2));
            first2++;
        }

        // Copy temp into original array.
        Iterator<Row> tempIter = temp.iterator();
        for(int i = first; i <= last; i++) {
            data.set(i, tempIter.next());
        }
    }
}
