public class Sort {

    int N;

    //sorts an array of ints using heapsort
    public void heapSort(int[] to_sort) {
	Heap sort = new Heap(to_sort);

	for(int i=0; i< to_sort.length; i++){
	    to_sort[to_sort.length-i-1] = sort.my_heap[1];
	    sort.deleteMax();
	}

    }

    //sorts an array of ints using selection sort
    public void selectionSort(int[] to_sort) {
 
        for (int i = 0; i < N-1; i++)
        {
            int min = i;
            for (int j = i+1; j < N; j++){
                if (to_sort[j] < to_sort[min])
                    min = j;}
 
            int temp = to_sort[min];
            to_sort[min] = to_sort[i];
            to_sort[i] = temp;
        }
    }

    //sorts an array of ints using quicksort
    public void quickSort(int[] to_sort) {
	qsort(to_sort, 0, N-1);

    }

     public void qsort(int arr[], int lo, int hi)
    {
        if (lo < hi)
        {
            int p = partition(arr, lo, hi);
 
            qsort(arr, lo, p-1);
            qsort(arr, p+1, hi);
        }
    }

    public int partition(int arr[], int lo, int hi)
    {
        int x = arr[hi]; 
        int i = (lo-1);
        for (int j=lo; j<hi; j++)
        {
  
            if (arr[j] <= x)
            {
                i++;
 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        int temp = arr[i+1];
        arr[i+1] = arr[hi];
        arr[hi] = temp;
 
        return i+1;
    }
 


    //sorts an array of ints using mergesort
    public void mergeSort(int[] to_sort) {
	merge_sort(to_sort, 0, N-1);

    }

    public void merge_sort(int arr[], int lo, int hi)
    {
        if (lo < hi)
        {
            int middle = (lo+hi)/2;
 
            merge_sort(arr, lo, middle);
            merge_sort(arr , middle+1, hi);
 
            merge(arr, lo, middle, hi);
        }
    }



    public void merge(int arr[], int lo, int mi, int hi)
    {

        int n1 = mi - lo + 1;
        int n2 = hi - mi;
 
        int Left[] = new int [n1];
        int Right[] = new int [n2];
 
        for (int i=0; i<n1; ++i)
            Left[i] = arr[lo + i];
        for (int j=0; j<n2; ++j)
            Right[j] = arr[mi + 1+ j];
 

        int i = 0;
	int j = 0;

        int k = lo;
        while (i < n1 && j < n2)
        {
            if (Left[i] <= Right[j])
            {
                arr[k] = Left[i];
                i++;
            }
            else
            {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }
 
        while (i < n1)
        {
            arr[k] = Left[i];
            i++;
            k++;
        }
 
        while (j < n2)
        {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }
 

    //sorts an array of ints using insertion sort
    public void insertionSort(int[] to_sort) {
	
	for(int i = 1; i < N; i++) {

	    int val = to_sort[i];
	    int j = i - 1;

	    while(j >= 0 && val < to_sort[j]) {
		to_sort[j + 1] = to_sort[j];
		j--;
	    }

	    to_sort[j+1] = val;

	}

    }




    public void insertionTest() {

	int[] my_array = new int[N];

	long total_time = 0;
	int num_iters = 10;

	//test insertionsort
	//sort multiple times to reduce noise
	for(int j = 0; j < num_iters; j++) { 
	    Generate.randomData(my_array); //fill my_array with unsorted data

	    long start_time = System.nanoTime();
	    insertionSort(my_array);
	    long end_time = System.nanoTime();
	    total_time += end_time - start_time;
	}

	//TO TEST IF SORTING IS CORRECT
	/*for(int i=0; i< my_array.length; i++){
	    System.out.println(my_array[i] + " ");
	    }*/

	// System.out.println(num_items + "\t");
	System.out.println((total_time/1000000000.0)/(num_iters * 1.0) + " ");
    }

    public void selectionTest() {

	int[] my_array = new int[N];

	long total_time = 0;
	int num_iters = 10;

	for(int j = 0; j < num_iters; j++) { 
	    Generate.randomData(my_array); //fill my_array with unsorted data

	    long start_time = System.nanoTime();
	    selectionSort(my_array);
	    long end_time = System.nanoTime();
	    total_time += end_time - start_time;
	}

	System.out.println((total_time/1000000000.0)/(num_iters * 1.0) + " ");
    }

    public void mergeTest() {

	int[] my_array = new int[N];

	long total_time = 0;
	int num_iters = 10;

	for(int j = 0; j < num_iters; j++) { 
	    Generate.randomData(my_array); //fill my_array with unsorted data

	    long start_time = System.nanoTime();
	    mergeSort(my_array);
	    long end_time = System.nanoTime();
	    total_time += end_time - start_time;
	}

	System.out.println((total_time/1000000000.0)/(num_iters * 1.0) + " ");
    }

    public void quickTest() {

	int[] my_array = new int[N];

	long total_time = 0;
	int num_iters = 10;

	for(int j = 0; j < num_iters; j++) { 
	    Generate.randomData(my_array); //fill my_array with unsorted data

	    long start_time = System.nanoTime();
	    quickSort(my_array);
	    long end_time = System.nanoTime();
	    total_time += end_time - start_time;
	}

	System.out.println((total_time/1000000000.0)/(num_iters * 1.0) + " ");
    }

  public void heapTest() {

	int[] my_array = new int[N];

	long total_time = 0;
	int num_iters = 10;

	for(int j = 0; j < num_iters; j++) { 
	    Generate.randomData(my_array); //fill my_array with unsorted data

	    long start_time = System.nanoTime();
	    heapSort(my_array);
	    long end_time = System.nanoTime();
	    total_time += end_time - start_time;
	}

	System.out.println((total_time/1000000000.0)/(num_iters * 1.0) + " ");
    }





    //input: number of elements to sort
    public static void main(String[] args) {

	int num_items = Integer.parseInt(args[0]);

	//number of items is the first input size we want to test
	System.out.println("Insertion Sort: ");
	for(int i= num_items; i <= 100000; i=i+10000){
        
        System.out.print(i + "\t");

	Sort s = new Sort(i);
	s.insertionTest();
	}


	System.out.println("Selection Sort: ");
	for(int i= num_items; i <= 100000; i=i+10000){
        
        System.out.print(i + "\t");

	Sort s = new Sort(i);
	s.selectionTest();
	}



	System.out.println("Merge Sort: ");
	for(int i= num_items; i <= 1000000; i=i+10000){
        
        System.out.print(i + "\t");

	Sort s = new Sort(i);
	s.mergeTest();
	}



	System.out.println("Quick Sort: ");
	for(int i= num_items; i <= 1000000; i=i+10000){
        
        System.out.print(i + "\t");

	Sort s = new Sort(i);
	s.quickTest();
	}



	System.out.println("Heap Sort: ");
	for(int i= num_items; i <= 1000000; i=i+10000){
        
        System.out.print(i + "\t");

	Sort s = new Sort(i);
	s.heapTest();
	}


    }

    public Sort(int num_elts) {
	N = num_elts;
    }

}