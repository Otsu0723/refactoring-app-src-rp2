package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.Constant;

/**
 * 部署DTO
 * 
 * @author otsuka
 */
public class Department {
	/** 部署ID */
	private Integer deptId;
	/** 部署名 */
	private String deptName;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		String deptIdString = Constant.DB_DEPT_ID;
		int deptName = Integer.parseInt(deptIdString);
		if (deptName == 1) {
			System.out.println(Constant.DEPT_SALES);
		} else if (deptName == 2) {
			System.out.println(Constant.DEPT_ACCOUNTING);
		} else if (deptName == 3) {
			System.out.println(Constant.DEPT_GENERAL);
		}

		return deptId + Constant.SPACE + deptName + Constant.LINE;
	}
}
