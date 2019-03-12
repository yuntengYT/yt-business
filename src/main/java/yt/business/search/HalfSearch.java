package yt.business.search;

public class HalfSearch {

	public static void main(String[] args) {
		int[] a = new int[]{1,4,5,6,7,8,9,23};
		int aaa = biSearch(a,9);
		System.out.println(aaa);

	}

	public static int biSearch (int[] array, int a) {

		int low = 0;
		int high = array.length - 1;
		int mid;
		while (low <= high){
			mid = (low + high) / 2;
			if(a == array[mid]){
				return mid + 1;
			}else if(array[mid] < a){
				low = mid + 1;
			}else {
				high = mid - 1;
			}

		}
		return -1;
	}
}
