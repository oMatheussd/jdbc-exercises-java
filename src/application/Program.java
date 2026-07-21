package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Connection conn = DB.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		System.out.print("Digite o Id do departamento: ");
		int id =sc.nextInt();
		
		try {
			
			st = conn.prepareStatement(
					
					"SELECT * FROM department "
					+ "WHERE id = ? ");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				System.out.println("Departamento encontrado!");
				int departmentId = rs.getInt("Id");
				System.out.println("Id: " + departmentId);
				String name = rs.getString("Name");
				System.out.println("Nome: " + name);
			} else {
				System.out.println("Departamento não encontrado!");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
		sc.close();
	}
}
