package BasicStructure;

public class QueuePriorityTest {
    public static void main(String[] args){
        QueuePriority queuePriority = new QueuePriority(5);
        QueuePriority.Node temp;
        queuePriority.add(new QueuePriority.Node(1,20));
        queuePriority.add(new QueuePriority.Node(2,60));
        queuePriority.add(new QueuePriority.Node(3,100));
        queuePriority.add(new QueuePriority.Node(4,80));
        queuePriority.add(new QueuePriority.Node(5,40));

        while(!queuePriority.isEmpty()){
            temp = (QueuePriority.Node) queuePriority.take();
            System.out.println("index of element: "+ temp.data+".  priority of element: "+temp.priority);
        }
    }
}
