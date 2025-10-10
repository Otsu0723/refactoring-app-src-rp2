package jp.co.sss.crud.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.service.IEmployeeService;
import jp.co.sss.crud.util.Constant;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeDAO implements IEmployeeDAO {

	IEmployeeService iEmployeeService;

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IllegalInputException 
	 */
	@Override
	public List<Employee> findAll()
			throws ClassNotFoundException, SQLException, SystemErrorException, IllegalInputException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Employee employee = new Employee();
		Department department = new Department();
		List<Employee> employees = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			// レコードを出力
			while (resultSet.next()) {

				// DTOへの格納
				employee = new Employee();
				department = new Department();

				employee.setEmpId(resultSet.getInt(Constant.DB_EMP_ID));
				employee.setEmpName(resultSet.getString(Constant.DB_EMP_NAME));
				employee.setGender((Integer.parseInt(resultSet.getString(Constant.DB_GENDER))));
				employee.setBirthday(resultSet.getString(Constant.DB_BIRTHDAY));
				department.setDeptName(resultSet.getString(Constant.DB_DEPT_NAME));
				employee.setDepartment(department);
				employees.add(employee);
			}

			return employees;

		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員名に該当する社員情報を検索
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public List<Employee> findByEmpName(String searchName) throws SQLException, IOException, ClassNotFoundException {
		ConsoleWriter.findByEmpName();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 検索ワード
		String searchWord = br.readLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Employee employee = new Employee();
		Department department = new Department();
		List<Employee> employees = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, Constant.PERCENT + searchWord + Constant.PERCENT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				// DTOへの格納
				employee = new Employee();
				department = new Department();

				employee.setEmpId(resultSet.getInt(Constant.DB_EMP_ID));
				employee.setEmpName(resultSet.getString(Constant.DB_EMP_NAME));
				employee.setGender((Integer.parseInt(resultSet.getString(Constant.DB_GENDER))));
				employee.setBirthday(resultSet.getString(Constant.DB_BIRTHDAY));
				department.setDeptName(resultSet.getString(Constant.DB_DEPT_NAME));
				employee.setDepartment(department);
				employees.add(employee);
			}

			return employees;

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	@Override
	public List<Employee> findByDeptId(String deptId)
			throws SystemErrorException, ClassNotFoundException, SQLException, IOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Employee employee = new Employee();
		Department department = new Department();
		List<Employee> employees = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, Integer.parseInt(deptId));

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// DTOへの格納
				employee = new Employee();
				department = new Department();

				employee.setEmpId(resultSet.getInt(Constant.DB_EMP_ID));
				employee.setEmpName(resultSet.getString(Constant.DB_EMP_NAME));
				employee.setGender((Integer.parseInt(resultSet.getString(Constant.DB_GENDER))));
				employee.setBirthday(resultSet.getString(Constant.DB_BIRTHDAY));
				department.setDeptName(resultSet.getString(Constant.DB_DEPT_NAME));
				employee.setDepartment(department);
				employees.add(employee);
			}

			return employees;

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * @return 
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	@Override
	public List<Employee> insert(Employee employee)
			throws ClassNotFoundException, SQLException, IOException, ParseException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 登録する値を入力
		ConsoleWriter.findByEmpName();
		String empName = br.readLine();
		ConsoleWriter.insertGender();
		String gender = br.readLine();
		ConsoleWriter.insertBirthday();
		String birthday = br.readLine();
		ConsoleWriter.insertDeptId();
		String deptId = br.readLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat(Constant.BIRTHDAY);
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(deptId));

			// SQL文を実行
			preparedStatement.executeUpdate();

			// 登録完了メッセージを出力
			ConsoleWriter.registComp();
		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
		return null;
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	@Override
	public Integer update(Employee employee) throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 更新する社員IDを入力
		ConsoleWriter.update();

		// 更新する値を入力する
		String updateEmpId = br.readLine();
		Integer.parseInt(updateEmpId);

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			ConsoleWriter.findByEmpName();
			String emp_name = br.readLine();
			// 性別を入力
			ConsoleWriter.insertGender();
			String gender = br.readLine();
			// 誕生日を入力
			ConsoleWriter.insertBirthday();
			String birthday = br.readLine();
			// 部署IDを入力
			ConsoleWriter.insertDeptId();
			String deptId = br.readLine();

			// 入力値をバインド
			preparedStatement.setString(1, emp_name);
			preparedStatement.setInt(2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat(Constant.BIRTHDAY);
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(deptId));
			preparedStatement.setInt(5, Integer.parseInt(updateEmpId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}

		ConsoleWriter.updateComp();
		return null;
	}

	@Override
	public Integer delete(Integer empId) throws SystemErrorException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
