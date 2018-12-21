
import java.util.Random;

public class ShuffleSort {

	public static void sort(int[] a) {
		if(a.length < 1) return;

		for(int i = 0; i < a.length; i++) {
			Random r = new Random();
			int j = r.nextInt(i+1);
			swap(i, j, a); 
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
		ShuffleSort.sort(a);
		for(int j : a) System.out.print(j + " ");
		System.out.println();
	}
}