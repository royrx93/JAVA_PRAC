package BasicStructure;

public class StackLink implements Stack {
    private class Node{
        private Object data;
        private Node next;

        public Node(){

        }

        public Node(Object element, Node next){
            this.data = element;
            this.next = next;
        }
    }

    private int size;
    private Node top;

    public StackLink(){
        this.top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean push(Object element) {
        if(element == null){
            throw new RuntimeException("element can be null");
        }
        this.top = new Node(element,this.top);
        size++;
        return true;
    }

    @Override
    public Object pop() {
        if(this.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        Node curr = this.top;
        this.top = this.top.next;
        size--;
        return curr.data;
    }

    @Override
    public int size() {
        return size;
    }
}
