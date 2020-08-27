package Http;

import com.alibaba.fastjson.JSON;
import constant.ConstantPara;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import vo.Result;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HttpClientHelper {
    public String sendPost(String urlParam) throws HttpException, IOException {
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        // 创建post请求方法实例对象
        PostMethod postMethod = new PostMethod(urlParam);
        // 设置post请求超时时间
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");
        postMethod.addRequestHeader("Content-Type", "application/json");

        httpClient.executeMethod(postMethod);

        String result = postMethod.getResponseBodyAsString();
        postMethod.releaseConnection();
        return result;
    }
    public String sendGet(String urlParam) throws HttpException, IOException {
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        // 创建GET请求方法实例对象
        GetMethod getMethod = new GetMethod(urlParam);
        // 设置post请求超时时间
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        getMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");
        getMethod.addRequestHeader("Content-Type", "application/json");
//        getMethod.setRequestHeader("Cookie","RK=9GDUhi7Hdv; ptcz=01620d42e5b51b5c289fbb70ec13a61ae8645ea5a420abfc7592ba03955efa13; ied_qq=o0313317924; pgv_pvid=9646215256; eas_sid=g115z8u5b970q4J76065I691m2; pgv_pvi=1200336896; o_cookie=313317924; pac_uid=1_313317924; ts_uid=6016330006; pay_mobile_account=qq; pay_openid=B45E37EE6CC631CFC1DD01668E183431; pay_openkey=EF2F6537D8539C5A6F850C0B14500306; pay_qq_appid=101502376; pay_session_id=openid; pay_session_type=kp_accesstoken; pay_qq_avatar=http://thirdqq.qlogo.cn/g?b=oidb&k=kZRm6tuVibXtQiapQKU6GnoA&s=100&t=1556452553; pay_qq_nickname=遗芬余荣; aid4open=pay.adeny.roy; ts_refer=my.pay.qq.com/account/account_qdqb_trade_record.shtml; uin=o0313317924; iip=0; pgv_si=s2155487232; skey=@n8TNVysRK; rv2=8065D1BEE47E6D66445954916DD7F2F3864C0154C47B313992; property20=86009F5E798FD72E943449D2221C7DF20AFF4DFCBC093622A00F2420D03983E2F0F3BAD0AA2C524E; idqq_account=theCanChange%3D1%3BtheShowUin%3D313317924%3BBindedPhone%3D166******96%3BPhoneCanSeach%3D0%3BBindedEmail%3Dtinjeck@qq.com%3BEmailCanSeach%3D1%3BEmailIsActive%3D1%3BUinCanSeach%3D1%3Bshouldshowmail%3D1%3Bfirstsetidqq%3D1%3BMSK%3D0%3B; pgv_info=ssid=s1974607448&pgvReferrer=https://my.pay.qq.com/account/account_qdqb_trade_record.shtml; pay_sessionid=A2E462F334A0E73B36994C23B5B2B2DE; verifysession=h01eda0e19f2e4889916a8639c3ba8766545ecf3b34b91dee990591efeabc0a68e950ad7342aeac13b8");
        getMethod.setRequestHeader("Cookie",ConstantPara.YOURCOOKIE);

        httpClient.executeMethod(getMethod);

        String result = getMethod.getResponseBodyAsString();
        getMethod.releaseConnection();
        return result;
    }
}