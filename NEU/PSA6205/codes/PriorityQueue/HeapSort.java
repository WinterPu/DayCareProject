
public class HeapSort {

	public static void sort(int[] a) {
		int N = a.length-1;
		for(int k = N/2; k >= 1; k--)
			sink(a, k, N);
		while(N > 1) {
			exch(a, 1, N);
			sink(a, 1, --N);
		}
	}

	private static void sink(int[] a, int k, int N) {
		while(2*k <= N) {
			int j = 2*k;
			if(j < N && (a[j] < a[j+1])) j++;
			if(a[k] > a[j]) break;
			exch(a, k, j);
			k = j;
		}

	}

	private static void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = new int[]{0, 11, 15, 4, 8, 1, 19, 60, 4, 2, 1};
		for(int i : a) System.out.print(i + " ");
		System.out.println();
		HeapSort.sort(a);
		for(int j : a) System.out.print(j + " ");
		System.out.println();
	}
}