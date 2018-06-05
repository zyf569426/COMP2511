
/**
 * Interface for a collection of elements (a set).
 *
 * @author Kane Walter
 *
 * @param <E> Any type of object
 */
public interface Set<E> extends Iterable<E> {
    int getSize();
    void addToSet(E e);
    void removeFromSet(E e);
    Set<E> union(Set<E> e);
    Set<E> intersection(Set<E> e);
    boolean contains(Object e);
}
