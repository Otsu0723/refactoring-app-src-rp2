package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeAllFindService implements IEmployeeService {

	public void getInstanceByMenuNo(int menuNo) {

	}

	public void execute()
			throws SystemErrorException, IllegalInputException, ClassNotFoundException, SQLException {

		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> employees = employeeDAO.findAll();
		ConsoleWriter.showEmployees(employees);
	}

}
