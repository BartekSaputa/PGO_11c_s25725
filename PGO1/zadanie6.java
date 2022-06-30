package PGO1;
import java.util.Arrays;
import java.util.Random;
public class zadanie6 {

    public static void main(String[] args){
        Random r=new Random();
        int[] arr= new int[10];
        System.out.print("Tablica: ");

        for(int i=0;i<10;i++){
            arr[i]=r.nextInt(1000-100)+100;
            System.out.print(arr[i]+", ");
        }
        done(sort(arr));
    }
    public static void done(int[] sort) {
        System.out.println(" ");
        System.out.print("Posortowana tablica: ");
        for(int i=0;i<10;i++){
            System.out.print(sort[i]+", ");
        }
    }
    public static int[] sort(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
}