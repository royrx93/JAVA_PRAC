package BasicStructure;

public class QueueLink implements Queue {
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

    private Node head;
    private Node tail;
    private int size;

    public QueueLink(){
        head = null;
    }

    @Override
    public void add(Object element) {
        if(isEmpty()){
            head = new Node(element, null);
            tail = head;

        }else{
            Node nextNode = new Node(element, null);
            tail.next = nextNode;
            tail = nextNode;
        }
        size++;
    }

    @Override
    public Object take() {
        if(isEmpty()){
            System.out.println("queue is empty");
            return null;
        }
        Object element = head.data;
        head = head.next;
        size--;
        return element;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
