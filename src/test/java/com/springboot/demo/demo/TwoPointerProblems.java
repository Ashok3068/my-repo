package com.springboot.demo.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TwoPointerProblems {
    public static void main(String[] args) {
        //System.out.println(removeDuplicates(new int[]{2, 3, 3, 3, 6, 9, 9}));
        //System.out.println(sortSquares1(new int[]{-2,-1,0,1,2,3,4}));
        // System.out.println(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        // System.out.println(searchSTripletSumCloseToTarget(new int[]{-3, -1, 1, 2}, 1));
        // System.out.println(searchTripletWithSmallerSum(new int[]{-1, 0, 1, 1, 3}, 3));
        //System.out.println(findSubarrays(new int[]{2,4,5,1,3},777));
        // System.out.println(findSubarrays1(new int[]{9,8,7,4,5,2,1},777));
        //dutchFlagsort(new int[]{1, 0, 2, 1, 0});
        // System.out.println(searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1));
        //System.out.println(compare("xy#z", "xyz#"));
/*        System.out.println(shortestWindowSort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));

        System.out.println(shortestWindowSort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));*/
       // System.out.println(shortestWindowSort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(shortestWindowSort(new int[] { 1, 2, 3 }));
        System.out.println(shortestWindowSort(new int[] { 3, 2, 1 }));
        //System.out.println(findSubarrays1(new int[]{2, 4,5,1,2, 4,5,1,3,9,1,3,-4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,-5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1,2, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1, 4,5,1,3,9,1,3,4,5,8,9,8,9,1,9,4,2,2,1},2550000));


    }
    /*Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
     after removing the duplicates in-place return the length of the subarray that has no duplicate in it.
     Input: [2, 3, 3, 3, 6, 9, 9]
    Output: 4
    Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].*/

    public static int removeDuplicates(int nums[]) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < nums.length - 1) {
            ++j;
            if (nums[i] == nums[j])
                ++count;
            i = j;


        }
        return nums.length - count;
    }
    /*
     * find the postive number first and compare left and right from there*/

    public static int[] sortSquares1(int nums[]) {
        int left = 0, right = 0;
        int nums2[] = new int[nums.length];
        int numsIndex = 0;

        while (nums[right] < 0)
            right++;
        left = right - 1;
        while (right < nums.length && left >= 0) {
            if (Math.pow(nums[right], 2) > Math.pow(nums[left], 2)) {
                nums2[numsIndex] = (int) Math.pow(nums[left], 2);
                --left;
                ++numsIndex;
            } else if (Math.pow(nums[right], 2) < Math.pow(nums[left], 2)) {
                nums2[numsIndex] = (int) Math.pow(nums[right], 2);
                ++right;
                ++numsIndex;
            } else if (Math.pow(nums[right], 2) == Math.pow(nums[left], 2)) {
                nums2[numsIndex] = (int) Math.pow(nums[left], 2);
                ++numsIndex;
                nums2[numsIndex] = (int) Math.pow(nums[right], 2);
                ++numsIndex;
                --left;
                ++right;

            }
        }
        while (right < nums.length) {
            nums2[numsIndex] = (int) Math.pow(nums[right], 2);
            ++numsIndex;
            ++right;
        }
        while (left >= 0) {
            nums2[numsIndex] = (int) Math.pow(nums[left], 2);
            ++numsIndex;
            --left;
        }

        return nums2;

    }

    /*
     * start from  both ends, add the largest number at the end of new list
     * */

    public static int[] sortSquares(int nums[]) {
        int left = 0, right = nums.length - 1;
        int numsIndex = nums.length - 1;
        int nums2[] = new int[nums.length];


        while (left < right) {
            if (Math.pow(nums[right], 2) > Math.pow(nums[left], 2)) {
                nums2[numsIndex--] = (int) Math.pow(nums[right], 2);
                --right;
            } else {
                if (Math.pow(nums[right], 2) < Math.pow(nums[left], 2)) {
                    nums2[numsIndex--] = (int) Math.pow(nums[left], 2);
                    ++left;
                } else {
                    nums2[numsIndex--] = (int) Math.pow(nums[left], 2);

                    nums2[numsIndex--] = (int) Math.pow(nums[right], 2);
                    ++left;
                    --right;
                }


            }
        }


        return nums2;

    }
    /*
    * You are given an integer array height of length n.
    *  There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
     Container With Most Water
     * https://leetcode.com/problems/container-with-most-water/
     *
    * */

    public static int maxArea(int[] height) {
        if (height.length < 1) return 0;
        int maxSize = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {

            int size = Math.abs(right - left) * (height[left] > height[right] ? height[right] : height[left]);
            maxSize = Math.max(size, maxSize);
            if (height[left] < height[right]) {
                left++;
            } else

                --right;
        }


        return maxSize;

    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        //sort arrays
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            //if next element is duplicate skip
            if (i + 1 < arr.length && arr[i] == arr[i + 1])
                continue;
            searchTriplet(arr, -arr[i], i + 1, list);


        }
        return list;

    }//[-3, -2, -1, 0, 1, 1, 2]

    /*serach triplet close to sum*/
    public static void searchTriplet(int arr[], int target, int left, List<List<Integer>> list) {

        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == target) {
                list.add(Arrays.asList(-target, arr[left], arr[right]));
                ++left;
                right--;
                //after finding the match, need to skip the duplicate elements in next
                while (arr[left] == arr[left - 1] && left < right)
                    left++;
                while (arr[right] == arr[right + 1] && left < right)
                    --right;
            } else if (arr[left] + arr[right] > target)
                --right;
            else if (arr[left] + arr[right] <= target)
                ++left;

        }

    }

    /*
     *
     * find triplet close to sum*/
    public static int searchSTripletSumCloseToTarget(int[] arr, int target) {
        int tripletSum = Integer.MAX_VALUE;
        //sort arrays
        Arrays.sort(arr);
        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            //if next element is duplicate skip
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < target)
                    ++left;
                else
                    --right;
                if (closestSum > Math.abs(sum - target))
                    tripletSum = sum;

                closestSum = Math.min(closestSum, Math.abs(sum - target));


            }


        }
        return tripletSum;
    }

    public static int searchTripletWithSmallerSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        //sort arrays
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            //if next element is duplicate skip
            if (i + 1 < arr.length && arr[i] == arr[i + 1])
                continue;
            searchTripletForSmallerSum(arr, target, i + 1, list);


        }
        return list.size();

    }

    public static void searchTripletForSmallerSum(int arr[], int target, int left, List<List<Integer>> list) {
        int firstTriplet = arr[left - 1];
        int right = arr.length - 1;
        while (left < right) {
            if (firstTriplet + arr[left] + arr[right] < target) {
                for (int y = right; y > left; y--)
                    if (arr[y] != arr[y - 1])
                        list.add(Arrays.asList(firstTriplet, arr[left], arr[y]));
                ++left;
            } else
                right--;
            //after finding the match, need to skip the duplicate elements in next
            while (arr[left] == arr[left - 1] && left < right)
                left++;
            while (left < right && arr[right] == arr[right - 1])
                --right;


        }

    }

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        long s1 = System.currentTimeMillis();
        List<List<Integer>> subarrays = new ArrayList<>();
        int startWindow = 0;

        for (int i = 0; i < arr.length; i++) {
            startWindow = i;
            ArrayList list = new ArrayList();
            int prod = 1;
            while (startWindow < arr.length && prod * arr[startWindow] < target) {

                list.add(arr[startWindow]);
                prod = prod * arr[startWindow];
                subarrays.add(new ArrayList<>(list));
                ++startWindow;
            }

        }
        System.out.println(System.currentTimeMillis() - s1);
        System.out.println(subarrays.size());

        return subarrays;

    }

    public static List<List<Integer>> findSubarrays1(int[] arr, int target) {
        long s1 = System.currentTimeMillis();
        List<List<Integer>> result = new ArrayList<>();
        double product = 1;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left < arr.length)
                product /= arr[left++];
            // since the product of all numbers from left to right is less than the target therefore,
            // all subarrays from left to right will have a product less than the target too; to avoid
            // duplicates, we will start with a subarray containing only arr[right] and then extend it
            List<Integer> tempList = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }
        System.out.println(System.currentTimeMillis() - s1);
        System.out.println(result.size());
        return result;

    }

    /*
    * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.

    The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.*/
    public static void dutchFlagsort(int[] arr) {
        int i = 0;
        int low = 0;
        int high = arr.length - 1;
        /*there will be only there types of elements (0,1,2), if the element is zero it should go to the start and if it is 2 it should be the end*/
        while (i < high) {
            if (arr[i] == 0) {
                int temp = arr[low];
                arr[low] = arr[i];
                arr[i] = temp;
                ++low;

            } else if (arr[i] == 2) {
                int temp = arr[high];
                arr[high] = arr[i];
                arr[i] = temp;
                --high;

            } else
                i++;


        }
        System.out.println(arr);
    }
/*Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.
* Input: [4, 1, 2, -1, 1, -3], target=1
Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
Explanation: Both the quadruplets add up to the target.
*
*
*
* a+b+c+d=target
* b+c+d=target-a; triplets
* c+d=target-a-b
*
* */

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);
        // TODO: Write your code here

        for (int i = 0; i < arr.length - 3; i++) {
            searchTripletsToTarget(quadruplets, arr, i, target - arr[i]);
        }


        return quadruplets;
    }

    private static void searchTripletsToTarget(List<List<Integer>> quadruplets, int[] arr, int i, int target) {
        for (int q = i + 1; q < arr.length - 2; q++) {
            searchTriplets(arr, i, q, q + 1, target - arr[q], quadruplets);
        }
    }

    private static void searchTriplets(int[] arr, int first, int second, int left, int target, List<List<Integer>> quadruplets) {

        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == target) {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                --right;
                while (left < right && arr[left - 1] == arr[left])
                    ++left;
                while (left < right && arr[right] == arr[right - 1])
                    --right;
            } else if (arr[left] + arr[right] > target)
                --right;
            else left++;
        }
    }

    /*
    *
    * Comparing Strings containing Backspaces (medium)#
        Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
    *
    * Input: str1="xy#z", str2="xzz#"
    Output: true
    Explanation: After applying backspaces the strings become "xz" and "xz" respectively.*/
    public static boolean compare(String str1, String str2) {
        int str1Right = str1.length() - 1;
        int str2Right = str2.length() - 1;
        if (str1.equals(str2)) return true;

        while (str1Right >= 0 && str2Right >= 0) {
            int count = 0;
            while (str1.charAt(str1Right) == '#') {
                ++count;
                --str1Right;
            }
            str1Right = str1Right - count;
            count = 0;
            while (str2.charAt(str2Right) == '#') {
                ++count;
                --str2Right;
            }
            str2Right = str2Right - count;
            if (str2Right < 0 && str1Right < 0) return true;
            if (str2Right < 0 || str1Right < 0) return false;

            if (str1.charAt(str1Right) != str2.charAt(str2Right))
                return false;
            --str1Right;
            --str2Right;
        }
        return true;
    }

    /*
    *
    *
    * From the beginning and end of the array, find the first elements that are out of the sorting order. The two elements will be our candidate subarray.
Find the maximum and minimum of this subarray.
Extend the subarray from beginning to include any number which is bigger than the minimum of the subarray.
Similarly, extend the subarray from the end to include any number which is smaller than the maximum of the subarray.*/
    public static int shortestWindowSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        //find the f
        while (left  < right && arr[left] <= arr[left + 1]) {
            ++left;
        }
        if(left==right)
            return 0;

        while (right > left && arr[right] > arr[right - 1]) {
            --right;
        }


        int i = left;
        int smallest = left;
        int largest = right;
        while (i <=right) {
            if (arr[smallest] > arr[i]) {
                smallest = i;
            }

            if (arr[largest] < arr[i]) {
                largest = i;
            }
            ++i;

        }


        while (left > 0 && arr[smallest] < arr[left - 1]) {
            --left;

        }


        while (right < arr.length - 1 && arr[largest] > arr[right + 1]) {

            ++right;
        }


        return right - left + 1;
    }


}
