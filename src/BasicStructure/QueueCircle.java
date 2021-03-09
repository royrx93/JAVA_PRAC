package BasicStructure;

public class QueueCircle implements Queue{
    int front;
    int rear;

    int maxSize;

    int count;

    Object[] array;

    public QueueCircle(int initSize){
        front = 0;
        rear = 0;
        maxSize = initSize;
        count = 0;
        array = new Object[initSize];

    }

    @Override
    public void add(Object element) {
        if(front == rear){
            System.out.print("front and end meet-----");
        }

        if(this.isFull() && front == rear){
            System.out.println("queue is full");
            return;
        }

        array[rear] = element;
        rear = (rear+1)%maxSize;
        count++;
    }

    @Override
    public Object take() {
        if(this.isEmpty()){
            System.out.println("queue is empty");
            return null;
        }

        Object element = array[front];
        count--;
        front = (front+1)%maxSize;
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
