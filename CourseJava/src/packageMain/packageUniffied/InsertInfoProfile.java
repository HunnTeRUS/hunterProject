package packageMain;

public class InsertInfoProfile {
	ConectionDB db = new ConectionDB();

	private String SQL;
	private PreparedStatement stmt;

	public boolean insertData(String name, String age, String phone, String github, String facebook, String instagram,
			String user) {

		if (db.getConnection()) {
			try {
				SQL = "UPDATE users SET nameUser = ? WHERE userr=? OR email=?";
				stmt = db.con.prepareStatement(SQL);
				stmt.setString(1, name);
				stmt.setString(2, user);
				stmt.setString(3, user);

				stmt.executeUpdate();

				SQL = "UPDATE users SET age = ? WHERE userr=? OR email=?";
				stmt = db.con.prepareStatement(SQL);
				stmt.setString(1, age);
				stmt.setString(2, user);
				stmt.setString(3, user);

				stmt.executeUpdate();

				SQL = "UPDATE users SET phone = ? WHERE userr=? OR email=?";
				stmt = db.con.prepareStatement(SQL);
				stmt.setString(1, phone);
				stmt.setString(2, user);
				stmt.setString(3, user);

				stmt.executeUpdate();


				SQL = "UPDATE users SET github = ? WHERE userr=? OR email=?";
				stmt = db.con.prepareStatement(SQL);
				stmt.setString(1, github);
				stmt.setString(2, user);
				stmt.setString(3, user);

				stmt.executeUpdate();


				SQL = "UPDATE users SET facebook= ? WHERE userr=? OR email=?";
				stmt = db.con.prepareStatement(SQL);
				stmt.setString(1, facebook);
				stmt.setString(2, user);
				stmt.setString(3, user);

				stmt.executeUpdate();


				SQL = "UPDATE users SET instagram= ? WHERE userr=? OR email=?";
				stmt = db.con.prepareStatement(SQL);
				stmt.setString(1, instagram);
				stmt.setString(2, user);
				stmt.setString(3, user);

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