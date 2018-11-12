package manualcalculationitem;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "ManualCalculationItem",
        propOrder = {"lineNumber", "repairOperation", "itemKind", "description", "partNumber", "hours", "labourRate", "amount", "itemType", "provider"}
)
public class ManualCalculationItem {
    @XmlElement(
            required = true
    )
    private String lineNumber;
    private String repairOperation;
    private ManualCalculationItemKind itemKind;
    private String description;
    private String partNumber;
    private BigDecimal hours;
    private BigDecimal labourRate;
    private BigDecimal amount;
    private String itemType;
    private String provider;

    public ManualCalculationItem() {
    }

    public String getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getRepairOperation() {
        return this.repairOperation;
    }

    public void setRepairOperation(String repairOperation) {
        this.repairOperation = repairOperation;
    }

    public ManualCalculationItemKind getItemKind() {
        return this.itemKind;
    }

    public void setItemKind(ManualCalculationItemKind itemKind) {
        this.itemKind = itemKind;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public BigDecimal getHours() {
        return this.hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public BigDecimal getLabourRate() {
        return this.labourRate;
    }

    public void setLabourRate(BigDecimal labourRate) {
        this.labourRate = labourRate;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
