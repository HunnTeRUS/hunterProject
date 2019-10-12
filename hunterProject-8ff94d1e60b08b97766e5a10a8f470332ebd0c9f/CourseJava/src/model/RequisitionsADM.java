package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequisitionsADM {

	// THE VISUAL OF THIS CLASS, IT'S A REQUISITIONSVISUALADM CLASS!

	ConectionDB db = new ConectionDB();

	PreparedStatement stmt;
	String SQL;
	ResultSet rs;

	String user, email, explanation;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	// Method to save the requisitions into the database
	public int insertRequisitionsDB(int userCode, String explanation) {

		try {
			if (db.getConnection()) {
				SQL = "INSERT INTO requisitions(idUser, explanation) VALUES ('" + userCode + "', '" + explanation
						+ "')";

				stmt = db.con.prepareStatement(SQL);
				stmt.executeQuery();

				stmt.close();
				return 0;
			}
		} catch (SQLException e) {
			return 1;
		}
		return 1;
	}

	// Method thats return one requisition, receiving the user code to search in the database
	public void receiveRequisitionsDB() {
		try {
			if (db.getConnection()) {
				String rsLenght = "SELECT MIN(idRequisition) AS firstRequisition FROM requisitions;";
				stmt = db.con.prepareStatement(rsLenght);
				ResultSet lenght = stmt.executeQuery();

				lenght.next();

				SQL = "SELECT usr.userr, usr.email, usr.codeUser, req.explanation FROM users usr INNER JOIN requisitions req ON usr.codeUser = req.idUser WHERE req.idRequisition = "
						+ lenght.getInt("firstRequisition") + ";";

				stmt = db.con.prepareStatement(SQL);
				ResultSet rs = stmt.executeQuery();
				rs.next();

				setUser(rs.getString("userr"));
				setEmail(rs.getString("email"));
				setExplanation(rs.getString("explanation"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
