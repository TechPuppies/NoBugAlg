package TechPuppies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Xin on 5/25/2014.
 */
public class Solution {
    public static ArrayList<int[]> pairs(int[] A, int target) {
        // this is O(nlogn) without extra space
        Arrays.sort(A); // sort A
        System.out.println(Arrays.toString(A));
        int ptr1 = A.length - 1;
        int ptr2 = A.length - 2;
        ArrayList<int[]> a = new ArrayList<int[]>();
        while (ptr1 >= 0 && ptr2 >= 0) {
            int st = A[ptr1] - A[ptr2];
            if (st == target) {
                a.add(new int[]{A[ptr1], A[ptr2]});
                ptr1--;
                ptr2--;
            } else if (st > target) {
                ptr1--;
            } else {
                ptr2--;
            }
        }
        return a;
    }

    public static ArrayList<int[]> pairs2(int[] A, int target) {
        // this is O(n) with O(n) extra space
        ArrayList<int[]> a = new ArrayList<int[]>();
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < A.length; i++) {
            int st = A[i] - target;
            if (hashMap.containsKey(st)) {
                hashMap.get(st).add(i);
            } else {
                hashMap.put(st, new ArrayList<Integer>());
                hashMap.get(st).add(i);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (hashMap.containsKey(A[i])) {
                for (int j : hashMap.get(A[i])) {
                    if (i != j) a.add(new int[]{A[i], A[j]});
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int[] i : pairs2(A, 2)) System.out.println(Arrays.toString(i));
    }
}
