package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import valueObject.VCLecture;

public class RegistrationPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private SelectionPanel selectionPanel;
	private MovePanel movePanel1;
	private BasketPanel basketPanel;
	private MovePanel movePanel2;
	private BasketPanel resultPanel;
	ActionListener actionHandler;
	String basketFileName = "Data/basketFile";
	String resultFileName = "Data/resultFile";
	
	public RegistrationPanel(PersonalInfoPanel personalInfo) {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.selectionPanel = new SelectionPanel();
//		this.add(this.selectionPanel);

		actionHandler = new ActionHandler();
		this.movePanel1 = new MovePanel(this.actionHandler);
//		this.add(this.movePanel1);

		this.basketPanel = new BasketPanel();
//		this.add(this.basketPanel);

		this.movePanel2 = new MovePanel(this.actionHandler);
//		this.add(this.movePanel2);

		this.resultPanel = new BasketPanel();

//		this.add(this.resultPanel);

	}

	public void initialize(String id) throws FileNotFoundException {
		this.selectionPanel.initialize(id);
		this.basketPanel.initialize(id);
		this.resultPanel.initialize(id);
		basketPanel.basketFile(basketFileName);
		resultPanel.resultFile(resultFileName);


		// 기말고사에 구현해야 할 것들.

	}
	private void moveLecturesToBasket() {
		Vector<VCLecture> selectedLectures = this.selectionPanel.getSelectedLectures();
		System.out.println(selectedLectures.size());
		this.basketPanel.addLectures(selectedLectures);
	}

	private void removeLecturesInBasket() {
		this.basketPanel.removeLectures();
	}

	public void moveBasketToResult() {
		Vector<VCLecture> selectedLectures = this.basketPanel.getSelectedLectures();
		this.resultPanel.addLectures(selectedLectures);
	}

	public void removeResultInBasket() {
		this.resultPanel.removeLectures();

	}

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource().equals(movePanel1.getLeftButton())) {
				basketPanel.basketFileName();
				removeLecturesInBasket();
				
			} else if (e.getSource().equals(movePanel1.getRightButton())) {
				basketPanel.basketFileName();
				moveLecturesToBasket();

			} else if (e.getSource().equals(movePanel2.getLeftButton())) {
				resultPanel.resultFileName();
				removeResultInBasket();

			} else if (e.getSource().equals(movePanel2.getRightButton())) {
				resultPanel.resultFileName();
				moveBasketToResult();

			}
		}
	}

	public void Damgi() {		
		this.add(this.selectionPanel);
		this.add(this.movePanel1);
		this.add(this.basketPanel);
	}

	public void Sincheong() {	
		this.add(this.basketPanel);
		this.add(this.movePanel2);
		this.add(this.resultPanel);
		
	}

	public void Dsincheong() {
		this.remove(this.selectionPanel);
		this.remove(this.movePanel1);
		this.remove(this.basketPanel);	
		
	}

	public void Ddamgi() {
		this.remove(this.basketPanel);
		this.remove(this.movePanel2);
		this.remove(this.resultPanel);		
	}
}
