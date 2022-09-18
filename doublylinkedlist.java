public class doublylinkedlist {

    // Node storing all the data
    static class Node {
        String name;
        int age;
        Node next;
        Node prev;

        Node(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    // Doubly LinkedList with head and tail pointers
    static class LinkedList {
        Node head;
        Node tail;
        int size;

        // appends node at the end
        void addLast(String myname, int myage) {
            Node temp = new Node(myname, myage);
            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
            }
            size++;
        }

        // appends node at the beginning
        void addFirst(String myname, int myage) {
            Node temp = new Node(myname, myage);
            if (size == 0) {
                head = tail = temp;
            } else {
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
            size++;
        }

        // print & get the head node
        public Node getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return null;
            }
            System.out.println("Name: " + head.name + " " + "Age: " + head.age);
            return head;
        }

        //print & get the last node
        public Node getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return null;
            }
            System.out.println("Name: " + tail.name + " " + "Age: " + tail.age);
            return tail;
        }

        //print & get a node at index idx
        public Node getAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return null;
            }

            if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return null;
            }

            if (idx == 0) {
                // getfirst
                return getFirst();
            }
            if (idx == size - 1) {
                // getlast
                return getLast();
            }

            Node temp = head;
            for (int jump = 0; jump < idx; jump++) {
                temp = temp.next;
            }
            System.out.println("Name: " + temp.name + " " + "Age: " + temp.age);
            return temp;
        }

        //display the doubly linkedlist from start
        void display_start() {

            if (size == 0) {
                System.out.println("List is empty");
                return;
            }

            Node start = head;
            while (start != null) {
                System.out.println("Name: " + start.name + " " + "Age: " + start.age);
                start = start.next;
            }
        }

        //display the doubly linkedlist from end
        void display_reverse() {
            if (size == 0) {
                System.out.println("List is empty");
                return;
            }

            Node start = tail;
            while (start != null) {
                System.out.println("Name: " + start.name + " " + "Age: " + start.age);
                start = start.prev;
            }
        }

        //remove the last node
        public void removeLast() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            if (size == 1) {
                head = tail = null;
                size = 0;
                return;
            }
            tail = tail.prev;
            tail.next = null;
            size--;
        }

        //remove & print a node at index idx
        public void removeAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
            }

            else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
            }
            else if(idx==size-1)removeLast();
            else {
                Node temp = head;
                for (int jump = 0; jump < idx; jump++) {
                    temp = temp.next;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }

    }

    public static void main(String[] args) {
        LinkedList family = new LinkedList();
        family.addLast("Man Singh", 47);
        family.addLast("Jasbir Kaur", 43);
        family.addLast("Gurtaj Singh", 23);
        family.addLast("Harman Singh", 19);

        family.display_start();

    }
}
