package BasicStructure;

public class QueueLinkTest {
    public static void main(String[] args){
        int capacity = 10;
        QueueLink queueLink = new QueueLink();

        System.out.println("queue is empty: "+ queueLink.isEmpty());
        for(int i = 0; i < capacity; i++){
            queueLink.add(i);
        }
        System.out.println("size of queue:"+ queueLink.size());

        System.out.println("\n---------\n" +
                "queue is empty: "+ queueLink.isEmpty());



        for(int j = 0; j < capacity; j ++){
            System.out.print(queueLink.take());
        }

        System.out.println("queue is empty: "+ queueLink.isEmpty());
        System.out.println("size of queue:"+ queueLink.size());

    }
}
