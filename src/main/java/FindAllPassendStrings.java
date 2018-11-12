import manualcalculationitem.ManualCalculationItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 02.07.2017.
 */
public class FindAllPassendStrings {

    public List<ManualCalculationItem> findStringsAndMakeObjekt(String dokument) {

        List<ManualCalculationItem> manualCalculationItems = new ArrayList<ManualCalculationItem>();

        String[] allLines = dokument.split("\r?\n");
        String[] dataBlockHeaders = new String[]{"Remove & Replace", "Repair", "Parts Part No", "Paint - Metallic 2", "Freight"};
        String[] ignoreDataLines = new String[]{"R & R Section Total", "Page ", "Invoice Date", "Tax Invoice", "Estimate Number",
                "Hrs/Qty Value", "Metallic 2 Section Total", "FR Section Total", "Parts Section Total", "Total Original Estimate", "Additional Estimate", "Total Additional Estimate",
                "Total", "GST"};
        String typeOperation = "";
        for (int i = 0; i < allLines.length; i++) {
            String line = allLines[i];
            String line01 = line.trim();
            for (int j = 0; j < dataBlockHeaders.length; j++) {
                String typOper = dataBlockHeaders[j];
                if (typOper.equals(line01)) {
                    typeOperation = typOper;
                    break;
                }
            }

            if (!(typeOperation == "") && !line01.equals(typeOperation)) {

                boolean contensIgnoreDataLines = false;
                for (int j = 0; j < ignoreDataLines.length; j++) {
                    String s = ignoreDataLines[j];

                    if (line01.contains(s)) {
                        contensIgnoreDataLines = true;
                        break;
                    }
                }
                if (!contensIgnoreDataLines) {

                    String[] lineContens = line01.split(" ");
                    String lastWordOfLine = lineContens[lineContens.length - 1];
                    ManualCalculationItem manualCalculationItem = new ManualCalculationItem();
                    manualCalculationItem.setRepairOperation(typeOperation);
                    manualCalculationItem.setAmount(new BigDecimal(lastWordOfLine));
                    String description;

                    if (!typeOperation.equals("Parts Part No")) {
                        description = line01.replaceAll("-?\\d\\.?", "").trim();
                        manualCalculationItem.setDescription(description);
                    }

                    if (typeOperation.equals("Parts Part No")) {
                        String otherDescription = "";
                        String partNumber = "";
                        for (int j = 0; j < lineContens.length; j++) {

                            if (!(lineContens[j] == " ") && lineContens[j].matches("\\D+")) {
                                otherDescription = otherDescription + " " + lineContens[j];
                            }

                            if (lineContens[j].matches("[\\D]+?[0-9]+?\\.?[0-9]+?") && !(j == lineContens.length - 1)) {
                                partNumber = lineContens[j];
                            } else if (lineContens[j].matches("\\d+")) {
                                partNumber = lineContens[j];
                            }
                        }

                        manualCalculationItem.setDescription(otherDescription.trim());
                        manualCalculationItem.setPartNumber(partNumber);
                    }
                    manualCalculationItems.add(manualCalculationItem);

                }
            }
        }
        return manualCalculationItems;
    }
}
