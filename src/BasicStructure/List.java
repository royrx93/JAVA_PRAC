package BasicStructure;

/**
 * list----- Searching Time Complexity: O(n)
 *  LIMITED, CONTINUOUS
 * Adding --- make elements move backwards.
 * Deleting --- make elements move forwards.
 *
 *
 * @Auther Ruoyu Wu
 *
 * */

public interface List {
    /**
     * give the length of the list
     * @return length
     * */
    int size();


    /**
     * tell if the list is empty
     * @return ture empty; false not empty
     * */
    boolean isEmpty();

    /**
     * insert object into list
     * @param index position
     * @param object object
     * */
    void insert(int index, Object object);

    /**
     * delete object from list
     * @param index position
     * */
    void delete(int index);

    /**
     * get the object at corresponding position
     * @param index position
     */
    Object get(int index);

}
