package constant;

import java.util.Date;

public class ConstantPara {
    public static String YOURCOOKIE = ""; //Cookie值，需要自己在网址登陆之后复制过来
    public static String STARTDATE = "2006-01-01";  //每一次查询开始时间，格式为“yyyy-MM-dd”
    public static String ENDDATE = "2006-05-01";  //每一次查询结束时间，格式为“yyyy-MM-dd”
    public static int INTERVALTIME = 4 ; //往后查询间隔，默认为4个月，最大不能超过6个月
}
