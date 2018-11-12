package manualcalculationitem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"manualCalculationItem"}
)
@XmlRootElement(
        name = "ManualCalculationItems"
)
public class ManualCalculationItems {
    protected List<ManualCalculationItem> manualCalculationItem;

    public ManualCalculationItems() {
    }

    public List<ManualCalculationItem> getManualCalculationItem() {
        if(this.manualCalculationItem == null) {
            this.manualCalculationItem = new ArrayList();
        }

        return this.manualCalculationItem;
    }
}

