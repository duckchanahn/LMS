package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import valueObject.VCLecture;

public class SelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private DirectoryPanel directoryPanel;
	private LecturePanel lecturePanel;
	private JPanel search;
	private Vector<String> get;

	public SelectionPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		MyMouseListener listSelectionListener = new MyMouseListener();
		
		this.search = new JPanel();
		JLabel la = new JLabel("강좌명: ");
		JTextField text = new JTextField(15);
		JButton btn = new JButton("검색");
		btn.setActionCommand("search");
		search.add(la);
		search.add(text);
		search.add(btn);
		this.add(search);
		
		this.directoryPanel = new DirectoryPanel(listSelectionListener);
		this.add(this.directoryPanel);
		
		this.lecturePanel = new LecturePanel();
		this.add(this.lecturePanel);
	}

	public void initialize(String id) {
		this.directoryPanel.initialize(id);
		this.lecturePanel.initialize(id);
		this.getSearch();

	}
	
	public void getSearch() {
		get = new Vector<String>();
		get=this.directoryPanel.getSearch();
	}
	public void setSearch() {
		this.lecturePanel.setSearch(get);
		
	}
	public Vector<VCLecture> getSelectedLectures() {

		return this.lecturePanel.getSelectedLectures();
	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
		
			if (actionEvent.getActionCommand().equals("search")) {
				setSearch();
			} else {
			}										//메인프레임 제어
		}		
	}
	public class MyMouseListener extends MouseAdapter {
		
	    @Override
	    public void mouseClicked(MouseEvent e) {
	    if (e.getButton() == 1) {
			String fileName = directoryPanel.refresh(e.getSource());
			try {
				lecturePanel.refresh(fileName);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

} //클릭
	  
	}
	}

}