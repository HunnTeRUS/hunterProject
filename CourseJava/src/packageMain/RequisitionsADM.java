package packageMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;

public class RequisitionsADM {

	ConectionDB db = new ConectionDB();

	PreparedStatement stmt;
	String SQL;
	ResultSet rs;

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
	public Object[] receiveRequisitionsDB(int userCode) {
		try {
			if (db.getConnection()) {
				String user, email, explanation;
				int codeUser;

				SQL = "SELECT usr.userr, usr.email, usr.codeUser, req.explanation FROM users usr INNER JOIN requisitions req ON usr.codeUser = req.idUser WHERE usr.codeUser = "
						+ userCode + ";";

				stmt = db.con.prepareStatement(SQL);
				rs = stmt.executeQuery();

				rs.next();

				user = rs.getString("userr");
				email = rs.getString("email");
				explanation = rs.getString("explanation");

				stmt.close();

				Object[] o = { user, email, explanation };
				return o;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
}
