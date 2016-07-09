package sdkd.com.ec.model;

/**
 * Created by Xuwenchao on 2016/7/7.
 */
public class EbProdCate {
    private int epcId;
    private String epcName;
    private int epcParentId;

    public EbProdCate(int epcId, String epcName, int epcParentId) {
        this.epcId = epcId;
        this.epcName = epcName;
        this.epcParentId = epcParentId;
    }

    public int getEpcId() {
        return epcId;
    }

    public void setEpcId(int epcId) {
        this.epcId = epcId;
    }

    public String getEpcName() {
        return epcName;
    }

    public void setEpcName(String epcName) {
        this.epcName = epcName;
    }

    public int getEpcParentId() {
        return epcParentId;
    }

    public void setEpcParentId(int epcParentId) {
        this.epcParentId = epcParentId;
    }
}
