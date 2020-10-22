package QXQ.listener;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteInfo {
    public void appendFile(String path,String data) {
        try {
            File file = new File(path);
            //if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(file,true);
            fileWritter.write(data);
            fileWritter.flush();
            fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void interfaceData(String time, String url, String body_string, int responseCode, JSONObject responseBody){
//        time = getTime();
        appendFile("result/response.txt",
                "执行时间："+time+"\t"+"接口名称："+url+"\r\n"
                        +"请求数据："+body_string+"\r\n"
                        +"请求结果："+responseCode+"\t"+responseBody+"\r\n");
    }
    public String getTime(){
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
        String time=format.format(date);
        return time;

    }

    //此方法 获取时间 用来判断天数
    public Integer getTime2(){
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyyMMdd");
        Integer time= Integer.valueOf(format.format(date));
        return time;

    }
}
