import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
	create table bank_account
	(
		owner varchar(100),
	    balance int
	);
	
	insert into bank_account values('철수', 1000);
	insert into bank_account values('영희', 1000);
	
	select * from bank_account;
	
	update bank_account set balance = 1000;
*/

public class App {

	public static void main(String[] args) {
		
		Connection conn = null;			// 연결과 관련된 JDBC 호출 규격 ( 인터페이스 )
		PreparedStatement pstmt = null;	// 명령 실행과 관련된 JDBC 호출 규격 ( 인터페이스 )		
		
		try {
			// 1. Driver 등록
			// DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 연결 및 연결 객체 가져오기
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb", 		// 데이터베이스 연결 정보
					"testuser", "mysql"); 						// 데이터베이스 계정 정보
			
			// 3. SQL 작성 + 명령 객체 가져오기
			String sql = 
					"UPDATE bank_account " +
					"SET balance = balance + ? " +
					"WHERE owner = ?"; // ? : 나중에 채워질 영역 표시
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, -500);
			pstmt.setString(2, "철수");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 500);
			pstmt.setString(2, "영희");
			pstmt.executeUpdate();
			
			System.out.println("계좌 이체 완료");
			
		} catch (Exception ex) {
			System.out.println("계좌 이체 실패");
		} finally {
			// 6. 연결 닫기			
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}

	}

}