import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;

public class QueryExecutor
{
	private static final String DB_URL =
			"jdbc:mysql://localhost:3306/dbProjectData";

	private static final String DB_USER =
			System.getenv("TRANSNET_DB_USER");

	private static final String DB_PASSWORD =
			System.getenv("TRANSNET_DB_PASSWORD");


	public static void processQuery(String Query)
	{
		String url = DB_URL;

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con =
					DriverManager.getConnection(url, DB_USER, DB_PASSWORD);

			Statement st = con.createStatement();

			st.executeUpdate(Query);

			st.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}


	public static String[] getSingleColumn(String Query)
	{
		String url = DB_URL;

		Vector<String> v = new Vector<String>();

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con =
					DriverManager.getConnection(url, DB_USER, DB_PASSWORD);

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(Query);

			while(rs.next())
			{
				v.addElement(rs.getString(1));
			}

			rs.close();
			st.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}

		String[] values = v.toArray(new String[v.size()]);

		return values;
	}


	public static String[] getSingleRow(String Query, int ColumnCount)
	{
		String url = DB_URL;
		int value = 0;

		Vector<String> v = new Vector<String>();

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con =
					DriverManager.getConnection(url, DB_USER, DB_PASSWORD);

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(Query);

			if(rs.next())
			{
				for(int i = 0; i < ColumnCount; i++)
				{
					v.addElement(rs.getString(i + 1));
				}
			}

			st.close();
			rs.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}

		String[] values = v.toArray(new String[v.size()]);

		return values;
	}


	public static String[][] getAllRows(String Query, int ColumnCount)
	{
		String url = DB_URL;
		int value = 0;

		Vector<Vector<String>> vector = new Vector<>();

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con =
					DriverManager.getConnection(url, DB_USER, DB_PASSWORD);

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(Query);

			int r = 0;

			while(rs.next())
			{
				Vector<String> row1 = new Vector<>();

				for(int i = 0; i < ColumnCount; i++)
				{
					row1.addElement(rs.getString(i + 1));
					r++;
				}

				vector.add(row1);
			}

			st.close();
			rs.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}

		String[][] stringArray = new String[vector.size()][];

		for(int i = 0; i < vector.size(); i++)
		{
			Vector<String> row = vector.get(i);
			stringArray[i] = row.toArray(new String[0]);
		}

		return stringArray;
	}


	public static int getSingleNumber(String Query)
	{
		String url = DB_URL;
		int value = 0;

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con =
					DriverManager.getConnection(url, DB_USER, DB_PASSWORD);

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(Query);

			if(rs.next())
			{
				value = rs.getInt(1);
			}

			rs.close();
			st.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}

		return value;
	}


	public static String getSingleString(String Query)
	{
		String url = DB_URL;
		String value = "";

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con =
					DriverManager.getConnection(url, DB_USER, DB_PASSWORD);

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(Query);

			if(rs.next())
			{
				value = rs.getString(1);
			}

			rs.close();
			st.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}

		return value;
	}


	public static int getIDFromName(String Query)
	{
		return QueryExecutor.getSingleNumber(Query);
	}


	public static String getNameFromID(String Query)
	{
		return QueryExecutor.getSingleString(Query);
	}


	public static String[] getObjectInformation(String Query, int ColumnsCount)
	{
		return QueryExecutor.getSingleRow(Query, ColumnsCount);
	}


	public static String[][] getAllObjectInformation(String Query, int ColumnsCount)
	{
		return QueryExecutor.getAllRows(Query, ColumnsCount);
	}


	public static int getRowsCount(String Query)
	{
		return QueryExecutor.getSingleNumber(Query);
	}
}