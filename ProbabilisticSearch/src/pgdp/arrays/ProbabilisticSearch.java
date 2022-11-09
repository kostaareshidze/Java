package pgdp.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ProbabilisticSearch extends MiniJava {
    /**
     * Binary search slightly modified from the lecture
     */
    public static int[] find(int[] a, int x) {
        return find0(a, x, 0, a.length - 1, 1);
    }

    public static int[] find0(int[] a, int x, int n1, int n2, int numberOfSteps) {
        int t = (n1 + n2) / 2;
        if (a[t] == x)
            return new int[]{t, numberOfSteps};
        else if (n1 >= n2)
            return new int[]{-1, numberOfSteps};
        else if (x > a[t])
            return find0(a, x, t + 1, n2, numberOfSteps + 1);
        else if (n1 < t)
            return find0(a, x, n1, t - 1, numberOfSteps + 1);
        else return new int[]{-1, numberOfSteps};
    }

    public static int[] probalisticSearch(int[] arr, int value) {
        int counter = 0;
        int position;
        int min = arr[0];
        int max = arr[arr.length - 1];
        int pow = 0;
        double formula = (double) (value - min) / ((double) (max - min) / (arr.length - 1));
        position = (int) Math.round(formula);
        int startRange = 0;
        int endRange = arr.length - 1;
        if (value == arr[position]){
            counter++;
        return new int[]{position, counter};
        }
        if (position == arr.length)
            position = arr.length - 1;
        else if (position > arr.length || position < 0)
            return new int[]{-1, 0};
        if (arr[position] > value) {
            startRange = 0;
            counter++;
            while (arr[position] > value) {
                int twoPower = (int) Math.pow(2, pow);
                if (position - twoPower >= 0) {
                    endRange = position;
                    position -= twoPower;
                    pow++;
                    startRange = position;
                    counter++;
                } else {
                    endRange = position;
                    startRange = 0;
                    counter++;
                    break;
                }
            }
        } else if (arr[position] < value) {
            endRange = 0;
            counter++;
            while (arr[position] < value) {
                int twoPower = (int) Math.pow(2, pow);
                if (position + twoPower < arr.length) {
                    startRange = position;
                    position += twoPower;
                    pow++;
                    endRange = position;
                    counter++;
                } else {
                    startRange = position;
                    endRange = arr.length - 1;
                    counter++;
                    break;
                }
            }
        }
        if (arr[position] == value) {
            return new int[]{position, counter};
        }
        int isInArray = 0;
        int[] newArr = find0(arr, value, startRange + 1, endRange - 1, counter);
        return newArr;
    }

    public static boolean isInArr(int[] arr, int value) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                counter++;
            }
        }
        if (counter == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void compareApproaches(int[] arr, int min, int max) {
        long sumOfCalls = 0;
        int binaryMax = 0;
        int indexOfBinaryMax = 0;
        int probabilitySMax = 0;
        int indexOfProbabilitySMax = 0;

        for (int i = 0; i < arr.length; i++) {
            int[] array1 = find(arr, arr[i]);
            sumOfCalls += array1[1];
        }for (int i = min; i <= max; i++) {
            int[] array1 = find(arr, i);
            if (!isInArr(arr, i))
                sumOfCalls += array1[1];
        }
        for (int i = min; i <=max ; i++) {
            if (find(arr,i)[1]>binaryMax){
                binaryMax = find(arr,i)[1];
                indexOfBinaryMax = i;
            }
        }
        for (int i = min; i <=max ; i++) {
            if (probalisticSearch(arr,i)[1]>probabilitySMax){
                probabilitySMax = probalisticSearch(arr,i)[1];
                indexOfProbabilitySMax = i;
            }
        }
        int counter = 0;
        long sumOfCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] probArray = probalisticSearch(arr, arr[i]);
            sumOfCounter += probArray[1];

        }
        for (int i = min; i <= max; i++) {
            int[] probArray = probalisticSearch(arr, i);
            if (probArray[1] > counter) {
                counter = probArray[1];
            }if (isInArr(arr, i) == false) {
                sumOfCounter += probArray[1];
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.println(i + " " + Arrays.toString(probalisticSearch(arr, i)));
        }
        System.out.println("Binary Search:");
        System.out.println("Maximum number of calls:\n" + binaryMax);
        System.out.println("Value at which the maximum number of calls occurs:\n" + indexOfBinaryMax);
        System.out.println("Number of total calls:\n" + sumOfCalls);
        System.out.println("Probabilistic Search:");
        System.out.println("Maximum number of calls:\n" + probabilitySMax);
        System.out.println("Value at which the maximum number of calls occurs:\n" + indexOfProbabilitySMax);
        System.out.println("Number of total calls:\n" + sumOfCounter);
    }

    public static void main(String[] args) {
        int[] exampleArray = new int[]{6, 20, 22, 35, 51, 54, 59, 74, 77, 80, 87, 94, 97};
        int[] secondEx = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 100};
        System.out.println(Arrays.toString(probalisticSearch(secondEx, 3)));
        compareApproaches(secondEx, 10, 75);
    }
}
