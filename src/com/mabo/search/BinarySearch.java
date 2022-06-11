package com.mabo.search;
/**
 * @Author mabo
 * @Description   二分法查找有序集合算法
 */

public class BinarySearch {
    int nums[]=new int[]{1,2,3,4,6,9,17,24,53};

    public int getNumPosition(int value){
        int low=0;
        int high=nums.length-1;
        while(low<=high) {
            int mid=(low+high)/2;
            if(value==nums[mid]) {
                return mid;
            }
            if(value>nums[mid]) {
                low=mid+1;
            }
            if(value<nums[mid]) {
                high=mid-1;
            }

        }
        return -1;//没有找到返回-1
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int numPosition = binarySearch.getNumPosition(6);
        System.out.println(numPosition);
    }
}
