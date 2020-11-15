package view;

import java.awt.Color;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CDirectory;
import global.Constants.EDataFileName;
import global.Constants.EDirectoryPanel;
import valueObject.VCDirectory;
import view.SelectionPanel.MyMouseListener;

public class DirectoryPanel extends JPanel {
	private static final long serialVersionUID = EDirectoryPanel.serialVersionUID.getInt();

	private DirectoryList directoryList1;
	private DirectoryList directoryList2;
	private DirectoryList directoryList3;
	JScrollPane scrollpane;
	Vector<String> send = new Vector<String>();

	Vector<String> header = new Vector<String>();

	public DirectoryPanel(MyMouseListener listSelectionListener) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		scrollpane = new JScrollPane(); // 디렉토리 리스트를 붙인다.
		header.add(EDirectoryPanel.campus.getString());
		directoryList1 = new DirectoryList();
		directoryList1.addMouseListener(listSelectionListener);
		scrollpane.setViewportView(directoryList1);
		scrollpane.getViewport().setBackground(new Color(255, 255, 245));
		this.add(scrollpane);
		// 부모에게 붙일 때 싸고있는 얘 한테 붙여야 함. 디렉토리 리스트를 스크롤 패인으로 아예 만들면 new만 해도 가능. 나중에 리팩토리할 예정

		scrollpane = new JScrollPane(); // 디렉토리 리스트를 붙인다.
		header.clear();
		header.add(EDirectoryPanel.college.getString());
		directoryList2 = new DirectoryList();
		directoryList2.addMouseListener(listSelectionListener);
		scrollpane.setViewportView(directoryList2);
		scrollpane.getViewport().setBackground(new Color(255, 255, 245));
		this.add(scrollpane);

		scrollpane = new JScrollPane(); // 디렉토리 리스트를 붙인다.
		header.clear();
		header.add(EDirectoryPanel.sub.getString());
		directoryList3 = new DirectoryList();
		directoryList3.addMouseListener(listSelectionListener);
		scrollpane.setViewportView(directoryList3);
		scrollpane.getViewport().setBackground(new Color(255, 255, 245));
		this.add(scrollpane);

	}

	public void initialize(String id) {
		this.refresh(null);

		this.directoryList1.initialize(id);
		this.directoryList2.initialize(id);
		this.directoryList3.initialize(id);
	}

	public String refresh(Object source) {

		String fileName = "";

		if (source == null) {
			this.directoryList1.refresh(EDataFileName.root.getString());
			fileName = this.directoryList1.getSelectedFile();
			this.directoryList2.refresh(fileName);
			fileName = this.directoryList2.getSelectedFile();
			this.directoryList3.refresh(fileName);
			fileName = this.directoryList3.getSelectedFile();
		} else if (source.equals(directoryList1)) {
			fileName = this.directoryList1.getSelectedFile();
			this.directoryList2.refresh(fileName);
			fileName = this.directoryList2.getSelectedFile();
			this.directoryList3.refresh(fileName);
			fileName = this.directoryList3.getSelectedFile();
		} else if (source.equals(this.directoryList2)) {
			fileName = this.directoryList2.getSelectedFile();
			this.directoryList3.refresh(fileName);
			fileName = this.directoryList3.getSelectedFile();
		} else if (source.equals(this.directoryList3)) {
			fileName = this.directoryList3.getSelectedFile();
		}
		return fileName;
	}

	private class DirectoryList extends JTable {
		private static final long serialVersionUID = 1L;
		// 스트링 타입으로 어레이를 넣겠다.
		private Vector<String> listData;
		private CDirectory cDirectory;
		private Vector<VCDirectory> vCDirectories;
		DefaultTableModel model;

		public DirectoryList() {
			this.getTableHeader().setBackground(new Color(204, 255, 255));
			model = new DefaultTableModel(header, 0) {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
				};
				this.getTableHeader().setReorderingAllowed(false);
			// this.listData = new Vector<String>();
			this.cDirectory = new CDirectory();
			this.setModel(model);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		}

		public void initialize(String id) {
			for(int i =0; i<this.getRowCount(); i++) {
				send.add(vCDirectories.get(i).getFileName());
		}
			
	
		}
		public String getSelectedFile() {

			if (getSelectedRow() != -1) {
				String fileName = vCDirectories.get(getSelectedRow()).getFileName();
				return fileName;

			}
			return null;
		}

		public void refresh(String fileName) {
			model.setRowCount(0);

			if (fileName == null)
				return;
			vCDirectories = cDirectory.getCampusData(fileName); // 이름과 파일 네임 두가지 가진 밸류

			for (VCDirectory vCDirectory : vCDirectories) {
				this.listData = new Vector<String>();

				// this.listData.clear();
				this.listData.add(vCDirectory.getText());
				model.addRow(listData);

			}
			this.getSelectionModel().addSelectionInterval(0, 0);
			this.updateUI();

		}
	}
	public Vector<String> getSearch() {
		Vector<String> set = new Vector<String>();
		
		set = send;
		return set;

	}

}