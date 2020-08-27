package vo;

public class Result {
    private String resultcode;
    private Resultinfo Resultinfo = new Resultinfo();

    public Result(String resultcode, Resultinfo Resultinfo) {
        this.resultcode = resultcode;
        this.Resultinfo = Resultinfo;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultcode='" + resultcode + '\'' +
                ", Resultinfo=" + Resultinfo +
                '}';
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public void setResultinfo(Resultinfo Resultinfo) {
        this.Resultinfo = Resultinfo;
    }

    public String getResultcode() {
        return resultcode;
    }

    public Resultinfo getResultinfo() {
        return Resultinfo;
    }
}
