package view;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import global.Constants.EBasketPanel;
import global.Constants.ErrorDialog;
import valueObject.VCLecture;

public class BasketPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Vector<VCLecture> vCRows;

	private BasketList basketlist;
	private DefaultTableModel tableModel;
	String fileName;
	String basketFileName;
	String resultFileName;
	String id;
	
	
	public BasketPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.basketlist = new BasketList();
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(this.basketlist);
		scroll.getViewport().setBackground(new Color(255, 255, 245));
		this.add(scroll);
	}

	public void initialize(String id) {
		this.id = id;
	}



	private class BasketList extends JTable {
		private static final long serialVersionUID = 1L;

		public BasketList() {
			
			this.getTableHeader().setBackground(new Color(204, 255, 255)); // »ó´Ü»ö
			Vector<String> header = new Vector<String>();
			for (int i = 0; i < EBasketPanel.values().length; i++) {
				header.add(EBasketPanel.values()[i].getString());
			}

			tableModel = new DefaultTableModel(header, 0) {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			vCRows = new Vector<VCLecture>();		
			this.setModel(tableModel);
			tableHeader.setReorderingAllowed(false);
		
		}

	}

	public void addLectures(Vector<VCLecture> vCLectures) {
	
		Vector<String> rowData;
		for (VCLecture vCLecture : vCLectures) {
			rowData = new Vector<String>();
			rowData.add(vCLecture.getId());
			rowData.add(vCLecture.getName());
			rowData.add(vCLecture.getProfessorName());
			rowData.add(vCLecture.getCredit());
			rowData.add(vCLecture.getTime());

			if(Check(rowData)) {
				save(rowData);
			tableModel.addRow(rowData);
			vCRows.add(vCLectures.elementAt(0));
			//imsi.add(vCLectures.elementAt(0));
			}
		}
		this.updateUI();

	}


	private boolean Check(Vector<String> rowData) {
		Vector<Vector> check = new Vector<Vector>();
		check = tableModel.getDataVector();
		
		boolean hwakin = false;
		if (check.size() != 0) {

			int count = 0;
			for (int i = 0; i < check.size(); i++) {
				if (rowData.equals(check.elementAt(i))) {
					JOptionPane.showMessageDialog(this.getParent(), ErrorDialog.errorBM.getString(), ErrorDialog.errorBT.getString(), JOptionPane.INFORMATION_MESSAGE);
				} else {
					count++;
				}
			}
		
			if (count == check.size()) {
				hwakin = true;
				
			}
		}else if(check.size() == 0) {
			hwakin = true;
		}
		
		return hwakin;
	}
	
	public void save(Vector<String> rowData) {

		tableModel.getDataVector();
		FileWriter fw;
		try {
			fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String st = new String();
			for (int i = 0; i < rowData.size(); i++) {
				st = st + rowData.elementAt(i) + " ";
			}
			bw.write(id + " " + st);
			bw.newLine();

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void refresh(String fileName) {
		File file = new File(fileName);
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String hak = scan.next();

				Vector<String> cr = new Vector<String>();
				cr.addElement(scan.next());
				cr.addElement(scan.next());
				cr.addElement(scan.next());
				cr.addElement(scan.next());
				cr.addElement(scan.next());
				
				VCLecture vC = new VCLecture();
				vC.setId(cr.elementAt(0));
				vC.setName(cr.elementAt(1));
				vC.setProfessorName(cr.elementAt(2));
				vC.setCredit(cr.elementAt(3));
				vC.setTime(cr.elementAt(4));
		
				if (id.equals(hak)) {
					tableModel.addRow(cr);
					vCRows.add(vC);
					
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public void removeLectures() {

	      tableModel.getDataVector();
	      FileWriter fw;
	      try {
	         fw = new FileWriter(fileName);
	         BufferedWriter bw = new BufferedWriter(fw);
	         
	         String st = new String();
	         for (int i = this.tableModel.getRowCount(); i >= 0; i--) {
	            if (basketlist.isRowSelected(i)) {
	               this.tableModel.removeRow(i);
	            }
	         }
	         for (int i = 0; i < tableModel.getRowCount(); i++) {
	            for(int j = 0; j < tableModel.getColumnCount(); j++) {
	            st = st + basketlist.getValueAt(i, j) + " ";
	         }

	         }
	            if(basketlist.getRowCount() != 0) {
		   	         bw.write(id + " " + st);
		   	         bw.newLine();
		         } 
	         bw.close();

	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }

	public Vector<VCLecture> getSelectedLectures() {
		Vector<VCLecture> selectedVCLectures = new Vector<VCLecture>();
		for (int i = 0; i < basketlist.getRowCount(); i++) {
			if (basketlist.isRowSelected(i)) {
				selectedVCLectures.add(vCRows.get(i));
			}
		}
		return selectedVCLectures;
	}

	public void basketFileName() {
		this.fileName = basketFileName;
		
	}

	public void resultFileName() {
		this.fileName = resultFileName;
		
	}
	
	public void basketFile(String basketFileName) {
		this.basketFileName = basketFileName;	
		refresh(basketFileName);
		}
	
	public void resultFile(String resultFileName) {
	this.resultFileName = resultFileName;	
	refresh(resultFileName);
	}

}
