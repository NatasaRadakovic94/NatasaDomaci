import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Zadatak {
    public static void main(String[] args) throws IOException {
    FileInputStream inputStream = new FileInputStream("tabelaimena.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
    XSSFSheet sheet = workbook.getSheetAt(0);
    for (int i = 0; i < 5; i++) {
        XSSFRow row = sheet.getRow(i);
        XSSFCell cell = row.getCell(0);
        XSSFCell cell2 = row.getCell(1);
        String ime = cell.getStringCellValue();
        String prezime = cell2.getStringCellValue();
        System.out.println(ime + " " + prezime);
        System.out.println();
    }


    Faker faker = new Faker();
    for (int i = 5; i < 10; i++) {
        // Create a new row
        Row row = sheet.createRow(i);
        // Create a new cell
        Cell firstNameCell = row.createCell(0);
        Cell lastNameCell = row.createCell(1);
        // Set the cell value
        firstNameCell.setCellValue(faker.name().firstName());
        lastNameCell.setCellValue(faker.name().lastName());
    }

    for (int i = 5; i < 10; i++) {
        XSSFRow row = sheet.getRow(i);
        XSSFCell cell = row.getCell(0);
        XSSFCell cell2 = row.getCell(1);
        String ime = cell.getStringCellValue();
        String prezime = cell2.getStringCellValue();
        System.out.println(ime + " " + prezime);
        // Write the workbook to a file
        FileOutputStream fileOut = new FileOutputStream("tabelaimena.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        System.out.println();
    }
}
}
