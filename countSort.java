import java.util.Random;
/**
 * @author Steven Taylor
 * @version 9/11/2020
 * @class CSCI 333
 * @assignment HW4 RAMSortSelect
 * @description countSort class implements the countSort method: for each input element a, the number of elements less than a. This data is used to place element a
 * directly into its position in the output array. The countSort class also implements the randomSelect method which makes use of the random methods utilized in hw3. 
 * This method is different from randomQuickSort in that it only utilizes one side of the partition instead of both sides. All methods implemented verbatim from the 
 * textbook and slides. Ref page 216: randSelect, page: 195. 
 * 
 */
public class countSort {
	Random rand = new Random();
	public countSort(int[] a, int[]b, int k){
	int [] c;
	c = new int[k+1];
	System.out.println("c size= "+ c.length);
	for(int i=0; i<=k;i++) {
		c[i]=0;
	}
	for(int i=0; i<a.length;i++) {
		c[a[i]] = c[a[i]]+1;
	}
	for(int i=1; i<=k;i++) {
		c[i]=c[i]+c[i-1];
	}
	for(int i=a.length -1; i>=0;i--) {
		b[c[a[i]]-1] =a[i];
		c[a[i]]=c[a[i]]-1;
	}
	
	}
	//begin part2
	
	private int partition(int[] array, int start, int end) {
		int x = array[end];
		int i = start - 1;
		for( int j= start; j<=end-1; j++) {
			if(array[j] <= x) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i+1];
		array[i+1] = array[end];
		array[end] = temp;
		return i+1;
	}
	
	private int randomPartition(int[] array, int start, int end) {
		int i = rand.nextInt((end - start) +1) + start;
		int temp = array[end];
		array[end] = array[i];
		array[i] = temp;
		return partition(array, start, end);
	}

	private int[] randomSelectIni(int[] a, int i, int j, int k) {
		int[] b = java.util.Arrays.copyOf(a, a.length);
		randomSelect(b, i, j, k);
		return b;
	}
	public int randomSelect(int [] array, int p, int r, int i) {
		if (p == r) {
			return array[p];
		}
		int q = randomPartition(array, p, r);
		int k = q-p+1;
		if(i==k) {
			return array[q];
		}
		if(i<k){
			return randomSelect(array, p, q-1, i);
		}
		else {
			return randomSelect(array,q+1,r,i-k);
		}
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int d[]= {2,5,3,0,2,3,0,3};
		int e[] = new int[d.length];
		System.out.println("Pre sort: "+java.util.Arrays.toString(d));
		countSort cs = new countSort(d,e,5);
		System.out.println("Aft sort: "+java.util.Arrays.toString(e));
		int f[]= {414,233,322,11,143,312,200,403};
		int g[] = new int[f.length];
		System.out.println("Pre sort: "+java.util.Arrays.toString(f));
		
		countSort cs1 = new countSort(f,g,414);
		System.out.println("Aft sort: "+java.util.Arrays.toString(g));
		int h[]= {5,4,3,2,1,0};
		int i[] = new int[h.length];
		System.out.println("Pre sort: "+java.util.Arrays.toString(h));
		countSort cs2 = new countSort(h,i,5);
		System.out.println("Aft sort: "+java.util.Arrays.toString(i));
		int j[]= {0,0,88,5};
		int k[] = new int[j.length];
		System.out.println("Pre sort: "+java.util.Arrays.toString(j));
		countSort cs3 = new countSort(j,k,88);
		System.out.println("Aft sort: "+java.util.Arrays.toString(k));
		int l[]= {99,55,1,7,2,3,9,3,14};
		int m[] = new int[l.length];
		System.out.println("Pre sort: "+java.util.Arrays.toString(l));
		countSort cs4 = new countSort(l,m,99);
		System.out.println("Aft sort: "+java.util.Arrays.toString(m));
		System.out.println();
		
		System.out.println("Begin Part Two testing Randomized Selection");
		System.out.println();
		
		
		int a[] = {3,2,9,0,7,5,4,8,6,1};
		System.out.println("Pre sort: "+java.util.Arrays.toString(a));
		int b[] = cs.randomSelectIni(a, 0, a.length-1, (a.length+1) /2);
		System.out.println("Aft sort: "+java.util.Arrays.toString(b));
		Random rand = new Random();
		int n[] = new int [64];
		for(int z = 0; z < n.length; z++) {
			n[z] = rand.nextInt(100);
		}
		System.out.println("Pre sort: "+java.util.Arrays.toString(n));
		int o[] = cs.randomSelectIni(n, 0, n.length-1, (n.length+1) /2);
		System.out.println("Aft sort: "+java.util.Arrays.toString(o));
		int p[] = new int [32];
		for(int z = 0; z < p.length; z++) {
			p[z] = rand.nextInt(75);
		}
		System.out.println("Pre sort: "+java.util.Arrays.toString(p));
		int q[] = cs.randomSelectIni(p, 0, p.length-1, (p.length+1) /2);
		System.out.println("Aft sort: "+java.util.Arrays.toString(q));
		int r[] = new int[16];
		for(int z = 0; z < r.length; z++) {
			r[z] = rand.nextInt(50);
		}
		System.out.println("Pre sort: "+java.util.Arrays.toString(r));
		int s[] = cs.randomSelectIni(r, 0, r.length-1, (r.length+1) /2);
		System.out.println("Aft sort: "+java.util.Arrays.toString(s));
		int t[] = new int [8];
		for(int z = 0; z < t.length; z++) {
			t[z] = rand.nextInt(25);
		}
		System.out.println("Pre sort: "+java.util.Arrays.toString(t));
		int u[] = cs.randomSelectIni(t, 0, t.length-1, (t.length+1) /2);
		System.out.println("Aft sort: "+java.util.Arrays.toString(u));
		
	}


}
