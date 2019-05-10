package yt.business.singleton;

public class SingleTons {
	private static SingleTons singleTon = new SingleTons();
	public static int count1;
	public static int count2 = 3;


	private SingleTons() {
		System.out.println("count1=111");
		count1++;
		count2++;
	}

	public static SingleTons getInstance() {
		return singleTon;
	}

}
