package BasicStructure;

public class QueuePriority implements Queue {
    /**
     * First in Largest Out
     * no matter the sequence of in queue, the element
     * with the highest priority will dequeue firstly
     */
    static class Node{
        Object data;
        int priority;

        public Node(Object data, int prior){
            this.data = data;
            this.priority = prior;
        }

    }

    private int front;
    private int rear;
    private int count;
    private int maxSize;
    private Node[] queue;

    public QueuePriority(int size){
        this.maxSize = size;
        front = 0;
        rear = 0;
        count = 0;
        queue = new Node[size];
    }

    @Override
    public void add(Object element) {
        if(isFull()){
            System.out.println("queue is full");
        }
        queue[rear] = (Node) element;
        rear++;
        count++;
    }

    @Override
    public Object take() {
        if(isEmpty()){
            System.out.println("queue is empty");
            return null;
        }
        int maxIndex = 0;

        for(int i = 0; i< count; i++){
            if(queue[i].priority > queue[maxIndex].priority){
                maxIndex = i;
            }
        }
        Object element = queue[maxIndex];/** should be the element itself*/

        for(int j = maxIndex+1; j < count; j++ ){
            queue[j - 1] = queue[j];
        }
        count--;
        rear--;

        return element;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull(){
        return count >= maxSize;
    }
}
