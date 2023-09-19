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
	
	// 아이디 중복검사
	public boolean checkId(String id) {
		String query = "SELECT COUNT(ID) FROM TBL_USER_JSP WHERE ID = ?";
		boolean check =false;
		try {
			// DBMS 연결 객체 가져오기
			conn = DBConnector.getconnection();
			//String으로 선언된 쿼리르 pstm객체에 전달하기
			pstm = conn.prepareStatement(query);
			//SQL 쿼리에 ?가 있다면 알맞는 값으로 지정해주기
			pstm.setString(1, id);
			//쿼리 실행 후 결과를 rs객체에 담기
			rs = pstm.executeQuery();
			
			//행 가져오기
			rs.next();
			//위에서 가져온 행의 열을 타입에 맞춰서 가져오기
			check = rs.getInt(1) == 1;		//0일 때 중복없음 (false), 1일 떄 중복있음 (true)
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
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
		return check;
	}
}
