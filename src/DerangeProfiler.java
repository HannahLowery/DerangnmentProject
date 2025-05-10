/**
 * A program to profile derangement algorithms, a naive implementation
 * and a fast version of the algorithm
 * !n = n!(1/0! - 1/1! + 1/2! - 1/3! + 1/4! + ... 1/n!)
 * @author William Duncan, Hannah Lowery
 * @see Derangement.java
 * <pre>
 * Date: 09/07/2024
 * Course: csc 3102
 * Project # 0
 * Instructor: Dr. Duncan
 * </pre>
 */

import java.util.Scanner;

public class DerangeProfiler
{
    public static void main(String[] args)
    {
        System.out.println("Enter 2 non-negative integers ->");

        Scanner in = new Scanner(System.in);
        int []numberArray = new int[2];

        //for loop to get and store the users answer
        for (int i = 0; i < numberArray.length;){
            numberArray[i] = in.nextInt();
        if(numberArray[i] >= 0)
            i++;
        else
            System.out.println("Only enter positive numbers!->");
        }

        //calculates and prints the derangement's
        int num1 = numberArray[0];
        int num2 = numberArray[1];
        double fastDerange;
        double naiveDerange;

        System.out.println("Using Fast Derangement: ");
        fastDerange = Derangement.fastDerange(num1);
        System.out.printf("!%d = %.0f%n" ,num1,fastDerange);

        fastDerange = Derangement.fastDerange(num2);
        System.out.printf("!%d = %.0f%n" ,num2,fastDerange);

        System.out.println("Using Naive Derangement:");
        naiveDerange= Derangement.naiveDerange(num1);
        System.out.printf("!%d = %.0f%n" ,num1,naiveDerange);

        naiveDerange = Derangement.naiveDerange(num2);
        System.out.printf("!%d = %.0f%n",num2, naiveDerange);

        System.out.println();

        //create a chart
        System.out.printf("%s%20s%20s%20s%20s","n","!n(naive)","Time(ns)","!n (fast)","Time(ns)");
        System.out.printf("%n%s%n","=================================================================================");

        //an array to store the number
        int [] numArray = new int[8];
        int number =20;

        //for loop to generate the number,derangement, and time in ns
        for(int i=0; i<numArray.length; i++)
        {
          long startTime;
          long elapsed,elapsedTime;
          double fast,naive;
          numArray[i] =number;
          number+=20;

        //calculating the time in (ns)
          startTime = System.nanoTime();
          naive= Derangement.naiveDerange(numArray[i]);
          elapsedTime = System.nanoTime() - startTime;

          startTime = System.nanoTime();
          fast= Derangement.fastDerange(numArray[i]);
          elapsed = System.nanoTime() - startTime;

          //prints the contents in the chart
          System.out.printf("%d%20e%15d%20e%18d%n",numArray[i],naive,elapsedTime,fast,elapsed);
        }
        //ends the chart
        System.out.printf("%s","=================================================================================");
    }
}
