package Ch33;

package Ch37함수형프로그래밍;

import java.util.Arrays;

interface functional{
	int execute(int ...args);
}
class Calc{
	functional sum;
	functional sub;
	functional mul;
	functional div;
	
	Calc(){
		//덧셈로직
		sum = (numbers)->Arrays.stream(numbers).reduce((a,b)->a+b).getAsInt();
		//뺄셈로직
		//곱셈로직
		//나눗셈로직
	}
}


public class C01_2Ex {

	
	public static void main(String[] args) {
		Calc calc = new Calc();
		System.out.println("합 :"+ calc.sum.execute(10,20,30,40,50,60));
		
		
		
	}
}
