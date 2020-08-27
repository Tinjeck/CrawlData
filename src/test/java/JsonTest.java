import com.alibaba.fastjson.JSON;
import vo.Result;

public class JsonTest {
    public static void main(String[] args) {
        String json = "{ \"resultcode\": 0, \"resultinfo\": { \"count\": \"129\", \"pageno\": \"1\", \"payqb\": \"3.80\", \"payqd\": \"0.0\", \"per\": \"7\", \"saveqb\": \"0.00\", \"saveqd\": \"0.0\", \"list\": [ { \"accttype\": \"1\", \"balance\": \"0.00\", \"Info\": \"购买三国商品:1级豪杰装备包x1,\", \"pay\": \"0.10\", \"save\": \"\", \"tranday\": \"2008-04-26\" }, { \"accttype\": \"1\", \"balance\": \"0.10\", \"Info\": \"购买三国商品:铁质委任书x1,\", \"pay\": \"0.50\", \"save\": \"\", \"tranday\": \"2008-04-25\" }, { \"accttype\": \"1\", \"balance\": \"0.60\", \"Info\": \"购买三国商品:小强丸x1,\", \"pay\": \"1.00\", \"save\": \"\", \"tranday\": \"2008-04-25\" }, { \"accttype\": \"1\", \"balance\": \"1.60\", \"Info\": \"购买三国商品:神游丸x1,\", \"pay\": \"1.00\", \"save\": \"\", \"tranday\": \"2008-04-25\" }, { \"accttype\": \"1\", \"balance\": \"2.60\", \"Info\": \"购买三国商品:1级阴阳装备包x1,\", \"pay\": \"0.10\", \"save\": \"\", \"tranday\": \"2008-04-25\" }, { \"accttype\": \"1\", \"balance\": \"2.70\", \"Info\": \"购买三国商品:1级仙术装备包x1,\", \"pay\": \"0.10\", \"save\": \"\", \"tranday\": \"2008-04-24\" }, { \"accttype\": \"1\", \"balance\": \"2.80\", \"Info\": \"购买三国商品:活力丸x1,\", \"pay\": \"1.00\", \"save\": \"\", \"tranday\": \"2008-04-23\" } ] } }";
        System.out.println(json);
        Result result = JSON.parseObject(json,Result.class);
        System.out.println(result);
        System.out.println("一共爬取到362条数据");

    }
}
