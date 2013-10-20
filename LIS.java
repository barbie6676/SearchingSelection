// return the len of the longest increase subsequence in the given array.

// resource: http://en.wikipedia.org/wiki/Longest_increasing_subsequence#Efficient_algorithms 
// the algorithm will return the length, but you can print out the value from P

public static int longestIncreSubseq(int[] A) {
		int n = A.length;
		
		if (n<=1) return n;
		
		
		//M[j] store the position k that smallest of value X[k] that length of j lis can end at X[k]
		//for example, a sequence of length 4 lis can end at X[5] = 3, or at X[9] = 4, M[4] = 9
		//P[k] stores the position of the predecessor of X[k] in the lis ending at X[k]
		// for example 0 4 5 is a lis, P[2] = 1, because X[2] = 5, the predecessor is 4, position is 1
		
		//X[M[1]], X[M[2]], ..., X[M[L]] is nondecreasing.
		int[] M = new int[n];
		int[] P = new int[n];
		M[0] = -1;
		
		int L = 0;
		 for (int i = 0 ; i< n;i++){
			 // binary search for the largest positive j <= L
			   //   such that X[M[j]] < X[i] (or set j = 0 if no such value exists)
			 int l = 1;
			 int r = L;
			 while (l<=r) {
				 int m = (l+r)/2;
				 if (A[M[m]]<A[i]) {
					 l = m+1;
				 } else {
					 r = m-1;
				 }
			 }
			 int j = r;
			 
			 P[i] = M[j];
			 			 
		   if (j == L || A[i] < A[M[j+1]]){
		       M[j+1] = i;
		       L = Math.max(L, j+1);
		    }
		 }
		 
		 //Methods.printArray(A);
		 //Methods.printArray(M);
		 //Methods.printArray(P);
		 int j = M[L];
		 while (j!=-1) {
			 System.out.print(A[j]+" ");
			 j = P[j];
		 }		       
		       
		return L;
	}
