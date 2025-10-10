package jp.co.sss.crud.util;

/**
 * 
 * コンソール出力するメッセージクラス
 * 
 * @author otsuka
 */
public class Constant {
	private Constant() {
	}

	public static final String NONE = "";
	public static final String LINE = "\n";
	public static final String SPACE = "\t";
	public static final String PERCENT = "%";
	public static final String DB_EMP_ID = "emp_id";
	public static final String DB_EMP_NAME = "emp_name";
	public static final String DB_GENDER = "gender";
	public static final String DB_BIRTHDAY = "birthday";
	public static final String DB_DEPT_NAME = "dept_name";
	public static final String DB_DEPT_ID = "dept_id";
	public static final String MENU = "=== 社員管理システム ===";
	public static final String MENU_FIND_ALL = "1.全件表示";
	public static final String MENU_FIND_EMPNAME = "2.社員名検索";
	public static final String MENU_FIND_DEPTID = "3.部署ID検索";
	public static final String MENU_INSERT = "4.新規登録";
	public static final String MENU_UPDATE = "5.更新";
	public static final String MENU_DELETE = "6.削除";
	public static final String MENU_END = "7.終了";
	public static final String MENU_INPUT = "メニュー番号を入力してください：";
	public static final String GENDER_NO_ANSWER = "回答なし";
	public static final String GENDER_MAN = "男性";
	public static final String GENDER_WOMAN = "女性";
	public static final String GENDER_OTHER = "その他";
	public static final String DEPT_SALES = "営業部";
	public static final String DEPT_ACCOUNTING = "経理部";
	public static final String DEPT_GENERAL = "総務部";
	public static final String EMPNAME = "社員名:";
	public static final String BIRTHDAY = "yyyy/MM/dd";
	public static final String RESULT_COLUMN = "社員ID\t社員名\t性別\t生年月日\t部署名";
	public static final String FIND_RESULT_NONE = "該当者はいませんでした\n";
	public static final String INSERT_GENDER = "性別(0:その他, 1:男性, 2:女性, 9:回答なし):";
	public static final String INSERT_BIRTHDAY = "生年月日(西暦年/月/日):";
	public static final String INSERT_DEPTID = "部署ID(1:営業部、2:経理部、3:総務部):";
	public static final String REGIST_COMP = "社員情報を登録しました\n";
	public static final String FIND_DEPTID = "部署ID(1:営業部、2:経理部、3:総務部)を入力してください:";
	public static final String UPDATE_START_EMPID = "更新する社員の社員IDを入力してください：";
	public static final String UPDATE_COMP_EMPID = "社員情報を更新しました\n";
	public static final String DELETE_START_EMPID = "削除する社員の社員IDを入力してください：";
	public static final String DELETE_COMP = "社員情報を削除しました\n";
	public static final String END_SYSTEM = "システムを終了します。";
	public static final String MSG_ERROR_MENU = "1～7以外の数字が入力されました。";
	public static final String MSG_ERROR_INPUT = "入力方法が間違っています。";
	public static final String MSG_ERROR = "エラーが発生しました。";
}
