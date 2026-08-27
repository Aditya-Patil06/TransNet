import java.util.*;

public class dlsEmployee
{
	public static void addNewEmployee(clsEmployee temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "insert into dbProjectData.tblEmployee" + SPACE +
					   "("+ "EmployeeName,Address,Age,ContactNo,EmailID,DesignationID,Gender,AreaID,BillaNo,LicenceNo) " +
					   "Values" + SPACE + "("+
					   SQ + temp.getEmployeeName() + SQ + COMMA+
					   SQ + temp.getAddress() + SQ + COMMA+
					   SQ + temp.getAge() + SQ + COMMA+
					   SQ + temp.getContactNo() + SQ + COMMA+
					   SQ + temp.getEmailID() + SQ + COMMA+
					   SQ + temp.getDesignationID() + SQ + COMMA+
					   SQ + temp.getGender() + SQ + COMMA+
					   SQ + temp.getAreaID() + SQ + COMMA+
					   SQ + temp.getBillaNo() + SQ + COMMA+
					   SQ + temp.getLicenceNo() + SQ +

					   ")";

		QueryExecutor.processQuery(Query);
		System.out.println(Query);
		System.out.println("dls addNewEmployee");


	}
	public static void updateEmployee(clsEmployee temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblEmployee set" + SPACE +
					   "EmployeeName=" + SQ + temp.getEmployeeName() + SQ + SPACE +
					   "where EmployeeID=" + String.valueOf(temp.getEmployeeID());

		QueryExecutor.processQuery(Query);

	}

	public static void deleteEmployee(clsEmployee temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblEmployee where EmployeeID="+temp.getEmployeeID();

		QueryExecutor.processQuery(Query);
	}

	public static int getIDFromName(String mEmployeeName)
	{
		String Query = "select EmployeeID from tblEmployee where EmployeeName='"+mEmployeeName+"'";

		return QueryExecutor.getIDFromName(Query);
	}

	public static String getNameFromID(int mEmployeeID)
	{
		String Query = "select EmployeeName from tblEmployee where EmployeeID="+String.valueOf(mEmployeeID);

		return QueryExecutor.getNameFromID(Query);
	}

	public static String [] getAllEmployeeNames()
	{
		String Query = "select EmployeeName from dbProjectData.tblEmployee order by EmployeeName";
		return(QueryExecutor.getSingleColumn(Query));
	}

	public static int getAllEmployeeCount()
	{
		String Query = "select count(EmployeeID) from dbProjectData.tblEmployee";
		return(QueryExecutor.getRowsCount(Query));
	}


	public static clsEmployee getEmployeeInformation(int mEmployeeID)
	{
		String Query = "select * from tblEmployee where EmployeeID="+String.valueOf(mEmployeeID);

		String data[] = QueryExecutor.getObjectInformation(Query,2);

		clsEmployee temp = new clsEmployee();

		temp.setEmployeeID(Integer.parseInt(data[0]));
		temp.setEmployeeName(data[1]);
		return(temp);


	}

	public static clsEmployee[] getAllEmployeeInformation()
	{
		String Query = "select * from tblEmployee";
		String data[][] = QueryExecutor.getAllObjectInformation(Query,2);
		clsEmployee temp[] = new clsEmployee[data.length];
		for(int i = 0;i<data.length;i++)
		{
			temp[i] = new clsEmployee();
			temp[i].setEmployeeID(Integer.parseInt(data[i][0]));
			temp[i].setEmployeeName(data[i][1]);
		}
		return(temp);
	}

	public static String[][] getAllObjectInformation(String Query,int ColoumnCount)
	{
		return(QueryExecutor.getAllRows(Query,ColoumnCount));
	}


	public static void main(String rags[])
	{
		clsEmployee temp = new clsEmployee();

		dlsEmployee.addNewEmployee(temp);

	}


}