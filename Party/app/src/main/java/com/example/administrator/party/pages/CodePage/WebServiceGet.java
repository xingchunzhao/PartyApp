package com.example.administrator.party.pages.CodePage;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2017/5/17.
 */

public class WebServiceGet {

    //标记登录状态
    //boolean loginstatic = false;
    public static int loginflag = 1;

    private static String IP = "192.168.1.166:9090";
    //通过Get方式获取HTTP服务器数据
    public static String executeHttpGet(String date)
    {

        HttpURLConnection conn = null;
        InputStream is = null;
        String responseMsg = "failed";
//        String path = "http://"+ IP + "/ServerDemo/login";
//        String flag = null;
        try {
//            switch (flag)
//            {
//                case "login":
//                    //用户名，密码
//                    //URL地址
//                    //String loginpath = "http://"+ IP + "/ServerDemo/login";
//                    path = path + "?username=" + username + "&password=" + password;
//                    System.out.println(path);
//                    break;
//                case "register":
//                    //用户名，密码
//                    //URL地址
//                    path = path + "?username=" + username + "&password=" + password;
//                    System.out.println(path);
//                    break;
//                case "MsgR":
//                    path = path + "?date=" + date;
//            }
            //用户名，密码
            //URL地址
            String path = "http://"+ IP + "/ServerDemo/login";
            path = path + "?date=" + date;
            System.out.println(path);


            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(3000);  //设置超时时间
            conn.setReadTimeout(3000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");//设置获取信息的方式
            conn.setRequestProperty("Charset", "UTF-8");  //设置接受数据编码格式

            if (conn.getResponseCode() == 200)
            {
                //String result = EntityUtils.toString(conn.getEntity);
                is = conn.getInputStream();
                return parseInfo(is);
//                System.out.println("Servlet: "+parseInfo(is));
//                responseMsg = parseInfo(is);
//                return responseMsg;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            //意外退出时进行连接关闭保护
            if (conn != null)
            {
                conn.disconnect();
            }
            if (is != null)
            {
                try {
                    is.close();
                }catch (Exception e)
                {
                    e.printStackTrace();

                }
            }
        }

        return responseMsg;
    }

    //将输入流转化为String型
    private static String parseInfo(InputStream inStream) throws Exception
    {
        byte[] data = read(inStream);
        //转化为字符串
        return new String(data, "UTF-8");
    }

    //将输入流转化为byte型
    public static byte[] read(InputStream inStream) throws Exception
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1)
        {
            outputStream.write(buffer,0,len);
        }
        inStream.close();
        return outputStream.toByteArray();
    }
}
