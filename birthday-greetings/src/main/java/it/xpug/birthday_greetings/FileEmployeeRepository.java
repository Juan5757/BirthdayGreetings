package it.xpug.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class FileEmployeeRepository implements IEmployeeRepository{
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	ArrayList<Employee> employeesWithTodayBirthday= new ArrayList<Employee>();
	
	@SuppressWarnings("resource")
	FileEmployeeRepository(String fileName) throws IOException, ParseException, AddressException, MessagingException {
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String str = "";
		str = in.readLine(); // skip header
		while ((str = in.readLine()) != null) {
			String[] employeeData = str.split(", ");
			Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
			employees.add(employee);
		}
	}
	
	public List<Employee> getListEmployees() {
		// TODO Auto-generated method stub
		return employees;
	}
	
	public List<Employee> getListEmployeesWithTodayBirthday(XDate xDate){
		for(Employee employee: employees){
			if(employee.isBirthday(xDate)){
				employeesWithTodayBirthday.add(employee);							
			}
		}
		return employeesWithTodayBirthday;		
	}
	
	
}
