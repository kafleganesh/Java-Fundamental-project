package fr.epita.crud.services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.epita.crud.datamodel.identity;
import fr.epita.crud.services.DaoInitializationException;
public class IdentityJDBCDAO 
{
	private Connection currentConnection;
	public IdentityJDBCDAO() throws DaoInitializationException {
		try {
		getConnection();
		} catch (SQLException e) {
			DaoInitializationException die = new DaoInitializationException();
			die.initCause(e);
			throw die;
			
		}
	}
	/**
	 * Connect to the Database
	 * 
	 * @throws SQLException any SQL Error
	 */
	private Connection getConnection() throws SQLException {
		try {
			this.currentConnection.getSchema();
		} catch (Exception e) {
			String user = "ganesh1";
			String password = "ganesh1";
			String connectionString = "jdbc:derby://localhost:1527/ganesh1;create=true";
			this.currentConnection = DriverManager.getConnection(connectionString, user, password);
		}
		return this.currentConnection;
	}

//insert into database
		public void write(identity identity) throws SQLException
		{
			Connection connection = getConnection();
			String intodb = "INSERT INTO ganesh(identity_id ,name, email) VALUES(?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(intodb);
			pstmt.setString (1, identity.getIdentity_id());
			pstmt.setString(2, identity.getDisplayname());
			pstmt.setString(3, identity.getEmail());
			pstmt.execute();
			System.out.println("sucussefully inserted into database");	
		}

//update identity
		public void update(identity identity) throws SQLException 
		{
			Connection connection = getConnection();
			String sqlUpdate = "UPDATE ganesh SET NAME = ?, EMAIL = ? WHERE IDENTITY_ID = ?";
			PreparedStatement pstmt = connection.prepareStatement(sqlUpdate);
			pstmt.setString(1, identity.getDisplayname());
			pstmt.setString(2, identity.getEmail());
			pstmt.setString(3, identity.getIdentity_id());
			pstmt.execute();
		}

//delete identity from database on the basis of identity_id
		public void delete(identity identity) throws SQLException 
		{
			Connection connection = getConnection();
			String sqlInstruction = "DELETE FROM ganesh WHERE IDENTITY_ID = ?";
			PreparedStatement pstmt = connection.prepareStatement(sqlInstruction);
			pstmt.setString(1, identity.getIdentity_id());
			pstmt.execute();
		}
		
//list indentities from database
		public List<identity> readAllIdentities() throws SQLException 
		{
			List<identity> identities = new ArrayList<identity>();
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from ganesh");
			ResultSet rs = statement.executeQuery();
				while (rs.next()) 
				{
					String uid = rs.getString("IDENTITY_ID");
					String displayName = rs.getString("NAME");
					String email = rs.getString("EMAIL");
					identity identity = new identity(uid, displayName, email);
					identities.add(identity);
				}
				return identities;
		}
		
//identity search
		public void search(identity identity) throws SQLException 
		{
			Connection connection = getConnection();
			String sqlsearch = "SELECT  name from ganesh where identity_id =?";
			PreparedStatement pstmt = connection.prepareStatement(sqlsearch);
			pstmt.setString(1, identity.getDisplayname());
			pstmt.setString(2, identity.getEmail());
			pstmt.setString(3, identity.getIdentity_id());
			pstmt.execute();
		}	
}

