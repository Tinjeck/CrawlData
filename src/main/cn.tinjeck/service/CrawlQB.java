package service;

import Http.HttpClientHelper;
import com.alibaba.fastjson.JSON;
import constant.ConstantPara;
import jdbc.JDBCBase;
import vo.Result;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CrawlQB {
    public void saveCrawlQb() throws Exception {
        Date beginTime = new Date();

        HttpClientHelper httpClient = new HttpClientHelper();
        //请求地址：https://my.pay.qq.com/account/account_qdqb_trade_record.shtml

        /**
         * 初始化请求参数
         * 这里除了日期，其他的可以不动
         */
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start_date = dateFormat.parse(ConstantPara.STARTDATE);
        Date end_date= dateFormat.parse(ConstantPara.ENDDATE);
        String coin_type = "0";
        int page_no = 1;
        String channel = "qdqb";
        int per = 7;
        String extcode = "";
        String t = "0.2841945974201854";

        Long intervalTime = 1000l*60*60*24*30*ConstantPara.INTERVALTIME; //查询间隔,一次查询最大6个月 默认4个月
        Date nowTime = new Date(); //查询截止时间，可以自定义，默认为当前时间
//        Date nowTime = dateFormat.parse("2009-05-01");

        //分时间段查询数据
        List sTime = new ArrayList();
        List eTime = new ArrayList();
        while (true){
            sTime.add(dateFormat.format(start_date));
            eTime.add(dateFormat.format(end_date));
            start_date.setTime(end_date.getTime()+1000l*60*60*24);
            end_date.setTime(end_date.getTime()+intervalTime);
            if(!nowTime.after(end_date)){
                break;
            }
        }

        //开始爬取
        List<Result> resultList = new ArrayList<Result>();
        for(int i = 0; i<sTime.size(); i++){
            String url = ("https://my.pay.qq.com/cgi-bin/personal/account_tradeinfo.cgi?coin_type="+coin_type+"&start_date="+sTime.get(i)+"&end_date="+eTime.get(i)+"&page_no="+page_no+"&channel="+channel+"&per="+per+"&extcode="+extcode+"&t="+t);
            String res = httpClient.sendGet(url);
            Result resultinfoVo = JSON.parseObject(res,Result.class);
            System.out.println(resultinfoVo);
            resultList.add(resultinfoVo);
            while(page_no*per < resultinfoVo.getResultinfo().getCount()){
                page_no++;
                per = resultinfoVo.getResultinfo().getPer();
                url = ("https://my.pay.qq.com/cgi-bin/personal/account_tradeinfo.cgi?coin_type="+coin_type+"&start_date="+sTime.get(i)+"&end_date="+eTime.get(i)+"&page_no="+page_no+"&channel="+channel+"&per="+per+"&extcode="+extcode+"&t="+t);
                res = httpClient.sendGet(url);
                resultinfoVo = JSON.parseObject(res,Result.class);
                System.out.println(resultinfoVo);
                resultList.add(resultinfoVo);
            }
            page_no = 1;
        }

        JDBCBase jdbcTest = new JDBCBase();
        jdbcTest.saveResultList(resultList);

        //统计爬取到的结果
        int sum = 0;
        for(Result re:resultList){
            sum += re.getResultinfo().getList().size();
        }
        System.out.println("一共爬取到"+sum+"条数据,用时"+ ((System.currentTimeMillis()-beginTime.getTime())/1000)+"秒" );

    }

}
