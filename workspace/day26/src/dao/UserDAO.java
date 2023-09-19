package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.UserVO;

public class UserDAO {

	Connection conn;			// 외부 저장소인 DBMS를 드라이버를 통해 가져온 연결 객체
	PreparedStatement pstm;		// 문자열안에 있는 SQL문을 객체로 저장, 변수가 들어갈 자리에 알맞는 값을 넣어줌, SQL문 실행시킴
	ResultSet rs;				// SELECT의 결과를 담는 객체
	
	public void join(UserVO user) {
		String query = "INSERT INTO TBL_USER_JSP VALUES(SEQ_USER_JSP.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBConnector.getconnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, user.getId());
			pstm.setString(2, user.getName());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getGender());
			pstm.setString(5, user.getZipcode());
			pstm.setString(6, user.getAddress());
			pstm.setString(7, user.getAddress_detail());
			pstm.setString(8, user.getAddress_etc());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
