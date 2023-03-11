// Name: Sreemoyee Mukherjee
// Course: Data Structures & Algorithms
// Assignment Number: 1

package edu.cmu.andrew.sreemoym;

import java.util.Random;
import edu.colorado.nodes.ObjectNode;

public class OrderedLinkedListOfIntegers extends SinglyLinkedList{
    public static void main(String[] args){
        OrderedLinkedListOfIntegers o = new OrderedLinkedListOfIntegers();

        o.sortedAdd(8);
        o.sortedAdd(2);
        o.sortedAdd(6);
        o.sortedAdd(4);
        o.sortedAdd(3);
        o.sortedAdd(1);
        System.out.println("Testing sortedAdd(): ");
        o.reset();
        while(o.hasNext()){
            System.out.println(o.next());
        }
        OrderedLinkedListOfIntegers o1 = new OrderedLinkedListOfIntegers();
        OrderedLinkedListOfIntegers o2 = new OrderedLinkedListOfIntegers();
        Random randomNum = new Random();
        for (int i=1; i<=20; i++){
            o1.sortedAdd(randomNum.nextInt(100));
            o2.sortedAdd(randomNum.nextInt(100));
        }
        System.out.println("1st ordered linked list: ");
        o1.reset();
        while(o1.hasNext()){
            System.out.print(o1.next() + "\t");
        }
        System.out.println("\n2nd ordered linked list: ");
        o2.reset();
        while(o2.hasNext()){
            System.out.print(o2.next() + "\t");
        }
        System.out.println("\nMerged ordered linked list: ");
        OrderedLinkedListOfIntegers merged = merge(o1, o2);
        merged.reset();
        while(merged.hasNext()){
            System.out.print(merged.next() + "\t");
        }
        System.out.println("\nMerging 2 empty lists: ");
        OrderedLinkedListOfIntegers empty = merge(new OrderedLinkedListOfIntegers(), new OrderedLinkedListOfIntegers());
        empty.reset();
        while(empty.hasNext()){
            System.out.println(empty.next());
        }
        System.out.println("Head of 2 merged empty lists: " + empty.head);
    }
    public OrderedLinkedListOfIntegers(){
        super();
    }
    public void sortedAdd(Object c)     //Big Theta: Θ(n)
    {
        ObjectNode node_c = new ObjectNode(c, null);

        if (head == null || (int) head.getData() >= (int) node_c.getData()) {
            node_c.setLink(head);
            head = node_c;
        }
        else {
            current = head;
            while (current.getLink() != null && (int) current.getLink().getData() < (int) node_c.getData()) {
                current = current.getLink();
            }

            node_c.setLink(current.getLink());
            current.setLink(node_c);
        }
        countNodes++;
    }
    public static OrderedLinkedListOfIntegers merge(OrderedLinkedListOfIntegers o1, OrderedLinkedListOfIntegers o2){  //Big Theta: Θ(m + n)
        OrderedLinkedListOfIntegers merged = new OrderedLinkedListOfIntegers();
        ObjectNode on = new ObjectNode(0, null);
        merged.head = on;
        merged.tail = on;
        while (true){
            if(o1.head == null){
                merged.tail.setLink(o2.head);
                break;
            }
            if(o2.head == null){
                merged.tail.setLink(o1.head);
                break;
            }
            if((int)o1.head.getData() <= (int)o2.head.getData()){
                merged.tail.setLink(o1.head);
                o1.head = o1.head.getLink();
            }
            else{
                merged.tail.setLink(o2.head);
                o2.head = o2.head.getLink();
            }
            merged.tail = merged.tail.getLink();
        }
        merged.head = merged.head.getLink();
        return merged;
    }
}