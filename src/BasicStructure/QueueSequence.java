package BasicStructure;

public class QueueSequence implements Queue{
    /**
     * move the head to avoid fake leak
     */

    private Object[] array;
    private int size;

    public QueueSequence(int intSize){
        array = new Object[intSize];
        size = 0;
    }

    @Override
    public void add(Object element) {
        array[size++] = element;
    }

    @Override
    public Object take() {
        Object element = array[0];
        for(int i = 1; i<size; i ++){
            array[i-1] = array[i];
        }
        size--;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull(){ return size>=array.length; }
}
