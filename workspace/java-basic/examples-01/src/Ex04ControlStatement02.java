
public class Ex04ControlStatement02 {

	public static void main(String[] args) {
		
		// 1-1. 난수 발생기 사용
		double number = Math.random(); // Math.random() : 0 <= n < 1 범위의 난수 발생
		System.out.println("난수 1 : " + number);
		
		// 1-2. 1 ~ 100 범위의 정수형 난수 만들기
		double number2 = Math.random() * 99; // 0 ~ 99 (실수)
		number2 = number2 + 1; // 1 ~ 100 (실수)
		int iNumber = (int)number2;
		System.out.println("난수 2 : " + iNumber);
		
		// 2. 가위 바위 보 게임
		//    - (1, 2, 3) 범위의 정수 난수 발생 -> 변수에 저장 : 1 - 가위, 2 - 바위, 3 - 보
		//    - 사용자 입력 후 변수에 저장 : 1, 2, 3 범위의 정수 : 1 - 가위, 2 - 바위, 3 - 보
		//    - 테스트 코드 ( 두 숫자 출력 )
		//    - 승부 계산
		//    - 출력
		
		
		

	}

}
