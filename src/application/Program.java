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

		int n = 0;

		do {
			System.out.println("1 - Inserir departamento");
			System.out.println("2 - Buscar departamento");
			System.out.println("3 - Atualizar departamento");
			System.out.println("4 - Excluir departamento");
			System.out.println("5 - Sair");
			System.out.println();

			System.out.print("Digite a opção desejada: ");
			n = sc.nextInt();

			System.out.println();

			switch (n) {

			case 1:
				sc.nextLine();
				insertDepartment(conn, sc);
				break;
			case 2:
				selectDepartment(conn, sc);
				break;
			case 3:
				updateDepartment(conn, sc);
				break;
			case 4:
				deleteDepartment(conn, sc);
				break;

			case 5:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção invalida, tente novamente.");
				System.out.println();
			}
		} while (n != 5);

		sc.close();
		DB.closeConnection();
	}

	public static void insertDepartment(Connection conn, Scanner sc) {

		PreparedStatement st = null;
		ResultSet rs = null;

		System.out.print("Nome do departamento: ");
		String department = sc.nextLine();

		try {
			st = conn.prepareStatement(

					"INSERT INTO department " + "(Name) " + "VALUES (?) ", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, department);
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Departamento inserido com sucesso!");
					System.out.println("Done! Id = " + id);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	public static void selectDepartment(Connection conn, Scanner sc) {

		PreparedStatement st = null;
		ResultSet rs = null;

		System.out.print("Digite o Id do departamento: ");
		int id = sc.nextInt();

		try {

			st = conn.prepareStatement(

					"SELECT * FROM department " + "WHERE id = ? ");

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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	public static void updateDepartment(Connection conn, Scanner sc) {

		PreparedStatement st = null;

		System.out.print("Digite o Id do departamento: ");
		int id = sc.nextInt();
		System.out.print("Digite o novo nome do departamento: ");
		sc.nextLine();
		String newDepartmentName = sc.nextLine();

		try {

			st = conn.prepareStatement(

					"UPDATE department " + "SET Name = ? " + "WHERE Id = ? ");

			st.setString(1, newDepartmentName);
			st.setInt(2, id);
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Departamento atualizado com sucesso!");
				System.out.println("Linhas afetadas: " + rowsAffected);
			} else {
				System.out.println("Nenhum departamento foi atualizado.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
		}
	}

	public static void deleteDepartment(Connection conn, Scanner sc) {

		PreparedStatement st = null;

		System.out.print("Digite o Id do departamento: ");
		int id = sc.nextInt();
		try {

			st = conn.prepareStatement(

					"DELETE FROM department " + "WHERE Id = ? ");

			st.setInt(1, id);
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Departamento excluído com sucesso!");
				System.out.println("Linhas afetadas: " + rowsAffected);
			} else {
				System.out.println("Nenhum departamento foi excluído.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
		}
	}
}
