package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

    private static final String FILE_PATH =
            "src/test/resources/testdata/ParabankData.xlsx";

    public static String getCellData(String sheetName,
            int rowNum,
            int colNum) {

		try {
		
		FileInputStream fis =
		new FileInputStream(FILE_PATH);
		
		Workbook workbook =
		WorkbookFactory.create(fis);
		
		Sheet sheet =
		workbook.getSheet(sheetName);
		
		if(sheet == null) {
		
		System.out.println(
		"Sheet NOT FOUND : " + sheetName);
		
		workbook.close();
		
		return "";
		}
		
		DataFormatter formatter =
		new DataFormatter();
		
		String value =
		formatter.formatCellValue(
		   sheet.getRow(rowNum)
		        .getCell(colNum));
		
		workbook.close();
		
		return value;
		
		} catch (Exception e) {
		
		e.printStackTrace();
		}
		
		return "";
		}
}