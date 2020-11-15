package view;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import global.Constants.EButtonCmd;
import global.Constants.EButtonImg;

public class MovePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JButton leftButton;
	private JButton rightButton;
	
	private ImageIcon moveBtn;
	private ImageIcon removeBtn;
	private ImageIcon moveBtnPressed;
	private ImageIcon removeBtnPressed;
	
	public JButton getLeftButton() {
		return leftButton;
	}

	public JButton getRightButton() {
		return rightButton;
	}

	public MovePanel(ActionListener actionHandler){
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		moveBtn = new ImageIcon(EButtonImg.moveBtn.getString());
		removeBtn = new ImageIcon(EButtonImg.removeBtn.getString());
		moveBtnPressed = new ImageIcon(EButtonImg.moveBtnPressed.getString());
		removeBtnPressed = new ImageIcon(EButtonImg.removeBtnPressed.getString());
		
		this.rightButton = new JButton(moveBtn);
		this.rightButton.addActionListener(actionHandler);
		this.rightButton.setActionCommand(EButtonCmd.rightBtn.getString());
		this.add(this.rightButton);
		
		this.leftButton = new JButton(removeBtn);
		this.leftButton.addActionListener(actionHandler);
		this.leftButton.setActionCommand(EButtonCmd.leftBtn.getString());
		this.add(this.leftButton);
		
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusable(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(removeBtnPressed);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(removeBtn);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusable(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(moveBtnPressed);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(moveBtn);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
	}
	
	public void initialize(){
		
	}
}
