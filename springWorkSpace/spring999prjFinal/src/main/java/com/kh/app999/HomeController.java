package com.kh.app999;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "/home";
	}
	
	@GetMapping("/excel/download")
	public void excelDownload(HttpServletResponse response) throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("ù��° ��Ʈ");
		Row row = null;
		Cell cell = null;
		int rowNum = 0;
		
		 // Header
        row = sheet.createRow(rowNum++);
        cell = row.createCell(0);
        cell.setCellValue("��ȣ");
        cell = row.createCell(1);
        cell.setCellValue("�̸�");
        cell = row.createCell(2);
        cell.setCellValue("����");

        // Body
        for (int i=0; i<3; i++) {
            row = sheet.createRow(rowNum++);
            cell = row.createCell(0);
            cell.setCellValue(i);
            cell = row.createCell(1);
            cell.setCellValue(i+"_name");
            cell = row.createCell(2);
            cell.setCellValue(i+"_title");
        }

        // ������ Ÿ�԰� ���ϸ� ����
        response.setContentType("ms-vnd/excel");
        //response.setHeader("Content-Disposition", "attachment;filename=example.xls");
        response.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

        // Excel File Output
        wb.write(response.getOutputStream());
        wb.close();
	}
}
