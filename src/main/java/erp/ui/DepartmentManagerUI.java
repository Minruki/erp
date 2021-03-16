package erp.ui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import erp.dto.Department;
import erp.service.DepartmentService;
import erp.ui.content.AbstractContentPanel;
import erp.ui.content.DepartmentPanel;
import erp_ui.list.AbstractCustomTablePanel;
import erp_ui.list.DepartmentTablePanel;

@SuppressWarnings("serial")
public class DepartmentManagerUI extends AbstractManagerUI<Department> {
	private DepartmentService service;
	
	@Override
	protected void setService() {
		service = new DepartmentService();
	}

	@Override
	protected void tableLoadData() {
		((DepartmentTablePanel)pList).setService(service);
		pList.loadData();
		
	}

	@Override
	protected AbstractContentPanel<Department> createContentPanel() {
		
		return pContent = new DepartmentPanel();
	}

	@Override
	protected AbstractCustomTablePanel<Department> createTablePanel() {
		
		return new DepartmentTablePanel();
	}

	@Override
	protected void actionPerformedMenuGubun() {
		throw new UnsupportedOperationException("제공되지 않음");
		
		
	}

	@Override
	protected void actionPerformedMenuUpdate() {
		Department updateDept = pList.getItem();
		pContent.setItem(updateDept);
		btnAdd.setText("수정");
		
	}

	@Override
	protected void actionPerformedMenuDelete() {
		Department delDept = pList.getItem();
		service.removeDepartment(delDept);
		pList.loadData();
		JOptionPane.showMessageDialog(null, delDept + "삭제 되었습니다.");
		
	}

	@Override
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Department updateDept = pContent.getItem();
		service.modifyDepartment(updateDept);
		pList.loadData();
		pContent.clearTf();
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, updateDept.getDeptName() + "정보가 수정되었습니다.");
		
	}

	@Override
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Department addDept = pContent.getItem();
		service.addDepartment(addDept);
		pList.loadData();
		pContent.clearTf();
		JOptionPane.showMessageDialog(null, addDept + " 추가했습니다.");
		
	}

}
