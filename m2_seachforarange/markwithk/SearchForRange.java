public class SearchForRange{

    public int[] solve(int[] a, int target) {
	int[] result = new int[2];
	result[0] = getLeft(a, target, 0, a.length-1);
	result[1] = getRight(a,target, result[0], a.length-1);
	return result;
    }

    int getLeft(int[] a, int target, int start, int end) {
	if(start == end){
	    if(a[start] == target)
	    {
		return start;
	    }
	    else
	    {
		return -1;
	    }
	}

	int mid= start + (end-start)/2;

	if(a[mid]< target){
	    return getLeft(a, target, mid+1, end);
	}
	else if (a[mid]>target){
	    return getLeft(a, target, start, mid);
	}
	else if(mid>start && a[mid-1] == target) {
	    return getLeft(a, target, start, mid-1);
	}
	else{
	    return mid;
	}
    }

    int getRight(int[] a, int target, int start, int end) {
	if(start == end){
	    if(a[start] == target)
	    {
		return start;
	    }
	    else
	    {
		return -1;
	    }
	}

	int mid= start + (end-start)/2;

	if(a[mid]< target){
	    return getRight(a, target, mid+1, end);
	}
	else if (a[mid]>target){
	    return getLeft(a, target, start, mid);
	}
	else if(mid<end && a[mid+1] == target) {
	    return getRight(a, target, mid+1, end);
	}
	else{
	    return mid;
	}
    }

    public static void main (String[] args) {
	int[] a= {5,7,7,8,8,10};
	int target = 8;
	SearchForRange s= new SearchForRange();
	int[] result = s.solve(a,target);
	System.out.println(result[0]+" "+result[1]);
    }
}

