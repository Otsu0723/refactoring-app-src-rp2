package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeDeleteService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
import jp.co.sss.crud.service.EmployeeUpdateService;
import jp.co.sss.crud.service.IEmployeeService;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {

	public static IEmployeeService employeeService;

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

		EmployeeAllFindService allFindService = new EmployeeAllFindService();
		EmployeeFindByEmpNameService findByEmpNameService = new EmployeeFindByEmpNameService();
		EmployeeFindByDeptIdService findByDeptIdService = new EmployeeFindByDeptIdService();
		EmployeeRegisterService registerService = new EmployeeRegisterService();
		EmployeeUpdateService updateService = new EmployeeUpdateService();
		EmployeeDeleteService deleteService = new EmployeeDeleteService();

		int menuNo = 0;

		do {
			// メニュー出力
			ConsoleWriter.menu();

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);
			//employeeService.getInstanceByMenuNo(menuNo);

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
				// 登録機能の呼出
				registerService.execute();
				break;

			case 5:
				// 更新機能の呼出
				updateService.execute();
				break;

			case 6:
				// 削除機能の呼出
				deleteService.execute();
				break;

			}
		} while (menuNo != 7);
		ConsoleWriter.systemEnd();
	}
}
