import java.util.HashSet;

import java.lang.Math;

public class LeetCode {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> resultSet = new HashSet<Character>();
        HashSet<Character> tempSet = new HashSet<Character>();
        int i;
        for(i = 0; i < s.length(); i++) {
            if(!resultSet.contains(s.charAt(i))) {
                resultSet.add(s.charAt(i));
            } else {
                break;
            }
        }
        for(int j = i; j < s.length(); j++) {
            if(!tempSet.contains(s.charAt(j))) {
                tempSet.add(s.charAt(j));
            } else {
                if(tempSet.size() >= resultSet.size()) {
                    resultSet = tempSet;
                    tempSet = new HashSet<Character>();
                    tempSet.add(s.charAt(j));
                }
            }
        }
        if(tempSet.size() > resultSet.size()) {
            return tempSet.size();
        } else {
            return resultSet.size();
        }
    }

    public static String longestSubstring(String s) {
        int ans = 0, maxPalindrome = 0;
        int oddLength = 0, evenLength = 0;
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            oddLength = expandPalindrome(s, i, i);
            evenLength = expandPalindrome(s, i, i+1);
            maxPalindrome = Math.max(oddLength, evenLength);
            ans = Math.max(ans, maxPalindrome);
            if(maxPalindrome > i) {
                if(ans%2 == 0) {
                    start = i - (ans/2) + 1;
                    end = i + (ans/2);
                } else {
                    start = i - (ans/2);
                    end = i + (ans/2);
                }
                System.out.println("i: " + i);
            }
        }
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        System.out.println("ans: " + ans);
        return s.substring(start, end);
    }

    private static int expandPalindrome(String s, int leftIndex, int rightIndex) {
        while((leftIndex >= 0) && (rightIndex < s.length()) && (s.charAt(leftIndex) == s.charAt(rightIndex))) {
            leftIndex--;
            rightIndex++;
        }
        return (rightIndex - leftIndex - 1);
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("cbbd"));
    }
}