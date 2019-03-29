package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Student;
import util.ConnectionDB;

public class StudentModel {

	public List<Student> getStudentByAccountId(String accountID) {
		Connection conn = null;
		PreparedStatement pstm = null;
		List<Student> listStudentBA = new ArrayList<>();
		try {
			conn = ConnectionDB.openConnection();
			String sql = "SELECT st.ID, st.STUDENTNAME, st.STUDENTEMAIL, st.PHONENUMBER, st.STUDENTCLASS, st.NOTE, st.ACCOUNT_ID FROM STUDENT st WHERE st.ACCOUNT_ID = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, accountID);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Student st = new Student();
				st.setId(rs.getString("ID"));
				st.setStudentName(rs.getString("STUDENTNAME"));
				st.setStudentEmail(rs.getString("STUDENTEMAIL"));
				st.setPhoneNumber(rs.getInt("PHONENUMBER"));
				st.setStudentClass(rs.getString("STUDENTCLASS"));
				st.setNote(rs.getString("NOTE"));
				st.setAccount_Id(rs.getString("ACCOUNT_ID"));
				listStudentBA.add(st);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn, pstm);
		}

		return listStudentBA;

	}

	public List<Student> getAllStudent() {
		Connection conn = null;
		PreparedStatement pstm = null;
		List<Student> listAllStudent = new ArrayList<>();
		try {
			conn = ConnectionDB.openConnection();
			String sql = "SELECT st.ID, st.STUDENTNAME, st.STUDENTEMAIL, st.PHONENUMBER, st.STUDENTCLASS, st.NOTE, st.ACCOUNT_ID FROM STUDENT st";
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Student st = new Student();
				st.setId(rs.getString("ID"));
				st.setStudentName(rs.getString("STUDENTNAME"));
				st.setStudentEmail(rs.getString("STUDENTEMAIL"));
				st.setPhoneNumber(rs.getInt("PHONENUMBER"));
				st.setStudentClass(rs.getString("STUDENTCLASS"));
				st.setNote(rs.getString("NOTE"));
				st.setAccount_Id(rs.getString("ACCOUNT_ID"));
				listAllStudent.add(st);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn, pstm);
		}

		return listAllStudent;

	}

	public boolean insertNewStudent(Student student) {
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConnection();
			String sql = "INSERT INTO STUDENT(ID, STUDENTNAME, STUDENTEMAIL, PHONENUMBER, STUDENTCLASS, NOTE, ACCOUNT_ID) VALUES (?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, student.getId());
			pstm.setString(2, student.getStudentName());
			pstm.setString(3, student.getStudentEmail());
			pstm.setInt(4, student.getPhoneNumber());
			pstm.setString(5, student.getStudentClass());
			pstm.setString(6, student.getNote());
			pstm.setString(7, student.getAccount_Id());

			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			check = false;
		} finally {
			ConnectionDB.closeConnection(conn, pstm);
		}
		return check;

	}

	public boolean updateStudent(Student student) {
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConnection();
			String sql = "UPDATE STUDENT st SET st.STUDENTNAME = ?, st.STUDENTEMAIL = ?, st.PHONENUMBER = ?, st.STUDENTCLASS = ?, st.NOTE = ?, st.ACCOUNT_ID = ? WHERE st.ID = ?";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, student.getStudentName());
			pstm.setString(2, student.getStudentEmail());
			pstm.setInt(3, student.getPhoneNumber());
			pstm.setString(4, student.getStudentClass());
			pstm.setString(5, student.getNote());
			pstm.setString(6, student.getAccount_Id());
			pstm.setString(7, student.getId());

			pstm.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			check = false;
		} finally {
			ConnectionDB.closeConnection(conn, pstm);
		}
		return check;

	}
}
