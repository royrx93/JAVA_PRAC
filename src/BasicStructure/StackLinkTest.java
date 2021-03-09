package BasicStructure;

public class StackLinkTest {
    public static void main(String[] args){
        int size = 10;
        StackLink stackLink = new StackLink();
        System.out.println("stack is empty: "+ stackLink.isEmpty());
        for(int i = 0; i < size; i++){
            stackLink.push(i);
        }
        System.out.println("stack is empty: "+ stackLink.isEmpty());
        System.out.println("size of stacl: "+ stackLink.size());
        while(!stackLink.isEmpty()){
            System.out.println("pop: " + stackLink.pop());
        }
        System.out.println("stack is empty: "+ stackLink.isEmpty());
    }

}
