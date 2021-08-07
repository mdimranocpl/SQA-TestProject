package com.bat.STest.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bat.STest.DTO.LoginDTO;

public class ExcelUtils {

	private static FileInputStream fileInputStream = null;
	private static Workbook workBook = null;

	private static Sheet getSheet(int sheetNo) throws IOException {

		File f = new File("C:\\Users\\pc\\Desktop\\New folder\\datafile.xlsx");
		fileInputStream = new FileInputStream(f);
		workBook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = (Sheet) workBook.getSheetAt(sheetNo);
		return sheet;
	}

	// Login Data
	public static List<LoginDTO> getLoginData() throws IOException {
		List<LoginDTO> logindata = new ArrayList<LoginDTO>();
		DataFormatter formatter = new DataFormatter();

		Iterator<Row> rowiterator = ExcelUtils.getSheet(0).iterator();
		while (rowiterator.hasNext()) {
			Row nextrow = rowiterator.next();
			Iterator<Cell> celliterator = nextrow.cellIterator();
			LoginDTO login = new LoginDTO();
			byte cellCounter = 0;
			while (celliterator.hasNext()) {

				Cell cell = celliterator.next();

				switch (cellCounter) {
				case 0:
					login.setUsername(formatter.formatCellValue(cell));
					cellCounter++;
					break;

				case 1:
					login.setPassword(formatter.formatCellValue(cell));
					cellCounter++;
					break;
				case 2:
					login.setUsername(formatter.formatCellValue(cell));
					cellCounter++;
					break;
				case 3:
					login.setPassword(formatter.formatCellValue(cell));
					break;
					
				}
			}
			logindata.add(login);

		}
		close();
		return logindata;
	}

	// others method declare part here

	private static void close() throws IOException {
		// TODO Auto-generated method stub
		workBook.close();
		fileInputStream.close();
	}
}
