package QXQ.Utils;

import java.io.*;

public class FileWrite {


    public void writerresponse(String content) throws IOException {
        String filepath = "result/response.txt";
        File file = new File(filepath);
        System.out.println("88888");
        //if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStreamWriter out = null;
        try {
            out = new OutputStreamWriter(new FileOutputStream(filepath), "utf8");
            out.write(content);
            out.flush();
//            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                out.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
