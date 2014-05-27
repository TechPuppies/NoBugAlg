import java.util.ArrayList;

public class Solution {
	public ArrayList<int[]>  PairsOfSubtraction(int[] a, int target){
		/**
		 * Assume all elements in array a are positive integers ranging from 1 to 40
		 */
		ArrayList<int[]> result = new ArrayList<int[]>();
		int[] t = new int[40];
		
		for(int i=0; i<a.length; i++){
			t[a[i]]=i;
		}
		
		for(int i : a){
			int b = t[i+2];
			if(b!= 0){
				result.add(new int[] {i, i+2} );
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a= {5, 7, 8, 10, 12};
		int target = 2;
		Solution s = new Solution();
		ArrayList<int[]> result = new ArrayList<int[]>();
		result = s.PairsOfSubtraction(a,target);
		for(int[] i: result)
		System.out.format("{%d,%d} ", i[0],i[1]);
	}
}
