package Ch17Ex;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class C02Ex {

	public static void main(String[] args) throws InterruptedException {
		
		//1 ~ 45 까지숫자를 6개를 랜덤으로 받아(Random클래스를이용) set에 저장
		//[추가]저장된 set의 오름차순정렬을 해보세요(검색을통해서 해결해봅니다)
		
		Set<Integer> set = new HashSet();
		Random rnd = new Random();
		
//		while(true) {
//			System.out.println(rnd.nextInt(44) +1); 		
//			Thread.sleep(500);
//		}
		while(set.size()<6)
			set.add(rnd.nextInt(44) +1);

//		for(int num : set)
//			System.out.print(num+" ");
		
		//Set->List
//		List<Integer> list = new ArrayList(set);
//		Collections.sort(list);
//		for(int num : list)
//			System.out.print(num+" ");		
		
		//Collection's Stream
		List<Integer> list=
		 set.stream()
			.sorted()
			.collect(Collectors.toList());
		for(int n : list)System.out.print(n+" ");
		
	}
}
