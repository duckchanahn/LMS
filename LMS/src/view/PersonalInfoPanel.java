package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.CPersonalInfo;
import global.Constants.EPersonalInfo;
import valueObject.VCPersonalInfo;

public class PersonalInfoPanel extends JPanel implements Runnable{
	private static final long serialVersionUID = EPersonalInfo.serialVersionUID.getInt();

	private JLabel grade, gwa, number, name;
	private JButton infoButton, logoutButton;
	private JLabel nameInfo, gradeInfo, gwaInfo, idInfo;
	private Thread thread;
	private String now;
	private JLabel time;
	private JLabel hwan;
	
	private ImageIcon pInfoBtn = new ImageIcon(EPersonalInfo.InfoImage.getString());
	private ImageIcon logoutBtn = new ImageIcon(EPersonalInfo.LogoutImage.getString());
	private ImageIcon info_n = new ImageIcon(EPersonalInfo.Infon.getString());
	private ImageIcon logout_n = new ImageIcon(EPersonalInfo.Logoutn.getString());
	
	public PersonalInfoPanel(ActionListener actionHandler) {
		this.setLayout(new GridLayout(1, 1));
	
		JPanel all = new JPanel();
		all.setBackground(Color.LIGHT_GRAY);
		all.setLayout(new GridLayout(1, 5));
		
		JPanel bin;
		
		time = new JLabel();
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
		//this.add(time);
		all.add(time);
		
		time.setText(now);
		JPanel timePanel = new JPanel();
		timePanel.add(time);
		//this.add(time);
		all.add(time);
		
		bin = new JPanel();
		bin.setBackground(Color.LIGHT_GRAY);
		//this.add(bin);
		//all.add(bin);
		
		this.hwan = new JLabel();
		
		all.add(hwan);

		JPanel button = new JPanel();
		button.setBackground(Color.LIGHT_GRAY);
		this.infoButton = new JButton(pInfoBtn);
		this.infoButton.addActionListener(actionHandler);
		this.infoButton.setActionCommand(EPersonalInfo.btnInfo.getString());
		button.add(this.infoButton);	//개인정보
		infoButton.setBorderPainted(false);
		infoButton.setContentAreaFilled(false);
		infoButton.setFocusable(false);
		infoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				infoButton.setIcon(info_n);
				infoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				infoButton.setIcon(pInfoBtn);
				infoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.logoutButton = new JButton(logoutBtn);
		this.logoutButton.addActionListener(actionHandler);
		this.logoutButton.setActionCommand(EPersonalInfo.btnLogout.getString());
		button.add(this.logoutButton);	//로그아웃
		logoutButton.setBorderPainted(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setFocusable(false);
		logoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logoutButton.setIcon(logout_n);
				logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				logoutButton.setIcon(logoutBtn);
				logoutButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		all.add(button);
		
		this.add(all);
		
		grade = new JLabel();
		gwa = new JLabel();
		number = new JLabel();
		name = new JLabel();
	}

	public void initialize(String id) {
		this.showPersonalInfo(id);
		
	}
	public void run() {
		while (true) {
			Calendar cal = Calendar.getInstance();
			now = (cal.get(Calendar.MONTH) + 1) + "월 "
					+ cal.get(Calendar.DATE) + "일 "
					+ cal.get(Calendar.HOUR) + " : "
					+ cal.get(Calendar.MINUTE) + " : " 
					+ cal.get(Calendar.SECOND);
			time.setText(now);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void showPersonalInfo(String id) {
		CPersonalInfo cPersonalInfo = new CPersonalInfo();
		VCPersonalInfo vPersonalInfo = cPersonalInfo.getPersonalInfo(id);
		this.hwan.setText(EPersonalInfo.empty.getString() + vPersonalInfo.getName() + EPersonalInfo.lbInsaPostfix.getString());
		this.name.setText(vPersonalInfo.getName());
		this.number.setText(vPersonalInfo.getId());
		this.grade.setText(vPersonalInfo.getGrade());
		this.gwa.setText(vPersonalInfo.getGwa());
	}

	public void ShowMe() {

		JDialog show = new JDialog();
		show.setSize(EPersonalInfo.width.getInt(), EPersonalInfo.height.getInt());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		show.setLocation(dim.width / 2 - show.getSize().width / 2, dim.height / 2 - show.getSize().height / 2);

		show.setTitle(EPersonalInfo.btnInfo.getString());
		show.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);		
		show.setLayout(new GridLayout(1, 3));
		
		JPanel left = new JPanel();
		left.setLayout(new GridLayout(4,1));
		JPanel right = new JPanel();
		right.setLayout(new GridLayout(4,1));
		
		this.idInfo = new JLabel(EPersonalInfo.id.getString());
		this.nameInfo = new JLabel(EPersonalInfo.name.getString());
		this.gradeInfo = new JLabel(EPersonalInfo.grade.getString());
		this.gwaInfo = new JLabel(EPersonalInfo.hakgwa.getString());
		
		left.add(idInfo);
		left.add(nameInfo);
		left.add(gradeInfo);
		left.add(gwaInfo);
	
		right.add(number);
		right.add(name);
		right.add(grade);
		right.add(gwa);
		
		show.add(left);
		show.add(right);
		
		show.setVisible(true);

	}


}
