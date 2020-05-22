package file_demo;

import java.io.*;

public class File_test2 {

    //逐行读取的方法
    public static void readFile(File file)throws IOException {
//        FileReader用户读取字符流
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);

        }
        br.close();
    }

    //逐行写入的方法
    public static void writeFile(File file){
//        FileWriter是用于写入字符流
        FileWriter fileWriter=null;
        try{
            fileWriter=new FileWriter(file,true);
            for(int i=1;i<=100000;i++){
                fileWriter.write(i+"\r\n");
            }
            fileWriter.close();
            System.out.println("写入成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("写入失败");
        }
    }

    //测试
    public static void main(String[] args) {
        File file = new File("F://测试.txt");
        //写入数据
        writeFile(file);
        //读取数据
        try {
            readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
