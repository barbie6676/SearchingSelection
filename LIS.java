// return the len of the longest increase subsequence in the given array.

// resource: http://en.wikipedia.org/wiki/Longest_increasing_subsequence#Efficient_algorithms 
// the algorithm will return the length, but you can print out the value from P

public static int longestIncreSubseq(int[] X) {
		int n = X.length;
		
		if (n<=1) return n;
		
		
		//M[j] stores the index k of the smallest value X[k] such that there is an increasing subsequence of length j ending at X[k]
		//for example, X = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
		// j = 1, M[1] = 0; j = 2, M[2] = 1 (0,8); j = 3, M[3] = 3 (X[2] = 12, 0,8,12, or 0,4,12)
		// j = 4, an increasing subsequence of len 4 can end at X[7] (0,8,10,14), or at X[9](0,4,6,9) the smaller k is 7, M[4] = 7
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
				 if (X[M[m]]<X[i]) {
					 l = m+1;
				 } else {
					 r = m-1;
				 }
			 }
			 int j = r;
			 
			 P[i] = M[j];
			 			 
		   if (j == L || X[i] < X[M[j+1]]){
		       M[j+1] = i;
		       L = Math.max(L, j+1);
		    }
		 }
		 
		 //Methods.printArray(X);
		 //Methods.printArray(M);
		 //Methods.printArray(P);
		 int j = M[L];
		 while (j!=-1) {
			 System.out.print(X[j]+" ");
			 j = P[j];
		 }		       
		       
		return L;
	}
