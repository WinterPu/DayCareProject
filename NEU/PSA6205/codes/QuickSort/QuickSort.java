
public class QuickSort {

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

	public static void sort(int[] a, int lo, int hi) {
		if(a.length < 1) return;

		// Remeber me
		if(lo >= hi) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}

	public static void main(String[] args) {
		int[] a = new int[]{11, 15, 4, 8, 1, 19, 60, 4, 2, 1};
		for(int i : a) System.out.print(i + " ");
		System.out.println();
		QuickSort.sort(a, 0, a.length-1);
		for(int j : a) System.out.print(j + " ");
		System.out.println();
	}
}