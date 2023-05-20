package Day1;

import java.util.Arrays;
import java.util.Scanner;

public class Pascal {
    public static void main(String[] args) {
        Pascal pascal = new Pascal();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the limit -> ");
        int n = scanner.nextInt() - 1;
        System.out.println("Top Down Pascal Triangle");
        pascal.pascalTriangleTopDown(n);
        System.out.println("Bottom Up Pascal Triangle");
        pascal.pascalTriangleBottomUp(n);
    }
    private void pascalTriangleTopDown(int n){
        if(n < 0)
            return;
        pascalTriangleTopDown(n-1);
        char [] result = Integer.toString((int) Math.pow(11, n)).toCharArray();
        System.out.println(Arrays.toString(result));
    }
    private void pascalTriangleBottomUp(int n){
        if(n < 0)
            return;
        char [] result = Integer.toString((int) Math.pow(11, n)).toCharArray();
        System.out.println(Arrays.toString(result));
        pascalTriangleBottomUp(n-1);
    }
    private void pascalTriangleBUIterative(int n){
        while(n >= 0){
            char [] result = Integer.toString((int) Math.pow(11, n)).toCharArray();
            System.out.println(Arrays.toString(result));
            n -= 1;
        }
    }
    private void pascalTriangleTDIterative(int n){
        for(int i = 0; i<=n; i+=1){
            char [] result = Integer.toString((int) Math.pow(11, i)).toCharArray();
            System.out.println(Arrays.toString(result));
        }
    }
}
