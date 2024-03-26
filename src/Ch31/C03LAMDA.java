package Ch31;


//덧셈, 뺄셈, 곱셈, 나눗셈을 수행하는 함수형 인터페이스 정의
interface Calculator {
int calculate(int num1, int num2);
}

public class C03LAMDA {
	public static void main(String[] args) {
		
		Calculator addition = "람다식 정의";
		System.out.println("Addition: " + addition.calculate(5, 3));

		Calculator subtraction = "람다식 정의";;
		System.out.println("Subtraction: " + subtraction.calculate(5, 3));	
		
		Calculator multiplication = "람다식 정의"; ;
		System.out.println("Multiplication: " + multiplication.calculate(5, 3));
		
		Calculator division =  "람다식 정의";;
		System.out.println("Division: " + division.calculate(5, 3));
		
	}
}
