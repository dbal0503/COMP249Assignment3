import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class BookList {
    private Node head;
    public BookList(){
        head = null;
    }
    public void addToStart(Book b){
        Node n = new Node();
        n.b = b;
        if (head == null){
            head = n;
            System.out.println("aaa");
        }
        else {
            Node temp = head;
            if (temp.next == null){

                temp.next = n;
                n.next = head;
                head = n;
            }else {
                while (temp.next!= head){
                    temp = temp.next;
                }

                temp.next = n;
                n.next =head;
                head = n;
            }}
    }
    public void show(){
        Node node = head;

        while(node.next!=head){
            System.out.println(node.b);
            node = node.next;
        }
        System.out.println(node.b);

    }
    public int length() {
        Node node = head;
        int count = 0;
        if (head == null){
            return 0;

        }
        if (node.next== null){
            return 1;
        }
        while (node.next != head) {
            count++;
            node = node.next;
        }
        return count;
    }



    public void storeRecordsByYear(int yr){
        Node node = head;
        int count =0;
        Book[] bookswithYearTemp = new Book[this.length()];
        while(node.next!= head){

            if (node.b.getYear() == yr){
                bookswithYearTemp[count]= node.b;
                count++;
            }
            node = node.next;
        }
        PrintWriter pr;
        if (count!=0){


            try {
                pr = new PrintWriter(new FileOutputStream(yr+".txt"));
                for (int i= 0; i<bookswithYearTemp.length; i++){
                    if (bookswithYearTemp[i] != null){
                        pr.println(bookswithYearTemp[i].toString());
                    }
                }

                pr.close();
            }
            catch (FileNotFoundException fileNotFoundException){
                System.out.println("File could not be created or accessed");
                System.out.println(fileNotFoundException.getMessage());
            }
        }
        else {
            System.out.println("No books in list match given publication year");
        }






    }

    public boolean insertBefore(long isbn, Book b){
        Node node = head;
        Node newnode = new Node(b, null);

        int count = 0;
        if (node.b.getISBN() == isbn){
            System.out.println("going to start");
            addToStart(b);
            return true;
        }

        while (node.next != head){
            if (node.next.b.getISBN() == isbn){
                newnode.next = node.next;
                node.next= newnode;
                return true;
            }
            node = node.next;

        }
        return false;

    }

    public boolean insertBetween(long isbn1, long isbn2, Book b){
        Node node = head;
        Node nodetoadd = new Node(b, null);

        while (node.next != head){
            if ((node.next.next == head) && (node.next.b.getISBN() == isbn1) && (node.next.next.b.getISBN() == isbn2)){
                addToStart(b);
                return true;
            }
            if ((node.next.b.getISBN() == isbn1) && (node.next.next.b.getISBN() == isbn2)){
                nodetoadd.next = node.next.next;
                node.next.next = nodetoadd;
                return true;
            }
            node = node.next;
        }


        return false;
    }

    public boolean delConsecutiveRepeatedRecords(){
        Node temp = head;
        while(temp.next != head){

            if(temp.next.b.getISBN() == temp.next.next.b.getISBN()){
                temp.next = temp.next.next;
                delConsecutiveRepeatedRecords();
                return true;
            }
                temp = temp.next;

        }
        return false;
    }

    public BookList extractAuthList(String aut){
        BookList authLst = new BookList();
        Node temp = head;

        while (temp.next != head){
            if (temp.b.getAuthor().equals(aut)){
                authLst.addToStart(temp.b);
            }
            temp = temp.next;
        }
        if (temp.b.getAuthor() == aut){
            authLst.addToStart(temp.b);
        }

        return authLst;
    }
    public Node getnode(int integer){
        Node temp = head;
        for (int i=0; i<integer; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean swap(long isbn1, long isbn2) {
        Node temp = head;
        boolean check =false;
        Node node1 = null;
        Node swap1 = null;
        Node node2 = null;
        Node swap2 =null;

        while (temp.next != head) {
            if (temp.next.b.getISBN() == isbn1) {
                System.out.println("cc");
                node1 = temp;
                swap1 = temp.next;
            }
            if (temp.next.b.getISBN() == isbn2) {
                System.out.println("bb");
                node2 = temp;
                swap2 = temp.next;
            }
            if ((node1 != null) && (node2 != null)) {
                check = true;
                System.out.println("aa");
                break;
            }
            temp = temp.next;
        }

        Book b1Temp  = new Book(swap1.b);
        Book b2Temp = new Book(swap2.b);
        swap1.b= b2Temp;
        swap2.b = b1Temp;

        return check;
    }





    private class Node {
        private Book b;
        private Node next;

        public Node(){}

        public Node(Book b, Node next){
            this.b = b;
            this.next = next;
        }

    }

}






