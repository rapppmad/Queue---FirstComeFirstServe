package HackerRankPraktikum.HRStackQueue;

import java.util.Scanner;
import java.util.*;

public class FCFS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue queue = new Queue();
        ArrayList array = new ArrayList();
        int jumlahThread = scan.nextInt();
        scan.nextLine();

        while (true) {
            int thread = jumlahThread;
            String perintah = scan.nextLine();
            if(perintah.equals("START")) {

                if (queue.isEmpty()) {
                    array.add(thread + " idle thread");
                    continue;
                } else {
                    for (int i = 0; !queue.isEmpty() && i < jumlahThread; i++) {
                        array.add("task " + queue.dequeue() + " done");
                        thread--;
                    }
                    array.add(thread + " idle thread");
                    continue;
                }
            }
            if(perintah.equals("DONE")){
                for (Object data : array){ System.out.println(data);}
                System.out.println("task left: ");
                queue.print();
                break;
            } else{
            queue.enqueue(perintah);
            }
        }
    }
}
class Queue {
    SinglyNode tail;
    SinglyNode head;
    int size;

    public Queue() {
        makeEmpty();
    }

    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(Object data) {
        SinglyNode tmp = new SinglyNode(data);
        if (isEmpty()) {
            this.head = tmp;
            this.tail = tmp;
        } else{
            this.tail.next = tmp;
            this.tail = tmp;
        }

        size++;
    }

    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object tmp = this.head.data;
        if (head.next == null) {
            makeEmpty();
        } else {
            this.head = this.head.next;
        }
        size--;
        return tmp;
    }
    public void print(){
        SinglyNode temp = head;
        while (temp != null){
            System.out.println("task " + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
}


class SinglyNode {
    Object data;
    SinglyNode next;

    public SinglyNode() {
    }

    public SinglyNode(Object data) {
        this(data, null);
    }

    public SinglyNode(Object data, SinglyNode next) {
        this.data = data;
        this.next = next;
    }
}