package erp.dao;

import erp.dto.Employee;
import erp.dto.EmployeeDetail;

public interface EmployeeDetailDao {
	EmployeeDetail selectEmployeeDetailByNo(Employee employee);
	
	int insertEmployeeDetail(EmployeeDetail employee);
	int updateEmployeeDetail(EmployeeDetail employee);
	int deleteEmployeeDetail(Employee employee);
	
	

}
