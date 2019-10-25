package yt.business.string;


import java.util.HashSet;
import java.util.Set;

public class HuaDongChangKou {

	public static void main(String[] args) {
		Integer[] a = {3,-1,6,6,7,7};
		int n = 3;
		System.out.println(getMaxSum(a,n));

		System.out.println(getMaxStrNum("abcabcbb"));
	}

	private static Integer getMaxSum(Integer[] a,int n){
		if(a.length < n){
			return null;
		}
		Integer maxSum = 0;
		Integer sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}
		maxSum = sum;
		for(int i = n; i < a.length; i++){
			sum += a[i] - a[i-n];
			maxSum = Math.max(maxSum,sum);
		}

		return maxSum;
	}


	private static Integer getMaxStrNum(String s) {
		if(null == s || "".equals(s)) {
			return 0;
		}
		char[] chars = s.toCharArray();

		if(1 == chars.length) {
			return 1;
		}
		int res = 1;
		int a = 0;
		int b = 1;
		Set<Character> strSet = new HashSet(16);
		strSet.add(chars[a]);
		while (a < chars.length && b < chars.length) {
			if(strSet.contains(chars[b])){
				strSet.remove(chars[a]);
				a++;
			}else {
				strSet.add(chars[b]);
				b++;
				res = Math.max(res,b - a);
			}
		}
		return res;
	}
}
