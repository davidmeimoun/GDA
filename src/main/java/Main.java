import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

	public static void main(String[] args) {
		Workbook wb = new XSSFWorkbook();
		FileOutputStream fileOut = null;

		try {

			fileOut = new FileOutputStream("workbook.xlsx");
			Sheet sheet1 = wb.createSheet("Redis");
			creatingBaseTableau(wb,sheet1);
			Redis redis = new Redis(recupererValeur());
			creatingDonnee10(wb,sheet1,String.valueOf(redis.moyenneTempsSet(10)),String.valueOf(redis.moyenneTempsGet(10)),String.valueOf(redis.moyenneTempsDelete(10)));
			creatingDonnee25(wb,sheet1,String.valueOf(redis.moyenneTempsSet(4635)),String.valueOf(redis.moyenneTempsGet(4635)),String.valueOf(redis.moyenneTempsDelete(4635)));
			creatingDonnee50(wb,sheet1,String.valueOf(redis.moyenneTempsSet(9270)),String.valueOf(redis.moyenneTempsGet(9270)),String.valueOf(redis.moyenneTempsDelete(9270)));
			creatingDonnee75(wb,sheet1,String.valueOf(redis.moyenneTempsSet(13907)),String.valueOf(redis.moyenneTempsGet(13907)),String.valueOf(redis.moyenneTempsDelete(13907)));
			
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}


	public static void creatingBaseTableau(Workbook wb, Sheet sheet){
		Row row = sheet.createRow((short)0);
		row.createCell(0).setCellValue("Nombre de données");
		row.createCell(1).setCellValue("Temps Execution : Set");
		row.createCell(2).setCellValue("Temps Execution : Get");
		row.createCell(3).setCellValue("Temps Execution : Delete");
	}
	public static void creatingDonnee10(Workbook wb, Sheet sheet, String valueSet,String valueGet, String ValueDelete){

		sheet.createRow(1).createCell(0).setCellValue("10");
		sheet.createRow(1).createCell(1).setCellValue(valueSet);
		sheet.createRow(1).createCell(2).setCellValue(valueGet);
		sheet.createRow(1).createCell(3).setCellValue(ValueDelete);
	}
	public static void creatingDonnee25(Workbook wb, Sheet sheet, String valueSet,String valueGet, String ValueDelete){

		sheet.createRow(2).createCell(0).setCellValue("25% -> 4635");
		sheet.createRow(2).createCell(1).setCellValue(valueSet);
		sheet.createRow(1).createCell(2).setCellValue(valueGet);
		sheet.createRow(1).createCell(3).setCellValue(ValueDelete);
	}
	
	public static void creatingDonnee50(Workbook wb, Sheet sheet, String valueSet,String valueGet, String ValueDelete){

		sheet.createRow(3).createCell(0).setCellValue("50% -> 9270");
		sheet.createRow(3).createCell(1).setCellValue(valueSet);
		sheet.createRow(1).createCell(2).setCellValue(valueGet);
		sheet.createRow(1).createCell(3).setCellValue(ValueDelete);
	}
	public static void creatingDonnee75(Workbook wb, Sheet sheet, String valueSet,String valueGet, String ValueDelete){

		sheet.createRow(4).createCell(0).setCellValue("75% ->  13907");
		sheet.createRow(4).createCell(1).setCellValue(valueSet);
		sheet.createRow(1).createCell(2).setCellValue(valueGet);
		sheet.createRow(1).createCell(3).setCellValue(ValueDelete);
	}
	
	public void creatingCell(Workbook wb, Sheet sheet, String value){
		  Row row = sheet.createRow((short)0);
		  Cell cell = row.createCell(0);
		  cell.setCellValue(value);
		
	}
	public static List<Hebergement> recupererValeur() {
		String csvFile = "/home/david/Documents/test-hebergements.csv";
		String line = "";
		String cvsSplitBy = ",";
		int cpt = 0;
		List<String> listPhrase = new ArrayList<String>();
		List<Hebergement> listHebergements = new ArrayList<Hebergement>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {
				// use comma as separator
				cpt++;
				String[] ligne = line.split(cvsSplitBy);
				String DATE_DE_CLASSEMENT = ligne[0];
				String DATE_DE_PUBLICATION_ETABLISSEMENT = ligne[1];
				String TYPOLOGIE_ETABLISSEMENT = ligne[2];
				String CLASSEMENT = ligne[3];
				String CATEGORIE = ligne[4];
				String NOM_COMMERCIAL = ligne[5].replaceAll(" ", "-");
				String ADRESSE = ligne[6].replaceAll(" ", "-");
				String CODE_POSTAL = ligne[7];
				String COMMUNE = ligne[8];
				String TELEPHONE = ligne[9];
				String COURRIEL = ligne[10];
				String SITE_INTERNET = ligne[11];
				Hebergement heb = new Hebergement(DATE_DE_CLASSEMENT, DATE_DE_PUBLICATION_ETABLISSEMENT,
						TYPOLOGIE_ETABLISSEMENT, CLASSEMENT, CATEGORIE, NOM_COMMERCIAL, ADRESSE, CODE_POSTAL, COMMUNE,
						TELEPHONE, COURRIEL, SITE_INTERNET);
				String phraseFinal = "eval curl -i -X POST http://localhost:8098/riak/heb -H \"Content-Type:application/json\" -d \"{"
						+ "\"" + "DATE_DE_CLASSEMENT" + "\"" + ":" + "\"" + DATE_DE_CLASSEMENT + "\"," + "\""
						+ "DATE_DE_PUBLICATION_ETABLISSEMENT" + "\"" + ":" + "\"" + DATE_DE_PUBLICATION_ETABLISSEMENT
						+ "\"," + "\"" + "TYPOLOGIE_ETABLISSEMENT" + "\"" + ":" + "\"" + TYPOLOGIE_ETABLISSEMENT + "\","
						+ "\"" + "CLASSEMENT" + "\"" + ":" + "\"" + CLASSEMENT + "\"," + "\"" + "CATEGORIE" + "\"" + ":"
						+ "\"" + CATEGORIE + "\"," + "\"" + "NOM_COMMERCIAL" + "\"" + ":" + "\"" + NOM_COMMERCIAL
						+ "\"," + "\"" + "ADRESSE" + "\"" + ":" + "\"" + ADRESSE + "\"," + "\"" + "CODE_POSTAL" + "\""
						+ ":" + "\"" + CODE_POSTAL + "\"," + "\"" + "COMMUNE" + "\"" + ":" + "\"" + COMMUNE + "\","
						+ "\"" + "TELEPHONE" + "\"" + ":" + "\"" + TELEPHONE + "\"," + "\"" + "COURRIEL" + "\"" + ":"
						+ "\"" + COURRIEL + "\"" +
						// "\"" + "SITE_INTERNET" + "\"" + ":" + "\""
						// +SITE_INTERNET+ "\","+
						"}\"";
				listPhrase.add(phraseFinal);
				listHebergements.add(heb);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listHebergements;
	}

}
