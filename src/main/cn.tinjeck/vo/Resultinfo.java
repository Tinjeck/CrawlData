package vo;


import java.util.ArrayList;
import java.util.List;

public class Resultinfo {
    private int count;
    private int pageno;
    private float payqb;
    private int per;
    private float saveqb;
    private String display;
    private List<Info> list = new ArrayList<Info>();

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    public Resultinfo(int count, int pageno, float payqb, int per, float saveqb, String display, List<Info> list) {
        this.count = count;
        this.pageno = pageno;
        this.payqb = payqb;
        this.per = per;
        this.saveqb = saveqb;
        this.display = display;
        this.list = list;
    }

    public Resultinfo() {
    }

    public void setList(List<Info> list) {
        this.list = list;
    }

    public List<Info> getList() {
        return list;
    }

    public Resultinfo(int count, int pageno, float payqb, int per, float saveqb, List<Info> list) {
        this.count = count;
        this.pageno = pageno;
        this.payqb = payqb;
        this.per = per;
        this.saveqb = saveqb;
        this.list = list;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public void setPayqb(float payqb) {
        this.payqb = payqb;
    }

    public void setPer(int per) {
        this.per = per;
    }

    public void setSaveqb(float saveqb) {
        this.saveqb = saveqb;
    }

    public int getCount() {
        return count;
    }

    public int getPageno() {
        return pageno;
    }

    public float getPayqb() {
        return payqb;
    }

    public int getPer() {
        return per;
    }

    public float getSaveqb() {
        return saveqb;
    }
}
