package Ch31;


//덧셈, 뺄셈, 곱셈, 나눗셈을 수행하는 함수형 인터페이스 정의
interface Calculator {
int calculate(int num1, int num2);
}

public class C03LAMDA {
	public static void main(String[] args) {
		
		Calculator addition =(n1,n2)->n1+n2;
		System.out.println("Addition: " + addition.calculate(5, 3));

		Calculator subtraction = (n1,n2)->{
			if(n1>n2)
				return n1-n2;
			else
				return n2-n1;
		};
		System.out.println("Subtraction: " + subtraction.calculate(5, 3));	
		
		Calculator multiplication = (n1,n2)->n1*n2;
		System.out.println("Multiplication: " + multiplication.calculate(5, 3));
		
		Calculator division = (n1,n2)->n1/n2;
		System.out.println("Division: " + division.calculate(5, 3));
		
	}
}
