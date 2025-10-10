package jp.co.sss.crud.service;

import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeDeleteService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException, ClassNotFoundException, SQLException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee = new Employee();
		Integer employees = employeeDAO.delete(employee);
	}

}
