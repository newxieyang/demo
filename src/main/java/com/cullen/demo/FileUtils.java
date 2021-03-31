package com.cullen.demo;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtils {


    public static File checkFile(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            throw new NullPointerException("路径为空");
        }

        File file = new File(filePath);

        if (!file.exists()) {
            throw new NullPointerException("文件不存在");
        }

        return file;
    }


    public static String readFile(String filePath) {

        File file = checkFile(filePath);


        try {
            FileInputStream fileInputStream = new FileInputStream(file);

            FileChannel channel = fileInputStream.getChannel();

            ByteBuffer bb = ByteBuffer.allocate(1024 << 4);

            byte[] bytes = new byte[1024];

            int len = 0;

            while ((len = channel.read(bb)) != -1) {
                bb.flip();

                bb.get(bytes, 0, len);

                System.out.printf(new String(bytes, 0, len));
//                while (bb.hasRemaining()) {
//                    System.out.print((char) bb.get());
//                }

                bb.clear();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }


    public static void writeFile(String filepath, String content) {



    }
}
