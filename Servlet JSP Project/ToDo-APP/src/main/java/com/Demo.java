package com.excel.filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class Solve {
	int keyIndex;
	int[] valueIndex;
	String key = "ORG RDD";
	Map<String, Integer> valueToIndex;
	Map<String, Integer> month;
	XSSFWorkbook newWorkBook;
	XSSFSheet newSheet;
	int newRowCnt;

	Solve() {
		newWorkBook = new XSSFWorkbook();
		newSheet = newWorkBook.createSheet("output");
		newRowCnt = 0;

		valueIndex = new int[8];
		valueToIndex = new HashMap<>();
		int i = 0;
		String[] strs = new String[] { "W", "I", "AE", "VD", "VA", "UV", "OA", "X1" };
		for (String str : strs) {
			valueToIndex.put(str, i++);
		}
		strs = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		i = 1;
		month = new HashMap<>();
		for (String str : strs)
			month.put(str, i++);

	}

	private void changeColor(Cell cell) {
		XSSFCellStyle cellStyle = newWorkBook.createCellStyle();
		cellStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
		// cellStyle.setFillBackgroundColor(IndexedColors.BLUE.index);
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		Font font = newWorkBook.createFont();
		font.setColor(IndexedColors.BLACK.index);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
	}

	private void addRow(Row row, Set<Integer> invalidCols) throws ParseException {
		XSSFRow newRow = newSheet.createRow(newRowCnt++);
		int n = row.getLastCellNum();

		for (int i = 0; i < n; i++) {
			Cell cell = newRow.createCell(i);
			if (row.getCell(i).getColumnIndex() == 38
					&& !row.getCell(i).toString().equalsIgnoreCase("TOTAL EDI EVENTS SENT")) {
				cell.setCellValue(String.valueOf(row.getCell(i).toString()).split("\\.")[0]);
			} else if (row.getCell(i).getColumnIndex() == 39
					&& !row.getCell(i).toString().equalsIgnoreCase("TOTAL ONTIME EDI")) {
				cell.setCellValue(String.valueOf(row.getCell(i).toString()).split("\\.")[0]);
			} else {
				cell.setCellValue(row.getCell(i).toString());
			}
			if (invalidCols.contains(i))
				changeColor(cell);
		}
		newSheet.setColumnHidden(52, true);
		newSheet.setColumnHidden(53, true);
	}

	private Date parse(String date) {
		Date finalDate = null;
		if (date != null) {
			final String[] formats = { "dd-MMM-yyyy", "MM/dd/yyyy", "yyyyMMdd" };
			for (String parse : formats) {
				SimpleDateFormat sdf = new SimpleDateFormat(parse);
				try {
					finalDate = sdf.parse(date);
				} catch (ParseException e) {

				}
			}
		}
		return finalDate;

	}

	private void fillIndex(Row row) throws ParseException {
		int n = row.getLastCellNum();
		for (int i = 0; i < n; i++) {
			Cell cell = row.getCell(i);
			String cellValue = cell.getStringCellValue();
			if (cellValue.equalsIgnoreCase(key)) {
				keyIndex = i;
			} else if (valueToIndex.containsKey(cellValue)) {
				valueIndex[valueToIndex.get(cellValue)] = i;
			}
		}

		System.out.println("Value to index");
		for (Map.Entry<String, Integer> entry : valueToIndex.entrySet()) {
			System.out.println(entry.getKey() + " " + valueIndex[entry.getValue()]);
		}

		System.out.println("keyIndex = " + keyIndex);
		System.out.println(26 + 'H' - 'A');
		addRow(row, new HashSet<>());
	}

	private Set<Integer> isValid(Row row) {
		Set<Integer> set = new HashSet<Integer>();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		try {
			String[] date = row.getCell(keyIndex).toString().split("-", -1);
			int mnth = month.get(date[1]);
			String newDate = (mnth < 10 ? "0" + mnth : mnth) + "/" + date[0] + "/" + date[2];

			Date keyDate = formatter.parse(newDate);
			for (int i : valueIndex) {
				if (row.getCell(i).getCellType() == Cell.CELL_TYPE_STRING) {
					String currDateStr = row.getCell(i).getStringCellValue();
					if (currDateStr.length() == 0)
						continue;

					Date currDate = formatter.parse(currDateStr);
					if (!(keyDate.compareTo(currDate) >= 0)) {
						set.add(i);
					}
				}
				if (row.getCell(i).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					Date currDateStr = row.getCell(i).getDateCellValue();
					if (!(keyDate.compareTo(currDateStr) >= 0)) {
						set.add(i);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("exception  " + e.getMessage());
			e.printStackTrace();
		}
		return set;
	}

	public void process() {
		try {
			String path = System.getProperty("user.dir");
			InputStream excelFile = new FileInputStream(path + "\\" + "Historical.xlsx");

			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(excelFile);
			XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);

			int invalidRowsCnt = 0;
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				final Row row = sheet.getRow(i);
				if (i == 0) {
					fillIndex(row);
					System.out.println("Invalid rows ares ::");
					continue;
				}
				Set<Integer> set = isValid(row);
				if (set.size() > 0) {
					addRow(row, set);
					invalidRowsCnt++;
				}
			}

			System.out.println("Total invalid rows " + invalidRowsCnt);
			generateOutFile();
			excelFile.close();
			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void generateOutFile() {
		try {
			String path = System.getProperty("user.dir");
			FileOutputStream fileOutput = new FileOutputStream(path + "\\" + "UPDATED-HISTORICAL_REPORT.xlsx");
			newWorkBook.write(fileOutput);

			fileOutput.close();
			newWorkBook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class ExcelFilterTaskFile {
	public static void main(String[] args) throws FileNotFoundException {
		new Solve().process();
		System.out.println("EXCEL FILE CREATED SUCCESSFULLY.....");

		// sendEmail();
		sendEmail();
		System.out.println("MAIL SENT SUCESSFULLY");

	}

	private static void sendEmail() {
		// we have to add this

		Properties emailProp = getEmailProp("smtp", "Outlook.office365.com", "25", "false");
		Session session = getEmailSession(emailProp, false, "", "");
		Message msg = null;
		String SUBJECT = "Military Monthly HISTORICAL Report";
		String CONTENT_TYPE = "text/html";
		try {
			msg = new MimeMessage(session);
			String[] recipients = { "RRamachandraNishad@encoress.com" };

			InternetAddress[] recipAddress = new InternetAddress[recipients.length];
			for (int index = 0; index < recipAddress.length; index++) {
				recipAddress[index] = new InternetAddress(recipients[index].trim());
			}
			msg.setFrom(new InternetAddress("Supportbox@matson.com"));
			msg.setRecipients(Message.RecipientType.TO, recipAddress);
			msg.setSubject(SUBJECT);
			msg.setContent("", CONTENT_TYPE);
			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setText("Hi EDI-Team, Please check the attached Military Filtered Report.");

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			String path = System.getProperty("user.dir");
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(path + "\\" + "UPDATED-HISTORICAL_REPORT.xlsx");
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("UPDATED_Military_Report.xlsx");
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			msg.setContent(multipart);

			Transport.send(msg);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static Session getEmailSession(Properties emailProp, boolean isAuthEnabled, String userid,
			String password) {
		if (isAuthEnabled) {
			return Session.getInstance(emailProp, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userid, password);
				}
			});
		} else {
			return Session.getInstance(emailProp);
		}
	}

	private static Properties getEmailProp(String protocol, String hostName, String port, String authEnabled) {
		Properties envProp = new Properties();
		envProp.put("mail.store.protocol", "smtp");
		// envProp.put("mail.smtp.host", configUtil.getConfigValue(SMTPHOST));
		// envProp.put("mail.smtp.host",
		// configUtil.getConfigValue(SMTPHOST_MODIFIED));//IBS- 05 sep changes
		envProp.put("mail.smtp.host", "mailhost.pp.matson.com");// IBS- changes 05 sep
		// envProp.put("mail.smtp.port", "587");
		// envProp.put("mail.smtp.starttls.enable", "true");
		// IBS-11 29-oct
		envProp.put("mail.debug", "true");// Added New
		// envProp.put("mail.smtp.ssl.protocols","TLSv1.2"); // Added New
		// IBS-11 29-oct
		// envProp.put("mail.smtp.ssl.enable", "true");
		// envProp.put("mail.protocol.ssl.trust",
		envProp.put("mail.smtp.auth", "false");
		return envProp;
	}

}
