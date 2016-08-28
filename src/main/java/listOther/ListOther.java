package listOther;


public class ListOther {


    static class Node {
        char label;
        Node next;
        Node other;

        Node(char label) {
            super();
            this.label = label;
            this.next = null;
            this.other = null;
        }

    }

    Node head;
    int size = 0;

    public void add(char a) {
        Node node = new Node(a);

        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public ListOther clone() throws CloneNotSupportedException {
        ListOther other = new ListOther();
        if (size > 0) {
            other.head = new Node(this.head.label);
            Node walk = head.next; // walk through remainder of original list
            Node otherTail = other.head; // remember most recently created node
            while (walk != null) { // make a new node storing same element
                Node newest = new Node(walk.label);
                otherTail.next = newest; // link previous node to this one
                otherTail = newest;
                walk = walk.next;
            }
        }
        return other;
    }

    public ListOther cloneWithOther() throws CloneNotSupportedException {
        ListOther other = new ListOther();
        if (size > 0) {
            other.head = new Node(this.head.label);
            if(head.other != null){
                Node newOther = new Node(head.other.label);
                other.head.other = newOther;
            }
            Node walk = head.next; // walk through remainder of original list
            Node otherTail = other.head; // remember most recently created node
            while (walk != null) { // make a new node storing same element
                Node newest = new Node(walk.label);
                otherTail.next = newest; // link previous node to this one
                otherTail = newest;
                if(walk.other != null){
                    Node newOther = new Node(walk.other.label);
                    otherTail.other = newOther;
                }
                walk = walk.next;
            }
        }
        return other;
    }

    public String printNodes() {
        StringBuilder stringBuilder = new StringBuilder();
        Node start = head;
        while (start != null) {
            stringBuilder.append(start.label);
            System.out.print(start.label + " ");
            start = start.next;
        }
        return stringBuilder.toString();
    }


    public String printNodesOther() {
        StringBuilder stringBuilder = new StringBuilder();
        Node start = head;
        while (start != null) {
            stringBuilder.append(start.label);
            System.out.print(start.label + " ");
            if(start.other != null){
                start = start.other;
            }else{
                start = start.next;
            }
        }
        return stringBuilder.toString();
    }

}
