package packageMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectionDB {

	public Connection con = null;
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DBNAME = "courseJava";
	private final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
	private final String LOGIN = "root";
	//private final String SENHA = "hunter";
	private final String SENHA = "root";

	public boolean getConnection() {
		try {
			int c=0;
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			if(c==0) {
				String cdb = "USE courseJava";
				Statement stm = con.createStatement();
				stm = con.prepareStatement(cdb);
				stm.execute(cdb);
				c++;
			}
			
			System.out.println("Classe BD - Conectou");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Classe BD - Driver nao encontrado" + e.toString());
			return false;
		} catch (SQLException e) {
			System.out.println("Classe BD - Falha ao conectar" + e.toString());
			return false;
		}
	}

	public void close() {
		try {
			con.close();
			System.out.println("Classe BD - Desconectou");
		} catch (SQLException e) {
		}
	}
}
