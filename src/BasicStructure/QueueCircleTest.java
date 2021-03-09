package BasicStructure;

public class QueueCircleTest {
    public static void main(String[] args){
        int capacity = 10;
        QueueCircle queueCircle = new QueueCircle(capacity);

        System.out.println("queue is empty: "+ queueCircle.isEmpty());
        System.out.println("queue is full: "+ queueCircle.isFull());
        for(int i = 0; i < capacity+capacity; i++){
            queueCircle.add(i);
        }

        System.out.println("\n---------\n" +
                "queue is empty: "+ queueCircle.isEmpty());
        System.out.println("queue is full: "+ queueCircle.isFull());

        for(int j = 0; j < capacity; j ++){
            System.out.print(queueCircle.take());
        }

        System.out.println("\n---------\n" +
                "queue is empty: "+ queueCircle.isEmpty());
        System.out.println("queue is full: "+ queueCircle.isFull());
    }
}
