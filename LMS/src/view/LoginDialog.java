package view;
import java.awt.Cursor; 
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.CLogin;
import global.Constants.ELoginDialog;
import global.Constants.ErrorDialog;

public class LoginDialog extends JDialog {
	private static final long serialVersionUID = ELoginDialog.serialVersionUID.getInt(); 
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel passwordLabel;
	private JTextField passwordText;
	private JButton okButton;
	private JButton cancelButton;
	private JCheckBox saveID;

	private ImageIcon logo = new ImageIcon(ELoginDialog.Logo.getString());
	
	private ImageIcon loginimage = new ImageIcon(ELoginDialog.Login.getString());
	private ImageIcon cancelimage = new ImageIcon(ELoginDialog.Cancel.getString());
	private ImageIcon loginBtnPressed = new ImageIcon(ELoginDialog.Loginn.getString());
	private ImageIcon closeBtnPressed = new ImageIcon(ELoginDialog.Canceln.getString());
	
	private CLogin cLogin;

	public LoginDialog(ActionListener actionHandler, ActionListener enterKey) {
		
		this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	
		this.setLayout(new GridLayout(2, 1));
		this.setTitle(ELoginDialog.lTitle.getString());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JLabel image = new JLabel(logo);
		this.add(image);
		
		JPanel all = new JPanel(); // 제일 큰 패널
		all.setLayout(new GridLayout(5, 1)); 
		
		JPanel name = new JPanel();
		nameLabel = new JLabel(ELoginDialog.nameLabel.getString());	
		name.add(nameLabel);			
		nameText = new JTextField(ELoginDialog.textSize.getInt());
		nameText.addActionListener(enterKey);
		name.add(nameText);
		all.add(name);
		
		JPanel password = new JPanel();
		passwordLabel = new JLabel(ELoginDialog.passwordLabel.getString());
		password.add(passwordLabel);
		passwordText = new JPasswordField(ELoginDialog.textSize.getInt());		
		passwordText.addActionListener(enterKey);
		password.add(passwordText);
		all.add(password);
	
		JPanel save= new JPanel();
		saveID = new JCheckBox(ELoginDialog.SaveID.getString());
		save.add(saveID);
		all.add(save);
		
		JPanel button = new JPanel();
		okButton = new JButton(loginimage);
		okButton.addActionListener(actionHandler);
		okButton.setActionCommand(ELoginDialog.okButton.getString());
		button.add(okButton);

		cancelButton = new JButton(cancelimage);
		cancelButton.addActionListener(actionHandler);
		cancelButton.setActionCommand(ELoginDialog.cancelButton.getString());
		button.add(cancelButton);
		add(button);
		all.add(button);

		this.add(all);
		
		okButton.setBorderPainted(false);
		okButton.setContentAreaFilled(false);
		okButton.setFocusable(false);
		okButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				okButton.setIcon(loginBtnPressed);
				okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				okButton.setIcon(loginimage);
				okButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		cancelButton.setBorderPainted(false);
		cancelButton.setContentAreaFilled(false);
		cancelButton.setFocusable(false);
		cancelButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				cancelButton.setIcon(closeBtnPressed);
				cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				cancelButton.setIcon(cancelimage);
				cancelButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
	}
	
	public void saveID() {
		if(saveID.isSelected()) {
			passwordnull();
		}else {
			allnull();
		}
	}
	public void passwordnull() {
		passwordText.setText("");
	}
	public void allnull() {
		nameText.setText("");
		passwordText.setText("");
	}
	
	public void initialize() {
		
	}	
	public String validateUser() {
		String id = nameText.getText();
		String password = passwordText.getText();
		
		this.cLogin = new CLogin();
		boolean result = cLogin.validateUser(id, password);
		if (result) {
			return id;
		} else {
			JOptionPane.showMessageDialog(this, ErrorDialog.errorM.getString(), ErrorDialog.errorT.getString(), JOptionPane.INFORMATION_MESSAGE);
			return null;
		}		
	}
	
	public void cancel() {
		this.dispose();
	}
	

}