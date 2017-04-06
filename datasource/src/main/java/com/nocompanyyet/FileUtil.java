package com.nocompanyyet;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件工具类
 * Created by doctor2nd on 2017/4/6.
 */

class FileUtil {
    static File newExternalFile(String path) {
        return new File(Environment.getExternalStorageDirectory() + "/" + path);
    }

    static String read(File source) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(source));
            String readLine = "";
            while ((readLine = br.readLine()) != null) {
                content.append(readLine);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    static void write(File dest, String content) {
        try {
            if (!dest.exists()) {
                File destDir = new File(dest.getParent());
                if (!destDir.exists()) {
                    destDir.mkdirs();
                }
                dest.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(dest);
            fos.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if external storage is available for read and write
     */
    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if external storage is available to at least read
     */
    private boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}
