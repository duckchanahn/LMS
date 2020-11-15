package global;

public class Constants {

	// final�� ���� ��� ǥ��
	// �빮�ڷ� ���� ��κ� ��� (������ ��)
	public static enum EDataFileName {
		serialVersionUID("1"), 
		path("Data/"), 
		root("root"), 
		login("login"), 
		personalInfo("student"), 
		refresh("englishYG");

		private String value;

		private EDataFileName(String value) {
			// constructor
			this.value = value;
		}

		public String getString() {
			return this.value;
		}

	}

	public static enum ETMainFrame { // static = new���� �ʾƵ� �ڵ����� �Ҵ�
		serialVersionUID("1"), title("������û"),
		damgiBtn("damgi"), sincheongBtn("sincheong");
		// ���� �о������ ���� ""�� null�� �س��� ���� �о������ �ϸ� ��.
		private String value;

		private ETMainFrame(String value) {
			// constructor
			this.value = value;
		}
//
//		public int getInt() {
//			return Integer.parseInt(this.value);
//		}

		public String getString() {
			return this.value;
		}

	}

	public static enum EGMainFrame {
		serialVersionUID("1"), width("1000"), height("700"),
		damgiBtn("images/basket.png"), sincheongBtn("images/sugang.png"),
		damgiBtnPressed("images/basket_n.png"), sincheongBtnPressed("images/sugang_n.png");



		// ���� �о������ ���� ""�� null�� �س��� ���� �о������ �ϸ� ��.
		private String value;

		private EGMainFrame(String value) {
			// constructor
			this.value = value;
		}

		public int getInt() {
			return Integer.parseInt(this.value);
		}

		public String getString() {
			return this.value;
		}
	}

	public static enum ELoginDialog {
		serialVersionUID("1"),
		width("350"), height("450"), textSize("15"), 
		lTitle("�α���"), 
		nameLabel("���̵�    "), passwordLabel("��й�ȣ"),
		okButton("Login"), cancelButton("Cancel"),
		Logo("images/logo.png"), 
		Login("images/login.png"),Cancel("images/cancel.png"), 
		Loginn("images/login_n.png"), Canceln("images/cancel_n.png"), 
		SaveID("���̵� ����");

		private String value;

		private ELoginDialog(String value) {
			
			this.value = value;
		}

		public int getInt() {
			return Integer.parseInt(this.value);
		}

		public String getString() {
			return this.value;
		}
		public long getLong() {
			return Long.parseLong(this.value);
		}
	}

	
	public static enum EPersonalInfo {
		serialVersionUID("1"), 
		lbInsaPostfix("�� ȯ���մϴ�. >"), 
		empty("                               < "),
		width("250"), height("200"),
		btnInfo("��������"), btnLogout("�α׾ƿ�"),
		InfoImage("images/info.png"),LogoutImage("images/logout.png"),
		Infon("images/info_n.png"),
		Logoutn("images/logout_n.png"),
		id("              �й�      : "), 
		name("              �̸�     : "), 
		grade("              �г�     : "), 
		hakgwa("              �а�     : ");


		private String value;

		private EPersonalInfo(String value) {
			// constructor
			this.value = value;
		}

		public int getInt() {
			return Integer.parseInt(this.value);
		}

		public String getString() {
			return this.value;
		}
	}
	public static enum EDirectoryPanel {
		serialVersionUID("1"),
		campus("����"),
		college("�а�"), 
		sub("����");

		private String value;

		private EDirectoryPanel(String value) {
			// constructor
			this.value = value;
		}

		public int getInt() {
			return Integer.parseInt(this.value);
		}

		public String getString() {
			return this.value;
		}
	}

	public static enum ELecturePanel {
		serialVersionUID("1"),
		number("�����ȣ"),
		name("�����"),
		pro("������"),
		hak("����"),
		time("�ð�");

		private String value;

		private ELecturePanel(String value) {
			// constructor
			this.value = value;
		}

		public int getInt() {
			return Integer.parseInt(this.value);
		}

		public String getString() {
			return this.value;
		}
	}

	public static enum ErrorDialog {
		serialVersionUID("1"), errorM("Ʋ�Ƚ��ϴ�."), errorT("�α��� ����"),
		errorBM("�ߺ��� �����Դϴ�."), errorBT("������û ����");

		private String value;

		private ErrorDialog(String value) {
			// constructor
			this.value = value;
		}

		public int getInt() {
			return Integer.parseInt(this.value);
		}

		public String getString() {
			return this.value;
		}

	}

	public static enum EBasketPanel{
		number("�����ȣ"),
		name("�����"),
		pro("������"),
		hak("����"),
		time("�ð�");
		
		private String value;
		private EBasketPanel(String value){
			this.value = value;
		}
		public String getString(){
			return  this.value;
		}
		public int getInt() {
			return Integer.parseInt(this.value);
		}
	}
	
	public static enum EButtonImg{
		moveBtn("images/sincheong.png"), removeBtn("images/delete.png"),
		moveBtnPressed("images/sincheong_n.png"),removeBtnPressed("images/delete_n.png");
		
		private String value;
		private EButtonImg(String value) {
			this.value = value;
		}
		public String getString(){
			return  this.value;
		}
		public int getInt() {
			return Integer.parseInt(this.value);
		}
	}
	
	public static enum EButtonCmd{
		rightBtn("rightButton"), leftBtn("leftButton");
		
		private String value;
		private EButtonCmd(String value) {
			this.value = value;
		}
		public String getString(){
			return  this.value;
		}
		public int getInt() {
			return Integer.parseInt(this.value);
		}
	}
	

}