package sdkd.com.ec.model;

/**
 * Created by Xuwenchao on 2016/7/8.
 */
public class EbShopCar {
    private int euId;
    private EbProduct ep;
    private int escProductQuantity;
    public EbShopCar(int euId, EbProduct ep, int escProductQuantity) {
        this.euId = euId;
        this.ep = ep;
        this.escProductQuantity = escProductQuantity;

    }
    public int getEuId() {
        return euId;
    }

    public void setEuId(int euId) {
        this.euId = euId;
    }

    public EbProduct getEp() {
        return ep;
    }

    public void setEp(EbProduct ep) {
        this.ep = ep;
    }

    public int getEscProductQuantity() {
        return escProductQuantity;
    }

    public void setEscProductQuantity(int escProductQuantity) {
        this.escProductQuantity = escProductQuantity;
    }

}
