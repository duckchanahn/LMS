package view;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import global.Constants.ELoginDialog;

public class Main {

	private LoginDialog loginDialog;	
	private MainFrame mainFrame;	

	public Main() {
		ActionHandler actionHandler = new ActionHandler();
		EnterKey enterKey = new EnterKey();
		this.loginDialog = new LoginDialog(actionHandler, enterKey);
		this.loginDialog.setVisible(true);	
	}
	
	private void initialize() {
	this.loginDialog.initialize();	
	}
	
	private void loginOK() throws FileNotFoundException {
		String id = loginDialog.validateUser();
		if (id != null) {
			loginDialog.dispose();
			ActionHandler actionHandler = new ActionHandler();
			this.mainFrame = new MainFrame(actionHandler);	
			this.mainFrame.initialize(id);
		} else {
			loginDialog.saveID();
		}
	}
	private void loginCancel() {
		loginDialog.cancel();
		loginDialog.dispose();
	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			if (actionEvent.getActionCommand().equals(ELoginDialog.okButton.getString())) {
				try {
					loginOK();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else if (actionEvent.getActionCommand().equals(ELoginDialog.cancelButton.getString())) {
				loginCancel();
			}	
		if (actionEvent.getActionCommand().equals("개인정보")) {
			mainFrame.ShowMe();
		} else if (actionEvent.getActionCommand().equals("로그아웃")) {
			mainFrame.dispose();
			loginDialog.saveID();
			loginDialog.setVisible(true);
		}
	
	}
	}		
		class EnterKey implements ActionListener {
			public void actionPerformed(ActionEvent actionEvent) {
			try {loginOK();} catch (FileNotFoundException e) {e.printStackTrace();}
			}
		}

	public static void main(String[] args) {
		Main main;
		main = new Main();	
		main.initialize();		
	}									
	
}


