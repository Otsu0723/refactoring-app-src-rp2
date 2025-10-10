package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.Constant;

/**
 * 社員情報DTO
 *  * 
 * @author otsuka
 */
public class Employee {

	/** 社員ID */
	private Integer empId;
	/** 社員名 */
	private String empName;
	/** 性別 */
	private int gender;
	/** 生年月日 */
	private String birthday;
	//	/** 部署ID */
	//	private Integer deptId;
	/** 部署名 */
	private String deptName;
	private Department department;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		String genderStr = Constant.NONE;
		if (gender == 0) {
			genderStr = Constant.GENDER_NO_ANSWER;
		} else if (this.gender == 1) {
			genderStr = Constant.GENDER_MAN;
		} else if (this.gender == 2) {
			genderStr = Constant.GENDER_WOMAN;
		} else if (gender == 9) {
			genderStr = Constant.GENDER_OTHER;
		}

		return empId + Constant.SPACE + empName + Constant.SPACE + genderStr
				+ Constant.SPACE + birthday + Constant.SPACE + department.getDeptName();
	}

}
