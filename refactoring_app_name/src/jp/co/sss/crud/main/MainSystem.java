package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.service.IEmployeeService;

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
	 * @param employees 
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 * @throws SystemErrorException 
	 * @throws IllegalInputException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException,
			SQLException, ParseException, SystemErrorException, IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int menuNo = 0;

		do {
			// メニュー出力
			ConsoleWriter.menu();
			// メニュー番号の入力
			String menuNoStr = br.readLine();

			try {
				menuNo = Integer.parseInt(menuNoStr);

				if (menuNo != 7) {
					IEmployeeService service = IEmployeeService.getInstanceByMenuNo(menuNo);

					if (service != null) {
						service.execute();
					} else {
						// 8以上の無効な数値を入力した場合、再度メニュー選択メッセージを出力する
						ConsoleWriter.menu();
						menuNoStr = br.readLine();
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} while (menuNo != 7);
		// システム終了
		ConsoleWriter.systemEnd();
	}
}
