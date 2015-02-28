/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lari.terus;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 *
 * @author lifeuniverse
 */

public class objekAnimasi{

    private Bitmap bitmap; // the actual bitmap
    private Bitmap animasi1;
    private Bitmap animasi2;
    private Bitmap animasi3;
    private Bitmap animasi4;
    private Bitmap animasi5;
    private Bitmap animasi6;
    private Bitmap animasi7;
    private Bitmap animasi8;
    private Bitmap animasi9;
    private Bitmap animasi10;
    private Bitmap animasi11;
    private Bitmap animasi12;
    private Bitmap animasi13;
    private Bitmap animasi14;
    private Bitmap animasi15;
    private Bitmap animasi16;
    private Bitmap animasi17;
    private Bitmap animasi18;
    private Bitmap animasi19;
    private Bitmap animasi20;
    private Bitmap animasi21;
    private Bitmap animasi22;
    private Bitmap animasi23;
    private Bitmap animasi24;
    private Bitmap animasi25;
    private int i = 0;

    public objekAnimasi(Bitmap B){
        this.bitmap = B;
    }
    
    public void aturGambarUtama(Bitmap B){
        this.bitmap = B;
    }
    
    public Bitmap ambilGambarUtama(){
        return bitmap;
    }
    
    public void aturSprite(int N, int x0, int y0, int x1, int y1){
        Bitmap temp = Bitmap.createBitmap(bitmap, x0, y0, x1, y1);
        if(N <= 25){ 
            switch(N){
                case 1 : animasi1 = temp;
                         break;
                case 2 : animasi2 = temp;
                         break;
                case 3 : animasi3 = temp;
                         break;
                case 4 : animasi4 = temp;
                         break;
                case 5 : animasi5 = temp;
                         break;
                case 6 : animasi6 = temp;
                         break;
                case 7 : animasi7 = temp;
                         break;
                case 8 : animasi8 = temp;
                         break;
                case 9 : animasi9 = temp;
                         break;
                case 10 : animasi10 = temp;
                         break;
                case 11 : animasi11 = temp;
                         break;
                case 12 : animasi12 = temp;
                         break;
                case 13 : animasi13 = temp;
                         break;
                case 14 : animasi14 = temp;
                         break;
                case 15 : animasi15 = temp;
                         break;
                case 16 : animasi16 = temp;
                         break;
                case 17 : animasi17 = temp;
                         break;
                case 18 : animasi18 = temp;
                         break;
                case 19 : animasi19 = temp;
                         break;
                case 20 : animasi20 = temp;
                         break;
                case 21 : animasi21 = temp;
                         break;
                case 22 : animasi22 = temp;
                         break;
                case 23 : animasi23 = temp;
                         break;
                case 24 : animasi24 = temp;
                         break;
                case 25 : animasi25 = temp;
                         break;
            }
        }
    }
    
    public void aturSprite(int N, Bitmap bitmap){
        Bitmap temp = bitmap;
        if(N <= 25){
            switch(N){
                case 1 : animasi1 = temp;
                         break;
                case 2 : animasi2 = temp;
                         break;
                case 3 : animasi3 = temp;
                         break;
                case 4 : animasi4 = temp;
                         break;
                case 5 : animasi5 = temp;
                         break;
                case 6 : animasi6 = temp;
                         break;
                case 7 : animasi7 = temp;
                         break;
                case 8 : animasi8 = temp;
                         break;
                case 9 : animasi9 = temp;
                         break;
                case 10 : animasi10 = temp;
                         break;
                case 11 : animasi11 = temp;
                         break;
                case 12 : animasi12 = temp;
                         break;
                case 13 : animasi13 = temp;
                         break;
                case 14 : animasi14 = temp;
                         break;
                case 15 : animasi15 = temp;
                         break;
                case 16 : animasi16 = temp;
                         break;
                case 17 : animasi17 = temp;
                         break;
                case 18 : animasi18 = temp;
                         break;
                case 19 : animasi19 = temp;
                         break;
                case 20 : animasi20 = temp;
                         break;
                case 21 : animasi21 = temp;
                         break;
                case 22 : animasi22 = temp;
                         break;
                case 23 : animasi23 = temp;
                         break;
                case 24 : animasi24 = temp;
                         break;
                case 25 : animasi25 = temp;
                         break;
            }
        }
    }
    
    
    public Bitmap ambilSprite(int N){
        Bitmap temp = Bitmap.createBitmap(bitmap, 0, 0, 1, 1); // inisialisasi asal-asalan jika N > 25
        if(N <= 25){
            switch(N){
                case 1 : temp = animasi1;
                         break;
                case 2 : temp = animasi2;
                         break;
                case 3 : temp = animasi3;
                         break;
                case 4 : temp = animasi4;
                         break;
                case 5 : temp = animasi5;
                         break;
                case 6 : temp = animasi6;
                         break;
                case 7 : temp = animasi7;
                         break;
                case 8 : temp = animasi8;
                         break;
                case 9 : temp = animasi9;
                         break;
                case 10 : temp = animasi10;
                         break;
                case 11 : temp = animasi11;
                         break;
                case 12 : temp = animasi12;
                         break;
                case 13 : temp = animasi13;
                         break;
                case 14 : temp = animasi14;
                         break;
                case 15 : temp = animasi15;
                         break;
                case 16 : temp = animasi16;
                         break;
                case 17 : temp = animasi17;
                         break;
                case 18 : temp = animasi18;
                         break;
                case 19 : temp = animasi19;
                         break;
                case 20 : temp = animasi20;
                         break;
                case 21 : temp = animasi21;
                         break;
                case 22 : temp = animasi22;
                         break;
                case 23 : temp = animasi23;
                         break;
                case 24 : temp = animasi24;
                         break;
                case 25 : temp = animasi25;
                         break;
            }
        }
        return temp;
    }
    

    public Bitmap ambilBitmap(){
        return bitmap;
    }

    public void aturBitmap(Bitmap bitmap){
        this.bitmap = bitmap;
    }
}
