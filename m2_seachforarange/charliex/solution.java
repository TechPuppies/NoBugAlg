package TechPuppies;

import java.util.Arrays;

/**
 * Created by Xin on 5/25/2014.
 */
public class SearchForARange {
    public int[] binarySearch(int[] A, int target, int start, int end) {
        if (start >= end && A[start] != target) {
            int[] res = {-1, -1, -1};
            return res;
        }
        int mid = start + (end - start) / 2;
        if (A[mid] == target) {
            int[] res = {start, mid, end};
            return res;
        } else if (A[mid] > target) return binarySearch(A, target, start, mid - 1);
        else return binarySearch(A, target, mid + 1, end);
    }

    public int leftSearch(int[] A, int target, int start, int end) {
        if (start == end) return start; //base case
        int mid = start + (end - start) / 2;
        if (A[mid] == target) return leftSearch(A, target, start, mid);
        else return leftSearch(A, target, mid + 1, end);
    }

    public int rightSearch(int[] A, int target, int start, int end) {
        if (start == end) return start; //base case
        int mid = start + (end - start + 1) / 2;
        if (A[mid] == target) return rightSearch(A, target, mid, end);
        else return rightSearch(A, target, start, mid - 1);
    }

    public int[] searchRange(int[] A, int target) {
        int[] cannotFind = {-1, -1};
        if (A.length == 0) return cannotFind; // edge case
        int[] binaryResult = binarySearch(A, target, 0, A.length - 1);
        if (binaryResult[1] == -1) return cannotFind; // edge case
        int left = leftSearch(A, target, binaryResult[0], binaryResult[1]);
        int right = rightSearch(A, target, binaryResult[1], binaryResult[2]);
        int[] res = {left, right};
        return res;
    }

    public static void main(String[] args) {
        SearchForARange s = new SearchForARange();
        int[] E = {2, 2};
        System.out.println(Arrays.toString(s.searchRange(E, 1)));
        int[] A = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(s.searchRange(A, 8)));
        int[] B = {1, 2, 3};
        System.out.println(Arrays.toString(s.searchRange(B, 2)));
        int[] C = {1, 2, 3, 3, 3, 3, 4, 5, 9};
        System.out.println(Arrays.toString(s.searchRange(C, 3)));
        int[] D = {1, 2, 2};
        System.out.println(Arrays.toString(s.searchRange(D, 2)));
    }
}
