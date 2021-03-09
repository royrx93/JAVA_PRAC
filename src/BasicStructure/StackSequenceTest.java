package BasicStructure;

public class StackSequenceTest {
    public static void main(String[] args){
        int size = 10;
        StackSequence stackSequence = new StackSequence(size);

        System.out.println("stack is empty:" + stackSequence.isEmpty());

        for(int i = 0; i < size; i++){
            stackSequence.push(i);
        }

        System.out.println("stack is full:" + stackSequence.isFull());
        System.out.println("size of stack:" + stackSequence.size());

        for(int j = 0; j < size -1; j++){
            System.out.print(stackSequence.pop()+" ");
        }

        System.out.println("stack is empty:" + stackSequence.isEmpty());
        System.out.println("size of stack:" + stackSequence.size());
    }
}
