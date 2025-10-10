package jp.co.sss.crud.db;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

public interface IEmployeeDAO {
	/**
	 * 全件表示
	 *
	 * @return {@code List<Employee>} 全社員エンティティリスト
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalInputException 
	 */
	List<Employee> findAll() throws SystemErrorException, ClassNotFoundException, SQLException, IllegalInputException;

	/**
	 * 社員名検索
	 * 
	 * @param searchName 検索社員名 
	 * @return {@code List<Employee>} 検索社員名を含むエンティティリスト
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	List<Employee> findByEmpName(String searchName)
			throws SystemErrorException, SQLException, IOException, ClassNotFoundException;

	/**
	 * 部署ID検索
	 * 
	 * @param deptId 部署ID
	 * @return {@code List<Employee>} 検索部署IDを含むエンティティリスト
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	List<Employee> findByDeptId(String deptId)
			throws SystemErrorException, ClassNotFoundException, SQLException, IOException;

	/**
	 * 登録
	 * <br>引数のEmployeeから社員名、性別、生年月日、部署番号を取得し新たな社員情報を生成する。
	 * <br>社員IDは自動採番機能を用いること
	 * 
	 * @param employee
	 * @return 
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	List<Employee> insert(Employee employee)
			throws SystemErrorException, ClassNotFoundException, SQLException, IOException, ParseException;

	/**
	 * 社員情報を1件更新する
	 * <br>引数のEmployeeから社員ID、社員名、性別、生年月日、部署番号を取得し社員情報を更新する。
	 * 
	 * @param employee
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	Integer update(Employee employee)
			throws SystemErrorException, ClassNotFoundException, SQLException, IOException, ParseException;

	/**
	 * 社員情報を1件削除する
	 * <br>引数のEmployeeから社員IDから社員情報を削除する。
	 * 
	 * @param empId 
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 */
	Integer delete(Employee employee) throws SystemErrorException;

}
