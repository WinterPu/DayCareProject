
public class SelectionSort {

	public static void sort(int[] a) {
		if(a.length < 1) return;

		for(int i = 0; i < a.length; i++) {
			for(int j = i+1; j < a.length; j++) {
				if(a[i] > a[j]) swap(a, i ,j);
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}


	public static void main(String[] args) {
		int[] a = new int[]{11, 15, 4, 8, 1, 19, 60, 4, 2, 1};
		for(int i : a) System.out.print(i + " ");
		System.out.println();
		SelectionSort.sort(a);
		for(int j : a) System.out.print(j + " ");
		System.out.println();
	}
}