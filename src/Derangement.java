/**
 * Implementations for a naive alogorithm and a fast algorithm that
 * count the number of derangements of a set given its cardinality.
 * @author William Duncan, Hannah Lowery
 * <pre>
 * Date: 09/7/2024
 * Course: csc 3102
 * Project # 0
 * Instructor: Dr. Duncan
 * </pre>
 */
import java.lang.Math;
public class Derangement {

    /**
     * Computes the number of derangements of a set
     *
     * @param n the size of the set
     * @return the number of derangements of a set with the specified size
     * @throws IllegalArgumentException exception when n is negative
     */
    public static double fastDerange(int n) {
        double fastAl;


        if (n < 0) { //ensures the number isnt negative
            throw new IllegalArgumentException("negative number");
        } else if (n == 0) { //test to see its equal to 0
            fastAl = 1;
        } else {
            double term = -1;
            double sum=0;
            for(int i=2;i<=n;i++) { //i is the factorial so !i
                term = -term/i; //term is just -1
                sum +=term; //stores term
            }
            fastAl= (sum/Math.abs(term)); //calculates the derangement
        }
        return fastAl; //returns the derangement
    }

        /**
         * Computes the number of derangements of a set
         * @param n the size of the set
         * @return the number of derangements of a set with the specified size
         * @throws IllegalArgumentException exception when n is negative
         */
        public static double naiveDerange(int n)
        {
            double naiveAl;


            if (n < 0) {
                throw new IllegalArgumentException("negative number");
            } else if (n == 0) {
                naiveAl = 1;
            } else {
                double sum = 0;
                double sign = -1;
                double factRcp = 0;
                for (int i = 2; i <= n; i++) {
                    sign *= -1; //multiplies by itself so it interchanges between positive and negative
                    factRcp = 1;

                    for (int k = 1; k <= i; k++) {
                        factRcp = factRcp / k; //factRcp is 1
                    }
                    sum = sum + sign * factRcp; //stores the answer in sum
                }
                naiveAl = (sum / factRcp); //calculates the derangement
            }
            return naiveAl;
        }
    }

