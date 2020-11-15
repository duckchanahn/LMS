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
		VCPersonalInfo vCPersonalInfo = new VCPersonalInfo(); //C���� ����°� C E���� ����°� E //�׶����� �޸� ���� ȣ���ϴ� ��. ������ �޸𸮸� ���� ������ ��Ƽ �����峪 �Ϲ�ȭ �� �� ������.	
		vCPersonalInfo.setId(vEPersonalInfo.getId());	//���̵� �޾ƿ�
		vCPersonalInfo.setName(vEPersonalInfo.getName());	//�̸� �޾ƿ�
		vCPersonalInfo.setGrade(vEPersonalInfo.getGrade());
		vCPersonalInfo.setGwa(vEPersonalInfo.getGwa());
		//������ �۽��ο��� ���� �����͸� ���̾� �۽��η� �ű��.
		
		return vCPersonalInfo;
	
	}
}
