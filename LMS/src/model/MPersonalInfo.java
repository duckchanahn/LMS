package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VMPersonalInfo;

public class MPersonalInfo {

	public VMPersonalInfo getPersonalInfo(String id) {
		VMPersonalInfo vEPersonalInfo = new VMPersonalInfo();
		
		//���Ͽ��� ������ �о ������ ���.
		try {
			File file = new File("Data/student.txt");
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) {
				vEPersonalInfo.readFromFile(scan);
				if(vEPersonalInfo.getId().equals(id)) {
					return vEPersonalInfo;
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
