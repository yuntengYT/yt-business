package yt.business.sort;

import java.util.Arrays;

public class FastSort {

	public static void main(String[] args) {
		int a[] = {3, 1, 4, 5, 6,3,2,1,5,7,34,8};
		sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	private static void sort(int a[], int low, int high) {

		if(low >= high) {
			return;
		}
		int i = low;
		int j = high;
		int k = a[i];

		while (i < j) {
			while (a[j] >= k && i < j) {
				j--;
			}

			while (a[i] <= k && i < j) {
				i++;
			}

			if(i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}

		a[low] = a[i];
		a[i] = k;
		sort(a, low, i - 1);
		sort(a, i + 1, high);
	}
}
