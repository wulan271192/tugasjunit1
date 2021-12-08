package com.qa.main;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStream;

import static org.junit.Assert.*;

import java.util.Scanner;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import com.qa.main.function.KecepatanRataFunction;

public class TestFungsiRataRata {
	KecepatanRataFunction function;

	@Before
	public void setUp() throws Exception {
		function = new KecepatanRataFunction();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRataRata() {
		for (String isi : readfile("src/test/resource/SkenarioRataRataKecepatan.csv")) {
			
			String [] data = isi.split(";");
			
			String jarak = data[0];
			String waktu = data[1];
			String Hasil = data[2];
			System.out.println("RataRata" + Hasil);
			assertEquals(Double.parseDouble(Hasil), function.RataRata(Double.parseDouble(jarak/waktu)),0.0);
			
	}}
	
	
	public List<String> readfile(String namefile) {
		
		List<String> penampung = new ArrayList<String>();
	
		try
		{
			
		InputStream myFile = getClass().getClassLoader().getResourceAsStream("SkenarioRataRataKecepatan.csv");
		
		Scanner reader = new Scanner(myFile);
		
		while(reader.hasNextLine()) {
			penampung.add(reader.nextLine());
			
		}
	}catch (Exception e) {
		e.printStackTrace();
		
	}
		return penampung;

}
}