package manualcalculationitem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(
        name = "ManualCalculationItemKind"
)
@XmlEnum
public enum ManualCalculationItemKind {
    @XmlEnumValue("labour")
    LABOUR("labour"),
    @XmlEnumValue("paintLabour")
    PAINT_LABOUR("paintLabour"),
    @XmlEnumValue("paintMaterial")
    PAINT_MATERIAL("paintMaterial"),
    @XmlEnumValue("spareParts")
    SPARE_PARTS("spareParts"),
    @XmlEnumValue("sublets")
    SUBLETS("sublets");

    private String name;

    private ManualCalculationItemKind(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static ManualCalculationItemKind fromValue(String inName) {
        if(inName == null) {
            throw new IllegalArgumentException("inName cannot be null.");
        } else {
            ManualCalculationItemKind[] arr$ = values();
            int len$ = arr$.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                ManualCalculationItemKind enumValue = arr$[i$];
                if(enumValue.name.equalsIgnoreCase(inName)) {
                    return enumValue;
                }
            }

            return null;
        }
    }
}
