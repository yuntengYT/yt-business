package yt.business.tree;

import java.util.HashMap;
import java.util.Map;

public class Digui {


	public static void main(String[] args) {

		Map<Integer , Integer> map  = new HashMap<>(16);
		System.out.println(diguiFast(6,map));
		System.out.println(diguiSlow(6));
		System.out.println(notDigui(6));
	}

	public static int diguiFast(int n,Map<Integer,Integer> map) {
		if(n == 1 || n == 2){
			return n;
		}
		if(map.get(n) == null) {
			map.put(n,(diguiFast(n - 1,map) + diguiFast (n - 2,map)));
		}

		return (diguiFast(n - 1,map) + diguiFast (n - 2,map)) ;
	}

	public static int diguiSlow(int n) {
		if(n == 1 || n == 2){
			return n;
		}

		return (diguiSlow(n - 1) + diguiSlow (n - 2)) ;
	}


	public static int notDigui(int n) {
		if(n == 1 || n == 2){
			return n;
		}
		int a = 1;
		int b = 2;
		for(int i = 3; i <= n; i++){
			int tem = b;
			b = b + a;
			a = tem;
		}
		return b;
	}
}
