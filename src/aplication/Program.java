package aplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
//Classe exemplo para recuperacao de dados 
public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;	
		try {
			conn = DB.getConnection(); //conecta com o banco
			
			st = conn.createStatement(); //cria o objeto Statement
			
			rs = st.executeQuery("select * from department"); 
			
			while(rs.next()) {//percorre a tabela enquanto a linha tiver valor
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);;
			DB.closeStatemente(st);;
			DB.closeConnection();
		}
	
	
	}

}
