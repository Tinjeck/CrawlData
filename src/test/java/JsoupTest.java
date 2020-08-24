import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsoupTest {
    public static void main(String[] args) {
        String coin_type = "0";
        String start_date = "2009-05-24";
        String end_date = "2009-08-24";
        String page_no = "1";
        String channel = "qdqb";
        String per = "7";
        String extcode = "";
        String t = "0.2841945974201854";

        Map<String,String> cookies = new HashMap();
        cookies.put("Qs_lvt_323937","1596262780");
        cookies.put("Qs_pv_323937","4245147956164716500");
        cookies.put("RK","qHDcwC7Gat");
        cookies.put("aid4open","tpay.adeny.roy");
        cookies.put("idqq_account","theCanChange%3D1%3BtheShowUin%3D313317924%3BBindedPhone%3D166******96%3BPhoneCanSeach%3D0%3BBindedEmail%3Dtinjeck@qq.com%3BEmailCanSeach%3D1%3BEmailIsActive%3D1%3BUinCanSeach%3D1%3Bshouldshowmail%3D1%3Bfirstsetidqq%3D1%3BMSK%3D0%3B\t");
        cookies.put("pay_sessionid","0CEEA53C3720F8723FB7FFA5CCED7B69");
        cookies.put("pgv_info","ssid=s5858137555&pgvReferrer=https://my.pay.qq.com/account/account_qdqb_trade_record.shtml\t");
        cookies.put("pgv_pvi","603511808");
        cookies.put("pgv_pvid","3857971654");
        cookies.put("pgv_si","s4694959104");
        cookies.put("ptcz","34dd00347f6d98aa396cb9cbdac4c765f54b39fdca9db27863eab67098397fd5");
        cookies.put("skey","@yonDwOv7L");
        cookies.put("tvfe_boss_uuid","ecf240e4175b2ddf");
        cookies.put("uin","o0313317924");
        cookies.put("verifysession","h01c8c87cad2ab10baa626929978c98f12d41196c43c0934b9946c43e10db1dad1bdde639927cac8551\t");

        try {
            Document data = Jsoup.connect("https://my.pay.qq.com/cgi-bin/personal/account_tradeinfo.cgi?coin_type="+coin_type+"&start_date="+start_date+"&end_date="+end_date+"&page_no="+page_no+"&channel="+channel+"&per="+per+"&extcode="+extcode+"&t="+t)
                    .cookies(cookies)
                    .get();
            String text = data.text();
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
