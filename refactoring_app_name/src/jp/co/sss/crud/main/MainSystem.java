package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.util.Constant;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;

		do {
			// メニューの表示
			System.out.println(Constant.MENU);
			System.out.println(Constant.MENU_FIND_ALL);
			System.out.println(Constant.MENU_FIND_EMPNAME);
			System.out.println(Constant.MENU_FIND_DEPTID);
			System.out.println(Constant.MENU_INSERT);
			System.out.println(Constant.MENU_UPDATE);
			System.out.println(Constant.MENU_DELETE);
			System.out.println(Constant.MENU_END);
			System.out.print(Constant.MENU_INPUT);

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case 1:
				// 全件表示機能の呼出
				DBController.findAll();
				break;

			case 2:
				// 社員名検索
				System.out.print(Constant.EMPNAME);

				// 検索機能の呼出
				DBController.findEmpName();
				break;

			case 3:
				// 検索する部署IDを入力
				System.out.print(Constant.FIND_DEPTID);
				String findDeptId = br.readLine();

				// 検索機能の呼出
				DBController.findDeptNo(findDeptId);
				break;

			case 4:
				// 登録する値を入力
				System.out.print(Constant.EMPNAME);
				String empName = br.readLine();
				System.out.print(Constant.INSERT_GENDER);
				String gender = br.readLine();
				System.out.print(Constant.INSERT_BIRTHDAY);
				String birthday = br.readLine();
				System.out.print(Constant.INSERT_DEPTID);
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
