package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VMLecture;

public class MLecture {
	
	private Vector<VMLecture> vMLectures;

	public MLecture() {
		this.vMLectures = new Vector<VMLecture>();
	}

	public Vector<VMLecture> getData(String fileName) {
		
		try {
			this.vMLectures.clear();
			
			File file = new File("Data/" + fileName);
			Scanner scan = new Scanner(file);
			
			while(scan.hasNext()) {
				VMLecture vMLecture = new VMLecture();
				vMLecture.readFromFile(scan);
				this.vMLectures.add(vMLecture);
			}
			
			scan.close();
			return vMLectures;
			
		} catch (FileNotFoundException e) {e.printStackTrace();}
		
		return null;
	}


}
