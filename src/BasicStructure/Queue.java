package BasicStructure;

public interface Queue {
    /**
     *  First In First Out
     *  Adding in one side and deleting in another side
     */
    /**
     * add to tail
     * @param element
     */
    void add(Object element);

    /**
     * take from head
     * @return
     */
    Object take();

    /**
     * size of the queue
     * @return
     */
    int size();

    /**
     * if queue is empty
     * @return
     */
    boolean isEmpty();

}
