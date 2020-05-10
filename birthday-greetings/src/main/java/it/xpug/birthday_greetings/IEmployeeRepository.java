package it.xpug.birthday_greetings;

import java.util.List;

public interface IEmployeeRepository {
	List<Employee> getListEmployees();

	List<Employee> getListEmployeesWithTodayBirthday(XDate xDate);
}
