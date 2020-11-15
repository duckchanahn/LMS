package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import global.Constants.EDataFileName;

public class MLogin {

	public boolean validateUser(String ID, String password) {
		try {
			File file = new File(EDataFileName.path.getString() + EDataFileName.login.getString());
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String sID = scanner.next();
				String sPassword = scanner.next();
				if (ID.equals(sID) && password.equals(sPassword)) {
					return true;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
		}		
		return false;
	}
}
