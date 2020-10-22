package QXQ.testcase;
import QXQ.API.QxpAPI;
import org.testng.annotations.Test;

public class Testcase {

    @Test(description = "检查男用户登录")
    public void checkmaleLogin() throws Exception {
        QxpAPI qxqAPI = new QxpAPI();
        qxqAPI.maleLogin();
    }
    @Test(description = "检查男用户注册")
    public void checkmaleReg() throws Exception {
        QxpAPI qxqAPI = new QxpAPI();
        qxqAPI.maleReg();
    }
    @Test(description = "检查缘分列表数量")
    public void checkmalefateList() throws Exception {
        QxpAPI qxqAPI = new QxpAPI();
        qxqAPI.malefateList();
    }
    @Test(description = "检查房间列表")
    public void checkonlineLiveRoomList() throws Exception {
        QxpAPI qxqAPI = new QxpAPI();
        qxqAPI.onlineLiveRoomList();
    }
    @Test(description = "检查男用户进入直播间")
    public void checkonmalejoinRoom() throws Exception {
        QxpAPI qxqAPI = new QxpAPI();
        qxqAPI.malejoinRoom();
    }
    @Test(description = "检查直播间麦上女嘉宾爱好设置")
    public void checkonliveUserSetting() throws Exception {
        QxpAPI qxqAPI = new QxpAPI();
        qxqAPI.liveUserSetting();
    }

}
