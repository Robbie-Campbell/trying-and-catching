import java.util.InputMismatchException;
import java.util.Scanner;

// This initial file comes courtesy of the youtuber Alex Lee
// Source: https://www.youtube.com/watch?v=ceGnVDrMy1A

public class TryCatchLesson
{

    // An alternative method has been created for different exception conditions
    public static void saveErrorMsg(Exception e)
    {
        System.out.println("ERROR MSG SAVED");
        if (e instanceof ArrayIndexOutOfBoundsException)
        {
            System.out.println("Array Out of Bounds");
        }
        else if (e instanceof NullPointerException)
        {
            System.out.println("Array is Null");
        }
        else 
        {
            System.out.println("Something else went wrong");
        }
    }

    public static void main(String[] args)
    {

        // Standard exception for any type of error
        try{
            int[] a = {4, 5, 1};
            System.out.println(a[3]);
        } catch (Exception e) {
            System.out.println("Exception happened");
        }

        // Error handle for an incorrect datatype
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your favourite number");
        try{
            int n = scan.nextInt();
            System.out.println(n + " is your fave number");
        }
        catch (InputMismatchException e) {
            System.out.println("Sorry, please enter a number");
        }

        // Handle the error in the saveErrorMsg Method
        try {
            int[] a = {5};
            System.out.println(a[1]);
        } catch (Exception e) {
            saveErrorMsg(e);
        }

        // Alternative try catches for each condition, not using the saveErrorMsg method
        try {
            int[] a = {5};
            System.out.println(a[1]);
        } catch (NullPointerException e) {
            System.out.println("The array is set to null.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The array index is out of bounds.");
        } catch (Exception e) {
            System.out.println("Something else went wrong.");
        }
    }
}