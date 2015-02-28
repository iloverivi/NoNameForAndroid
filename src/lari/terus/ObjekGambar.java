package lari.terus;

import android.graphics.Bitmap;

public class objekGambar{

    private Bitmap bitmap;
    private float x;   // koordinat X
    private float y;   // koordinat Y
    private float lebar;
    private float tinggi;
    private int nilaiAZ = 100;
    private int nilaiZA = 100;
    private int RIO = 0;
    private int RIO1 = 0;
    private boolean ada = true;

    public objekGambar(Bitmap bitmap, float x, float y, float lebar, float tinggi) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
	this.lebar = lebar;
	this.tinggi = tinggi;
    }
    
    public int ambilR(){
        return RIO;
    }
    
    public void aturR(int N){
        this.RIO = N;
    }
    
    public int ambilR1(){
        return RIO1;
    }
    
    public void aturR1(int N){
        this.RIO1 = N;
    }
    
    public boolean ambilAda(){
        return ada;
    }
    
    public void aturAda(boolean B){
        this.ada = B;
    }

    public Bitmap ambilBitmap() {
        return bitmap;
    }

    public void aturBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public float ambilLebar(){
    	return lebar;
    }
    
    public void aturLebar(float lebar){
    	this.lebar = lebar;
    } 

    public float ambilTinggi(){
    	return tinggi;
    }
    
    public int ambilNilaiAZ(){
        return nilaiAZ;
    }
    
    public int ambilNilaiZA(){
        return nilaiZA;
    }
    
    public void aturTinggi(float tinggi){
    	this.tinggi = tinggi;
    } 

    public float ambilX(){
        return x;
    }

    public void aturX(float x){
        this.x = x;
    }

    public float ambilY(){
        return y;
    }

    public void aturY(float y){
        this.y = y;
    }
    
    public void aturNilaiAZ(int N){
        this.nilaiAZ = N;
        if(this.nilaiAZ < 0)
            this.nilaiAZ = 0;
    }
    
    public void aturNilaiZA(int N){
        this.nilaiZA = N;
        if(this.nilaiZA < 0)
            this.nilaiZA = 0;
    }
}
