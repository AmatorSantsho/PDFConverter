import manualcalculationitem.ManualCalculationItem;
import util.PDFBoxPDFConverter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 123 on 04.07.2017.
 */
public class TestClassMain {
    public static void main(String[] args) throws IOException {

        String path = args[0];
        InputStream inputStream = new FileInputStream(path);
        String doc = new PDFBoxPDFConverter().convertToSV(inputStream, ";");
        List<ManualCalculationItem> list = new FindAllPassendStrings().findStringsAndMakeObjekt(doc);
        System.out.println(list.size());
        for (ManualCalculationItem m : list) {
            System.out.println(m.getRepairOperation());
            System.out.println(m.getDescription());
            System.out.println(m.getHours());
            System.out.println(m.getPartNumber());
            System.out.println(m.getAmount());
            System.out.println("---------------");

        }


    }
}
