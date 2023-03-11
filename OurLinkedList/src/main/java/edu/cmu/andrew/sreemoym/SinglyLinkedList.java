// Name: Sreemoyee Mukherjee
// Course: Data Structures & Algorithms
// Assignment Number: 1

package edu.cmu.andrew.sreemoym;

import edu.colorado.nodes.ObjectNode;

import static edu.colorado.nodes.ObjectNode.listPosition;

public class SinglyLinkedList {
    ObjectNode head;
    ObjectNode tail;
    public ObjectNode current;
    int countNodes;
    public static void main(String[] args){
        SinglyLinkedList s = new SinglyLinkedList();
        s.addAtEndNode(new ObjectNode(6, null));
        s.addAtFrontNode(new ObjectNode(3, null));
        s.addAtFrontNode(new ObjectNode(2, null));
        s.addAtFrontNode(new ObjectNode(1, null));
        s.addAtEndNode(new ObjectNode(4, null));
        s.addAtEndNode(new ObjectNode(5, null));
        s.addAtEndNode(new ObjectNode(6, null));
        System.out.println("Linked list elements: ");
        s.reset();
        while(s.hasNext()){
            System.out.println(s.next());
        }
        System.out.println("Last item: " + s.getLast());
        System.out.println("Item at position 3: " + s.getObjectAt(3));
        System.out.println("Count of Nodes: " +s.countNodes());
    }
    public SinglyLinkedList()
    {
        head = null;
        tail = null;
        countNodes = 0;
    }
    public void addAtEndNode(Object c){     //Big Theta: Θ(1)
        ObjectNode cur = new ObjectNode(c, null);
        if(tail == null && head == null){
            head = cur;
            tail = cur;
            current = cur;
        }
        else {
            tail.addNodeAfter(c);
            tail = tail.getLink();
        }
        countNodes++;
    }
    public void addAtFrontNode(Object c){   //Big Theta: Θ(1)
        ObjectNode cur = new ObjectNode(c, null);
        if(head == null){
            head = cur;
            tail = cur;
            current = cur;
        }
        else{
            cur.setLink(head);
            head = cur;
        }
        countNodes++;
    }
    public int countNodes(){
        return countNodes;
    }   //Big Theta: Θ(1)
    public Object getLast(){
        return tail.getData();
    }   //Big Theta: Θ(1)

    /**
     * @pre-condition
     *   Number of nodes in the linked list is at least equal to (i+1).
     **/
    public Object getObjectAt(int i){       //Big Theta: Θ(1)
        i++;
        if(i>=0 && i<=countNodes)
            return listPosition(head, i).getData();
        return null;
    }
    public boolean hasNext(){   //Big Theta: Θ(1)
        return current != null;
    }
    public Object next(){   //Big Theta: Θ(1)
        ObjectNode temp = current;
        current = current.getLink();
        return temp.getData();
    }
    public void reset(){
        current = head;
    }   //Big Theta: Θ(1)
    @Override
    public String toString() {
        return current.toString();
    }   //Big Theta: Θ(1)
}
