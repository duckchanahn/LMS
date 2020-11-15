package global;

public class Constants {

	// final은 보통 상수 표현
	// 대문자로 쓴건 대부분 상수 (고정된 값)
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

	public static enum ETMainFrame { // static = new하지 않아도 자동으로 할당
		serialVersionUID("1"), title("수강신청"),
		damgiBtn("damgi"), sincheongBtn("sincheong");
		// 파일 읽어오려면 위에 ""들 null로 해놓고 파일 읽어오도록 하면 됨.
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



		// 파일 읽어오려면 위에 ""들 null로 해놓고 파일 읽어오도록 하면 됨.
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
		lTitle("로그인"), 
		nameLabel("아이디    "), passwordLabel("비밀번호"),
		okButton("Login"), cancelButton("Cancel"),
		Logo("images/logo.png"), 
		Login("images/login.png"),Cancel("images/cancel.png"), 
		Loginn("images/login_n.png"), Canceln("images/cancel_n.png"), 
		SaveID("아이디 저장");

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
		lbInsaPostfix("님 환영합니다. >"), 
		empty("                               < "),
		width("250"), height("200"),
		btnInfo("개인정보"), btnLogout("로그아웃"),
		InfoImage("images/info.png"),LogoutImage("images/logout.png"),
		Infon("images/info_n.png"),
		Logoutn("images/logout_n.png"),
		id("              학번      : "), 
		name("              이름     : "), 
		grade("              학년     : "), 
		hakgwa("              학과     : ");


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
		campus("대학"),
		college("학과"), 
		sub("과목");

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
		number("과목번호"),
		name("과목명"),
		pro("교수명"),
		hak("학점"),
		time("시간");

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
		serialVersionUID("1"), errorM("틀렸습니다."), errorT("로그인 실패"),
		errorBM("중복된 과목입니다."), errorBT("수강신청 실패");

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
		number("과목번호"),
		name("과목명"),
		pro("교수명"),
		hak("학점"),
		time("시간");
		
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