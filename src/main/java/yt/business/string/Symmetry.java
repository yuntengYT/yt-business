package yt.business.string;


import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 对称
 * @author yunteng
 */
public class Symmetry {

	public static String getStr(String s) {
		List<Character> s_new = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			s_new.add('#');
			s_new.add(s.charAt(i));
		}
		s_new.add('#');
		List<Integer> Len = new ArrayList<>();
		//最长回文子串
		String sub = "";
		//表示在i之前所得到的Len数组中的最大值所在位置
		int sub_midd = 0;
		//表示以sub_midd为中心的最长回文子串的最右端在S_new中的位置
		int sub_side = 0;
		Len.add(1);
		for (int i = 1; i < s_new.size(); i++) {
			//i < sub_side时，在Len[j]和sub_side - i中取最小值，省去了j的判断
			if (i < sub_side) {
				int j = 2 * sub_midd - i;
				if (j >= 2 * sub_midd - sub_side && Len.get(j) <= sub_side - i) {
					Len.add(Len.get(j));
				}else {
					Len.add(sub_side - i + 1);
				}
				//i >= sub_side时，从头开始匹配
			} else {
				Len.add(1);
			}

			while ((i - Len.get(i) >= 0 && i + Len.get(i) < s_new.size()) && (s_new.get(i - Len.get(i)).equals(s_new.get(i + Len.get(i))))){
				//s_new[i]两端开始扩展匹配，直到匹配失败时停止
				Len.set(i, Len.get(i) + 1);
			}
			//匹配的新回文子串长度大于原有的长度
			if (Len.get(i) >= Len.get(sub_midd)) {
				sub_side = Len.get(i) + i - 1;
				sub_midd = i;
			}
		}
		//在s中找到最长回文子串的位置
		sub = s.substring((2 * sub_midd - sub_side) / 2, sub_side / 2);
		return sub;

	}


	public static void main(String[] args) {
		String a = "avbabbbacabbac";
		System.out.println(getStr(a));
	}
}
