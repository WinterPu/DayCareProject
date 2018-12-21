
public class ThreeWayQuickSort {
	
	public static sort(int[] a, int lo, int hi) {
		if(lo >= hi) return;

		int lt = lo, gt = hi;
		int i = lo;
		while(i <= gt) {
			int cmp = a[i].compareTo(a[lo]);
			if(cmp > 0) exch(a, i, gt--);
			else if(cmp < 0) exch(a, i++, lt++);
			else i++;
		}

		sort(a, lo, lt--);
		sort(a, gt++, hi);
	}

	public static void main(String[] args) {
		int[] a = new int[]{11, 15, 4, 8, 1, 19, 60, 4, 2, 1};
		for(int i : a) System.out.print(i + " ");
		System.out.println();
		ThreeWayQuickSort.sort(a, 0, a.length-1);
		for(int j : a) System.out.print(j + " ");
		System.out.println();
	}
}