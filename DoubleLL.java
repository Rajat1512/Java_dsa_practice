public class DoubleLL {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data +"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    public void removeFirst(){
        if(size == 0){
            System.out.println("DLL is empty");
            return;
        }
        else if(size == 1){
            head = tail = null;
            return;
        }
        else{
             head = head.next;
             head.prev = null;
             size--;
        }
    }

    public void removeLast(){
        if(size == 0){
            System.out.print("DLL is empty");
            return;
        }
        else if(size == 1){
            head = tail = null;
            return;
        }
        else{
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String args[]){
         DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
          dll.addFirst(1);
          dll.addLast(4);
          dll.addLast(5);
         dll.print();
         dll.reverse();
         dll.print();
         System.out.println(size);
    }
    
}
