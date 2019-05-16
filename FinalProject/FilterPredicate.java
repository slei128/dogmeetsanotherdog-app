/**
 * Represents a predicate that is used to filter a collection of items. 
 * Note: Modified from Angelina Li. 
 * 
 * @author Shirley Lei, Willa Sun, Emily Yin
 * @version May 15 2019
 */

public interface FilterPredicate<T> {
    /**
     * Given an element, will return true if this element should be included
     * in the Collection<T> this predicate is filtering over.
     * @return whether the specified element should be included in the filtered
     *         Collection<T> of elements.
     */
    public boolean apply(T element);
}