package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPDF {

	public static void main(String[] args) throws Throwable {

		File file = new File("./src/test/resources/multipage-pdf.pdf");

		PDDocument pdDoc = PDDocument.load(file);
		//int pages = pdDoc.getNumberOfPages();// Prints total num of pages present
		//System.out.println(pages);
		
		PDFTextStripper data = new PDFTextStripper();
		   //   String read = data.getText(pdDoc);//read entire pdf data
		  //    System.out.println(read);

//		       data.setStartPage(3);
//		      String pageData = data.getText(pdDoc);//reads the data of the page and followed
//		     System.out.println(pageData);
		
		     data.setStartPage(3);//starts reading data from the particular page
		     data.setEndPage(4);//ends reading data from the particular page
		      String pageData = data.getText(pdDoc);
		     System.out.println(pageData);
		}

	

}


