package BasicStructure;

public interface Stack {
    /**
     * First In Last Out
     * Adding and Deleting both in the same side.
     */

    /**
     * if stack is empty
     * @return true:empty false: not empty
     */
    boolean isEmpty();

    /**
     * push element into stack
     * @param element
     * @return if push success
     */
    boolean push(Object element);

    /**
     * pop element from stack
     * @return poped object
     */
    Object pop();

    /**
     * size of the stack
     * @return
     */
    int size();


}
