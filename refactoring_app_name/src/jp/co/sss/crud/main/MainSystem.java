package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.IEmployeeService;
import jp.co.sss.crud.util.Constant;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	IEmployeeService employeeService;

	/**
	 * 社員管理システムを起動
	 * @param employees 
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 * @throws SystemErrorException 
	 * @throws IllegalInputException 
	 */
	public static void main(String[] args)
			throws IOException, ClassNotFoundException, SQLException, ParseException, SystemErrorException,
			IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeAllFindService allFindService = new EmployeeAllFindService();
		EmployeeFindByEmpNameService findByEmpNameService = new EmployeeFindByEmpNameService();
		EmployeeFindByDeptIdService findByDeptIdService = new EmployeeFindByDeptIdService();

		int menuNo = 0;

		do {
			// メニュー出力
			ConsoleWriter.menu();

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case 1:
				// 全件表示機能の呼出
				allFindService.execute();
				break;

			case 2:
				// 社員名検索機能の呼出
				findByEmpNameService.execute();
				break;

			case 3:
				// 部署ID検索機能の呼出
				findByDeptIdService.execute();
				break;

			case 4:
				// 登録する値を入力
				ConsoleWriter.findByEmpName();
				String empName = br.readLine();
				ConsoleWriter.insertGender();
				String gender = br.readLine();
				ConsoleWriter.insertBirthday();
				String birthday = br.readLine();
				ConsoleWriter.insertDeptId();
				String deptId = br.readLine();

				// 登録機能の呼出
				DBController.insert(empName, gender, birthday, deptId);
				break;

			case 5:
				// 更新する社員IDを入力
				System.out.print(Constant.UPDATE_START_EMPID);

				// 更新する値を入力する
				String updateEmpId = br.readLine();
				Integer.parseInt(updateEmpId);

				// 更新機能の呼出
				DBController.update(updateEmpId);
				System.out.println(Constant.UPDATE_COMP_EMPID);

				break;

			case 6:
				// 削除する社員IDを入力
				System.out.print(Constant.DELETE_START_EMPID);

				// 削除機能の呼出
				DBController.delete();
				break;

			}
		} while (menuNo != 7);
		System.out.println(Constant.END_SYSTEM);
	}
}
