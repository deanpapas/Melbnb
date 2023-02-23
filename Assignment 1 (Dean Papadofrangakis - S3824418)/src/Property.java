/*
 * Property
 * 
 * V2.0
 *
 * 29/03/2022
 */

/*
 * The Property class defines the "Property" Object and defines the relevant
 * getters and setters for the object(s)
 */

public class Property {

    private String nAME;
    private String lOCATION;
    private String dESCRIPTION;
    private String tYPE_OF_PLACE;
    private String hOST;
    private int mAX_GUESTS;
    private double rATING;
    private double pRICE_PER_NIGHT;
    private double sERVICE_FEE;
    private double cLEANING_FEE;
    private double wEEKLY_DISCOUNT;

    public Property(String nAME, String lOCATION, String dESCRIPTION, String tYPE_OF_PLACE, String hOST, int mAX_GUESTS,
            double rATING, double pRICE_PER_NIGHT, double sERVICE_FEE, double cLEANING_FEE, double wEEKLY_DISCOUNT) {
        this.nAME = nAME;
        this.lOCATION = lOCATION;
        this.dESCRIPTION = dESCRIPTION;
        this.tYPE_OF_PLACE = tYPE_OF_PLACE;
        this.hOST = hOST;
        this.mAX_GUESTS = mAX_GUESTS;
        this.rATING = rATING;
        this.pRICE_PER_NIGHT = pRICE_PER_NIGHT;
        this.sERVICE_FEE = sERVICE_FEE;
        this.cLEANING_FEE = cLEANING_FEE;
        this.wEEKLY_DISCOUNT = wEEKLY_DISCOUNT;
    }

    public String getnAME() {
        return nAME;
    }

    public void setnAME(String nAME) {
        this.nAME = nAME;
    }

    public String getlOCATION() {
        return lOCATION;
    }

    public void setlOCATION(String lOCATION) {
        this.lOCATION = lOCATION;
    }

    public String getdESCRIPTION() {
        return dESCRIPTION;
    }

    public void setdESCRIPTION(String dESCRIPTION) {
        this.dESCRIPTION = dESCRIPTION;
    }

    public String gettYPE_OF_PLACE() {
        return tYPE_OF_PLACE;
    }

    public void settYPE_OF_PLACE(String tYPE_OF_PLACE) {
        this.tYPE_OF_PLACE = tYPE_OF_PLACE;
    }

    public String gethOST() {
        return hOST;
    }

    public void sethOST(String hOST) {
        this.hOST = hOST;
    }

    public int getmAX_GUESTS() {
        return mAX_GUESTS;
    }

    public void setmAX_GUESTS(int mAX_GUESTS) {
        this.mAX_GUESTS = mAX_GUESTS;
    }

    public double getrATING() {
        return rATING;
    }

    public void setrATING(double rATING) {
        this.rATING = rATING;
    }

    public double getpRICE_PER_NIGHT() {
        return pRICE_PER_NIGHT;
    }

    public void setpRICE_PER_NIGHT(int pRICE_PER_NIGHT) {
        this.pRICE_PER_NIGHT = pRICE_PER_NIGHT;
    }

    public double getsERVICE_FEE() {
        return sERVICE_FEE;
    }

    public void setsERVICE_FEE(double sERVICE_FEE) {
        this.sERVICE_FEE = sERVICE_FEE;
    }

    public double getcLEANING_FEE() {
        return cLEANING_FEE;
    }

    public void setcLEANING_FEE(int cLEANING_FEE) {
        this.cLEANING_FEE = cLEANING_FEE;
    }

    public double getwEEKLY_DISCOUNT() {
        return wEEKLY_DISCOUNT;
    }

    public void setwEEKLY_DISCOUNT(int wEEKLY_DISCOUNT) {
        this.wEEKLY_DISCOUNT = wEEKLY_DISCOUNT;
    }

}