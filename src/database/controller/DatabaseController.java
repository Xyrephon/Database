package database.controller;

import javax.swing.JOptionPane;
import java.sql.*;

public class DatabaseController 
{
	
	private String connectionString;
	private Connection databaseConnection;
	private DatabaseAppController baseController;
	
	public DatabaseController(DatabaseAppController baseController)
	{
		this.baseController = baseController;
		checkDriver();
	}
	
	private void checkDriver()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception currentException)
		{
			displayErrors(currentException);
			System.exit(1);
		}
	}
	
}
