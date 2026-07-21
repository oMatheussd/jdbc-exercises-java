package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Connection conn = DB.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		System.out.print("Nome do departamento: ");
		String department = sc.nextLine();

		try {
			st = conn.prepareStatement(

					"INSERT INTO department (Name) VALUES (?) ", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, department);
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeConnection();
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

		sc.close();
	}
}
