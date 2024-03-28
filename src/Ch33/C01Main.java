package Ch33;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Func{
	void say(String message);
}
@FunctionalInterface
interface Func2{
	int sum(int n1 , int n2);
}
@FunctionalInterface
interface Func3{
	int sum(int ...args);
}

@FunctionalInterface
interface Func4{
	List<Integer> sum(int ...args);
}

public class C01Main {

	public static void main(String[] args) {
		
//		//01
//		Func t1 = (m)->{System.out.println(m);};
//		t1.say("HELLO");
//		
//		//02
//		Func t2 = System.out::println;
//		t2.say("HELLO WORLD");
		
		//03
//		Func2 t3=(n1,n2)->{return n1+n2;};
//		System.out.println(t3.sum(10, 20)); 
		
		//04
//		Func3 t4=(numbers)->{
//			int sum=0;
//			for(int n : numbers) {
//				sum+=n;
//			}
//			return sum;
//		};
//		int result = t4.sum(10,2,4,676,225,1,2,4,121,1,2,66);
//		System.out.println(result);
		
		//05
		Func4 t5=(numbers)->{
			return Arrays.asList(
					 Arrays	.stream(numbers)
					 		.boxed()
					 		.sorted((a,b)->{return a-b;})
					 		.toArray(Integer[]::new)
					);	
		};
		 List<Integer> result =  t5.sum(55,11,251,9,15,2,1,67);
		 System.out.println(result);
		 
		 
		
		
	}
}
