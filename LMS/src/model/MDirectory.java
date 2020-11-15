package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VMDirectory;

public class MDirectory {
	
	private Vector<VMDirectory> vEDirectories;
	public MDirectory() {
		this.vEDirectories = new Vector<VMDirectory>();
	}

	public Vector<VMDirectory> getData(String fileName) {
		
		try {
			this.vEDirectories.clear();
			
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			
			while(scan.hasNext()) {
				VMDirectory vEDirectory = new VMDirectory();
				vEDirectory.readFromFile(scan);
				this.vEDirectories.add(vEDirectory);
			}
			
			scan.close();
			return vEDirectories;
			
		} catch (FileNotFoundException e) {e.printStackTrace();}
		
		return null;
	}


}
