package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeFindByEmpNameService implements IEmployeeService {

	private String searchWord;

	public void getInstanceByMenuNo(int menuNo) {
	}

	public void execute()
			throws SystemErrorException, IllegalInputException, SQLException, ClassNotFoundException, IOException {

		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> employees = employeeDAO.findByEmpName(searchWord);
		ConsoleWriter.showEmployees(employees);
	}

}
