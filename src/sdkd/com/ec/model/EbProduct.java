package sdkd.com.ec.model;

/**
 * Created by Xuwenchao on 2016/7/7.
 */
public class EbProduct {
    private int epId;
    private String epName;
    private String epDescription;
    private double epPrice;
    private int epStock;
    private int epcId;
    private int epcChildId;
    private String epFileName;
    private int epSpecial;
    public EbProduct() {}
    public EbProduct(int epId, String epName, String epDescription, double epPrice,
                     int epStock, int epcId, int epcChildId, String epFileName, int epSpecial) {
        this.epId = epId;
        this.epName = epName;
        this.epDescription = epDescription;
        this.epPrice = epPrice;
        this.epStock = epStock;
        this.epcId = epcId;
        this.epcChildId = epcChildId;
        this.epFileName = epFileName;
        this.epSpecial = epSpecial;
    }

    public int getEpId() {
        return epId;
    }

    public void setEpId(int epId) {
        this.epId = epId;
    }

    public String getEpName() {
        return epName;
    }

    public void setEpName(String epName) {
        this.epName = epName;
    }

    public String getEpDescription() {
        return epDescription;
    }

    public void setEpDescription(String epDescription) {
        this.epDescription = epDescription;
    }

    public double getEpPrice() {
        return epPrice;
    }

    public void setEpPrice(double epPrice) {
        this.epPrice = epPrice;
    }

    public int getEpStock() {
        return epStock;
    }

    public void setEpStock(int epStock) {
        this.epStock = epStock;
    }

    public int getEpcId() {
        return epcId;
    }

    public void setEpcId(int epcId) {
        this.epcId = epcId;
    }

    public int getEpcChildId() {
        return epcChildId;
    }

    public void setEpcChildId(int epcChildId) {
        this.epcChildId = epcChildId;
    }

    public String getEpFileName() {
        return epFileName;
    }

    public void setEpFileName(String epFileName) {
        this.epFileName = epFileName;
    }

    public int getEpSpecial() {
        return epSpecial;
    }

    public void setEpSpecial(int epSpecial) {
        this.epSpecial = epSpecial;
    }
}
