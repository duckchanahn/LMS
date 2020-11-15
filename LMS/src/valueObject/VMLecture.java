package valueObject;

import java.util.Scanner;

//강좌변호 과목명 교수명 학점 시간
public class VMLecture {

	String id;
	String Name;
	String ProfessorName;
	String Credit;
	String Time;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getProfessorName() {
		return ProfessorName;
	}
	public void setProfessorName(String professorName) {
		ProfessorName = professorName;
	}
	public String getCredit() {
		return Credit;
	}
	public void setCredit(String credit) {
		Credit = credit;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}

	public void readFromFile(Scanner scan) {

		this.id = scan.next();
		this.Name = scan.next();
		this.ProfessorName = scan.next();
		this.Credit = scan.next();
		this.Time = scan.next();

	}

}
