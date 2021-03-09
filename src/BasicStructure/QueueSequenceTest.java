package BasicStructure;

public class QueueSequenceTest {
    public static void main(String[] args){
        int capacity = 10;
        QueueSequence queuesequence = new QueueSequence(10);

        System.out.println("queue is empty: "+ queuesequence.isEmpty());
        for(int i = 0; i< capacity; i ++){
            queuesequence.add(i);
        }
        System.out.println("queue is empty: "+ queuesequence.isEmpty());
        System.out.println("queue is full: "+ queuesequence.isFull());

        for(int j =0; j<capacity; j++){
            System.out.print(queuesequence.take()+" ");
        }

        System.out.println("queue is empty: "+ queuesequence.isEmpty());
        System.out.println("queue is full: "+ queuesequence.isFull());

    }

}
