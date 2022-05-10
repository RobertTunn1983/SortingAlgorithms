import java.util.*;

public class MergeSort {

    //Let user enter the array to be sorted
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        
//        System.out.println("Please enter length of array to be sorted: ");
        
  //      int length = sc.nextInt();
        
//        int[] list = new int[length];
        
//        System.out.println("Please enter the elements of the list to be "
  //              + "sorted:");
    //    for (int i = 0; i < list.length; i++) {
      //      list[i] = sc.nextInt();
        //}
        
        int [] list = {34,54,23,13,65,43,56,87,65};
    
        int length = 9;
        
        System.out.println("The list before sorting is:");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        
        //Call mergeSort method below and update list variable with ordered list
        mergeSort(list, length);

        System.out.println();
        System.out.println("The list after sorting into ascending order is:");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    //Break down array to be sorted into sub-arrays of length 1
    public static void mergeSort(int[] input, int length) {
        
        //Recursive method
        
        System.out.println("input array is:");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
        
        //Special case:
        //Stop breaking down process when input array is of 1 element in length
        if (length == 1)
            return;
        //Element at n/2 will be regarded as mid element
        //Works for sub-arrays of odd and even lengths
        int mid = length / 2;
        int[] LHS = new int[mid];
        int[] RHS = new int[length - mid];

        //Copy one half of elements in input array to LHS
        for (int i = 0; i < mid; i++) {
            LHS[i] = input[i];
        }
        
        //To demonstrate what is going on, print LHS array to console
        System.out.println("LHS sub-array is:");
        for (int i = 0; i < LHS.length; i++) {
            System.out.print(LHS[i] + " ");
        }
        System.out.println();
        
        //Copy one half of elements in input array to LHS                
        for (int i = mid; i < length; i++) {
            RHS[i - mid] = input[i];
        }
        
        //To demonstrate what is going on, print RHS array to console
        System.out.println("RHS sub-array is:");
        for (int i = 0; i < RHS.length; i++) {
            System.out.print(RHS[i] + " ");
        }
        System.out.println();
        
        //Feed input arrays back into this method until reduced to a length of 1
        mergeSort(LHS, mid);
        mergeSort(RHS, length - mid);

        //Fuck knows
        merge(input, LHS, RHS, mid, length - mid);
    }

    //Merge the elements of the sub-arrays into an array of elements arranged
    //in ascending order
    public static void merge(int[] input, int[] LHS, int[] RHS, int leftLength, 
            int rightLength) {

        //Set three separate counters to zero
        int a = 0;
        int b = 0;
        int c = 0;

        //LHS goes with a, RHS goes with b, input goes with c
        //Until a equals length of LHS and b reaches length of RHS...
        while (a < leftLength && b < rightLength) {

            //If LHS[a] is less than RHS[b], input[c] = LHS[a]
            if (LHS[a] <= RHS[b]) {
                input[c] = LHS[a];
                //Move onto next element of LHS and input
                c++;
                a++;
            }
            //Otherwise if RHS[b] < LHS[a], input[c] = RHS[a]
            else {
                input[c] = RHS[b];
                c++;
                b++;
            }
        }
        
        System.out.println("input is now:");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();

        System.out.println("STEP 1: a is: " + a + ", b is: " + b + 
                ", c is: " + c);
        
        while (a < leftLength) {
            input[c] = LHS[a];
            c++;
            a++;
        }
        
        System.out.println("input is now:");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
        
        System.out.println("STEP 2: a is: " + a + ", b is: " + b + 
                ", c is: " + c);
        
        while (b < rightLength) {
            input[c] = RHS[b];
            c++;
            b++;
        }

        
        System.out.println("input is now:");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
        
        System.out.println("STEP 3: a is: " + a + ", b is: " + b + 
                ", c is: " + c);
    }
}
