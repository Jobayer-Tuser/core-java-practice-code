package linkedlist;
import java.util.LinkedList;
public class DefinedLinkedList {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        strings.addFirst("is");
        strings.addFirst("this");
        strings.addLast("a");
        strings.add("list"); // same work as addlast
        System.out.println(strings);

        for (int i = 0; i < strings.size(); i++){
            System.out.print(strings.get(i) + " -> ");
        }

        strings.removeFirst();
        strings.removeLast();
        strings.remove(4);
    }
}