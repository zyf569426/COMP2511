import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implementation of a set backed with an ArrayList.
 *
 * @author Kane Walter
 *
 * @param <E> Any type of Object or primitive value.
 * @invariant All elements of set are unique.
 */
public class ArrayListSet<E> implements Set<E>, Cloneable {
    int size;
    ArrayList<E> set;

    /**
     * Constructor for ArrayListSet objects.
     */
    public ArrayListSet() {
        this.size = 0;
        this.set = new ArrayList<E>();
    }

    /**
     * Gets the number of elements in the set.
     *
     * @return Number of elements in set.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Add element to set.
     *
     * @param e Element to be added to set.
     */
    @Override
    public void addToSet(E e) {
        if (!(set.contains(e))) {
            set.add(e);
            size++;
        }
    }

    /**
     * Remove element from the set.
     *
     * @param e Element to be removed from set.
     */
    @Override
    public void removeFromSet(E e) {
        if (set.contains(e)) {
            set.remove(e);
            size--;
        }
    }

    /**
     * Standard equals for ArrayListSet objects.
     *
     * @param  e Other set we want to compare with this set.
     * @return true/false depending on whether sets are equal.
     */
    @Override
    public boolean equals(Object e) {
        if (e == null) return false;
        if (e == this) return true;
        if (!(e instanceof Set)) return false;

        Set<E> _e = (Set<E>) e;

        for (E item : _e) {
            if (!set.contains(item))
                return false;
        }
        return true;
    }

    /**
     * Get set iterator.
     *
     * @return Iterable object for the set.
     */
    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    /**
     * Deep copies a set object.
     *
     * @return A new set identical to the old set.
     */
    @Override
    public ArrayListSet<E> clone() {
        try {
            ArrayListSet<E> newSet = (ArrayListSet<E>) super.clone();
            newSet.set = set;
            return newSet;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Compute the union of two sets.
     *
     * @param  e Other set we want to union with this set.
     * @return Union of this and other set.
     */
    @Override
    public Set<E> union(Set<E> e) {
        ArrayListSet<E> newUnion = this.clone();
        for (E item : e) {
            if (!newUnion.contains(item))
                newUnion.addToSet(item);
        }
        return newUnion;
    }

    /**
     * Compute the intersection of two sets.
     *
     * @param  e Other set we want to intersect with this set.
     * @return New set that is the intersection of other and this set.
     */
    @Override
    public Set<E> intersection(Set<E> e) {
        ArrayListSet<E> inter = new ArrayListSet<E>();
        for (E item : e) {
            if (this.contains(item))
                inter.addToSet(item);
        }
        return inter;
    }

    /**
     * Determines whether a set contains a given element.
     *
     * @param  e An object of type E.
     * @return true/false depending on whether the element is in the
     *         set.
     */
    @Override
    public boolean contains(Object e) {
        if (set.contains(e))
            return true;
        return false;
    }
}
