package BasicStructure;

public class StackSequence implements Stack{
    private Object[] data;
    private int maxSize;

    /**
     * index of the top of stack
     */
    private int top;

    /**
     * constructor with param
     * @param maxSize
     */
    public StackSequence(int maxSize){
        this.maxSize = maxSize;
        data = new Object[maxSize];
        System.out.println("top "+ top );
    }

    /**
     * constructor without param
     * @return
     */

    public StackSequence(){
        this(10);
    }

    public boolean isFull(){
        return top == maxSize;
    }

    @Override
    public boolean isEmpty() {
        return top <= 0;               /** -1 ??????*/
    }

    @Override
    public boolean push(Object element) {
        if(this.isFull()){
            throw new RuntimeException("stack is full");
        }
        //System.out.println("pushed in "+ top);
        data[top++] = element;
        //System.out.println("pushed  "+ data[top-1]);
        return true;
    }

    @Override
    public Object pop() {
        if(this.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
       //System.out.println("top: "+top);
        Object element = data[--top];
        //System.out.println("poped  "+ data[top]);
        data[top] = null;

        return element;
    }

    @Override
    public int size() {
        return top;
    }
}
