public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void printList(Node node) {
        while(null != node) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public void pushFront(Node node) {
        if(null == node) {return;}
        node.next = head;
        head=node;
    }

    public void deleteNode(int key) {

        Node temp = head, prev = null;
        if (null != temp && temp.data == key) {
            head = temp.next;
            return;
        }

        while (null != temp && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if(null == temp) {return;}
        prev.next = temp.next;

    }

    public int getCount(Node node) {
        Node temp = node;

        if (null == node) {return 0;}

        return 1+getCount(temp.next);
    }

    public void swapNodes(int x, int y) {

        if (x == y) { return; }

        Node currX = head, prevX = null;
        while (null != currX && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node currY = head, prevY = null;
        while (null != currY && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }
        if (null == currX || null == currY) { return; }
        if (null != prevX) {
            prevX.next = currY;
        } else
            head = currY;
        if (null != prevY) {
            prevY.next = currX;
        } else
            head = currX;


        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

    }

    public void reverse() {
        Node prev = null, curr = head,next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void reverseRecursive(Node p) {
        if (null == p.next) {
            head = p;
            return;
        }
        reverseRecursive(p.next);
        Node q = p.next;
        q.next = p;
        p.next = null;
    }

    public void printMiddle() {

        Node fastPtr = head, slowPtr = head;
        while (null != fastPtr && null != fastPtr.next) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        System.out.println("Middle Element------>>>"+slowPtr.data);
    }

    public Node mergeListDummy(Node listOne, Node listTwo) {
        Node list = new Node(0);
        Node p =list;
        while (null != listOne || null != listTwo) {
            if (listOne != null && listTwo != null) {
                if (listOne.data < listTwo.data) {
                    p.next = listOne;
                    listOne = listOne.next;
                } else {
                    p.next = listTwo;
                    listTwo = listTwo.next;
                }
                p = p.next;
            }
            if (null == listOne) {
                p.next = listTwo;
                break;
            } else if (null == listTwo) {
                p.next = listOne;
                break;
            }

    }

        return list.next;
    }

    public static void main(String args[]) {
        LinkedList llist = new LinkedList();
        llist.head = new Node(10);

        Node second = new Node(20);
        Node third = new Node(30);
        llist.head.next = second;
        second.next = third;


        LinkedList llist1 = new LinkedList();
        llist1.head = new Node(5);

        Node new1 = new Node(12);
        Node new2 = new Node(300);
        llist1.head.next = new1;
        new1.next = new2;


     //   Node frontNode = new Node(40);
       // llist.pushFront(frontNode);
        //System.out.println("Before Swap------>>>");
       //llist.printList(llist.head);
        //llist.printList(llist1.head);

        //llist.deleteNode(20);
        /*System.out.println("COUNT-------->>>>>> "+llist.getCount(llist.head));
        llist.swapNodes(40,30);
        System.out.println("After Swap------->>>");
        llist.printList(llist.head);*/
        //llist.reverseRecursive(llist.head);
       // llist.reverse();
        Node p = llist.mergeListDummy(llist.head,llist1.head);
        llist.printList(p);
        //llist.printMiddle();


    }
}

