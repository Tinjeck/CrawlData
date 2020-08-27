package vo;

public class Info {
    private String accttype;
    private float balance;
    private String info;
    private String pay;
    private float save;
    private String tranday;

    public void setAccttype(String accttype) {
        this.accttype = accttype;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public void setSave(float save) {
        this.save = save;
    }

    public void setTranday(String tranday) {
        this.tranday = tranday;
    }

    public String getAccttype() {
        return accttype;
    }

    public float getBalance() {
        return balance;
    }

    public String getInfo() {
        return info;
    }

    public String getPay() {
        return pay;
    }

    public float getSave() {
        return save;
    }

    public String getTranday() {
        return tranday;
    }

    public Info() {
    }

    public Info(String accttype, float balance, String info, String pay, float save, String tranday) {
        this.accttype = accttype;
        this.balance = balance;
        this.info = info;
        this.pay = pay;
        this.save = save;
        this.tranday = tranday;
    }
}
