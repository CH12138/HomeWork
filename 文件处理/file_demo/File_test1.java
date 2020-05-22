package file_demo;

import java.io.File;

public class File_test1 {

    //遍历目录下的所有文件（包括子目录下文件）
    private static void list_file(File file){
        //返回一个抽象路径名数组，表示由该抽象路径名表示的目录中的文件。
        File[] fs=file.listFiles();
        for (File f : fs) {
            //判断f是否是文件夹
            if (f.isDirectory()){
                //调用自身方法，递归实现
                list_file(f);
                //判断是否是文件
            }else  if (f.isFile()){
                System.out.println(f);
            }
        }
    }
    public static void main(String[] args) {
        File file = new File("F:\\文件测试");
        list_file(file);

    }
}
