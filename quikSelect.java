// average case O(n)


public static int partition(int[] A, int start , int end  ){
    	
    	// Move pivot to end
    	int pivotValue = A[end];
  
    	int i = start;
    	for( int j = start; j< end ; j++) {
    		if (A[j] < pivotValue){
    			
    			int temp = A[i];
    			A[i] = A[j];
    			A[j] = temp;
    			i++;
    		}
    	}
    	A[end] = A[i]; 
    	A[i]  = pivotValue;
    	 // Move pivot to its final place
    	return i;
	}
    
public static int quickselect(int[] A, int left, int right, int k){
    	if (left == right || k<= 0)        // If the list contains only one element
    		  return A[left];  // Return that element
    	//int pivotIndex  = (left+right)/2;     // select a pivotIndex between left and right
    	int pivotIndex  = partition(A, left, right);
    	int pivotDist  = pivotIndex - left + 1;
    	
	    // The pivot is in its final sorted position,
	    // so pivotDist reflects its 1-based position if list were sorted
    	if (pivotDist == k)
    		return A[pivotIndex];
    	else if (k < pivotDist)
    		return quickselect(A, left, pivotIndex - 1, k);
    	else
    		return quickselect(A, pivotIndex + 1, right, k - pivotDist);
}
    
public static int quickselectIter(int[] A, int left, int right ,int k){
    	if (k>right+1 || k<= 0)        // If the list contains only one element
    		return A[left];
    	
    	while(right>left){
    		  int pivotIndex  = partition(A, left, right);
        	int pivotDist  = pivotIndex - left + 1;
        	if (pivotDist == k) return A[pivotIndex];
        	else if (k<pivotDist) right = pivotIndex -1;
        	else{
        		k -= pivotDist;
        		left = pivotIndex +1;
        	}
    	}
    	return A[left];
}
