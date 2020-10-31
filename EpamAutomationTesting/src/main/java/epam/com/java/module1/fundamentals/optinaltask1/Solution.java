package epam.com.java.module1.fundamentals.optinaltask1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число чисел n");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter "+ n +" integer numbers: \n");
        for (int i=0; i<n; i++){
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
//        Arrays.stream(array).forEach(System.out::println);
        System.out.println("\n");
        findMaxLengthOfNumber(array, n);
        findMinLengthOfNumber(array, n);
        sortElementsByAscendingLenght(array, n);
        sortElementsByDescendingLenght(array, n);
        scanner.close();

    }
    private static void findMaxLengthOfNumber(int[] arr, int n){
        int maxLength = countCharsOfNumber(arr[n-1]);
        int num = arr[n-1];
        int i=n-2;
        while ( i >= 0){
            if (maxLength < countCharsOfNumber(arr[i]) )  {
                maxLength = countCharsOfNumber(arr[i]);
                num = arr[i];
            }
            i--;
        }
        System.out.println("Number with max length = "+num+" has length = "+maxLength);
    }
    private static void findMinLengthOfNumber(int[] arr, int n){
        int minLength =  countCharsOfNumber(arr[0]);
        int num = arr[0];
        int i=1;
        while ( i < n){
            if (minLength > countCharsOfNumber(arr[i])  ) {
                minLength = countCharsOfNumber(arr[i]);
                num = arr[i];
            }
            i++;
        }
        System.out.println("Number with min length = "+num+" has length = "+minLength);
    }

    private static void sortElementsByAscendingLenght(int[] arr, int n){
        List<List<Integer> > result = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 1; j < n-i; j++) {
                if (countCharsOfNumber(arr[j-1]) > countCharsOfNumber(arr[j])) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int item: arr) {
            result.add(Arrays.asList(new Integer[]{item, countCharsOfNumber(item)}));
        }
        System.out.println("Result of sorting numbers in ascending lenght [num , length]: \n"+result);
    }


    private static void sortElementsByDescendingLenght(int[] arr, int n){
        List<List<Integer> > result = new ArrayList<>();
        int temp = 0;
        for(int i=0 ; i<n; i++){
            for (int j=1; j<n-i; j++){
                if(countCharsOfNumber(arr[j-1]) < countCharsOfNumber(arr[j])){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j]=temp;
                }

            }
        }

        for (int item: arr) {
            result.add(Arrays.asList(new Integer[]{item, countCharsOfNumber(item)}));
        }
        System.out.println("Result of sorting numbers in descending lenght [num , length]: \n"+result);
    }

    private static int countCharsOfNumber(int number){
        int count = (number == 0) ? 1 : 0;
        while (number != 0)
        {
            count++;
            number /= 10;
        }
        return count;
    }

}
