package yt.business.spring;

import javax.annotation.Nullable;

public class TestNullable {


	public TestNullable(){
		System.out.println("111");
	}

	public TestNullable(@Nullable String str){
		System.out.println("222");
	}
}
