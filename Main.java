import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

    public ArrayList<Book> collect(BufferedReader br)throws IOException, FileNotFoundException {
        String[] temp;
        Book aBook;
        ArrayList<Book> books= new ArrayList<>();
        File errors = new File("BookErrors.txt");
        PrintWriter pr = new PrintWriter(errors);
        while (br.readLine()!=null){
            temp = br.readLine().split(",");

            if (temp.length == 6){
                for (int i =0; i<temp.length; i++){
                    temp[i] = temp[i].trim();
                }
                aBook = new Book(temp[0],temp[1],Double.parseDouble(temp[2]),Long.parseLong(temp[3]),temp[4],Integer.parseInt(temp[5]));
                books.add(aBook);
            }
            else {
                pr.write(br.readLine());
            }

        }
        return books;
    }


    public static void main(String[] args){
        BufferedReader br = null;
        ArrayList<Book> incorrectBooks;

        try {
            br = new BufferedReader(new FileReader("Books.txt"));
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }




    }
}
