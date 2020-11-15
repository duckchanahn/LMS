package view;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import global.Constants.EDataFileName;
import global.Constants.ELecturePanel;
import valueObject.VCLecture;

public class LecturePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	LectureList lectureList;
	private CLecture cLecture;
	private Vector<VCLecture> vCLectures;
//	DefaultTableModel model;
	Vector<String> header = new Vector<String>();
	JScrollPane scrollpane;
	Vector<VCLecture> selectedVCLectures;

	public LecturePanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.lectureList = new LectureList();
		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().setBackground(new Color(255, 255, 245));
		scroll.setViewportView(this.lectureList);
		this.add(scroll);

	}

	public void initialize(String id) {
		try {
			this.refresh(EDataFileName.refresh.getString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void refresh(String fileName) throws FileNotFoundException {
		
		this.cLecture = new CLecture();
		this.vCLectures = cLecture.getData(fileName);

		this.lectureList.addRows(this.vCLectures);
	}

	public class LectureList extends JTable {
		private static final long serialVersionUID = 1L;
		// 스트링 타입으로 어레이를 넣겠다.

		private DefaultTableModel tableModel;

		public LectureList() {
			
			this.getTableHeader().setBackground(new Color(204, 255, 255)); // 상단색
			Vector<String> header = new Vector<String>();
			for (int i = 1; i < ELecturePanel.values().length; i++) {
				header.add(ELecturePanel.values()[i].getString());
			}

			tableModel = new DefaultTableModel(header, 0) {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			this.getTableHeader().setReorderingAllowed(false);
			// System.out.println(header);
			this.setModel(tableModel);
		}

		public void addRows(Vector<VCLecture> vCLectures) {
			tableModel.setRowCount(0);
			Vector<String> rowData;

			for (VCLecture vCLecture : vCLectures) {
				rowData = new Vector<String>();
				rowData.add(vCLecture.getId());
				rowData.add(vCLecture.getName());
				rowData.add(vCLecture.getProfessorName());
				rowData.add(vCLecture.getCredit());
				rowData.add(vCLecture.getTime());
				this.tableModel.addRow(rowData);
			}
			this.getSelectionModel().addSelectionInterval(0, 0);
			this.updateUI();
			
		}

	}

	public Vector<VCLecture> getSelectedLectures() {
		selectedVCLectures = new Vector<VCLecture>();
		
//		System.out.println(vCLectures.);
		for (int i = 0; i < lectureList.getRowCount(); i++) {
			if (lectureList.isRowSelected(i)) {
				selectedVCLectures.add(vCLectures.get(i));
			}
		}
		return selectedVCLectures;
	}

	public void setSearch(Vector<String> get) {
		for(int i =7; i<get.size(); i++) {
			try {
				this.refresh(get.elementAt(i));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		

		
	}

}