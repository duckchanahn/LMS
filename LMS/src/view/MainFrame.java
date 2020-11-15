package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import global.Constants.EGMainFrame;
import global.Constants.ETMainFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = EGMainFrame.serialVersionUID.getInt();
	private PersonalInfoPanel personalInfo;
	private RegistrationPanel registration;
	private JPanel switchPanel;

	private ImageIcon damgiBtn;
	private ImageIcon sincheongBtn;
	private ImageIcon damgiBtnPressed;
	private ImageIcon sincheongBtnPressed;
	
	// constructor
	public MainFrame(ActionListener actionHandler) {
		// 메인에서 new MainFrame() 호출할 때 여기 컨스트럭터가 실행됨.

		// attributes
		this.setTitle(ETMainFrame.title.getString());
		this.setSize(EGMainFrame.width.getInt(), EGMainFrame.height.getInt());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이건 그냥 외우기. 프로그램 종료 문장

		damgiBtn = new ImageIcon(EGMainFrame.damgiBtn.getString());
		sincheongBtn = new ImageIcon(EGMainFrame.sincheongBtn.getString());
		damgiBtnPressed = new ImageIcon(EGMainFrame.damgiBtnPressed.getString());
		sincheongBtnPressed = new ImageIcon(EGMainFrame.sincheongBtnPressed.getString());
		
		// components
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager); // 화면 꽉 채워오기..
		
		switchPanel = new JPanel();
		switchPanel.setLayout(new BoxLayout(switchPanel, BoxLayout.Y_AXIS));
		ActionListener actionListener = new ActionHandler();

		this.personalInfo = new PersonalInfoPanel(actionHandler);
		this.personalInfo.setBackground(Color.LIGHT_GRAY);
		switchPanel.add(this.personalInfo);

		JPanel layout = new JPanel();	
		JButton damgi = new JButton(damgiBtn);
		damgi.addActionListener(actionListener);
		damgi.setActionCommand(ETMainFrame.damgiBtn.getString());
		JButton sincheong = new JButton(sincheongBtn);
		sincheong.addActionListener(actionListener);
		sincheong.setActionCommand(ETMainFrame.sincheongBtn.getString());
		
		layout.add(damgi);
		layout.add(sincheong);
		switchPanel.add(layout);

		damgi.setBorderPainted(false);
		damgi.setContentAreaFilled(false);
		damgi.setFocusable(false);
		damgi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				damgi.setIcon(damgiBtnPressed);
				damgi.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				damgi.setIcon(damgiBtn);
				damgi.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		sincheong.setBorderPainted(false);
		sincheong.setContentAreaFilled(false);
		sincheong.setFocusable(false);
		sincheong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sincheong.setIcon(sincheongBtnPressed);
				sincheong.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				sincheong.setIcon(sincheongBtn);
				sincheong.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});	
		
		this.registration = new RegistrationPanel(this.personalInfo);

		this.setVisible(true);
	}

	public void initialize(String id) throws FileNotFoundException {
		// 자신이 할 일 하고 자식 초기화, 자식 생성.
		this.Damgi();
		this.personalInfo.initialize(id);
		this.registration.initialize(id);// 장바구니, 수강신청 등록한 것 저장하려면 id 던져줘야 함.
	}

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(ETMainFrame.damgiBtn.getString())) {
				
					registration.Ddamgi();
					Damgi();
					try {
						Thread.sleep(1000);

					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					
			}else if(e.getActionCommand().equals(ETMainFrame.sincheongBtn.getString())) {	
					registration.Dsincheong();
					Sincheong();
					try {
						Thread.sleep(1000);

					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					
			}
		}
	}
	public void Damgi() {
		this.add(switchPanel, BorderLayout.NORTH);
		this.registration.Damgi();
		this.add(this.registration, BorderLayout.CENTER);
	}
	

	public void Sincheong() {
		this.add(switchPanel, BorderLayout.NORTH);
		this.registration.Sincheong();
		this.add(this.registration, BorderLayout.CENTER);

	}

	public void ShowMe() {
		this.personalInfo.ShowMe();

	}

}
