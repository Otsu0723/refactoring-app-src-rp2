package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeRegisterService implements IEmployeeService {

	public void execute() throws SystemErrorException, IllegalInputException, IOException,
			ClassNotFoundException, SQLException, ParseException {

		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee = new Employee();
		List<Employee> employees = employeeDAO.insert(employee);
	}

}
