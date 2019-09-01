package packageMain;

import java.sql.*;

public class InsertInfoProfile {
	ConectionDB db = new ConectionDB();

	private String SQL;
	private PreparedStatement stmt;

	public boolean insertData(String name, String age, int phone, String github, String facebook, String instagram,
			String user) {

		if (db.getConnection()) {
			try {
				SQL = "UPDATE users(nameUser, age, phone, github, facebook, instagram) SET ('" + name + "' , '" + age
						+ "', " + phone + ", '" + github + "', '" + facebook + "', '" + instagram + "') WHERE userr = '"
						+ user + "' OR email = '" + user + "';";
				stmt = db.con.prepareStatement(SQL);

				stmt.executeUpdate();

				stmt.close();
				db.close();
				return true;
   
			} catch (SQLException e) {
				e.getMessage();
			}

		}

		return false;
	}

}