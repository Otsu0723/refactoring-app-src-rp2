package jp.co.sss.crud.io;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.Constant;

public class ConsoleWriter {

	public String toString() {
		return null;
	}

	// メニュー表示
	public static void menu() {
		System.out.println(Constant.MENU);
		System.out.println(Constant.MENU_FIND_ALL);
		System.out.println(Constant.MENU_FIND_EMPNAME);
		System.out.println(Constant.MENU_FIND_DEPTID);
		System.out.println(Constant.MENU_INSERT);
		System.out.println(Constant.MENU_UPDATE);
		System.out.println(Constant.MENU_DELETE);
		System.out.println(Constant.MENU_END);
		System.out.print(Constant.MENU_INPUT);
	}

	// 全件表示 findAll
	public static void showEmployees(List<Employee> employees)
			throws ClassNotFoundException, SQLException, SystemErrorException, IllegalInputException {

		if (employees.isEmpty()) {
			System.out.println(Constant.FIND_RESULT_NONE);
		} else {
			System.out.println(Constant.RESULT_COLUMN);
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		}
	}

	// 社員名検索(社員名：)
	public static void findByEmpName() {
		System.out.print(Constant.EMPNAME);
	}

	// 部署名選択
	public static void findByDeptId() {
		System.out.print(Constant.FIND_DEPTID);
	}

	// 性別選択
	public static void insertGender() {
		System.out.print(Constant.INSERT_GENDER);
	}

	// 生年月日入力
	public static void insertBirthday() {
		System.out.print(Constant.INSERT_BIRTHDAY);
	}

	// 部署選択
	public static void insertDeptId() {
		System.out.print(Constant.INSERT_DEPTID);
	}

	// 登録完了メッセージ
	public static void registComp() {
		System.out.println(Constant.REGIST_COMP);
	}

	// 更新する社員情報の選択
	public static void update() {
		System.out.print(Constant.UPDATE_START_EMPID);
	}

	// 更新完了メッセージ
	public static void updateComp() {
		System.out.print(Constant.UPDATE_COMP_EMPID);
	}

	// 削除する社員の社員ID選択メッセージ
	public static void delete() {
		System.out.print(Constant.DELETE_START_EMPID);
	}
}
