package dataStore;


import java.sql.*;
import java.util.ArrayList;

import persons.Person;

public class DSDB implements DataStorage {

	private String dbconn = null;

	public DSDB(String dbconn) {
		this.dbconn = dbconn;
	}
	@Override
	public void save(ArrayList<Person> pal) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(dbconn);
			Statement stat = conn.createStatement();
			stat.executeUpdate("drop table if exists Persons");
			stat.executeUpdate("create table Persons (id int," +
                                            "firstname varchar," +
                                            "lastname varchar," +
                                            "email varchar" +
                                            ");" );
			PreparedStatement prep = conn.prepareStatement(
					"insert into Persons values (?, ?, ?, ?);");
			for (Person person : pal) {
				prep.setInt(1, person.getId());
				prep.setString(2, person.getFirstname());
				prep.setString(3, person.getLastname());
				prep.setString(4, person.getEmail());
				prep.addBatch();
			}
			conn.setAutoCommit(false);
			prep.executeBatch();
			conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> load() {
		ArrayList<Person> pal = new ArrayList<Person>();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(dbconn);
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from Persons;");
			while (rs.next()) {
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setFirstname(rs.getString("firstname"));
				person.setLastname(rs.getString("lastname"));
				person.setEmail(rs.getString("email"));
				pal.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return pal;
	}

}
