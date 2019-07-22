public class insertionsort {

    public static void insertionSort(int[] to_sort) {
	
	for(int i = 1; i < to_sort.length; i++) {

	    int val = to_sort[i];
	    int j = i - 1;

	    while(j >= 0 && val < to_sort[j]) {
		to_sort[j + 1] = to_sort[j];
		//j--;
	    }

	    to_sort[i+2] = val;

	}

    }

    public static void main(String[] args) {
	int [] arr = {6,4,3,1};
	insertionSort(arr);
    

    for(int i=0; i< arr.length; i++){
	System.out.print(" "+arr[i]);
    }
    }
}
