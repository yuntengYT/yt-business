package yt.business.singleton;


/**
 * @author yunteng
 */
public class SingletonReflex {

	public static boolean flag = false;

	private SingletonReflex(){
		synchronized(SingletonReflex.class) {
			if(!flag){
				flag = !flag;
			}else {
				throw new RuntimeException("反射攻击");
			}
		}
	}

	private static class SingletonHolder{
		public static final SingletonReflex INTANCE = new SingletonReflex();
	}

	public static SingletonReflex getInstance(){
		return SingletonHolder.INTANCE;
	}
}
