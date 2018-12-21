
public class QuickSelect {

	public static int partition(int[] a, int lo, int hi) {

		int i = lo, j = hi+1;
		while(true) {
			while(a[lo] > a[++i])
				if(i == hi) break;
			while(a[lo] < a[--j])
				if(j == lo) break;

			if(i >= j) break; // Remeber me
			swap(i, j, a); // Remeber me
		}
		swap(lo, j, a);
		return j;
	}

	private static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static int select(int[] a, int target, int lo, int hi) {

		while(hi > lo) {
			int k = partition(a, lo, hi);
			if(target > k) lo = k+1;
			else if(target < k) hi = k-1;
			else return a[target];
		}
		return a[target];
	}

	public static void main(String[] args) {
		int[] a = new int[]{11, 15, 4, 8, 1, 19, 60, 4, 2, 1};
		for(int i : a) System.out.print(i + " ");
		System.out.println();
		int t = QuickSelect.select(a, 10, 0, a.length-1);
		System.out.println(t);
	}
}