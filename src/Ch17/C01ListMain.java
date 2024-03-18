package Ch17;

import java.util.ArrayList;
import java.util.List;

public class C01ListMain {
	
	public static void main(String[] args) {
		
		
		List<String> list = new ArrayList();
		//추가
		list.add("HTML/CSS/JS");	//0
		list.add("JQUERY");	//1
		list.add("NODEJS");	//2
		list.add("SCSS");	//3
		list.add("REACT");
		list.add("JAVA");
		list.add("JSP/SERVLET");
		list.add("STS");
		list.add("SPRING BOOT");
		list.add("SPRING BOOT");
		//조회
		System.out.println("개수 확인 : " + list.size());
		System.out.println("idx로 조회 : " + list.get(2));
		System.out.println("Value로 idx확인 : " + list.indexOf("JAVA"));
		//삭제
		list.remove(0);
		list.remove("JQUERY");
		for(String el : list)
			System.out.println(el);
		
		//전체삭제
		list.clear();
	}
	
}
