
public double medianOfTwo(int[] A, int[] B) {

	int m = A.length;
	int n = B.length;
	
	int odds = fms(A, m, B, n, (m+n)/2+1, 0, 0);
	if ((m+n)%2 == 1) return odds;
	int even = fms(A, m, B, n, (m+2)/2, 0, 0);
	
	return (odds + even)/2.0;
}

// find median of two sorted arrays in O(lg(m+n)), m = real length of A astart = start index of A
//                                                  n = real length of B bstart = start index of B
// algorithm:
// put the shorter array infront as A
// first divide A into two half, break k into two part,
// look at the first part pa in front of A array and the second part pb in front of B
// if the elem in A at the end of pa is smaller than the elem in B at the end of B,
//          means that we can never find the kth in the first part of A, skip the part and search the 
//          rest in the second part of A and full B.
// if the other way around,
//          search k - pb in the full A and the second half of B.
public double fms(int A[], int m, int B[], int n, int k,int astart, int bstart){
         
        if (m>n) {return fms(B,n,A,m,k,bstart, astart);}
         
        if (m==0) { return B[bstart+k-1];}
        if (k==1) { return Math.min(A[astart],B[bstart]);}
        int pa = Math.min(k/2,m);
        int pb = k-pa;
        if (A[astart+pa-1]<=B[bstart+pb-1]) {return fms(A,m-pa,B,n,k-pa,astart+pa,bstart);}
        return fms(A,m,B,n-pb,k-pb,astart,bstart+pb);
    }
