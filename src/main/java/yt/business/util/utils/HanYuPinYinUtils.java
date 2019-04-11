package yt.business.util.utils;

import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author yunteng
 */
@Slf4j
public class HanYuPinYinUtils {

	/**
	 * 将文字转为汉语拼音
	 *
	 * @param chineseLanguage
	 * @return
	 */
	public String toHanyuPinyin(String chineseLanguage) {
		char[] cl_chars = chineseLanguage.trim().toCharArray();
		StringBuilder hanyupinyin = new StringBuilder();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		// 输出拼音全部小写
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		// 不带声调
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
		try {
			for (int i = 0; i < cl_chars.length; i++) {
				if (String.valueOf(cl_chars[i]).matches("[\u4e00-\u9fa5]+")) {
					// 如果字符是中文,则将中文转为汉语拼音
					hanyupinyin.append(PinyinHelper.toHanyuPinyinStringArray(cl_chars[i], defaultFormat)[0]);
				} else {// 如果字符不是中文,则不转换
					hanyupinyin.append(cl_chars[i]);
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			log.error("字符不能转成汉语拼音,chineseLanguage:{}", chineseLanguage, e);
		}
		return hanyupinyin.toString();
	}

	public static String getFirstLettersUp(String chineseLanguage) {
		return getFirstLetters(chineseLanguage, HanyuPinyinCaseType.UPPERCASE);
	}

	public static String getFirstLettersLo(String chineseLanguage) {
		return getFirstLetters(chineseLanguage, HanyuPinyinCaseType.LOWERCASE);
	}

	public static String getFirstLetters(String chineseLanguage, HanyuPinyinCaseType caseType) {
		char[] cl_chars = chineseLanguage.trim().toCharArray();
		StringBuilder hanyupinyin = new StringBuilder();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		// 输出拼音全部大写
		defaultFormat.setCaseType(caseType);
		// 不带声调
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		try {
			for (int i = 0; i < cl_chars.length; i++) {
				String str = String.valueOf(cl_chars[i]);
				if (str.matches("[\u4e00-\u9fa5]+")) {
					// 如果字符是中文,则将中文转为汉语拼音,并取第一个字母
					hanyupinyin.append(PinyinHelper.toHanyuPinyinStringArray(cl_chars[i], defaultFormat)[0].substring(0, 1));
				} else if (str.matches("[0-9]+")) {
					// 如果字符是数字,取数字
					hanyupinyin.append(cl_chars[i]);
				} else if (str.matches("[a-zA-Z]+")) {
					// 如果字符是字母,取字母
					hanyupinyin.append(cl_chars[i]);
				} else {// 否则不转换
					hanyupinyin.append(cl_chars[i]);
					//如果是标点符号的话，带着
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			log.error("字符不能转成汉语拼音,chineseLanguage:{}",chineseLanguage,e);
		}
		return hanyupinyin.toString();
	}

	public static String getPinyinString(String chineseLanguage) {
		char[] cl_chars = chineseLanguage.trim().toCharArray();
		StringBuilder hanyupinyin = new StringBuilder();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		// 输出拼音全部大写
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		// 不带声调
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		try {
			for (int i = 0; i < cl_chars.length; i++) {
				String str = String.valueOf(cl_chars[i]);
				// 如果字符是中文,则将中文转为汉语拼音,并取第一个字母
				if (str.matches("[\u4e00-\u9fa5]+")) {
					hanyupinyin.append(PinyinHelper.toHanyuPinyinStringArray(
							cl_chars[i], defaultFormat)[0]);
					// 如果字符是数字,取数字
				} else if (str.matches("[0-9]+")) {
					hanyupinyin.append(cl_chars[i]);
					// 如果字符是字母,取字母
				} else if (str.matches("[a-zA-Z]+")) {

					hanyupinyin.append(cl_chars[i]);
				} else {// 否则不转换
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			log.error("字符不能转成汉语拼音,chineseLanguage:{}",chineseLanguage,e);
		}
		return hanyupinyin.toString();
	}

	/**
	 * 取第一个汉字的第一个字符
	 *
	 * @return String
	 * @throws
	 * @Title: getFirstLetter
	 * @Description: TODO
	 */
	public static String getFirstLetter(String chineseLanguage) {
		char[] cl_chars = chineseLanguage.trim().toCharArray();
		String hanyupinyin = "";
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		// 输出拼音全部大写
		defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		// 不带声调
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		try {
			String str = String.valueOf(cl_chars[0]);
			// 如果字符是中文,则将中文转为汉语拼音,并取第一个字母
			if (str.matches("[\u4e00-\u9fa5]+")) {
				hanyupinyin = PinyinHelper.toHanyuPinyinStringArray(
						cl_chars[0], defaultFormat)[0].substring(0, 1);
				// 如果字符是数字,取数字
			} else if (str.matches("[0-9]+")) {
				hanyupinyin += cl_chars[0];
				// 如果字符是字母,取字母
			} else if (str.matches("[a-zA-Z]+")) {

				hanyupinyin += cl_chars[0];
			} else {// 否则不转换

			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			log.error("字符不能转成汉语拼音,chineseLanguage:{}",chineseLanguage,e);
		}
		return hanyupinyin;
	}

	public static void main(String[] args) {
		HanYuPinYinUtils hanyuPinyinHelper = new HanYuPinYinUtils();
		System.out.println(hanyuPinyinHelper.toHanyuPinyin("zhang云teng"));
	}
}
