package BasicStructure;

/**
 * Single linkage:
 *      Pro:
 *          Not limited, Not have to be continuous, no need to move nodes when adding or deleteing
 *
 *      Con:
 *          Need more space to store the link to the next node
 *          Search only from front to end
 *
 * Double Linkage:
 *      More space
 */
public class ListLink implements List{
    private  class Node{
        private Object data;
        private Node next;

        public Node(){

        }

        public Node(Object data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    private Node header;

    private Node tail;

    private int size;

    public ListLink(){
        header = null;
        tail = null;
    }
    public ListLink(Object element){
        header = new Node(element, null);
        tail = header;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public void addAtHeader(Object element){

        header = new Node(element, header);
        if(size == 0){
            tail = header;
        }
        size++;

    }


    public void addAtTail(Object element){
        Node curr = header;
        if(size==0){
            addAtHeader(element);
        }else{
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = new Node(element, null);
            size++;
        }

    }

    @Override
    public void insert(int index, Object element) {
        if(index < 0 || index > size){
            throw new RuntimeException("invalid index");
        }

        if(size == 0 || index == 0){
            this.addAtHeader(element);
        }
        else{
            Node curr = header;
            Node prev = header;

            int i = 0;
            while(i != index ){
                prev = curr;
                curr = curr.next;
                i++;
            }
            prev.next = new Node(element, prev.next);
            size++;
        }

    }

    @Override
    public void delete(int index) {
        if(index < 0 || index > size){
            throw new RuntimeException("invalid index");
        }
        Node del;
        if(index == 0){
            del = header;
            header = header.next;
            size--;
            return;
        }
        else{
            int i = 0;
            Node curr = header;
            Node prev = curr;
            while(i != index){
                prev = curr;
                curr = curr.next;
                i++;
            }
            prev.next = curr.next;
            del = curr;
            size--;

        }

    }

    @Override
    public Object get(int index){
        if(index < 0 || index > size){
            throw new RuntimeException("invalid index");
        }
        else{
            int i = 0;
            Node curr = header;
            while(i != index && curr != null ){
                curr = curr.next;
                i++;
            }
            return curr.data;
        }
    }
}
