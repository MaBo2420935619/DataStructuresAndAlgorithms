package com.mabo.sparsearray;

/**
 *
 * 二维数组
 * 转为
 * 稀疏数组
 */
public class SparseArray {

    private static final int ROW =11;

    private static final int COL =11;

    /**
     * @Author mabo
     * @Description   初始化
     */

    public static int[][] initSparseArray(){
        int[][] array = new int[ROW][COL];
        array[2][3]=1;
        array[5][6]=3;
        array[3][4]=2;
        return array;
    }

    public static void show(int  array[][]){
        for (int[]ROW:array) {
            for (int data:ROW) {
                System.out.print(data+" ");
            }
            System.out.println();
        }
    }

    /**
     * @Author mabo
     * @Description   二维数组转为稀疏数组
     */

    public static int[][] getSparseArray(int  array[][]){
        int sum=0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (array[i][j]!=0){
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum+1][3];
        sum=1;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (array[i][j]!=0){
                    sparseArray[sum][0]=i;
                    sparseArray[sum][1]=j;
                    sparseArray[sum][2]=array[i][j];
                    sum++;
                }
            }
        }
        sparseArray[0][0]=ROW;
        sparseArray[0][1]=COL;
        sparseArray[0][2]=sum-1;
        return  sparseArray;
    }
    /**
     * @Author mabo
     * @Description   稀疏数组转为二维数组
     */

    public static int[][] toArray(int  sparseArray[][]){
        int row=sparseArray[0][0];
        int col=sparseArray[0][1];
        int sum=sparseArray[0][2];//数量
        int[][] array = new int[row][col];
        for (int i = 1; i <=sum; i++) {
            int x = sparseArray[i][0];
            int y = sparseArray[i][1];
            array[x][y]=sparseArray[i][2];
        }
        return  array;
    }

    public static void main(String[] args) {
        int[][] array = SparseArray.initSparseArray();
        SparseArray.show(array);

        int[][] sparseArray = SparseArray.getSparseArray(array);
        SparseArray.show(sparseArray);

        int[][] ints = SparseArray.toArray(sparseArray);
        SparseArray.show(ints);

    }
}
