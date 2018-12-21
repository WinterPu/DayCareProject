
public class MergeSort {

	public static void merge(int[] a, int[] aux, int lo, int hi, int mid) {
		// Copy to aux
		for(int k = lo; k <= hi; k++) aux[k] = a[k];

		int i = lo;
		int j = mid + 1;
		for(int l = lo; l <= hi; l++) {
			if(i > mid) a[l] = aux[j++];
			else if(j > hi) a[l] = aux[i++];
			else if(aux[i] > aux[j]) a[l] = aux[j++];
			else a[l] = aux[i++];
		}
	}

	public static void sort(int[] a, int[] aux, int lo, int hi) {
		if(lo >= hi) return;

		int mid = lo + (hi - lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, hi, mid);
	}

	public static void buttonUppSort(int[] a) {
		int[] aux = new int[a.length];

		for(int sz = 1; sz < a.length; sz=sz+sz) {
			for(int lo = 0; lo < a.length-sz; lo+=sz+sz) {
				merge(a, aux, lo, Math.min(lo+sz+sz-1, a.length-1), lo+sz-1);
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[]{11, 15, 4, 8, 1, 19, 60, 4, 2, 1};
		int[] aux = new int[a.length];
		for(int i : a) System.out.print(i + " ");
		System.out.println();
		// MergeSort.sort(a, aux, 0, a.length-1);
		MergeSort.buttonUppSort(a);
		for(int j : a) System.out.print(j + " ");
		System.out.println();
	}
}