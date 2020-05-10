package it.xpug.birthday_greetings;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class BirthdayService {

	private IEmployeeRepository repository;
	private IMessageService messageService;
	
	public BirthdayService(IEmployeeRepository repository, IMessageService messageService){
		this.repository = repository;
		this.messageService = messageService;
	}
	
	public void sendGreetings(XDate xDate) throws IOException, ParseException, AddressException, MessagingException {
		
		List<Employee> employees = repository.getListEmployeesWithTodayBirthday(xDate);
		for(Employee employee: employees){
			Greetings greetings = new Greetings(employee);
			messageService.send(greetings);
		}
		
		
	}

	
}
