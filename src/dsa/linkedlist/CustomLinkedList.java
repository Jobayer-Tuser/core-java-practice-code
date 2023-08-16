package linkedlist;

public class CustomLinkedList {
    Node head;
    private int size;
    CustomLinkedList(){
        this.size = 0;
    }
    class Node {
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.printList();

        list.head = list.reverseInRecursive(list.head);
        list.printList();
//        list.size();
    }

    // add - first, last
    public void addFirst(String data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }

        Node currentNode = head;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
    }
    //delete first node
    public void deleteFirst(){
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        size--;
        head = head.next;
    }

    // delete last node
    public void deleteLast(){
        if (head == null){
            System.out.println("List is empty");
            return;
        }

        size--;
        if (head.next == null){
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        secondLast.next = null;
    }

    public void size(){
        System.out.println(size);
    }


    public void printList(){
        if (head == null){
            System.out.println("List is empty");
            return;
        }

        Node currentNode = head;
        while (currentNode != null){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }

        System.out.println("null");
    }

    public void reverseInIterate(){
        if (head == null || head.next == null){
            return;
        }

        Node previousNode = head;
        Node currentNode = head.next;

        while (currentNode != null){
            Node nextNode = currentNode.next;
            currentNode.next = previousNode;

            //update
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head.next = null;
        head = previousNode;
    }

    public Node reverseInRecursive(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node newhead = reverseInRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newhead;
    }
}
