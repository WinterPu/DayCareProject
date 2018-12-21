
public class InsertionSort {

	public static void sort(int[] a) {
		if(a.length == 0) return;

		for(int i = 1; i < a.length; i++) {
			int temp = i;
			for(int j = i-1; j >= 0; j--) {
				if(a[j] < a[temp]) break;
				else {
					swap(j, temp, a);
					temp--;
				}
			}
		}
	}

	private static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = new int[]{11, 15, 4, 8, 1, 19, 60, 4, 2, 1};
		for(int i : a) System.out.print(i + " ");
		System.out.println();
		InsertionSort.sort(a);
		for(int j : a) System.out.print(j + " ");
		System.out.println();

	}
}