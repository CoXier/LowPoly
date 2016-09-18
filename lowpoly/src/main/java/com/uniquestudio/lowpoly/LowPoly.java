package com.uniquestudio.lowpoly;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;

/**
 * Created by CoXier on 2016/9/14.
 */
public class LowPoly {
    static {
        System.loadLibrary("lowpoly");
    }

    public static native int[] getTriangles(int[] pixels, int width, int height, int pointNum);


    /**
     * @param input
     * @param blur
     * @return
     */
    public static Bitmap generate(Bitmap input, int blur) {
        int width = input.getWidth();
        int height = input.getHeight();
        Bitmap newImage = Bitmap.createBitmap(input.getWidth(), input.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newImage);
        Paint paint = new Paint();
        paint.setAntiAlias(false);
        paint.setStyle(Paint.Style.FILL);
        int x1, x2, x3, y1, y2, y3;
        int pixels[] = new int[width * height];
        input.getPixels(pixels,0,width,0,0,width,height);
        int[] triangles = getTriangles(pixels, width, height, blur);
        for (int i = 0; i < triangles.length; i = i + 6) {
            x1 = triangles[i];
            y1 = triangles[i + 1];
            x2 = triangles[i + 2];
            y2 = triangles[i + 3];
            x3 = triangles[i + 4];
            y3 = triangles[i + 5];

            int color = input.getPixel((x1 + x2 + x3) / 3, (y1 + y2 + y3) / 3);
            Path path = new Path();
            path.moveTo(x1, y1);
            path.lineTo(x2, y2);
            path.lineTo(x3, y3);
            path.close();
            paint.setColor(color);
            canvas.drawPath(path, paint);
        }
        return newImage;
    }
}
