package BasicStructure;

public class ListSequenceTest {
    public static void main(String[] args){
        int maxSize = 15;
        ListSequence listSequence = new ListSequence(maxSize);

        System.out.println("---------add new object into list --------");
        for(int i = 0; i < maxSize; i++){
            listSequence.insert(listSequence.size(),i);
            System.out.println("add"+i);
        }
        System.out.println("currentSize:" + listSequence.size()) ;
        for(int i = 0; i < maxSize; i++){
            System.out.println("get"+ listSequence.get(i));
        }
        System.out.println("---------full list --------");

        try{
            listSequence.insert(0,100);
        } catch (Exception e){
            e.printStackTrace();
        }

        listSequence.delete(0);
        System.out.println("-----if list is empty-----");
        System.out.println(listSequence.isEmpty());
        System.out.println("--------list elements after delete");
        for(int i = 0; i < listSequence.size(); i++){
            System.out.println("get"+ listSequence.get(i));
        }
    }
}
