import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {



    public static Book createBookfromString(String[] temp){
        for (int i =0; i<temp.length; i++){
            temp[i] = temp[i].trim();
        }
        return new Book(temp[0],temp[1],Double.parseDouble(temp[2]),Long.parseLong(temp[3]),temp[4],Integer.parseInt(temp[5]));
    }


    public static Object[] collect(BookList bkLst,ArrayList<Book> arrLst ) {
        String[] temp;
        Book aBook;
        Object[] objects = new Object[2];
        try {
            Scanner read = new Scanner(new FileInputStream("Books.txt"));


            while (read.hasNextLine()) {
                temp = read.nextLine().split(",");
                for (int i =0; i< temp.length; i++){
                    System.out.println(temp[i]);
                }

                if ((Integer.parseInt(temp[5].trim()) > 1900) && (Integer.parseInt(temp[5].trim()) < 2023)) {

                    bkLst.addToStart(createBookfromString(temp));

                } else {


                    arrLst.add(createBookfromString(temp));
                }

            }

            read.close();
        }
        catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
        objects[0] = bkLst;
        objects[1] = arrLst;
        return objects;
    }



    public static void main(String[] args) {
        File file = new File("2008.txt");
        file.delete();

        BookList bkLst = new BookList();
        ArrayList<Book> arrLst = new ArrayList<Book>();
        Object[] objects = collect(bkLst, arrLst);
        bkLst = (BookList) objects[0];
        arrLst = (ArrayList<Book>) objects[1];
/*
        for (int i = 0; i < arrLst.size(); i++) {
            System.out.println(arrLst.get(i).toString());
        }

 */
       // bkLst.show();
      //  bkLst.storeRecordsByYear(2008);
        Book booktoinsert = new Book("The Dark Road", "Jimin S.", 25.92, 1239009879, "FCN", 2019);
        long longISBN = 97807864121l;
        long longISBN2 = 879109858l;
       // System.out.println(bkLst.insertBetween(longISBN, longISBN2, booktoinsert));
        //System.out.println(bkLst.insertBefore(807863614, booktoinsert));
        System.out.println("default list: ");
        bkLst.show();

        System.out.println("Next method");

        /*
       bkLst.delConsecutiveRepeatedRecords();
        bkLst.show();
        */
        /*
        System.out.println("Using the extracting author method and printing it:");
        bkLst.extractAuthList("Mark W. Schraf").show();
        */


        long longswap1 = 97808798254l; //jazz
        long longswap2 = 97808709268l; //he ran
        System.out.println(bkLst.swap(longswap1, longswap2));
        bkLst.show();



    }
    }