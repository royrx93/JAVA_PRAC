package BasicStructure;

/**
 * @author Roywr
 */
public class ListSequence implements List{
    private int size;
    private int currentSize;

    private Object[] list;

    public ListSequence(int size){
        if(size<=0){
            throw new RuntimeException("size error");
        }
        this.size  = size;
        this.currentSize = 0;
        this.list = new Object[size];
    }
    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public void insert(int index, Object object) {
        if(currentSize == size){
            throw new RuntimeException("reach the max size of the list");
        }
        else if(index < 0 || index > size){
            throw new RuntimeException("index error");
        }
        else{
            for(int i = currentSize - 1; i >= index; i--){
                list[i+1] = list[i];
            }
            list[index] = object;
            this.currentSize++;
        }

    }

    @Override
    public void delete(int index) {
        if(isEmpty()){
            throw new RuntimeException("empty list");
        }
        if(index < 0 || index > currentSize){
            throw new RuntimeException("index error");
        }

        for(int i = index; i < currentSize - 1; i++){
            list[i] = list[i + 1];
        }
        currentSize --;
        System.out.println("currentsize:"+currentSize);
    }

    @Override
    public Object get(int index) {
        if(isEmpty()){
            throw new RuntimeException("empty list");
        }
        if(index < 0 || index > currentSize){
            throw new RuntimeException("index error");
        }
        return list[index];
    }
}
