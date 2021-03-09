package BasicStructure;

public class ListLinkTest {
    public static void main(String[] args){
        int size = 10;
        ListLink listLink = new ListLink();
        System.out.println("-----add objects into the linklist");
        for(int i=0; i < size; i++){
            listLink.insert(i,i);
        }
        for(int j=0; j < size; j++){
            System.out.println(listLink.get(j) + " ");
        }

        System.out.println();
        listLink.delete(0);
        System.out.println("---if empty--");
        System.out.println(listLink.isEmpty());
        System.out.println("----after delete");
        for(int k = 0; k < listLink.size(); k++){
            System.out.println(listLink.get(k));
        }
    }
}




