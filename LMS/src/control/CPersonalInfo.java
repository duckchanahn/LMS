package control;

import model.MPersonalInfo;
import valueObject.VCPersonalInfo;
import valueObject.VMPersonalInfo;

public class CPersonalInfo {
	private MPersonalInfo ePersonalInfo; 

	public CPersonalInfo() {
		this.ePersonalInfo = new MPersonalInfo();
	}
	public VCPersonalInfo getPersonalInfo(String id) {
		// get data from entity
		VMPersonalInfo vEPersonalInfo = this.ePersonalInfo.getPersonalInfo(id);
		
		//create value object and set data from entity value object
		VCPersonalInfo vCPersonalInfo = new VCPersonalInfo(); //C에서 만드는건 C E에서 만드는건 E //그때마다 메모리 만들어서 호출하는 것. 느리고 메모리를 많이 먹지만 멀티 스레드나 일반화 할 때 유리함.	
		vCPersonalInfo.setId(vEPersonalInfo.getId());	//아이디 받아옴
		vCPersonalInfo.setName(vEPersonalInfo.getName());	//이름 받아옴
		vCPersonalInfo.setGrade(vEPersonalInfo.getGrade());
		vCPersonalInfo.setGwa(vEPersonalInfo.getGwa());
		//브이이 퍼스널에서 받은 데이터를 브이씨 퍼스널로 옮기기.
		
		return vCPersonalInfo;
	
	}
}
