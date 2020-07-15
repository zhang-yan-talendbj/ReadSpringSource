package nio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File resource = new File("inputtest_file.txt");
        FileInputStream fileInputStream = new FileInputStream(resource);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 1);
        int i = bufferedInputStream.read();
        System.out.println((char)i);
        bufferedInputStream.mark(2);
        i = bufferedInputStream.read();
        System.out.println((char)i);
        i = bufferedInputStream.read();
        System.out.println((char)i);
        bufferedInputStream.reset();
    }
}
