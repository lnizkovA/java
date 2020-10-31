package epam.com.java.module1.fundamentals.optinaltask2;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n number");
        int n = scanner.nextInt();
        System.out.println("Enter m ");
        int m = scanner.nextInt();
        System.out.println("Enter k ");
        int k = scanner.nextInt();

        int [][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = generateRandomNumber(-m, m);
            }
        }
//        System.out.println(Arrays.deepToString(arr));
        System.out.println("Array "+n+" x "+n+" :");
        print2DArray(arr);

//        System.out.println("----------------\n");
//        int [][] array = {{1,-3,-1,-4,2},{1,3,-5,5,2},{1, -1, 2, -1, 4},{2,4,-1, 3,-1},{2,4,-4,3,4}} ;
//        for (int[] anArr: array ) {
//            System.out.println(Arrays.toString(anArr));
//        }

        System.out.println("\n----sort Array by column k = "+k+" ------------");
//        int[][] copyArray = arr.clone();
        sortArrayByColumn(arr, k-1);
//        System.out.println("\n");
//        print2DArray(arr);

        System.out.println("\n-----sort Array by row k = "+k+" -----------");
        sortArrayByRow(arr, k-1);
//        System.out.println("\n");
//        print2DArray(arr);

        System.out.println("\n------find max value in Array and delete row and column ----------");
        getMaxValueAndDeleteRowAndColumn(arr);

        scanner.close();
    }

    public static int generateRandomNumber(int min, int max) {
        max -= min;
        return (int) (Math.random() *  ++max) + min;
    }

    private static void getMaxValueAndDeleteRowAndColumn(int[][] arr){
        int[][] copyArr = arr.clone();
        int maxValue = copyArr[0][0];
        int maxRow = 0;
        int maxColumn = 0;
        for (int i = 0; i < copyArr.length; i++) {
            for (int j = 0; j < copyArr[i].length; j++) {
                if (copyArr[i][j] > maxValue) {
                    maxValue = copyArr[i][j];
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }
        System.out.println("maxNum = "+maxValue+" maxRow = "+(maxRow+1)+"  maxColumn = "+(maxColumn+1));
        int size = copyArr.length-1;
        int[][] newArr = new int[size][size];

        for(int i=0 ; i<size ; i++){
            for(int j=0 ; j<size ; j++){
                newArr[i][j] = arr[i+(i>=maxRow?1:0)][j+(j>=maxColumn?1:0)];
            }
        }
        print2DArray(newArr);
    }

    public static void sortArrayByColumn(int[][] arr, int column){
        int[][] copyArr = arr.clone();
        Arrays.sort(copyArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[column] > o2[column])  return 1;
                else if (o1[column] < o2[column]) return -1;
                return 0;
            }
        });
        print2DArray(copyArr);
    }

    private static void sortArrayByRow(int[][] arr, int row){
        int [][] copyArr = arr.clone();
        Arrays.sort(copyArr[row]);
        print2DArray(copyArr);
    }

    private static void print2DArray(int[][] arr){
        for (int[] anArr: arr) {
            System.out.println(Arrays.toString(anArr));

        }
    }
}
