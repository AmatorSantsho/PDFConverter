package util;

import interfaces.IPDFConverter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Apache PDFBox pdf converter.
 */
public class PDFBoxPDFConverter implements IPDFConverter {



    public String convertToSV(InputStream pdf, String separator) throws IOException {
        PDDocument document = null;
        try {
            long startTime = new Date().getTime();
            document = PDDocument.load(pdf);
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setWordSeparator(separator);
            stripper.setSortByPosition(true);
            stripper.setShouldSeparateByBeads(true);
            String result = stripper.getText(document);
            System.out.println("Pdf parsing is done, time = " + (new Date().getTime() - startTime) + "ms");
            return result;
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }

}
