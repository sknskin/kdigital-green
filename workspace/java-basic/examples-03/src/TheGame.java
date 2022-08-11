
// 1. 가위 바위 보 게임을 클래스 버전으로 변환
//    -> ContactManager 참고

// 2. 게임 마다 게임 결과를 목록에 저장
// 3. 게임 결과 보기 메뉴 기능 추가

public class TheGame {

	private java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public void doGame() {
		
		//outer: for(;true;) {
		outer: while(true) {
			
			String selection = selectMenu();
			
			System.out.println();
			
			switch(selection) {
			case "1": 
				int comNumber = makeComNumber();
				
				int userNumber = inputUserNumber(); 
				
				String result = makeDecision(userNumber, comNumber);
				
				showResult(comNumber, userNumber, result);
				
				break;
			case "9": // 프로그램 종료
				System.out.println("$$ 프로그램을 종료합니다. $$");
				//break; // switch문 종료
				break outer; // outer: while(true)문 종료
			default: 
				System.out.println("$$ 지원하지 않는 명령입니다. $$");
				break;
			} // end of switch
			
			System.out.println();
			
		} // end of while
		
		scanner.close();
		
		

	} // end of main
	
	public String selectMenu() {
		System.out.println("******************************");
		System.out.println("* 1. 가위/바위/보 게임 시작       *");
		System.out.println("* 9. 종료                     *");
		System.out.println("******************************");
		System.out.print("작업을 선택하세요 : ");
		String selection = scanner.next();
		
		return selection;
	}

	public int makeComNumber() {
		double n = Math.random() * 3; // 0 <= n < 3
		int comNumber = (int)(n + 1);
		return comNumber;
	}
	
	public int inputUserNumber() {
		String sUserNumber;
		do {
			System.out.print("가위/바위/보 입력 (가위=1, 바위=2, 보=3) : ");
			sUserNumber = scanner.next();
		} while (!sUserNumber.equals("1") &&
				 !sUserNumber.equals("2") &&
				 !sUserNumber.equals("3"));
		int userNumber = Integer.parseInt(sUserNumber); // Integer.parseInt("문자열") : "문자열"을 숫자로 변경
		return userNumber;
	}
	
	public String makeDecision(int userNumber, int comNumber) {
		String result = "DRAW";
		if ( (userNumber == 1 && comNumber == 2) || 
			 (userNumber == 2 && comNumber == 3) || 
			 (userNumber == 3 && comNumber == 1) ) {
			result = "LOSE";
		} else if (userNumber == comNumber) {
			// DO NOTHING : result = "DRAW"
		} else {
			result = "WIN";
		}
		return result;
	}
	
	public void showResult(int comNumber, int userNumber, String result) {
		// 출력				
		String com;
		if (comNumber == 1) 		com = "가위";
		else if (comNumber == 2) 	com = "바위";
		else 						com = "보";
		String user = userNumber == 1 ? "가위" : (userNumber == 2 ? "바위" : "보");
		System.out.printf("[COMPUTER : %2s][USER : %2s][RESULT : %s]\n", com, user, result);
	}
	
	public static void main(String[] args) {
		TheGame game = new TheGame();
		game.doGame();
	}
	
}













