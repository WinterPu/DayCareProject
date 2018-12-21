
public class ShellSort {

	public static void sort(int[] a, int[] h) {
		for(int i : h) {
			for(int j = i; j < a.length; j++) {
				for(int k = j-i; k >= 0; k-=i) {
					if(a[j] < a[k]) swap(j, k, a);
					else break;
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
		int[] h = new int[]{7, 3, 1};
		for(int i : a) System.out.print(i + " ");
		System.out.println();
		ShellSort.sort(a, h);
		for(int j : a) System.out.print(j + " ");
		System.out.println();
	}
}