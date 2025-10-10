package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeFindByDeptIdService implements IEmployeeService {

	//	private String deptId;

	public void execute()
			throws SystemErrorException, IllegalInputException, ClassNotFoundException, SQLException, IOException {
		ConsoleWriter.findByDeptId();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String findDeptId = br.readLine();

		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> employees = employeeDAO.findByDeptId(findDeptId);
		ConsoleWriter.showEmployees(employees);
	}

}
