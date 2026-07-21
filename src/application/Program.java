package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Connection conn = DB.getConnection();
		PreparedStatement st = null;
		
		System.out.print("Digite o Id do departamento: ");
		int id =sc.nextInt();
		System.out.print("Digite o novo nome do departamento: ");
		sc.nextLine();
		String newDepartmentName =sc.nextLine();
		
		try {
			
			st = conn.prepareStatement(
					
					"UPDATE department "
					+ "SET Name = ? "
					+ "WHERE Id = ? ");
			
			st.setString(1, newDepartmentName);
			st.setInt(2, id);
			int rowsAffected = st.executeUpdate();
			
			if ( rowsAffected > 0) {
				System.out.println("Departamento atualizado com sucesso!");
				System.out.println("Linhas afetadas: " + rowsAffected);
			} else {
				System.out.println("Nenhum departamento foi atualizado.");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		sc.close();
	}
}
