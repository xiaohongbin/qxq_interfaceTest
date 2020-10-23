package QXQ.API;

import QXQ.Constants.InterfaceConstants;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aventstack.extentreports.ExtentTest;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.io.IOException;
import java.util.HashMap;

//import com.alibaba.fastjson.JSONObject;
//import net.sf.json.JSONObject;


public class QxpAPI   {
    QXQ.http.RequestAPI client = new QXQ.http.RequestAPI();
    QXQ.listener.WriteInfo writeinfo = new QXQ.listener.WriteInfo();
    QXQ.Utils.FileWrite fw = new QXQ.Utils.FileWrite();
    QXQ.Utils.ReadExcel re = new QXQ.Utils.ReadExcel();
    JSONObject responseBody;
    int responseCode;
    static String url = null;
    static String session = null;
    String token = null;
    String sid = null;
    String roomId = null;
    String hongniangId =null;
    String nvjiabinId = null;
    CloseableHttpClient httpclient;
    HttpResponse res;
    String time = null;
    QXQ.listener.ExtentTestNGITestListener el = new QXQ.listener.ExtentTestNGITestListener();
    ExtentTest log = el.getlog();


    HashMap<String, String> responseHeads;
    String password;
    String account;


    //男用户，登录接口
    public void maleLogin() throws IOException {

        String regurl = QXQ.Constants.InterfaceConstants.HOST + "/login/byAccount?token=&sid=&";
//        String regurl = QXQ.Constants.InterfaceConstants.HOST +"/login/byAccount?token=&oh=89AE65C40257482E6F9FC7C4E843B96A_1603096438856_21efe6d3f6d1f1e9&sid=&_s=33AF8F6C789D6EF6CD134D5891E919D5C27B1BE7&_t=1603096438859";
        long timestamp = System.currentTimeMillis();//获取系统当前时间戳
        String body_string = "{\"platformInfo\": {\"fid\": 689999,\"maxClick\": \"56623\",\"release\": \"2020090310\",\"pid\": \"89AE65C40257482E6F9FC7C4E843B96A\",\"imsi\": \"89AE65C40257482E6F9FC7C4E843B96A\",\"ua\": \"\",\"versionName\": \"5.6.4\",\"systemVersion\": \"9\",\"mac\": \"B4:0F:B3:7E:A4:A3\",\"platform\": \"3\",\"baseType\": \"roseLive\",\"phonetype\": \"vivo_vivo Z1\",\"operators\": -1,\"mobileIP\": \"192.168.130.162\",\"product\": \"9\",\"netType\": 2,\"h\": 2201,\"version\": \"5.6.4\",\"versionCode\": \"1001\",\"yyCode\": \"a9559709c0a6ed74eaace7ab431e83f2\",\"version2\": \"40050604\",\"w\": 1080,\"imei\": \"862226043685179\",\"packName\": \"com.meigui.mgxq\",\"did\": \"DuV3pstKI05lWtPthv7K5mAu3yOgxtFNJr/8B08yBCb+ULZgsl1KJFAmeqfz7uQmR9BIWdCX3uZUM2146VUr678g\"},\"userName\": \"1048490712\",\"password\": \"123456\"}";

        //拼接完整URL请求
        url = client.requestHeaderInHash(timestamp, regurl);
//        System.out.println("url="+url);

        //传参发送post请求并接收reponse data
        time = writeinfo.getTime();
        res = client.http_post(url, body_string);
        responseBody = client.getBodyInJSON();
        responseCode = client.getCodeInNumber();
        responseHeads = client.getHeaderInHash();

        //获取sid
        sid = responseBody.getJSONObject("data").getJSONObject("userInfo").getString("userId");

//        String fromChannel = responseBody.getJSONObject("userInfo").getString("fid");
        System.out.println("sid"+sid);
        log.info("sid:" + sid);
        System.out.println("sid:" + sid);

        //获取登录token
        token = responseBody.getString("token");
    }
    //男用户，注册接口
    public void maleReg() throws IOException {

        String regurl = QXQ.Constants.InterfaceConstants.HOST + "/register/signUp?token=&sid=&";
        long timestamp = System.currentTimeMillis();//获取系统当前时间戳
        String body_string = "{\"platformInfo\": {\"fid\": 689999,\"maxClick\": \"56623\",\"release\": \"2020090310\",\"pid\": \"52A2971D4B0A3269FC98A6E444F20DC0\",\"imsi\": \"52A2971D4B0A3269FC98A6E444F20DC0\",\"ua\": \"\",\"versionName\": \"5.6.4\",\"systemVersion\": \"9\",\"mac\": \"B4:0F:B3:7E:A4:A3\",\"platform\": \"3\",\"baseType\": \"roseLive\",\"phonetype\": \"vivo_vivo Z1\",\"operators\": 2,\"mobileIP\": \"192.168.130.162\",\"product\": \"9\",\"netType\": 2,\"h\": 2201,\"version\": \"5.6.4\",\"versionCode\": \"1001\",\"yyCode\": \"a9559709c0a6ed74eaace7ab431e83f2\",\"version2\": \"40050604\",\"w\": 1080,\"imei\": \"862226043685179\",\"packName\": \"com.meigui.mgxq\",\"did\": \"DuV3pstKI05lWtPthv7K5mAu3yOgxtFNJr/8B08yBCb+ULZgsl1KJFAmeqfz7uQmR9BIWdCX3uZUM2146VUr678g\"},\"birthday\": \"1998-10-20\",\"longitudeAndlatitude\": \"116.423252,40.004445\",\"sex\": \"0\"}";
       //拼接完整URL请求
        url = client.requestHeaderInHash(timestamp, regurl);


        //传参发送post请求并接收reponse data
        time = writeinfo.getTime();
        res = client.http_post(url, body_string);
        responseBody = client.getBodyInJSON();
        responseCode = client.getCodeInNumber();
        responseHeads = client.getHeaderInHash();

        //获取sid
        sid = responseBody.getJSONObject("data").getJSONObject("userInfo").getString("userId");

//        String fromChannel = responseBody.getJSONObject("userInfo").getString("fid");
        log.info("sid:" + sid);
        //获取注册token
        token = responseBody.getJSONObject("data").getString("token");
        log.info("token:" + token);

    }

    /**
     * 男用户缘分列表
     */
    public void malefateList()throws IOException{
        this.maleReg();
        long timestamp = System.currentTimeMillis();
        String aurl =InterfaceConstants.HOST+"/liveblinddate/fateList?";
        String body_string ="{\"platformInfo\": {\"fid\": 689999,\"maxClick\": \"56623\",\"release\": \"2020090310\",\"pid\": \"52A2971D4B0A3269FC98A6E444F20DC0\",\"imsi\": \"52A2971D4B0A3269FC98A6E444F20DC0\",\"ua\": \"\",\"versionName\": \"5.6.4\",\"systemVersion\": \"9\",\"mac\": \"B4:0F:B3:7E:A4:A3\",\"platform\": \"3\",\"baseType\": \"roseLive\",\"phonetype\": \"vivo_vivo Z1\",\"operators\": 2,\"mobileIP\": \"192.168.130.162\",\"product\": \"9\",\"netType\": 2,\"h\": 2201,\"version\": \"5.6.4\",\"versionCode\": \"1001\",\"yyCode\": \"a9559709c0a6ed74eaace7ab431e83f2\",\"version2\": \"40050604\",\"w\": 1080,\"imei\": \"862226043685179\",\"packName\": \"com.meigui.mgxq\",\"did\": \"DuV3pstKI05lWtPthv7K5mAu3yOgxtFNJr/8B08yBCb+ULZgsl1KJFAmeqfz7uQmR9BIWdCX3uZUM2146VUr678g\"},\"batch\": \"0\",\"pageNum\": \"0\"}";
        url = client.requestHeaderInHashA(timestamp,aurl,token,sid);
//        System.out.println("url:"+url);

        time = writeinfo.getTime();
        res = client.http_post(url, body_string);
        responseBody = client.getBodyInJSON();
        responseCode = client.getCodeInNumber();
        responseHeads = client.getHeaderInHash();
        //获取列表用户数量
        Integer sum = responseBody.getJSONObject("data").getInteger("sum");
        log.info("检查缘分列表数量是否正确");
        if (sum == 0) {
            writeinfo.interfaceData(time, url, body_string, responseCode, responseBody);
            Assert.fail("，缘分列表数量错误：" + sum);
        }
        log.info("缘分列表数量："+sum+"个");
        JSONArray fateList = responseBody.getJSONObject("data").getJSONArray("fateList");
//        Integer size = responseBody.getJSONObject("data").getJSONArray("fateList").size();
//        if(!(size == 20)){
//            writeinfo.interfaceData(time,url,body_string,responseCode,responseBody);
//        }
        log.info("获取直播用户");
        Integer num = 0;
        for(int i = 0;i < fateList.size();i++){
            JSONObject oo = fateList.getJSONObject(i);
            if(oo.containsKey("roomId") ){
                num++;
//                log.info("找到第"+num+"个直播用户");
            }
        }
        log.info("一共有"+num+"个直播用户");
        log.info("检查列表中是否有重复用户");
        boolean flag = true;
        for(int i = 0;i< sum-1;i++){
            for(int j = 1;j < sum;j++){
                if(fateList.getJSONObject(i).getString("userId")==fateList.getJSONObject(j).getString("userId")){
                    flag =false;
                    log.info("重复的ID："+fateList.getJSONObject(i).getString("userId"));
                    break;
                }
            }
        }
        if(flag){
            log.info("缘分列表没有重复用户");
        }else{
            Assert.fail("缘分列表有重复数据");
        }

    }
    /**
     * 房间列表
     */
    public void onlineLiveRoomList()throws IOException{
        this.maleReg();
        long timestamp = System.currentTimeMillis();
        String aurl =InterfaceConstants.HOST+"/liveblinddate/onlineLiveRoomList?";
        String body_string ="{\"platformInfo\": {\"fid\": 689999,\"maxClick\": \"56623\",\"release\": \"2020090310\",\"pid\": \"52A2971D4B0A3269FC98A6E444F20DC0\",\"imsi\": \"52A2971D4B0A3269FC98A6E444F20DC0\",\"ua\": \"\",\"versionName\": \"5.6.4\",\"systemVersion\": \"9\",\"mac\": \"B4:0F:B3:7E:A4:A3\",\"platform\": \"3\",\"baseType\": \"roseLive\",\"phonetype\": \"vivo_vivo Z1\",\"operators\": 2,\"mobileIP\": \"192.168.130.162\",\"product\": \"9\",\"netType\": 2,\"h\": 2201,\"version\": \"5.6.4\",\"versionCode\": \"1001\",\"yyCode\": \"a9559709c0a6ed74eaace7ab431e83f2\",\"version2\": \"40050604\",\"w\": 1080,\"imei\": \"862226043685179\",\"packName\": \"com.meigui.mgxq\",\"did\": \"DuV3pstKI05lWtPthv7K5mAu3yOgxtFNJr/8B08yBCb+ULZgsl1KJFAmeqfz7uQmR9BIWdCX3uZUM2146VUr678g\"}}";
        url = client.requestHeaderInHashA(timestamp,aurl,token,sid);
//        System.out.println("url:"+url);

        time = writeinfo.getTime();
        res = client.http_post(url, body_string);
        responseBody = client.getBodyInJSON();
        responseCode = client.getCodeInNumber();
        responseHeads = client.getHeaderInHash();
        //获取房间数量
        JSONArray roomInfoList = responseBody.getJSONObject("data").getJSONArray("roomInfoList");
        Integer num = roomInfoList.size();
        log.info("检查是否有开播房间");
        if ((num == 0)) {
            writeinfo.interfaceData(time, url, body_string, responseCode, responseBody);
            log.info("当前没有开播房间");
        }else{
            log.info("直播间数量："+num);
            log.info("检查直播间金牌红娘数量");
            int jin = 0;
            int yin = 0;
            int tong =0;
            for( int i = 0;i < num;i++){
                int level = roomInfoList.getJSONObject(i).getInteger("level");

                if(level==2){
                    jin++;
                }else if(level == 1){
                    yin++;
                }else if(level == 0){
                    tong++;
                }else{
                    log.info("测试直播间");
                }

            }
            log.info("直播间，金牌"+jin+"个；银牌"+yin+"个；铜牌"+tong+"个");
            roomId = roomInfoList.getJSONObject(0).getString("roomId");
            String roomUserId = roomInfoList.getJSONObject(0).getString("roomUserId");
            log.info("选择直播间roomId："+roomId+"红娘Id:"+roomUserId);

        }


    }
    /**
     * 男用户进入房间
     */
    public void malejoinRoom()throws IOException{
        this.onlineLiveRoomList();
        long timestamp = System.currentTimeMillis();
        String aurl =InterfaceConstants.HOST+"/liveblinddate/joinRoom?";
        String body_string ="{\"platformInfo\": {\"fid\": 689999,\"maxClick\": \"56623\",\"release\": \"2020090310\",\"pid\": \"52A2971D4B0A3269FC98A6E444F20DC0\",\"imsi\": \"52A2971D4B0A3269FC98A6E444F20DC0\",\"ua\": \"\",\"versionName\": \"5.6.4\",\"systemVersion\": \"9\",\"mac\": \"B4:0F:B3:7E:A4:A3\",\"platform\": \"3\",\"baseType\": \"roseLive\",\"phonetype\": \"vivo_vivo Z1\",\"operators\": 2,\"mobileIP\": \"192.168.130.162\",\"product\": \"9\",\"netType\": 2,\"h\": 2201,\"version\": \"5.6.4\",\"versionCode\": \"1001\",\"yyCode\": \"a9559709c0a6ed74eaace7ab431e83f2\",\"version2\": \"40050604\",\"w\": 1080,\"imei\": \"862226043685179\",\"packName\": \"com.meigui.mgxq\",\"did\": \"DuV3pstKI05lWtPthv7K5mAu3yOgxtFNJr/8B08yBCb+ULZgsl1KJFAmeqfz7uQmR9BIWdCX3uZUM2146VUr678g\"},\"roomId\": \""+roomId+"\"}";
        url = client.requestHeaderInHashA(timestamp,aurl,token,sid);
//        System.out.println("url:"+body_string);

        time = writeinfo.getTime();
        res = client.http_post(url, body_string);
        responseBody = client.getBodyInJSON();
        responseCode = client.getCodeInNumber();
        responseHeads = client.getHeaderInHash();
        //获取房间内红娘和女嘉宾信息
        JSONArray roomOnlineUserList = responseBody.getJSONObject("data").getJSONArray("roomOnlineUserList");
        Integer num = roomOnlineUserList.size();
        log.info("检查房间是否有女嘉宾");
        String hongniang,nvzhubo;
        if ((num == 1)) {
            writeinfo.interfaceData(time, url, body_string, responseCode, responseBody);
            hongniang = roomOnlineUserList.getJSONObject(0).getString("nickName");
            log.info("房间没有女嘉宾,红娘昵称："+hongniang);

        }else{
            log.info("双人直播间");
            for( int i = 0;i < num;i++){
                int userRole = roomOnlineUserList.getJSONObject(i).getInteger("userRole");
                if(userRole==3){
                    hongniang = roomOnlineUserList.getJSONObject(i).getString("nickName");
                    log.info("红娘："+hongniang);
                }else{
                    nvzhubo=roomOnlineUserList.getJSONObject(i).getString("nickName");
                    log.info("女嘉宾"+nvzhubo);
                    nvjiabinId = roomOnlineUserList.getJSONObject(i).getString("userId");
                }
            }

        }

    }
    /**
     * 男用户进入房间
     * 查看直播间麦上女嘉宾
     */
    public void liveUserSetting()throws IOException{
        this.malejoinRoom();
        long timestamp = System.currentTimeMillis();
        String aurl =InterfaceConstants.HOST+"/liveblinddate/liveUserSetting?";
//        String body_string ="{\"platformInfo\": {\"fid\": 689999,\"maxClick\": \"56623\",\"release\": \"2020090310\",\"pid\": \"52A2971D4B0A3269FC98A6E444F20DC0\",\"imsi\": \"52A2971D4B0A3269FC98A6E444F20DC0\",\"ua\": \"\",\"versionName\": \"5.6.4\",\"systemVersion\": \"9\",\"mac\": \"B4:0F:B3:7E:A4:A3\",\"platform\": \"3\",\"baseType\": \"roseLive\",\"phonetype\": \"vivo_vivo Z1\",\"operators\": 2,\"mobileIP\": \"192.168.130.162\",\"product\": \"9\",\"netType\": 2,\"h\": 2201,\"version\": \"5.6.4\",\"versionCode\": \"1001\",\"yyCode\": \"a9559709c0a6ed74eaace7ab431e83f2\",\"version2\": \"40050604\",\"w\": 1080,\"imei\": \"862226043685179\",\"packName\": \"com.meigui.mgxq\",\"did\": \"DuV3pstKI05lWtPthv7K5mAu3yOgxtFNJr/8B08yBCb+ULZgsl1KJFAmeqfz7uQmR9BIWdCX3uZUM2146VUr678g\"},\"targetUserId\": \""+nvjiabinId+"\",\"source\": \"101\"}";
        String body_stringA=re.readdata(7,7);
        String body_string = body_stringA+"\"targetUserId\": \""+nvjiabinId+"\",\"source\": \"101\"}";
        url = client.requestHeaderInHashA(timestamp,aurl,token,sid);
//        System.out.println("url:"+body_string);

        time = writeinfo.getTime();
        res = client.http_post(url, body_string);
        responseBody = client.getBodyInJSON();
        responseCode = client.getCodeInNumber();
        responseHeads = client.getHeaderInHash();
        //获取房间女嘉宾爱好
        JSONArray userInterests = responseBody.getJSONObject("data").getJSONObject("userSettingView").getJSONObject("userInfo").getJSONArray("userInterests");
        Integer num = userInterests.size();
        log.info("检查女嘉宾爱好设置");
        if ((num == 0)) {
            log.info("女嘉宾没有设置爱好");
        }else{
            log.info("女嘉宾爱好:\n");
            for( int i = 0;i < num;i++){
                String tagName = userInterests.getJSONObject(i).getString("tagName");
                log.info(tagName+"；");
            }
        }
    }
    /**
     * 男用户进入房间
     * 查看更多嘉宾
     */
    public void appointmentList()throws IOException{
        this.maleReg();
        long timestamp = System.currentTimeMillis();
        String aurl =InterfaceConstants.HOST+"/liveblinddate/appointmentList?";
//        String body_string ="{\"platformInfo\": {\"fid\": 689999,\"maxClick\": \"56623\",\"release\": \"2020090310\",\"pid\": \"52A2971D4B0A3269FC98A6E444F20DC0\",\"imsi\": \"52A2971D4B0A3269FC98A6E444F20DC0\",\"ua\": \"\",\"versionName\": \"5.6.4\",\"systemVersion\": \"9\",\"mac\": \"B4:0F:B3:7E:A4:A3\",\"platform\": \"3\",\"baseType\": \"roseLive\",\"phonetype\": \"vivo_vivo Z1\",\"operators\": 2,\"mobileIP\": \"192.168.130.162\",\"product\": \"9\",\"netType\": 2,\"h\": 2201,\"version\": \"5.6.4\",\"versionCode\": \"1001\",\"yyCode\": \"a9559709c0a6ed74eaace7ab431e83f2\",\"version2\": \"40050604\",\"w\": 1080,\"imei\": \"862226043685179\",\"packName\": \"com.meigui.mgxq\",\"did\": \"DuV3pstKI05lWtPthv7K5mAu3yOgxtFNJr/8B08yBCb+ULZgsl1KJFAmeqfz7uQmR9BIWdCX3uZUM2146VUr678g\"},\"targetUserId\": \""+nvjiabinId+"\",\"source\": \"101\"}";
        String body_stringA=re.readdata(7,7);
        String body_string = body_stringA+"\"markerUserId\": \""+sid+"\"}";
        url = client.requestHeaderInHashA(timestamp,aurl,token,sid);
//        System.out.println("url:"+body_string);

        time = writeinfo.getTime();
        res = client.http_post(url, body_string);
        responseBody = client.getBodyInJSON();
        responseCode = client.getCodeInNumber();
        responseHeads = client.getHeaderInHash();
        //获取房间女嘉宾爱好
        JSONArray liveAppointmentsInfoList = responseBody.getJSONObject("data").getJSONArray("liveAppointmentsInfoList");
        Integer num = liveAppointmentsInfoList.size();
        log.info("检查更多女嘉宾列表是否显示正常");
        if ((num == 0)) {
            writeinfo.interfaceData(time, url, body_string, responseCode, responseBody);
            Assert.fail("直播间点击更多嘉宾，展示异常");
        }else{
            log.info("直播间点击更多嘉宾,展示女嘉宾："+num+"个\n");
            for( int i = 0;i < num;i++){
                String tagName = liveAppointmentsInfoList.getJSONObject(i).getString("nickName");
                log.info(tagName+"；");
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        httpclient.getConnectionManager().shutdown();


    }
}