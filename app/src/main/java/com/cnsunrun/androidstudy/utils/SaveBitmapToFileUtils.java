package com.cnsunrun.androidstudy.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ZhouBin on 2017/7/10.
 * Effect:
 */

public class SaveBitmapToFileUtils {


    public static String saveBitmapToFile(String aimpath, String _file, int quality) {
        File file = new File(_file);
        return file.exists() && file.length() != 0L ? _file : (saveBitmap(BitmapFactory.decodeFile(aimpath), _file, quality) ? _file : aimpath);
    }

    private static boolean saveBitmap(Bitmap bitmap, String _file, int quality) {
        BufferedOutputStream os = null;

        try {
            File e = new File(_file);
            int end = _file.lastIndexOf(File.separator);
            String _filePath = _file.substring(0, end);
            File filePath = new File(_filePath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }

            e.createNewFile();
            os = new BufferedOutputStream(new FileOutputStream(e));
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, os);
            boolean var8 = true;
            return var8;
        } catch (IOException var18) {
            Log.e("-->", var18.getMessage() + "  " + _file);
            var18.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException var17) {
                    Log.e("-->", var17.getMessage(), var17);
                }
            }

        }

        return false;
    }
}
