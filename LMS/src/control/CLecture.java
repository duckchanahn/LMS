package control;

import java.util.Vector;

import model.MLecture;
import valueObject.VCLecture;
import valueObject.VMLecture;

public class CLecture {
	
	private MLecture mLecture;
	private Vector<VCLecture> vCLectures;
	
	public CLecture() {
		this.mLecture = new MLecture();
		
	}
	
	public Vector<VCLecture> getData(String fileName) {
		Vector<VMLecture> vMLectures = this.mLecture.getData(fileName);
		this.vCLectures = new Vector<VCLecture>();
		
		for(VMLecture vMLecture: vMLectures) {
			VCLecture vcLecture = new VCLecture();
			vcLecture.setId(vMLecture.getId());
			vcLecture.setName(vMLecture.getName());
			vcLecture.setProfessorName(vMLecture.getProfessorName());
			vcLecture.setCredit(vMLecture.getCredit());
			vcLecture.setTime(vMLecture.getTime());
		      this.vCLectures.add(vcLecture);	   
		      
		}

		
		return vCLectures;
		
	}
	
	
}
