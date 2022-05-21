package com.springboot.demo.demo;

import java.util.*;
import java.util.HashMap;

class SidingWIndowProblems {
    public static void main(String[] args) {
        //System.out.println(findMaxSumSubArray(8, new int[]{3, 4, 1, 1, 8}));
        //System.out.println(findLength("araaci", 2));
        // System.out.println(maxFruitCountOf2Types(new char[] { 'A', 'B', 'C', 'B','B', 'C' }));
        //System.out.println(noRepeatSubstring("abcade"));
        // System.out.println(findLength1("bbacdb", 2));
        // System.out.println(replacingOnes(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        // System.out.println(findPermutation("bcdxabcdy","bcdyabcdx"));
        // System.out.println(findPermutation("aaaabaabcfaaa", "aaf"));
        //System.out.println(findStringAnagrams("abbcabc", "abc"));
        //System.out.println(findSubstring("abdabca", "abc"));
        // System.out.println(findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
       // System.out.println(findReplacezeroWithOne(new int[]{ 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
        System.out.println(findPermutationExist("acab","abc"));

        //int result = findMaxSumSubArray(7, new int[]{2, 1, 5, 2, 3, 2,0,9});
       // System.out.println("Smallest subarray length: " + result);

    }


    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowStart = 0;
        int windowEnd = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        while (windowEnd < arr.length) {
            sum += arr[windowEnd];
            while (sum >= k) {
                length = Math.min(length, windowEnd - windowStart + 1);
                sum -= arr[windowStart];
                ++windowStart;

            }
            ++windowEnd;

        }
        return length;
    }

    public static int longestSubString(String str, int k) {

        Map<Character,Integer> characterIntegerMap=new HashMap<>();
        int count=0;
        int windowStart=0;
        for(int i=0;i<str.length();i++){
            characterIntegerMap.put(str.charAt(i),characterIntegerMap.getOrDefault(str.charAt(i),0)+1);
            while(characterIntegerMap.size()>k){
                characterIntegerMap.put(str.charAt(windowStart),characterIntegerMap.get(str.charAt(windowStart))-1);
                if(characterIntegerMap.get(str.charAt(windowStart))==0)
                    characterIntegerMap.remove(str.charAt(windowStart));
                ++windowStart;

            }
            count = Math.max(count, i - windowStart + 1);

        }
        return count;


    }


    public static int maxFruitCountOf2Types(char[] str) {
        Map<Character, Integer> characterFrequencyMap = new java.util.HashMap<>();
        int count = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length; windowEnd++) {
            characterFrequencyMap.put(str[windowEnd], characterFrequencyMap.getOrDefault(str[windowEnd], 0) + 1);
            if (characterFrequencyMap.size() > 2) {
                characterFrequencyMap.put(str[windowStart], characterFrequencyMap.get(str[windowStart]) - 1);
                if (characterFrequencyMap.get(str[windowStart]) == 0)
                    characterFrequencyMap.remove(str[windowStart]);
                ++windowStart;
            } else {
                count = Math.max(count, windowEnd - windowStart + 1);
            }

        }
        return count;

    }

    //abccde
    public static int noRepeatSubstring(String str) {
        Set<Character> characterSet = new HashSet<>();
        int length = 0;
        int startWindow = 0;
        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            if (!characterSet.contains(str.charAt(endWindow))) {
                characterSet.add(str.charAt(endWindow));
                length = Math.max(length, endWindow - startWindow + 1);
            } else {
                int i = endWindow - 1;
                while (!(str.charAt(i) == str.charAt(endWindow))) {
                    --i;
                }
                startWindow = i + 1;
            }

        }


        return length;
    }


    //abccde
    public static int noRepeatSubstring1(String str) {
        ArrayList<Character> characterSet = new ArrayList<>();
        String s=null;
        int length = 0;
        int startWindow = 0;
        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            if (!characterSet.contains(str.charAt(endWindow))) {
                characterSet.add(str.charAt(endWindow));
                s=str.substring(startWindow,endWindow+1);

            } else {

                startWindow=  startWindow+str.substring(startWindow,endWindow).lastIndexOf(str.charAt(endWindow))+1;
                length = Math.max(length, endWindow - startWindow + 1);
/*
                int i = endWindow - 1;
                while (!(str.charAt(i) == str.charAt(endWindow))) {
                    --i;
                }
                startWindow = i + 1;*/
            }

        }
        System.out.println(s);


        return length;
    }


    public static int noRepeatSubstring2(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }

    public  static int findReplacezeroWithOne(int nums[], int k){

        int windowStart=0; int zeroCount=0;int maxLength=0;
        for (int  windowEnd=0;windowEnd<nums.length;windowEnd++){
            if(nums[windowEnd]==0)
                ++zeroCount;

            while(zeroCount>k && windowStart<windowEnd){

                if(nums[windowStart]==0)
                --zeroCount;
                ++windowStart;
            }
            maxLength=Math.max(windowEnd-windowStart+1,maxLength);





        }
        return maxLength;

        }


        public static boolean findPermutationExist(String str, String pattern){
        Map<Character,Integer> characterFrequencyMap=new HashMap<>();
        int count=0;
        if(count==pattern.length()) return true;

        for (int i=0;i<pattern.length();i++){
            characterFrequencyMap.put(pattern.charAt(i),characterFrequencyMap.getOrDefault(pattern.charAt(i),0)+1);
        }

        int windowStart=0;
        for (int windowEnd=0;windowEnd<str.length();windowEnd++){

            if(characterFrequencyMap.containsKey(str.charAt(windowEnd))){

                characterFrequencyMap.put(str.charAt(windowEnd),characterFrequencyMap.getOrDefault(str.charAt(windowEnd),0)-1);
                if(characterFrequencyMap.get(str.charAt(windowEnd))==0){
                    ++count;
                }
            }
            if(windowEnd-windowStart+1>pattern.length()){



                if(characterFrequencyMap.get(str.charAt(windowStart))==0){
                    --count;
                }
                characterFrequencyMap.put(str.charAt(windowStart),characterFrequencyMap.getOrDefault(str.charAt(windowStart),0)+1);
                ++windowStart;
            }
            if(count==pattern.length()) return true;

        }


            return false;
        }







    /*
    * Longest Substring with Same Letters after Replacement (hard)
    * This problem follows the Sliding Window pattern, and we can use a similar dynamic sliding window strategy as discussed in No-repeat Substring. We can use a HashMap to count the frequency of each letter.

We will iterate through the string to add one letter at a time in the window.
We will also keep track of the count of the maximum repeating letter in any window (let’s call it maxRepeatLetterCount).
So, at any time, we know that we do have a window with one letter repeating maxRepeatLetterCount times; this means we should try to replace the remaining letters.
If the remaining letters are less than or equal to ‘k’, we can replace them all.

If we have more than ‘k’ remaining letters, we should shrink the window as we cannot replace more than ‘k’ letters.

While shrinking the window, we don’t need to update maxRepeatLetterCount (hence, it represents the maximum repeating count of ANY letter for ANY window). Why don’t we need to update this count when we shrink the window? Since we have to replace all the remaining letters to get the longest substring having the same letter in any window, we can’t get a better answer from any other window even though all occurrences of the letter with frequency maxRepeatLetterCount is not in the current window.*/

    //CharacterReplacement
    public static int findLength1(String str, int k) {
        int windowStart = 0;
        int maxRepeatedCharCount = 0;
        int maxLength = 0;
        Map<Character, Integer> characterIntegerMap = new java.util.HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            // current window size is from windowStart to windowEnd, overall we have a letter which is
            // repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter
            // repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' letters
            characterIntegerMap.put(str.charAt(windowEnd), characterIntegerMap.getOrDefault(str.charAt(windowEnd), 0) + 1);
            maxRepeatedCharCount = Math.max(maxRepeatedCharCount, characterIntegerMap.get(str.charAt(windowEnd)));
            if (windowEnd - windowStart + 1 > maxRepeatedCharCount + k) {
                characterIntegerMap.put(str.charAt(windowStart), characterIntegerMap.getOrDefault(str.charAt(windowStart), 0) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    /*Longest Subarray with Ones after Replacement (hard)*/
    public static int replacingOnes(int[] arr, int k) {
        int count = 0;
        int windowStart = 0;
        int maxLength = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

            // current window size is from windowStart to windowEnd, overall we have a maximum of 1s
            // repeating a maximum of 'maxOnesCount' times, this means that we can have a window with
            // 'maxOnesCount' 1s and the remaining are 0s which should replace with 1s.
            // now, if the remaining 0s are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' Os

            if (arr[windowEnd] == 1) {
                ++count;
            }
            if (windowEnd - windowStart + 1 > count + k) {
                if (arr[windowStart] == 1)
                    --count;
                ++windowStart;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static boolean findPermutation(String str, String pattern) {
        Map<Character, Integer> characterIntegerMap = new java.util.HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            characterIntegerMap.put(pattern.charAt(i), characterIntegerMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        int count = 0;
        int startWindow = 0;


        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            if (characterIntegerMap.containsKey(str.charAt(windowEnd))) {
                characterIntegerMap.put(str.charAt(windowEnd), characterIntegerMap.get(str.charAt(windowEnd)) - 1);
                if (characterIntegerMap.get(str.charAt(windowEnd)) == 0)
                    ++count;
            }
            if (count == characterIntegerMap.size())
                return true;
            else if (windowEnd >= pattern.length() - 1) {
                if (characterIntegerMap.containsKey(str.charAt(startWindow))) {

                    if (characterIntegerMap.get(str.charAt(startWindow)) == 0)
                        --count;
                    characterIntegerMap.put(str.charAt(startWindow), characterIntegerMap.getOrDefault(str.charAt(startWindow), 0) + 1);
                }
                ++startWindow;
            }


        }
        return count == characterIntegerMap.size();
    }


    // String Anagrams
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        // TODO: Write your code here
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            characterIntegerMap.put(pattern.charAt(i), characterIntegerMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        int count = 0;
        int startWindow = 0;
        List<Integer> anagramIndices = new ArrayList<>();


        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            if (characterIntegerMap.containsKey(str.charAt(windowEnd))) {
                characterIntegerMap.put(str.charAt(windowEnd), characterIntegerMap.get(str.charAt(windowEnd)) - 1);
                if (characterIntegerMap.get(str.charAt(windowEnd)) == 0)
                    ++count;
            }
            if (count == characterIntegerMap.size())
                anagramIndices.add(startWindow);

            if (windowEnd >= pattern.length() - 1) {
                if (characterIntegerMap.containsKey(str.charAt(startWindow))) {

                    if (characterIntegerMap.get(str.charAt(startWindow)) == 0)
                        --count;
                    characterIntegerMap.put(str.charAt(startWindow), characterIntegerMap.getOrDefault(str.charAt(startWindow), 0) + 1);
                }
                ++startWindow;
            }


        }
        return anagramIndices;
    }


    // Smallest Window containing Substring (hard) #
    public static String findSubstring(String str, String pattern) {
        // TODO: Write your code here
        Map<Character, Integer> characterIntegerMap = new java.util.HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            characterIntegerMap.put(pattern.charAt(i), characterIntegerMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        int count = 0;
        int startWindow = 0;

        boolean isMatched = false;
        int windowEnd = 0;
        int matchShortEnd = Integer.MAX_VALUE;
        int matchStartEnd = 0;


        for (; windowEnd < str.length(); windowEnd++) {
            if (characterIntegerMap.containsKey(str.charAt(windowEnd))) {
                characterIntegerMap.put(str.charAt(windowEnd), characterIntegerMap.get(str.charAt(windowEnd)) - 1);
                if (characterIntegerMap.get(str.charAt(windowEnd)) == 0)
                    ++count;

                if (count == characterIntegerMap.size()) {
                    isMatched = true;
                    while (startWindow <= windowEnd) {
                        if (characterIntegerMap.containsKey(str.charAt(startWindow))) {

                            if (characterIntegerMap.get(str.charAt(startWindow)) == 0)
                                break;
                            characterIntegerMap.put(str.charAt(startWindow), characterIntegerMap.getOrDefault(str.charAt(startWindow), 0) + 1);
                        }
                        ++startWindow;
                    }
                    if (matchShortEnd - matchStartEnd > windowEnd - startWindow) {
                        matchShortEnd = windowEnd;
                        matchStartEnd = startWindow;
                    }

                }

            }


        }


        return isMatched ? str.substring(matchStartEnd, matchShortEnd + 1) : "";
    }

    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        if (words.length == 0) return resultIndices;
        Map<Integer, String> inexmap = new java.util.HashMap<>();
        int strLen = words[0].length();
        int j = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i = +strLen) {

            if (j < words.length && words[j].equals(str.substring(i, strLen))) {
                j++;
                inexmap.put(i, str.substring(i, strLen));
            }


        }


        return resultIndices;
    }
}




