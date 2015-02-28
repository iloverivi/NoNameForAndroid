	

     # Maaf kodenya ga rapi dan belum sempat buat dokumentasi, silahkan ditanya-tanya jika perlu.
     
    package lari.terus;
     
    import android.content.Context;
    import android.media.MediaPlayer;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.graphics.Canvas;
    import android.graphics.RectF;
    import android.view.View;
    import android.graphics.BitmapFactory;
    import android.view.MotionEvent;
     
    public class Dunia extends View {
       
       
       private MediaPlayer musiklatar;
       private MediaPlayer musikmain;
       private MediaPlayer musiklari;
       private MediaPlayer musikmemukul;
       private MediaPlayer musikciattt;
       private MediaPlayer musiktik;
       
       private RectF HP;
       private RectF MP;
       private RectF EXP;
       
       // xMin adalah posisi nol(0) dari layar
       private int xMin = 0;
       
       // xMax adalah posisi akhir dari sumbu-x layar atau lebar layar (480px) saat landscape
       private int xMax;
       
       //yMin adalah posisi nol(0) dari layar
       private int yMin = 0;
       
       // yMax adalah posisi akhir dari sumbu-y layar atau lebar layar (320px) saat landscape
       private int yMax;
       
       // i dimanfaatkan untuk menggerakkan animasi saat tombolA ditekan, mis. Animasi saat
       // menghunus pedang. -> Lihat bagian private void update()
       private int i = 0;
       
       //1 kanan, 2 kiri, 3 atas, 4 bawah
       private int arahSekarang = 1;
       
       // arahKiriKananSekarang adalah posisi hadap karakter (pemain) saat ini. Jika sedang
       // menghadap ke kanan bernilai 1, jika ke kiri bernilai 0. Nilai hanya 1 dan 0
       private int arahKiriKananSekarang = 1;
       
       // modeHunusPedang adalah nomor gambar animasi yang akan digerakkan. Nilai nol(0) artinya
       // animasi berhenti. Misalkan nilai variabel ini adalah N berarti menampilkan gambar ke-N
       // dari deretan animasi karakter saat menghunus pedang-> Lihat bagian private void update()
       private int modeHunusPedang = 0;
       
       // modeBerjalanKeKanan berfungsi hampir seperti variabel modeHunusPedang namun digunakan
       // untuk menggerakkan animasi karakter(pemain) saat berjalan ke arah kanan -> Lihat bagian
       // private void update()
       private int modeBerjalanKeKanan = 0;
       
       // sama seperti variabel modeBerjalanKeKanan namun berbeda arah
       private int modeBerjalanKeKiri = 0;
       
       // sama seperti variabel modeBerjalanKeKanan namun berbeda arah
       private int modeBerjalanKeAtas = 0;
       
       // sama seperti variabel modeBerjalanKeKanan namun berbeda arah
       private int modeBerjalanKeBawah = 0;
       
       // sama seperti variabel modeBerjalanKeKanan namun berbeda arah
       private int modeMinumRamuan = 0;
       
       private int modePopupSkor = 0;
       
       private int posisiXKarakter = 0;
       
       // -----
       
       private int sisaWaktu;
       private boolean waktuHabis = false;
       
       // -----
       
       private int exp;
       
       private int level1 = 100;
       private int level2 = 150;
       private int level3 = 200;
       private int level4 = 250;
       private int level5 = 300;
       private int levelPermainan;
       
       private float batasAtas = 100;
       private float batasBawah = 320;
       
       
       // variabel ini digunakan untuk mengakses private void gerakKeKanan(float v) -> Lihat
       // bagian private void gerakKeKanan(float v)
       private boolean boolGerakKeKanan = false;
       
       // sama seperti variabel boolGerakKeKanan namun beda arah
       private boolean boolGerakKeKiri = false;
       
       // sama seperti variabel boolGerakKeKanan namun beda arah
       private boolean boolGerakKeAtas = false;
       
       // sama seperti variabel boolGerakKeKanan namun beda arah
       private boolean boolGerakKeBawah = false;
       
       private boolean boolMinumRamuan = false;
       
       // cukup jelas
       private objekGambar karakterA;
       
       private objekGambar musuhA;
       private int posisiXAwalMusuhA = 400;
       private int posisiYAwalMusuhA = 260;
       
       private objekGambar musuhB;
       private int posisiXAwalMusuhB = -1500;
       private int posisiYAwalMusuhB = 160;
       
       private objekGambar musuhC;
       private int posisiXAwalMusuhC = 900;
       private int posisiYAwalMusuhC = 260;
       
       private objekGambar musuhD;
       private int posisiXAwalMusuhD = -500;
       private int posisiYAwalMusuhD = 160;
       
       private objekGambar musuhE;
       private int posisiXAwalMusuhE = 1200;
       private int posisiYAwalMusuhE = 260;
       
       private objekGambar musuhF;
       private int posisiXAwalMusuhF = -2000;
       private int posisiYAwalMusuhF = 160;
       
       private objekGambar musuhG;
       private int posisiXAwalMusuhG = 1500;
       private int posisiYAwalMusuhG = 260;
       
       private objekGambar musuhH;
       private int posisiXAwalMusuhH = -1000;
       private int posisiYAwalMusuhH = 160;
       
       private objekGambar musuhI;
       private int posisiXAwalMusuhI = 2500;
       private int posisiYAwalMusuhI = 260;
       
       private objekGambar musuhJ;
       private int posisiXAwalMusuhJ = 400;
       private int posisiYAwalMusuhJ = 260;
       
       
       // cukup jelas
       private objekGambar latarA;
       
       // cukup jelas
       private objekGambar latarB;
       
       // cukup jelas
       private objekGambar latarC;
     
       // cukup jelas
       private objekGambar tombolAtas;
       
       // cukup jelas
       private objekGambar tombolBawah;
       
       // cukup jelas
       private objekGambar tombolKanan;
       
       // cukup jelas
       private objekGambar tombolKiri;
       
       // cukup jelas
       private objekGambar tombolA;
       
       // cukup jelas
       private objekGambar tombolB;
       
       // cukup jelas
       private objekGambar tombolC;
       
       // cukup jelas
       private objekGambar tombolPause;
       
       // cukup jelas
       private objekGambar layarPause;
       
       // cukup jelas
       private objekGambar tKembali;
       
       // cukup jelas
       private objekGambar tReset;
       
       // cukup jelas
       private objekGambar tKeluar;
       
       // cukup jelas
       private objekGambar hpBar;
       
       private objekGambar tombolMulai;
       
       private objekGambar tombolBantuan;
       
       private objekGambar tombolKredit;
       
       private objekGambar tombolSebelum;
       
       private objekGambar tombolSesudah;
     
     
       //-------
       
       private objekGambar latarMenuUtama;
       private int YMenuUtama = -320;
       private boolean munculkanMenuUtama = true;
       private int sembunyikanMenuUtama = 0;
       
       //-------
       
       private objekGambar latarBantuan;
       private objekGambar dataBantuan;
       
       // ------
       
       private objekGambar latarKredit;
       private objekGambar dataKredit;
       
       // ------
     
       private objekGambar latarGameOver; // Tambahan
     
       // ------
       
       private objekAnimasi spriteMinumRamuan;
       
       private objekAnimasi spriteLariKeKanan;
       
       private objekAnimasi spriteLariKeKiri;
       
       private objekAnimasi spriteLariKeAtas;
       
       private objekAnimasi spriteLariKeBawah;
       
       private objekAnimasi spriteMusuhKiriL;
       
       private objekAnimasi spriteMusuhKananL;
       
       private objekAnimasi spriteMusuhKiriM;
       
       private objekAnimasi spriteMusuhKananM;
       
       private objekAnimasi spriteMusuhHancur;
       
       private objekAnimasi quas;
       
       private objekAnimasi spriteMenyerang;
       
       
       // ------
       private class popupSkor{
           private float x;
           private float y;
           private String S;
           private Paint cat;
           private int animasiPopupSkor = 0;
           private float awalX = -50;
           private float awalY = -50;
           
           public popupSkor(String S, float x, float y, int warna){
               this.S = S;
               this.x = x;
               this.y = y;
               this.cat = new Paint();
               this.cat.setColor(warna);
           }
           
           public String ambilTeks(){
               return S;
           }
           
           public float ambilX(){
               return x;
           }
           
           public float ambilY(){
               return y;
           }
           
           public Paint ambilCat(){
               return cat;
           }
           
           public int ambilAnimasiPopupSkor(){
               return animasiPopupSkor;
           }
           
           public void ambilPosisiAwal(){
               this.x = awalX;
               this.y = awalY;
           }
           
           public void aturTeks(String S){
               this.S = S;
           }
           
           public void aturX(float x){
               this.x = x;
           }
           
           public void aturY(float y){
               this.y = y;
           }
           
           public void aturWarna(int warna){
               this.cat.setColor(warna);
           }
           
           public void aturAnimasiPopupSkor(int i){
               this.animasiPopupSkor = i;
           }
       }
       
       private popupSkor skor1;
       private popupSkor skor2;
       private popupSkor skor3;
       private popupSkor skor4;
       private popupSkor skor5;
       private popupSkor skor6;
       private String teksBantuan = "Hello";
       
       private boolean skenarioMain = false;
       private boolean skenarioMenuUtama = true;
       private boolean skenarioBantuan = false;
       private boolean skenarioKredit = false;
       private boolean skenarioGameOver = false; // Tambahan
       private boolean kanvasSkenarioMain = false;
       private boolean kanvasSkenarioMenuUtama = true;
       private boolean kanvasSkenarioBantuan = false;
       private boolean kanvasSkenarioKredit = false;
       private boolean kanvasSkenarioGameOver = false; // Tambahan
       private boolean modePause = true;
       
       private Paint merah;
       private Paint biru;
       private Paint hijau;
       
       
       
       
       // Konstruktor <-- ???
       public Dunia(Context context) {
          // | ???
          // v
          super(context);
         
         
          musiklatar = MediaPlayer.create(context, R.raw.musiklatar2);
          musikmain = MediaPlayer.create(context, R.raw.musikmain);
          musikciattt = MediaPlayer.create(context, R.raw.punch);
          musikmemukul = MediaPlayer.create(context, R.raw.tik);
          musiklari = MediaPlayer.create(context, R.raw.run);
          musiktik = MediaPlayer.create(context, R.raw.klik);
          musikmain.setVolume(0.2f, 0.3f);
          musiklatar.setVolume(0.3f, 0.4f);
          musiklatar.setLooping(true);
          musikmain.setLooping(true);  
          musiklari.setLooping(true);
          musiktik.start();
          musiktik.pause();
          musiklari.start();
          musiklari.pause();
          musikciattt.start();
          musikciattt.pause();
          musikmemukul.start();
          musikmemukul.pause();
          musiklatar.start();
          //musiklari.start();
         
         
          // BitmapFactory.decodeResource(getResources(), R.drawable.<nama berkas *.png> adalah objek bitmap yang
          // ada pada folder "res" dari proyek.
          // objek gambar dibuat dengan pemanggilan sbg. berikut :
          //  >> new objekGambar(<BITMAP>, <POSISI AWAL-X>, <POSISI AWAL-Y>, <LEBAR>, <TINGGI>);
          merah = new Paint();
          merah.setColor(Color.RED);
          biru = new Paint();
          biru.setColor(Color.BLUE);
          hijau = new Paint();
          hijau.setColor(Color.GREEN);
         
         
          latarMenuUtama = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.bgmenuutama), 0, 0, 480, 320);
          latarBantuan = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.bgbantuan), 0, 0, 480, 320);
          latarGameOver = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.bggameover), 0, 0, 480, 320); // Tambahan
          dataBantuan = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.bantuan1), 0, 0, 300, 300);
            dataBantuan.aturR(1);
          latarKredit = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.bgkredit), 0, 0, 480, 320);
          //dataKredit = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.kredit), 0, 0, 300, 300);
          latarA = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.bgn), 480 * 0, 0, 480, 320);
          latarB = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.bgn), 480 * 1, 0, 480, 320);
          latarC = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.bgn), 480 * 2, 0, 480, 320);
          tombolAtas = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.atas), 28.24f, 197.5f, 69, 49);
          tombolBawah = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.bawah), 28.24f, 264.84f, 69, 49);
          tombolKanan = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.kanan), 70.51f, 222.6f, 49, 69);
          tombolKiri = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.kiri), 4.56f, 222.6f, 49, 69);
          tombolA = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.a), 430.62f, 200, 40f, 40f);
          tombolB = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.bn), 430.62f, 270, 40f, 40f);
          tombolC = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.cn), 430.62f, 249.97f, 40f, 40f);
          layarPause = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.layarpause), 145.65f, 65.37f, 188.69f, 189.27f);
          tKembali = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.tkembali), 167.44f, 104.76f, 147.28f, 33.44f);
          tReset = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.treset), 167.44f, 144.76f, 147.28f, 33.44f);
          tKeluar = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.tkeluar), 167.44f, 182.76f, 147.28f, 33.44f);
          tombolPause = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.pausen), 430.62f, 9.97f, 40f, 40f);
          musuhA = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.b1), 400 , 260, 39, 73);
            musuhA.aturR1(9);
          musuhB = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.b1), -1500 , 160, 39, 73);
            musuhB.aturR1(9); //NNN  
          musuhC = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.b1), 900 , 260, 39, 73);
            musuhC.aturR1(9);
          musuhD = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.b1), -500 , 160, 39, 73);
            musuhD.aturR1(9); //NNN  
          musuhE = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.b1), 1200 , 260, 39, 73);
            musuhE.aturR1(9);
          musuhF = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.b1), -2000 , 160, 39, 73);
            musuhF.aturR1(9); //NNN  
          musuhG = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.b1), 1500 , 260, 39, 73);
            musuhG.aturR1(9);
          musuhH = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.b1), -1000 , 160, 39, 73);
            musuhH.aturR1(9); //NNN  
          musuhI = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.b1), 2500 , 260, 39, 73);
            musuhI.aturR1(9);
          musuhJ = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.b1), -2500 , 160, 39, 73);
            musuhJ.aturR1(9); //NNN  
          karakterA = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.diamdepan), (480-32)/2 , 260, 39, 73);
          hpBar = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.hpbar), 10, 11.93f, 241, 67);
          // ada kesalahan penamaan seharusnya tbmulaid menjadi tbmulai
          tombolMulai = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.tbmulaid), 0, 73.207f, 322.197f, 53.089f);
          tombolBantuan = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.tbbantuand), 0, 132.065f, 322.197f, 53.089f);
          tombolKredit = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.tbkreditd), 0, 191.065f, 322.197f, 53.089f);
          tombolSebelum = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.tbsebelum), 20, 240, 62, 62);
          tombolSesudah = new objekGambar(BitmapFactory.decodeResource(getResources(), R.drawable.tbsesudah), 400, 240, 62, 62);
          skor1 = new popupSkor("10", -50, -50, Color.WHITE);
          skor2 = new popupSkor("10", -50, -50, Color.BLUE);
          skor3 = new popupSkor("10", -50, -50, Color.WHITE);
          skor4 = new popupSkor("10", -50, -50, Color.BLUE);
          skor5 = new popupSkor("10", -50, -50, Color.WHITE);
          skor6 = new popupSkor("10", -50, -50, Color.BLUE);
         
          batasBawah = 320 - karakterA.ambilTinggi();
         
          aturLevel(1);
         
          // sprite musuh hancur
          spriteMusuhHancur = new objekAnimasi(BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar2));
          spriteMusuhHancur.aturSprite(1, BitmapFactory.decodeResource(getResources(), R.drawable.musuhhancur12));
          spriteMusuhHancur.aturSprite(2, BitmapFactory.decodeResource(getResources(), R.drawable.musuhhancur11));
          spriteMusuhHancur.aturSprite(3, BitmapFactory.decodeResource(getResources(), R.drawable.musuhhancur10));
          spriteMusuhHancur.aturSprite(4, BitmapFactory.decodeResource(getResources(), R.drawable.musuhhancur9));
          spriteMusuhHancur.aturSprite(5, BitmapFactory.decodeResource(getResources(), R.drawable.musuhhancur8));
          spriteMusuhHancur.aturSprite(6, BitmapFactory.decodeResource(getResources(), R.drawable.musuhhancur7));
          spriteMusuhHancur.aturSprite(7, BitmapFactory.decodeResource(getResources(), R.drawable.musuhhancur6));
          spriteMusuhHancur.aturSprite(8, BitmapFactory.decodeResource(getResources(), R.drawable.musuhhancur5));
          spriteMusuhHancur.aturSprite(9, BitmapFactory.decodeResource(getResources(), R.drawable.musuhhancur4));
         
          // sprite musuh lari ke kiri
          spriteMusuhKiriL = new objekAnimasi(BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar2));
          spriteMusuhKiriL.aturSprite(1, BitmapFactory.decodeResource(getResources(), R.drawable.terbangkiri1));
          spriteMusuhKiriL.aturSprite(2, BitmapFactory.decodeResource(getResources(), R.drawable.terbangkiri2));
          spriteMusuhKiriL.aturSprite(3, BitmapFactory.decodeResource(getResources(), R.drawable.terbangkiri3));
          spriteMusuhKiriL.aturSprite(4, BitmapFactory.decodeResource(getResources(), R.drawable.terbangkiri4));
          spriteMusuhKiriL.aturSprite(5, BitmapFactory.decodeResource(getResources(), R.drawable.terbangkiri5));
          spriteMusuhKiriL.aturSprite(6, BitmapFactory.decodeResource(getResources(), R.drawable.terbangkiri6));
         
          // sprite musuh lari ke kanan
          spriteMusuhKananL = new objekAnimasi(BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar2));
          spriteMusuhKananL.aturSprite(1, BitmapFactory.decodeResource(getResources(), R.drawable.terbangkanan1));
          spriteMusuhKananL.aturSprite(2, BitmapFactory.decodeResource(getResources(), R.drawable.terbangkanan2));
          spriteMusuhKananL.aturSprite(3, BitmapFactory.decodeResource(getResources(), R.drawable.terbangkanan3));
          spriteMusuhKananL.aturSprite(4, BitmapFactory.decodeResource(getResources(), R.drawable.terbangkanan4));
          spriteMusuhKananL.aturSprite(5, BitmapFactory.decodeResource(getResources(), R.drawable.terbangkanan5));
          spriteMusuhKananL.aturSprite(6, BitmapFactory.decodeResource(getResources(), R.drawable.terbangkanan6));
         
          // quas <-- ???
          quas = new objekAnimasi(BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar2));
          quas.aturSprite(1, BitmapFactory.decodeResource(getResources(), R.drawable.quas1));
          quas.aturSprite(2, BitmapFactory.decodeResource(getResources(), R.drawable.quas2));
          quas.aturSprite(3, BitmapFactory.decodeResource(getResources(), R.drawable.quas3));
          quas.aturSprite(4, BitmapFactory.decodeResource(getResources(), R.drawable.quas4));
          quas.aturSprite(5, BitmapFactory.decodeResource(getResources(), R.drawable.quas5));
          quas.aturSprite(6, BitmapFactory.decodeResource(getResources(), R.drawable.quas6));
          quas.aturSprite(7, BitmapFactory.decodeResource(getResources(), R.drawable.quas7));
          quas.aturSprite(8, BitmapFactory.decodeResource(getResources(), R.drawable.quas8));
          quas.aturSprite(9, BitmapFactory.decodeResource(getResources(), R.drawable.quas9));
          quas.aturSprite(10, BitmapFactory.decodeResource(getResources(), R.drawable.quas10));
          quas.aturSprite(11, BitmapFactory.decodeResource(getResources(), R.drawable.quas11));
          quas.aturSprite(12, BitmapFactory.decodeResource(getResources(), R.drawable.quas12));
          quas.aturSprite(13, BitmapFactory.decodeResource(getResources(), R.drawable.quas13));
          quas.aturSprite(14, BitmapFactory.decodeResource(getResources(), R.drawable.quas14));
          quas.aturSprite(15, BitmapFactory.decodeResource(getResources(), R.drawable.quas15));
          quas.aturSprite(16, BitmapFactory.decodeResource(getResources(), R.drawable.quas16));
          quas.aturSprite(17, BitmapFactory.decodeResource(getResources(), R.drawable.quas17));
          quas.aturSprite(18, BitmapFactory.decodeResource(getResources(), R.drawable.quas18));
          quas.aturSprite(19, BitmapFactory.decodeResource(getResources(), R.drawable.quas19));
         
          // sprite Minum Ramuan
          spriteMinumRamuan = new objekAnimasi(BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar2));
          spriteMinumRamuan.aturSprite(1, BitmapFactory.decodeResource(getResources(), R.drawable.minumramuan1));
          spriteMinumRamuan.aturSprite(2, BitmapFactory.decodeResource(getResources(), R.drawable.minumramuan2));
          spriteMinumRamuan.aturSprite(3, BitmapFactory.decodeResource(getResources(), R.drawable.minumramuan3));
          spriteMinumRamuan.aturSprite(4, BitmapFactory.decodeResource(getResources(), R.drawable.minumramuan4));
          spriteMinumRamuan.aturSprite(5, BitmapFactory.decodeResource(getResources(), R.drawable.minumramuan5));
          spriteMinumRamuan.aturSprite(6, BitmapFactory.decodeResource(getResources(), R.drawable.minumramuan6));
          spriteMinumRamuan.aturSprite(7, BitmapFactory.decodeResource(getResources(), R.drawable.minumramuan7));
          spriteMinumRamuan.aturSprite(8, BitmapFactory.decodeResource(getResources(), R.drawable.minumramuan8));
          spriteMinumRamuan.aturSprite(9, BitmapFactory.decodeResource(getResources(), R.drawable.minumramuan9));
          spriteMinumRamuan.aturSprite(10, BitmapFactory.decodeResource(getResources(), R.drawable.minumramuan10));
          spriteMinumRamuan.aturSprite(11, BitmapFactory.decodeResource(getResources(), R.drawable.minumramuan11));
           
          // sprite Jalan Ke Kanan
          spriteLariKeKanan = new objekAnimasi(BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar2));
          spriteLariKeKanan.aturSprite(1, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar1));
          spriteLariKeKanan.aturSprite(2, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar2));
          spriteLariKeKanan.aturSprite(3, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar3));
          spriteLariKeKanan.aturSprite(4, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar4));
          spriteLariKeKanan.aturSprite(5, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar5));
          spriteLariKeKanan.aturSprite(6, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar6));
          spriteLariKeKanan.aturSprite(7, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar7));
          spriteLariKeKanan.aturSprite(8, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar8));
          spriteLariKeKanan.aturSprite(9, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar9));
          spriteLariKeKanan.aturSprite(10, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar10));
          spriteLariKeKanan.aturSprite(11, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar11));
          spriteLariKeKanan.aturSprite(12, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar12));
          spriteLariKeKanan.aturSprite(13, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar13));
          spriteLariKeKanan.aturSprite(14, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar14));
          spriteLariKeKanan.aturSprite(15, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar15));
          spriteLariKeKanan.aturSprite(16, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar16));
          spriteLariKeKanan.aturSprite(17, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar17));
          spriteLariKeKanan.aturSprite(18, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar18));
          spriteLariKeKanan.aturSprite(19, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar19));
          spriteLariKeKanan.aturSprite(20, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar20));
          spriteLariKeKanan.aturSprite(21, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar21));
          spriteLariKeKanan.aturSprite(22, BitmapFactory.decodeResource(getResources(), R.drawable.jalankananbar22));
         
          // sprite Jalan Ke Kiri
          spriteLariKeKiri = new objekAnimasi(BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar2));
          spriteLariKeKiri.aturSprite(1, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar1));
          spriteLariKeKiri.aturSprite(2, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar2));
          spriteLariKeKiri.aturSprite(3, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar3));
          spriteLariKeKiri.aturSprite(4, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar4));
          spriteLariKeKiri.aturSprite(5, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar5));
          spriteLariKeKiri.aturSprite(6, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar6));
          spriteLariKeKiri.aturSprite(7, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar7));
          spriteLariKeKiri.aturSprite(8, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar8));
          spriteLariKeKiri.aturSprite(9, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar9));
          spriteLariKeKiri.aturSprite(10, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar10));
          spriteLariKeKiri.aturSprite(11, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar11));
          spriteLariKeKiri.aturSprite(12, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar12));
          spriteLariKeKiri.aturSprite(13, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar13));
          spriteLariKeKiri.aturSprite(14, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar14));
          spriteLariKeKiri.aturSprite(15, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar15));
          spriteLariKeKiri.aturSprite(16, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar17));
          spriteLariKeKiri.aturSprite(17, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar18));
          spriteLariKeKiri.aturSprite(18, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar19));
          spriteLariKeKiri.aturSprite(19, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar20));
          spriteLariKeKiri.aturSprite(20, BitmapFactory.decodeResource(getResources(), R.drawable.jalankiribar21));
         
          // sprite Jalan Ke Atas
          spriteLariKeAtas = new objekAnimasi(BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar2));
          spriteLariKeAtas.aturSprite(1, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar1));
          spriteLariKeAtas.aturSprite(2, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar2));
          spriteLariKeAtas.aturSprite(3, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar3));
          spriteLariKeAtas.aturSprite(4, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar4));
          spriteLariKeAtas.aturSprite(5, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar5));
          spriteLariKeAtas.aturSprite(6, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar6));
          spriteLariKeAtas.aturSprite(7, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar7));
          spriteLariKeAtas.aturSprite(8, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar8));
          spriteLariKeAtas.aturSprite(9, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar9));
          spriteLariKeAtas.aturSprite(10, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar10));
          spriteLariKeAtas.aturSprite(11, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar11));
          spriteLariKeAtas.aturSprite(12, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar12));
          spriteLariKeAtas.aturSprite(13, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar13));
          spriteLariKeAtas.aturSprite(14, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar14));
          spriteLariKeAtas.aturSprite(15, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar15));
          spriteLariKeAtas.aturSprite(16, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar16));
          spriteLariKeAtas.aturSprite(17, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar17));
          spriteLariKeAtas.aturSprite(18, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar18));
          spriteLariKeAtas.aturSprite(19, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar19));
          spriteLariKeAtas.aturSprite(20, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar20));
          spriteLariKeAtas.aturSprite(21, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar21));
          spriteLariKeAtas.aturSprite(22, BitmapFactory.decodeResource(getResources(), R.drawable.jalanbelakangbar22));
         
          // sprite Jalan Ke Bawah
          spriteLariKeBawah = new objekAnimasi(BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar2));
          spriteLariKeBawah.aturSprite(1, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar2));
          spriteLariKeBawah.aturSprite(2, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar3));
          spriteLariKeBawah.aturSprite(3, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar4));
          spriteLariKeBawah.aturSprite(4, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar5));
          spriteLariKeBawah.aturSprite(5, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar6));
          spriteLariKeBawah.aturSprite(6, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar7));
          spriteLariKeBawah.aturSprite(7, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar8));
          spriteLariKeBawah.aturSprite(8, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar9));
          spriteLariKeBawah.aturSprite(9, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar10));
          spriteLariKeBawah.aturSprite(10, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar11));
          spriteLariKeBawah.aturSprite(11, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar12));
          spriteLariKeBawah.aturSprite(12, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar13));
          spriteLariKeBawah.aturSprite(13, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar14));
          spriteLariKeBawah.aturSprite(14, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar15));
          spriteLariKeBawah.aturSprite(15, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar16));
          spriteLariKeBawah.aturSprite(16, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar17));
          spriteLariKeBawah.aturSprite(17, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar18));
          spriteLariKeBawah.aturSprite(18, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar19));
          spriteLariKeBawah.aturSprite(19, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar20));
          spriteLariKeBawah.aturSprite(20, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar21));
          spriteLariKeBawah.aturSprite(21, BitmapFactory.decodeResource(getResources(), R.drawable.jalandepanbar22));
         
         
       }
     
       // | ???
       // v
       @Override
       protected void onDraw(Canvas canvas) {
          // Menggambar semua objek yang dibutuhkan pada layar
          // API menggambar objek pada kanvas, sbb. :
          // canvas.drawBitmap(<BITMAP>, <POSISI-X>, <POSISI-Y>, <???>);
           
            // main
            if(kanvasSkenarioMain){
                // Gambar latar 1
                canvas.drawBitmap(latarA.ambilBitmap(), latarA.ambilX(), latarA.ambilY(), null);      
     
                // Gambar latar 2
                canvas.drawBitmap(latarB.ambilBitmap(), latarB.ambilX(), latarB.ambilY(), null);
     
                // Gambar latar 3
                canvas.drawBitmap(latarC.ambilBitmap(), latarC.ambilX(), latarC.ambilY(), null);
               
                canvas.drawBitmap(karakterA.ambilBitmap(), karakterA.ambilX()-30, karakterA.ambilY()-80, null);
               
                // quas Karakter(pemain)      
                // canvas.drawBitmap(quas.ambilSprite((i % 19) + 1), karakterA.ambilX() - 40, karakterA.ambilY() - 100, null);
     
                // musuhA
                if(musuhA.ambilR1() > 0){
                    canvas.drawBitmap(musuhA.ambilBitmap(), musuhA.ambilX(), musuhA.ambilY() - 60, null);
                }
               
                // musuhA
                if(musuhB.ambilR1() > 0){
                    canvas.drawBitmap(musuhB.ambilBitmap(), musuhB.ambilX(), musuhB.ambilY() - 60, null);
                } // NNN
               
                // musuhA
                if(musuhC.ambilR1() > 0){
                    canvas.drawBitmap(musuhC.ambilBitmap(), musuhC.ambilX(), musuhC.ambilY() - 60, null);
                }
               
                // musuhA
                if(musuhD.ambilR1() > 0){
                    canvas.drawBitmap(musuhD.ambilBitmap(), musuhD.ambilX(), musuhD.ambilY() - 60, null);
                } // NNN
               
                // musuhA
                if(musuhE.ambilR1() > 0){
                    canvas.drawBitmap(musuhE.ambilBitmap(), musuhE.ambilX(), musuhE.ambilY() - 60, null);
                }
               
                // musuhA
                if(musuhF.ambilR1() > 0){
                    canvas.drawBitmap(musuhF.ambilBitmap(), musuhF.ambilX(), musuhF.ambilY() - 60, null);
                } // NNN
               
                // musuhA
                if(musuhG.ambilR1() > 0){
                    canvas.drawBitmap(musuhG.ambilBitmap(), musuhG.ambilX(), musuhG.ambilY() - 60, null);
                }
               
                // musuhA
                if(musuhH.ambilR1() > 0){
                    canvas.drawBitmap(musuhH.ambilBitmap(), musuhH.ambilX(), musuhH.ambilY() - 60, null);
                } // NNN
               
                // musuhA
                if(musuhI.ambilR1() > 0){
                    canvas.drawBitmap(musuhI.ambilBitmap(), musuhI.ambilX(), musuhI.ambilY() - 60, null);
                }
               
                // musuhA
                if(musuhJ.ambilR1() > 0){
                    canvas.drawBitmap(musuhJ.ambilBitmap(), musuhJ.ambilX(), musuhJ.ambilY() - 60, null);
                } // NNN
               
                // Tombol kanan
                canvas.drawBitmap(tombolKanan.ambilBitmap(), tombolKanan.ambilX(), tombolKanan.ambilY(), null);
     
                // Tombol kiri
                canvas.drawBitmap(tombolKiri.ambilBitmap(), tombolKiri.ambilX(), tombolKiri.ambilY(), null);
     
                // Tombol atas
                canvas.drawBitmap(tombolAtas.ambilBitmap(), tombolAtas.ambilX(), tombolAtas.ambilY(), null);
     
                // Tombol bawah
                canvas.drawBitmap(tombolBawah.ambilBitmap(), tombolBawah.ambilX(), tombolBawah.ambilY(), null);
     
     
                // Tombol A
                canvas.drawBitmap(tombolA.ambilBitmap(), tombolA.ambilX(), tombolA.ambilY(), null);
     
                // Tombol B
                canvas.drawBitmap(tombolB.ambilBitmap(), tombolB.ambilX(), tombolB.ambilY(), null);
     
                // Tombol C
                //canvas.drawBitmap(tombolC.ambilBitmap(), tombolC.ambilX(), tombolC.ambilY(), null);
     
                // Tombol Pause
                canvas.drawBitmap(tombolPause.ambilBitmap(), tombolPause.ambilX(), tombolPause.ambilY(), null);
     
                canvas.drawText(skor1.ambilTeks(), skor1.ambilX(), skor1.ambilY(), skor1.ambilCat());
                canvas.drawText(skor2.ambilTeks(), skor2.ambilX(), skor2.ambilY(), skor2.ambilCat());
                canvas.drawText(skor3.ambilTeks(), skor3.ambilX(), skor3.ambilY(), skor3.ambilCat());
                canvas.drawText(skor4.ambilTeks(), skor4.ambilX(), skor4.ambilY(), skor4.ambilCat());
                canvas.drawText(skor5.ambilTeks(), skor5.ambilX(), skor5.ambilY(), skor5.ambilCat());
                canvas.drawText(skor6.ambilTeks(), skor6.ambilX(), skor6.ambilY(), skor6.ambilCat());
                canvas.drawText(teksBantuan, 300, 40, skor1.ambilCat());
                canvas.drawRect(91.125f, 33.34f, 91.125f + karakterA.ambilNilaiAZ() * 135.10f / 100, 33.34f + 7.19f, merah);
                if(karakterA.ambilNilaiZA() > 0)
                    canvas.drawRect(71.68f, 52.27f, 71.68f + karakterA.ambilNilaiZA() * 100.52f / 100, 52.27f + 12.03f, biru);
                canvas.drawRect(84.89f, 46.20f, 84.89f + exp * 58.12f / levelPermainan, 46.20f + 5.03f, hijau);
                 
                // Background HP Bar
                canvas.drawBitmap(hpBar.ambilBitmap(), hpBar.ambilX(), hpBar.ambilY(), null);
     
                if(modePause){
                  canvas.drawBitmap(layarPause.ambilBitmap(), layarPause.ambilX(), layarPause.ambilY(), null);
                  canvas.drawBitmap(tKembali.ambilBitmap(), tKembali.ambilX(), tKembali.ambilY(), null);
                  canvas.drawBitmap(tReset.ambilBitmap(), tReset.ambilX(), tReset.ambilY(), null);
                  canvas.drawBitmap(tKeluar.ambilBitmap(), tKeluar.ambilX(), tKeluar.ambilY(), null);
                }
            }
           
            if(kanvasSkenarioBantuan){
                canvas.drawBitmap(latarBantuan.ambilBitmap(), 0, 0, null);
                canvas.drawBitmap(dataBantuan.ambilBitmap(), dataBantuan.ambilX(),  dataBantuan.ambilY(), null);
                canvas.drawBitmap(tombolSebelum.ambilBitmap(), tombolSebelum.ambilX(),  tombolSebelum.ambilY(), null);
                canvas.drawBitmap(tombolSesudah.ambilBitmap(), tombolSesudah.ambilX(),  tombolSesudah.ambilY(), null);
            }
           
            if(kanvasSkenarioKredit){
                canvas.drawBitmap(latarKredit.ambilBitmap(), 0, 0, null);
                //canvas.drawBitmap(dataKredit.ambilBitmap(), dataKredit.ambilX(),  dataKredit.ambilY(), null);
                canvas.drawBitmap(tombolSebelum.ambilBitmap(), tombolSebelum.ambilX(),  tombolSebelum.ambilY(), null);
            }
           
            if(kanvasSkenarioGameOver){ // Tambahan
                canvas.drawBitmap(latarGameOver.ambilBitmap(), 0, 0, null);
            }
           
            // memunculkan menu utama
            if(munculkanMenuUtama){
                geserMenuUtamaDenganStepB40();
                canvas.drawText("Memuat . . .", 400, 310, biru);
            }
     
            // menyembungikan menu utama
            if(sembunyikanMenuUtama > 0){
                geserMenuUtamaDenganStepA40(sembunyikanMenuUtama);
                canvas.drawText("Memuat . . .", 400, 310, biru);
            }
     
            // menu utama
                canvas.drawBitmap(latarMenuUtama.ambilBitmap(), 0, YMenuUtama, null);
                canvas.drawBitmap(tombolMulai.ambilBitmap(), 0, tombolMulai.ambilY() + YMenuUtama, null);
                canvas.drawBitmap(tombolBantuan.ambilBitmap(), 0, tombolBantuan.ambilY() + YMenuUtama, null);
                canvas.drawBitmap(tombolKredit.ambilBitmap(), 0, tombolKredit.ambilY() + YMenuUtama, null);
               
     
          // Mengupdate objek pada layar sekian kali setiap detiknya (frame per second/ fps) sesuai
          // dengan delay yang diberikan
          update();
     
          // Memberi delay
          try {  
             // delay 17ms
             Thread.sleep(17);  
          } catch (InterruptedException e) { } // <-- ???
         
          invalidate();  // Force a re-draw
       }
       
       // Menggerakkan karakter(pemain) ke kanan sebesar v pixel
       // dengan kata lain menggeser ke kanan dengan kecepatan
       // v pixel tiap pemanggilan prosedur
       // Ada kalanya dengan cara menggeser karakter namun ada juga
       // dengan cara menggeser layar belakang (gambar latar)
       // disini dilakukan juga penggantian gambar karakter
       // untuk memberikan efek animasi seolah berjalan
       
       private void resetSemua(){
           musuhA.aturX(posisiXAwalMusuhA);
           musuhA.aturY(posisiYAwalMusuhA);
           musuhA.aturNilaiAZ(100);
           musuhA.aturR1(9);
           musuhB.aturX(posisiXAwalMusuhB);
           musuhB.aturY(posisiYAwalMusuhB);
           musuhB.aturNilaiAZ(100);
           musuhB.aturR1(9);
           musuhC.aturX(posisiXAwalMusuhC);
           musuhC.aturY(posisiYAwalMusuhC);
           musuhC.aturNilaiAZ(100);
           musuhC.aturR1(9);
           musuhD.aturX(posisiXAwalMusuhD);
           musuhD.aturY(posisiYAwalMusuhD);
           musuhD.aturNilaiAZ(100);
           musuhD.aturR1(9);
           musuhE.aturX(posisiXAwalMusuhE);
           musuhE.aturY(posisiYAwalMusuhE);
           musuhE.aturNilaiAZ(100);
           musuhE.aturR1(9);
           musuhF.aturX(posisiXAwalMusuhF);
           musuhF.aturY(posisiYAwalMusuhF);
           musuhF.aturNilaiAZ(100);
           musuhF.aturR1(9);
           musuhG.aturX(posisiXAwalMusuhG);
           musuhG.aturY(posisiYAwalMusuhG);
           musuhG.aturNilaiAZ(100);
           musuhG.aturR1(9);
           musuhH.aturX(posisiXAwalMusuhH);
           musuhH.aturY(posisiYAwalMusuhH);
           musuhH.aturNilaiAZ(100);
           musuhH.aturR1(9);
           musuhI.aturX(posisiXAwalMusuhI);
           musuhI.aturY(posisiYAwalMusuhI);
           musuhI.aturNilaiAZ(100);
           musuhI.aturR1(9);
           musuhJ.aturX(posisiXAwalMusuhJ);
           musuhJ.aturY(posisiYAwalMusuhJ);
           musuhJ.aturNilaiAZ(100);
           musuhJ.aturR1(9);
           karakterA.aturX(240);
           karakterA.aturY(100);
           karakterA.aturNilaiAZ(100);
           karakterA.aturNilaiZA(100);
           exp = 0;
           latarA.aturX(-480);
           latarB.aturX(0);
           latarC.aturX(480);
           levelPermainan = level1;
           aturLevel(1);
       }
       
       private void tampilBantuan(int x){
           if((x <= 5) && (x >= 1)){
                switch(x){
                    case 1 :
                         dataBantuan.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bantuan1));
                         break;
                    case 2 :
                         dataBantuan.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bantuan2));
                         break;
                    case 3 :
                         dataBantuan.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bantuan3));
                         break;
                    case 4 :
                         dataBantuan.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bantuan4));
                         break;
                    case 5 :
                         dataBantuan.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bantuan5));
                         break;
                }
           }
       }
       
       private void aturLevel(int l){
           switch(l){
               case 1 : levelPermainan = level1; sisaWaktu = 100; break;
               case 2 : levelPermainan = level2; sisaWaktu = 150; break;
               case 3 : levelPermainan = level3; sisaWaktu = 200; break;
               case 4 : levelPermainan = level4; sisaWaktu = 250; break;
               case 5 : levelPermainan = level5; sisaWaktu = 300; break;
           }
           waktuHabis = false;
       }
       
       private void resetSkenarioFalse(){
            skenarioMain = false;
            skenarioMenuUtama = false;
            skenarioBantuan = false;
            skenarioKredit = false;
            skenarioGameOver = false; // Tambahan
       }
       private void resetKanvasSkenarioFalse(){
            kanvasSkenarioMain = false;
            kanvasSkenarioMenuUtama = false;
            kanvasSkenarioBantuan = false;
            kanvasSkenarioKredit = false;
            kanvasSkenarioGameOver = false; // Tambahan
       }
       
       private void geserMenuUtamaDenganStepA40(int pilihan){
           if(YMenuUtama > -320)
               YMenuUtama -= 40;
           else{
               sembunyikanMenuUtama = 0;
               switch(pilihan){
                    case 1 :
                        skenarioMain = true;
                        break;
                    case 2 :
                        skenarioBantuan = true;
                        break;
                    case 3 :
                        skenarioKredit = true;
                        break;
               }
           }
       }
       
       private void geserMenuUtamaDenganStepB40(){
           if(YMenuUtama < 0)
               YMenuUtama += 40;
           else{
               munculkanMenuUtama = false;
               skenarioMenuUtama = true;
           }
       }
       
       private void gerakMusuhKeKananOlehLayar(float v){
           musuhA.aturX(musuhA.ambilX() - v);
           musuhB.aturX(musuhB.ambilX() - v);
           musuhC.aturX(musuhC.ambilX() - v);
           musuhD.aturX(musuhD.ambilX() - v);
           musuhE.aturX(musuhE.ambilX() - v);
           musuhF.aturX(musuhF.ambilX() - v);
           musuhG.aturX(musuhG.ambilX() - v);
           musuhH.aturX(musuhH.ambilX() - v);
           musuhI.aturX(musuhI.ambilX() - v);
           musuhJ.aturX(musuhJ.ambilX() - v);
       }
       
       private void gerakMusuhKeKiriOlehLayar(float v){
           musuhA.aturX(musuhA.ambilX() + v);
           musuhB.aturX(musuhB.ambilX() + v);
           musuhC.aturX(musuhC.ambilX() + v);
           musuhD.aturX(musuhD.ambilX() + v);
           musuhE.aturX(musuhE.ambilX() + v);
           musuhF.aturX(musuhF.ambilX() + v);
           musuhG.aturX(musuhG.ambilX() + v);
           musuhH.aturX(musuhH.ambilX() + v);
           musuhI.aturX(musuhI.ambilX() + v);
           musuhJ.aturX(musuhJ.ambilX() + v);
       }
       
       private boolean musuhMengenaiKarakter(objekGambar K, objekGambar M){
           return (((M.ambilX() + M.ambilLebar() > K.ambilX() + 5)  //faktor 5
                   && (M.ambilX() + M.ambilLebar() < K.ambilX() + K.ambilLebar() - 5))
                   || ((M.ambilX() > K.ambilX() + 5)
                   && (M.ambilX() < K.ambilX() + K.ambilLebar() - 5)))
                   && (K.ambilY() == M.ambilY());
       }
       
       
       private void musuhGerakKeKanan(int p){
            objekGambar T = musuhA;
            switch(p){
                case 1 : T = musuhA; break;
                case 2 : T = musuhB; break;
                case 3 : T = musuhC; break;
                case 4 : T = musuhD; break;
                case 5 : T = musuhE; break;
                case 6 : T = musuhF; break;
                case 7 : T = musuhG; break;
                case 8 : T = musuhH; break;
                case 9 : T = musuhI; break;
                case 10 : T = musuhJ; break;
            }
            if(T.ambilR() > 5)
                T.aturR(0);
            else
                T.aturR(T.ambilR() + 1);
            int k = (T.ambilR() % 6) + 1;
            if(T.ambilNilaiAZ() > 0)
                T.aturBitmap(spriteMusuhKananL.ambilSprite(k));
       }
       
       private void musuhGerakKeKiri(int p){
            objekGambar T = musuhA;
            switch(p){
                case 1 : T = musuhA; break;
                case 2 : T = musuhB; break;
                case 3 : T = musuhC; break;
                case 4 : T = musuhD; break;
                case 5 : T = musuhE; break;
                case 6 : T = musuhF; break;
                case 7 : T = musuhG; break;
                case 8 : T = musuhH; break;
                case 9 : T = musuhI; break;
                case 10 : T = musuhJ; break;
            }
            if(T.ambilR() > 5)
                T.aturR(0);
            else
                T.aturR(T.ambilR() + 1);
            int k = (T.ambilR() % 6) + 1;
            if(T.ambilNilaiAZ() > 0)
                T.aturBitmap(spriteMusuhKiriL.ambilSprite(k));
       }
       
       
       private void musuhHancur(int p){
            objekGambar T = musuhA;
            switch(p){
                case 1 : T = musuhA; break;
                case 2 : T = musuhB; break;
                case 3 : T = musuhC; break;
                case 4 : T = musuhD; break;
                case 5 : T = musuhE; break;
                case 6 : T = musuhF; break;
                case 7 : T = musuhG; break;
                case 8 : T = musuhH; break;
                case 9 : T = musuhI; break;
                case 10 : T = musuhJ; break;
            }
            int k = T.ambilR1();
            T.aturBitmap(spriteMusuhHancur.ambilSprite(k));
            T.aturR1(T.ambilR1() - 1);
            if(T.ambilR1() == 0)
                T.aturY(500);
            if(T.ambilR1() == 7){
                musikciattt.pause();
                musikciattt.seekTo(0);
                musikciattt.start();
            }
               
       }
       
       
       
       private void minumRamuan(){
           if(boolMinumRamuan && (i % 1 == 0)){
               switch(modeMinumRamuan){
                  case 11 :
                    karakterA.aturBitmap(spriteMinumRamuan.ambilSprite(1));
                    break;
                  case 10 :
                    karakterA.aturBitmap(spriteMinumRamuan.ambilSprite(2));
                    break;
                  case 9 :
                    karakterA.aturBitmap(spriteMinumRamuan.ambilSprite(3));
                    break;
                  case 8 :
                    karakterA.aturBitmap(spriteMinumRamuan.ambilSprite(4));
                    break;
                  case 7 :
                    karakterA.aturBitmap(spriteMinumRamuan.ambilSprite(5));
                    break;
                  case 6 :
                    karakterA.aturBitmap(spriteMinumRamuan.ambilSprite(6));
                    break;
                  case 5 :
                    karakterA.aturBitmap(spriteMinumRamuan.ambilSprite(7));
                    break;
                  case 4 :
                    karakterA.aturBitmap(spriteMinumRamuan.ambilSprite(8));
                    break;
                  case 3 :
                    karakterA.aturBitmap(spriteMinumRamuan.ambilSprite(9));
                    break;
                  case 2 :
                    karakterA.aturBitmap(spriteMinumRamuan.ambilSprite(10));
                    break;
                  case 1 :
                    karakterA.aturBitmap(spriteMinumRamuan.ambilSprite(11));
                    break;
                  case 0 :
                    resetGambarKarakter(arahSekarang);
                    boolMinumRamuan = false;
                    break;
               }
               modeMinumRamuan--;
               if(karakterA.ambilNilaiZA() < 100){
                   karakterA.aturNilaiZA(karakterA.ambilNilaiZA() + 5);
               }
           }
       }
       
       
       private void gerakKeKanan(float v){
          if(karakterA.ambilX() < 300)
              karakterA.aturX(karakterA.ambilX() + v);
          else{
            gerakMusuhKeKananOlehLayar(v);
            latarA.aturX( latarA.ambilX() - v );
            latarB.aturX( latarB.ambilX() - v );
            latarC.aturX( latarC.ambilX() - v );
          }
          posisiXKarakter += v;
          if((modeBerjalanKeKanan > 0) && (i % 1 == 0)){
               switch(modeBerjalanKeKanan){
                  case 22 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(1));
                    break;
                  case 21 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(2));
                    break;
                  case 20 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(3));
                    break;
                  case 19 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(4));
                    break;
                  case 18 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(5));
                    break;
                  case 17 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(6));
                    break;
                  case 16 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(7));
                    break;
                  case 15 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(8));
                    break;
                  case 14 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(9));
                    break;
                  case 13 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(10));
                    break;
                  case 12 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(11));
                    break;
                  case 11 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(12));
                    break;
                  case 10 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(13));
                    break;
                  case 9 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(14));
                    break;
                  case 8 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(15));
                    break;
                  case 7 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(16));
                    break;
                  case 6 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(17));
                    break;
                  case 5 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(18));
                    break;
                  case 4 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(19));
                    break;
                  case 3 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(20));
                    break;
                  case 2 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(21));
                    break;
                  case 1 :
                    karakterA.aturBitmap(spriteLariKeKanan.ambilSprite(22));
                    modeBerjalanKeKanan = 22;
                    break;
               }
               modeBerjalanKeKanan--;
           }
       }
       
       // sama seperti private void gerakKeKanan(float v) namun beda arah
       private void gerakKeKiri(float v){
           if(karakterA.ambilX() > 140)
              karakterA.aturX(karakterA.ambilX() - v);
          else{
            gerakMusuhKeKiriOlehLayar(v);
            latarA.aturX( latarA.ambilX() + v );
            latarB.aturX( latarB.ambilX() + v );
            latarC.aturX( latarC.ambilX() + v );
           }
           posisiXKarakter -= v;
           if((modeBerjalanKeKiri > 0) && (i % 1 == 0)){
               switch(modeBerjalanKeKiri){
                  case 20 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(20));
                    break;
                  case 19 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(19));
                    break;
                  case 18 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(18));
                    break;
                  case 17 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(17));
                    break;
                  case 16 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(16));
                    break;
                  case 15 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(15));
                    break;
                  case 14 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(14));
                    break;
                  case 13 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(13));
                    break;
                  case 12 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(12));
                    break;
                  case 11 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(11));
                    break;
                  case 10 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(10));
                    break;
                  case 9 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(9));
                    break;
                  case 8 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(8));
                    break;
                  case 7 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(7));
                    break;
                  case 6 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(6));
                    break;
                  case 5 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(5));
                    break;
                  case 4 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(4));
                    break;
                  case 3 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(3));
                    break;
                  case 2 :
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(2));
                    break;
                  case 1 :  
                    karakterA.aturBitmap(spriteLariKeKiri.ambilSprite(1));
                    modeBerjalanKeKiri = 20;
                    break;
               }
               modeBerjalanKeKiri--;
           }
       }
       
       // hampir sama seperti private void gerakKeKanan(float v)
       // namun arahnya ke atas dan penggeseran dengan cara menggeser
       // karakter saja
       private void gerakKeAtas(float v){
          if(karakterA.ambilY() > batasAtas)
              karakterA.aturY( karakterA.ambilY() - v );
          //karakterA.aturX( karakterA.ambilX() - v );
          if((modeBerjalanKeAtas > 0) && (i % 1 == 0)){
               switch(modeBerjalanKeAtas){
                  case 22 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(1));
                    break;
                  case 21 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(2));
                    break;
                  case 20 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(3));
                    break;
                  case 19 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(4));
                    break;
                  case 18 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(5));
                    break;
                  case 17 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(6));
                    break;
                  case 16 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(7));
                    break;
                  case 15 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(8));
                    break;
                  case 14 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(9));
                    break;
                  case 13 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(10));
                    break;
                  case 12 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(11));
                    break;
                  case 11 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(12));
                    break;
                  case 10 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(13));
                    break;
                  case 9 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(14));
                    break;
                  case 8 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(15));
                    break;
                  case 7 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(16));
                    break;
                  case 6 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(17));
                    break;
                  case 5 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(18));
                    break;
                  case 4 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(19));
                    break;
                  case 3 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(20));
                    break;
                  case 2 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(21));
                    break;
                  case 1 :
                    karakterA.aturBitmap(spriteLariKeAtas.ambilSprite(22));
                    modeBerjalanKeAtas = 22;
                    break;
               }
               modeBerjalanKeAtas--;
           }
       }
       
       // sama seperti private void gerakKeAtas(float v) namun beda arah
       private void gerakKeBawah(float v){
          if(karakterA.ambilY() < batasBawah) karakterA.aturY( karakterA.ambilY() + v );
          //karakterA.aturX( karakterA.ambilX() + v );
          if((modeBerjalanKeBawah > 0) && (i % 1 == 0)){
               switch(modeBerjalanKeBawah){
                  case 21 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(1));
                    break;
                  case 20 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(2));
                    break;
                  case 19 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(3));
                    break;
                  case 18 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(4));
                    break;
                  case 17 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(5));
                    break;
                  case 16 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(6));
                    break;
                  case 15 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(7));
                    break;
                  case 14 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(8));
                    break;
                  case 13 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(9));
                    break;
                  case 12 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(10));
                    break;
                  case 11 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(11));
                    break;
                  case 10 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(12));
                    break;
                  case 9 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(13));
                    break;
                  case 8 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(14));
                    break;
                  case 7 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(15));
                    break;
                  case 6 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(16));
                    break;
                  case 5 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(17));
                    break;
                  case 4 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(18));
                    break;
                  case 3 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(19));
                    break;
                  case 2 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(20));
                    break;
                  case 1 :
                    karakterA.aturBitmap(spriteLariKeBawah.ambilSprite(21));
                    modeBerjalanKeBawah = 21;
                    break;
               }
               modeBerjalanKeBawah--;
           }
       }
       
       // Mengembalikan gambar karakter ke gambar mula-mula setelah melakukan aksi tertentu
       // mis. setelah melakukan animasi berjalan dan sebagainya.
       // kemungkinan nilai variabel arah :
       // 1 : Mereset gambar setelah melakukan animasi bergerak ke Kanan
       // 2 : Mereset gambar setelah melakukan animasi bergerak ke Kiri
       // 3 : atas
       // 4 : bawah
       // 0 : selain aksi diatas
       private void resetGambarKarakter(int arah){
           switch(arah){
               case 0 :
                    karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.b1));
                    break;
               case 1 :
                    karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.diamkanan));
                    break;
               case 2 :
                    karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.diamkiri));
                    break;
               case 3 :
                    karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.diambelakang));
                    break;
               case 4 :
                    karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.diamdepan));
                    break;
           
           }  
       }
       
       private boolean apakahMenyentuh(float X, float Y, objekGambar gbr){
           return    (X > (gbr.ambilX()))
                   && (Y > (gbr.ambilY()))
                   && (X < (gbr.ambilX() + gbr.ambilLebar()))
                   && (Y < (gbr.ambilY() + gbr.ambilTinggi()));
       }  
       
       private void tampilPopupSkor(float X, float Y){
           boolean temp = false;
           if(modePopupSkor < 6){
                modePopupSkor++;
                if(skor1.ambilAnimasiPopupSkor() == 0){
                    skor1.aturX(X);
                    skor1.aturY(Y);
                    skor1.aturAnimasiPopupSkor(10);
                    temp = true;
                }
                if(skor2.ambilAnimasiPopupSkor() == 0 && !temp){
                    skor2.aturX(X+10);
                    skor2.aturY(Y-10);
                    skor2.aturAnimasiPopupSkor(10);
                    temp = true;
                }
                if(skor3.ambilAnimasiPopupSkor() == 0 && !temp){
                    skor3.aturX(X+20);
                    skor3.aturY(Y);
                    skor3.aturAnimasiPopupSkor(10);
                    temp = true;
                }
                if(skor4.ambilAnimasiPopupSkor() == 0 && !temp){
                    skor4.aturX(X+30);
                    skor4.aturY(Y-10);
                    skor4.aturAnimasiPopupSkor(10);
                    temp = true;
                }
                if(skor5.ambilAnimasiPopupSkor() == 0 && !temp){
                    skor5.aturX(X+40);
                    skor5.aturY(Y);
                    skor5.aturAnimasiPopupSkor(10);
                    temp = true;
                }
                if(skor6.ambilAnimasiPopupSkor() == 0 && !temp){
                    skor6.aturX(X+50);
                    skor6.aturY(Y-10);
                    skor6.aturAnimasiPopupSkor(10);
                    temp = true;
                }
           }
       }
       
       private boolean terkenaHunusanPedangKanan(int arah, objekGambar K, objekGambar M){
           return (arah == 1)
                   && (K.ambilY() < M.ambilY() + 20)
                   && (K.ambilY() > M.ambilY() - 20)
                   && (K.ambilX() + K.ambilLebar() + 20 < M.ambilX() + M.ambilLebar() + 50)
                   && (K.ambilX() + K.ambilLebar() + 20 > M.ambilX());
       }
       
       private boolean terkenaHunusanPedangKiri(int arah, objekGambar K, objekGambar M){
           return (arah == 0)
                   && (K.ambilY() < M.ambilY() + 20)
                   && (K.ambilY() > M.ambilY() - 20)
                   && (K.ambilX() > M.ambilX() - 50)
                   && (K.ambilX() < M.ambilX() + M.ambilLebar() + 50);
       }
       //  
       
       // Update yang dilakukan sbb :
       // > variabel i
       // > Mengubah gambar ketika berjalan sebagai animasi berjalan
       //   baik arah kanan, kiri, atas, atau bawah dan juga saat menghunus pedang
       // > Memanggil prosedur gerakKeKanan() -> Lihat bagian private void gerakKeKanan(float v)
       //                      gerakKeKiri() -> Lihat bagian private void gerakKeKiri(float v)
       //                      gerakKeAtas() -> Lihat bagian private void gerakKeBawah(float v)
       //                      gerakKeBawah() -> Lihat bagian private void gerakKeAtas(float v)
       // > Menggeser gambar latar saat karakter(pemain) digerakkan ke kanan atau ke kiri
       //   jika penggeseran sudah berada di batas kiri maka akan dipindah langsung ke kanan dan sebaliknya
       //   pengulangan dilakukan terus menerus agar gambar latar tetap ada.
       private void update() {
               // rencana awal, variabel i digunakan untuk memberi delay pada pengubahan gambar (efek animasi)
               // masih bingung??? pikir sendiri !
           i++;
           if(i > 1000) i = 1;
           
           // mengubah gambar untuk memberi efek animasi
           // animasi berjalan ke kanan
           // ^sudah dipindah 201502131454
           // Lihat bagian private void gerakKeKanan(float v)
           
           // animasi berjalan ke kiri
           // ^sudah dipindah 201502131454
           // Lihat bagian private void gerakKeKiri(float v)
           
           
           if(!modePause){
                // MP ditambah secara otomatis
               if(i % 10 == 0 && karakterA.ambilNilaiZA() < 100)
                   karakterA.aturNilaiZA(karakterA.ambilNilaiZA() + 1);
               
                teksBantuan = Integer.toString(sisaWaktu / 60) + " : " + Integer.toString(sisaWaktu % 60);
                if((sisaWaktu > 0) && (i % 30 == 0)) // 30 adalah angka "frame per second"
                    sisaWaktu--;
                if(sisaWaktu == 0)
                    waktuHabis = true;
               
                boolean posisiTerjangkau;
     
     
                // mengecek apakah HP karakter > 0, jika <= 0 maka munculkan tampilan game over
                if(karakterA.ambilNilaiAZ() <= 0 || sisaWaktu == 0){ // Tambahan
                    resetKanvasSkenarioFalse();
                    kanvasSkenarioGameOver = true;
                    resetSkenarioFalse();
                    skenarioGameOver = true;
                }
               
               // ================================================================//
               // musuh A
                posisiTerjangkau = (musuhA.ambilX() + musuhA.ambilLebar() > -50) && (musuhA.ambilX() < 550);
                if(musuhA.ambilNilaiAZ() > 0 && posisiTerjangkau){
                    //ketika musuh mengenai karakter
                    if(musuhMengenaiKarakter(karakterA, musuhA)){
                        karakterA.aturNilaiAZ(karakterA.ambilNilaiAZ() - 1);
                        if(arahSekarang == 1)
                            karakterA.aturX(karakterA.ambilX() - 5);
                        if(arahSekarang == 2)
                            karakterA.aturX(karakterA.ambilX() + 5);
                    }
     
                    //musuh mengejar karakter(pemain)
                    if(musuhA.ambilX() < karakterA.ambilX() + 25){
                        musuhA.aturX(musuhA.ambilX() + 1);
                        musuhGerakKeKanan(1);
                    }
                    if(musuhA.ambilX() > karakterA.ambilX() - 25){
                        musuhA.aturX(musuhA.ambilX() - 1);
                        musuhGerakKeKiri(1);
                    }
                    if(musuhA.ambilY() + musuhA.ambilTinggi() < karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhA.aturY(musuhA.ambilY() + 0.5f);
                    }
                    if(musuhA.ambilY() + musuhA.ambilTinggi() > karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhA.aturY(musuhA.ambilY() - 0.5f);
                    }
                }
               
                if((musuhA.ambilNilaiAZ() <= 0) && (musuhA.ambilR1() > 0))
                    musuhHancur(1);
                // musuh A
                // ====================================================================== //
               
               
               // ================================================================//
               // musuh B
                posisiTerjangkau = (musuhB.ambilX() + musuhA.ambilLebar() > -50) && (musuhB.ambilX() < 550);
                if(musuhB.ambilNilaiAZ() > 0 && posisiTerjangkau){
                    //ketika musuh mengenai karakter
                    if(musuhMengenaiKarakter(karakterA, musuhB)){
                        karakterA.aturNilaiAZ(karakterA.ambilNilaiAZ() - 1);
                        if(arahSekarang == 1)
                            karakterA.aturX(karakterA.ambilX() - 5);
                        if(arahSekarang == 2)
                            karakterA.aturX(karakterA.ambilX() + 5);
                    }
     
                    //musuh mengejar karakter(pemain)
                    if(musuhB.ambilX() < karakterA.ambilX() + 25){
                        musuhB.aturX(musuhB.ambilX() + 1);
                        musuhGerakKeKanan(2);
                    }
                    if(musuhB.ambilX() > karakterA.ambilX() - 25){
                        musuhB.aturX(musuhB.ambilX() - 1);
                        musuhGerakKeKiri(2);
                    }
                    if(musuhB.ambilY() + musuhB.ambilTinggi() < karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhB.aturY(musuhB.ambilY() + 0.5f);
                    }
                    if(musuhB.ambilY() + musuhB.ambilTinggi() > karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhB.aturY(musuhB.ambilY() - 0.5f);
                    }
                }
               
                if((musuhB.ambilNilaiAZ() <= 0) && (musuhB.ambilR1() > 0))
                    musuhHancur(2);
                // musuh B
                // ====================================================================== //
               
                 
               // ================================================================//
               // musuh C
                posisiTerjangkau = (musuhC.ambilX() + musuhC.ambilLebar() > -50) && (musuhC.ambilX() < 550);
                if(musuhC.ambilNilaiAZ() > 0 && posisiTerjangkau){
                    //ketika musuh mengenai karakter
                    if(musuhMengenaiKarakter(karakterA, musuhC)){
                        karakterA.aturNilaiAZ(karakterA.ambilNilaiAZ() - 1);
                        if(arahSekarang == 1)
                            karakterA.aturX(karakterA.ambilX() - 5);
                        if(arahSekarang == 2)
                            karakterA.aturX(karakterA.ambilX() + 5);
                    }
     
                    //musuh mengejar karakter(pemain)
                    if(musuhC.ambilX() < karakterA.ambilX() + 25){
                        musuhC.aturX(musuhC.ambilX() + 1);
                        musuhGerakKeKanan(3);
                    }
                    if(musuhC.ambilX() > karakterA.ambilX() - 25){
                        musuhC.aturX(musuhC.ambilX() - 1);
                        musuhGerakKeKiri(3);
                    }
                    if(musuhC.ambilY() + musuhC.ambilTinggi() < karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhC.aturY(musuhC.ambilY() + 0.5f);
                    }
                    if(musuhC.ambilY() + musuhC.ambilTinggi() > karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhC.aturY(musuhC.ambilY() - 0.5f);
                    }
                }
               
                if((musuhC.ambilNilaiAZ() <= 0) && (musuhC.ambilR1() > 0))
                    musuhHancur(3);
                // musuh C
                // ====================================================================== //
               
                 
               // ================================================================//
               // musuh D
                posisiTerjangkau = (musuhD.ambilX() + musuhD.ambilLebar() > -50) && (musuhD.ambilX() < 550);
                if(musuhD.ambilNilaiAZ() > 0 && posisiTerjangkau){
                    //ketika musuh mengenai karakter
                    if(musuhMengenaiKarakter(karakterA, musuhD)){
                        karakterA.aturNilaiAZ(karakterA.ambilNilaiAZ() - 1);
                        if(arahSekarang == 1)
                            karakterA.aturX(karakterA.ambilX() - 5);
                        if(arahSekarang == 2)
                            karakterA.aturX(karakterA.ambilX() + 5);
                    }
     
                    //musuh mengejar karakter(pemain)
                    if(musuhD.ambilX() < karakterA.ambilX() + 25){
                        musuhD.aturX(musuhD.ambilX() + 1);
                        musuhGerakKeKanan(4);
                    }
                    if(musuhD.ambilX() > karakterA.ambilX() - 25){
                        musuhD.aturX(musuhD.ambilX() - 1);
                        musuhGerakKeKiri(4);
                    }
                    if(musuhD.ambilY() + musuhD.ambilTinggi() < karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhD.aturY(musuhD.ambilY() + 0.5f);
                    }
                    if(musuhD.ambilY() + musuhD.ambilTinggi() > karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhD.aturY(musuhD.ambilY() - 0.5f);
                    }
                }
               
                if((musuhD.ambilNilaiAZ() <= 0) && (musuhD.ambilR1() > 0))
                    musuhHancur(4);
                // musuh D
                // ====================================================================== //
               
                 
               // ================================================================//
               // musuh E
                posisiTerjangkau = (musuhE.ambilX() + musuhE.ambilLebar() > -50) && (musuhE.ambilX() < 550);
                if(musuhE.ambilNilaiAZ() > 0 && posisiTerjangkau){
                    //ketika musuh mengenai karakter
                    if(musuhMengenaiKarakter(karakterA, musuhE)){
                        karakterA.aturNilaiAZ(karakterA.ambilNilaiAZ() - 1);
                        if(arahSekarang == 1)
                            karakterA.aturX(karakterA.ambilX() - 5);
                        if(arahSekarang == 2)
                            karakterA.aturX(karakterA.ambilX() + 5);
                    }
     
                    //musuh mengejar karakter(pemain)
                    if(musuhE.ambilX() < karakterA.ambilX() + 25){
                        musuhE.aturX(musuhE.ambilX() + 1);
                        musuhGerakKeKanan(5);
                    }
                    if(musuhE.ambilX() > karakterA.ambilX() - 25){
                        musuhE.aturX(musuhE.ambilX() - 1);
                        musuhGerakKeKiri(5);
                    }
                    if(musuhE.ambilY() + musuhE.ambilTinggi() < karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhE.aturY(musuhE.ambilY() + 0.5f);
                    }
                    if(musuhE.ambilY() + musuhE.ambilTinggi() > karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhE.aturY(musuhE.ambilY() - 0.5f);
                    }
                }
               
                if((musuhE.ambilNilaiAZ() <= 0) && (musuhE.ambilR1() > 0))
                    musuhHancur(5);
                // musuh E
                // ====================================================================== //
                 
               // ================================================================//
               // musuh F
                posisiTerjangkau = (musuhF.ambilX() + musuhF.ambilLebar() > -50) && (musuhF.ambilX() < 550);
                if(musuhF.ambilNilaiAZ() > 0 && posisiTerjangkau){
                    //ketika musuh mengenai karakter
                    if(musuhMengenaiKarakter(karakterA, musuhF)){
                        karakterA.aturNilaiAZ(karakterA.ambilNilaiAZ() - 1);
                        if(arahSekarang == 1)
                            karakterA.aturX(karakterA.ambilX() - 5);
                        if(arahSekarang == 2)
                            karakterA.aturX(karakterA.ambilX() + 5);
                    }
     
                    //musuh mengejar karakter(pemain)
                    if(musuhF.ambilX() < karakterA.ambilX() + 25){
                        musuhF.aturX(musuhF.ambilX() + 1);
                        musuhGerakKeKanan(6);
                    }
                    if(musuhF.ambilX() > karakterA.ambilX() - 25){
                        musuhF.aturX(musuhF.ambilX() - 1);
                        musuhGerakKeKiri(6);
                    }
                    if(musuhF.ambilY() + musuhF.ambilTinggi() < karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhF.aturY(musuhF.ambilY() + 0.5f);
                    }
                    if(musuhF.ambilY() + musuhF.ambilTinggi() > karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhF.aturY(musuhF.ambilY() - 0.5f);
                    }
                }
               
                if((musuhF.ambilNilaiAZ() <= 0) && (musuhF.ambilR1() > 0))
                    musuhHancur(6);
                // musuh F
                // ====================================================================== //
               
                 
               // ================================================================//
               // musuh G
                posisiTerjangkau = (musuhG.ambilX() + musuhG.ambilLebar() > -50) && (musuhG.ambilX() < 550);
                if(musuhG.ambilNilaiAZ() > 0 && posisiTerjangkau){
                    //ketika musuh mengenai karakter
                    if(musuhMengenaiKarakter(karakterA, musuhG)){
                        karakterA.aturNilaiAZ(karakterA.ambilNilaiAZ() - 1);
                        if(arahSekarang == 1)
                            karakterA.aturX(karakterA.ambilX() - 5);
                        if(arahSekarang == 2)
                            karakterA.aturX(karakterA.ambilX() + 5);
                    }
     
                    //musuh mengejar karakter(pemain)
                    if(musuhG.ambilX() < karakterA.ambilX() + 25){
                        musuhG.aturX(musuhG.ambilX() + 1);
                        musuhGerakKeKanan(7);
                    }
                    if(musuhG.ambilX() > karakterA.ambilX() - 25){
                        musuhG.aturX(musuhG.ambilX() - 1);
                        musuhGerakKeKiri(7);
                    }
                    if(musuhG.ambilY() + musuhG.ambilTinggi() < karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhG.aturY(musuhG.ambilY() + 0.5f);
                    }
                    if(musuhG.ambilY() + musuhG.ambilTinggi() > karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhG.aturY(musuhG.ambilY() - 0.5f);
                    }
                }
               
                if((musuhG.ambilNilaiAZ() <= 0) && (musuhG.ambilR1() > 0))
                    musuhHancur(7);
                // musuh G
                // ====================================================================== //
               
                 
               // ================================================================//
               // musuh H
                posisiTerjangkau = (musuhH.ambilX() + musuhH.ambilLebar() > -50) && (musuhH.ambilX() < 550);
                if(musuhH.ambilNilaiAZ() > 0 && posisiTerjangkau){
                    //ketika musuh mengenai karakter
                    if(musuhMengenaiKarakter(karakterA, musuhH)){
                        karakterA.aturNilaiAZ(karakterA.ambilNilaiAZ() - 1);
                        if(arahSekarang == 1)
                            karakterA.aturX(karakterA.ambilX() - 5);
                        if(arahSekarang == 2)
                            karakterA.aturX(karakterA.ambilX() + 5);
                    }
     
                    //musuh mengejar karakter(pemain)
                    if(musuhH.ambilX() < karakterA.ambilX() + 25){
                        musuhH.aturX(musuhH.ambilX() + 1);
                        musuhGerakKeKanan(8);
                    }
                    if(musuhH.ambilX() > karakterA.ambilX() - 25){
                        musuhH.aturX(musuhH.ambilX() - 1);
                        musuhGerakKeKiri(8);
                    }
                    if(musuhH.ambilY() + musuhH.ambilTinggi() < karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhH.aturY(musuhH.ambilY() + 0.5f);
                    }
                    if(musuhH.ambilY() + musuhH.ambilTinggi() > karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhH.aturY(musuhH.ambilY() - 0.5f);
                    }
                }
                 
                if((musuhH.ambilNilaiAZ() <= 0) && (musuhH.ambilR1() > 0))
                    musuhHancur(8);
                // musuh H
                // ====================================================================== //
               
               
               // ================================================================//
               // musuh I
                posisiTerjangkau = (musuhI.ambilX() + musuhI.ambilLebar() > -50) && (musuhI.ambilX() < 550);
                if(musuhI.ambilNilaiAZ() > 0 && posisiTerjangkau){
                    //ketika musuh mengenai karakter
                    if(musuhMengenaiKarakter(karakterA, musuhI)){
                        karakterA.aturNilaiAZ(karakterA.ambilNilaiAZ() - 1);
                        if(arahSekarang == 1)
                            karakterA.aturX(karakterA.ambilX() - 5);
                        if(arahSekarang == 2)
                            karakterA.aturX(karakterA.ambilX() + 5);
                    }
     
                    //musuh mengejar karakter(pemain)
                    if(musuhI.ambilX() < karakterA.ambilX() + 25){
                        musuhI.aturX(musuhI.ambilX() + 1);
                        musuhGerakKeKanan(9);
                    }
                    if(musuhI.ambilX() > karakterA.ambilX() - 25){
                        musuhI.aturX(musuhI.ambilX() - 1);
                        musuhGerakKeKiri(9);
                    }
                    if(musuhI.ambilY() + musuhI.ambilTinggi() < karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhI.aturY(musuhI.ambilY() + 0.5f);
                    }
                    if(musuhI.ambilY() + musuhI.ambilTinggi() > karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhI.aturY(musuhI.ambilY() - 0.5f);
                    }
                }
               
                if((musuhI.ambilNilaiAZ() <= 0) && (musuhI.ambilR1() > 0))
                    musuhHancur(9);
                // musuh I
                // ====================================================================== //
                 
               
               // ================================================================//
               // musuh J
                posisiTerjangkau = (musuhJ.ambilX() + musuhJ.ambilLebar() > -50) && (musuhJ.ambilX() < 550);
                if(musuhJ.ambilNilaiAZ() > 0 && posisiTerjangkau){
                    //ketika musuh mengenai karakter
                    if(musuhMengenaiKarakter(karakterA, musuhJ)){
                        karakterA.aturNilaiAZ(karakterA.ambilNilaiAZ() - 1);
                        if(arahSekarang == 1)
                            karakterA.aturX(karakterA.ambilX() - 5);
                        if(arahSekarang == 2)
                            karakterA.aturX(karakterA.ambilX() + 5);
                    }
     
                    //musuh mengejar karakter(pemain)
                    if(musuhJ.ambilX() < karakterA.ambilX() + 25){
                        musuhJ.aturX(musuhJ.ambilX() + 1);
                        musuhGerakKeKanan(10);
                    }
                    if(musuhJ.ambilX() > karakterA.ambilX() - 25){
                        musuhJ.aturX(musuhJ.ambilX() - 1);
                        musuhGerakKeKiri(10);
                    }
                    if(musuhJ.ambilY() + musuhJ.ambilTinggi() < karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhJ.aturY(musuhJ.ambilY() + 0.5f);
                    }
                    if(musuhJ.ambilY() + musuhJ.ambilTinggi() > karakterA.ambilY() + karakterA.ambilTinggi()){
                        musuhJ.aturY(musuhJ.ambilY() - 0.5f);
                    }
                }
                 
                if((musuhJ.ambilNilaiAZ() <= 0) && (musuhJ.ambilR1() > 0))
                    musuhHancur(10);
                // musuh J
                // ====================================================================== //
               
                // animasi menghunus pedang
                if((modeHunusPedang > 0) && (i % 1 == 0)){
                    switch(modeHunusPedang){/*
                       case 20 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar1));
                         break;
                       case 19 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar2));
                         break;
                       case 18 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar3));
                         break;
                       case 17 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar4));
                         break;
                       case 16 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar5));
                         break;
                       case 15 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar6));
                         break;
                       case 14 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar7));
                         break;
                       case 13 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar8));
                         break;
                       case 12 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar9));
                         break;
                       case 11 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar10));
                         break;*/
                       case 10 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar1));
                         break;
                       case 9 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar3));
                         break;
                       case 8 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar6));
                         break;
                       case 7 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar8));
                         break;
                       case 6 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar10));
                         break;
                       case 5 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar11));
                         break;
                       case 4 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar13));
                         break;
                       case 3 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar15));
                         break;
                       case 2 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar17));
                         break;
                       case 1 :
                         karakterA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.attackbar19));
                         break;
                    }
                    // aksi jika hunusan pedang terkena musuh
                    // ...
                    // ======================================================//
                    // musuh A
                    if(terkenaHunusanPedangKanan(arahKiriKananSekarang, karakterA, musuhA)){
                        tampilPopupSkor(musuhA.ambilX() + musuhA.ambilLebar() * 0.7f, musuhA.ambilY() + 5);
                        musuhA.aturX(musuhA.ambilX() + 1);
                        musuhA.aturNilaiAZ(musuhA.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    if(terkenaHunusanPedangKiri(arahKiriKananSekarang, karakterA, musuhA)){
                        tampilPopupSkor(musuhA.ambilX() + musuhA.ambilLebar() * 0.7f, musuhA.ambilY() + 5);
                        musuhA.aturX(musuhA.ambilX() - 1);
                        musuhA.aturNilaiAZ(musuhA.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    // musuh A
                    // ======================================================//
                   
                   
                    // ======================================================//
                    // musuh B
                    if(terkenaHunusanPedangKanan(arahKiriKananSekarang, karakterA, musuhB)){
                        tampilPopupSkor(musuhB.ambilX() + musuhB.ambilLebar() * 0.7f, musuhB.ambilY() + 5);
                        musuhB.aturX(musuhB.ambilX() + 25);
                        musuhB.aturNilaiAZ(musuhB.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    if(terkenaHunusanPedangKiri(arahKiriKananSekarang, karakterA, musuhB)){
                        tampilPopupSkor(musuhB.ambilX() + musuhB.ambilLebar() * 0.7f, musuhB.ambilY() + 5);
                        musuhB.aturX(musuhB.ambilX() - 25);
                        musuhB.aturNilaiAZ(musuhB.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    // musuh B
                    // ======================================================//
                   
                   
                    // ======================================================//
                    // musuh C
                    if(terkenaHunusanPedangKanan(arahKiriKananSekarang, karakterA, musuhC)){
                        tampilPopupSkor(musuhC.ambilX() + musuhC.ambilLebar() * 0.7f, musuhC.ambilY() + 5);
                        musuhC.aturX(musuhC.ambilX() + 25);
                        musuhC.aturNilaiAZ(musuhC.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    if(terkenaHunusanPedangKiri(arahKiriKananSekarang, karakterA, musuhC)){
                        tampilPopupSkor(musuhC.ambilX() + musuhC.ambilLebar() * 0.7f, musuhC.ambilY() + 5);
                        musuhC.aturX(musuhC.ambilX() - 25);
                        musuhC.aturNilaiAZ(musuhC.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    // musuh C
                    // ======================================================//
                       
                   
                   
                    // ======================================================//
                    // musuh D
                    if(terkenaHunusanPedangKanan(arahKiriKananSekarang, karakterA, musuhD)){
                        tampilPopupSkor(musuhD.ambilX() + musuhD.ambilLebar() * 0.7f, musuhD.ambilY() + 5);
                        musuhD.aturX(musuhD.ambilX() + 25);
                        musuhD.aturNilaiAZ(musuhD.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    if(terkenaHunusanPedangKiri(arahKiriKananSekarang, karakterA, musuhD)){
                        tampilPopupSkor(musuhD.ambilX() + musuhD.ambilLebar() * 0.7f, musuhD.ambilY() + 5);
                        musuhD.aturX(musuhD.ambilX() - 25);
                        musuhD.aturNilaiAZ(musuhD.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    // musuh D
                    // ======================================================//
     
                   
                    // ======================================================//
                    // musuh E
                    if(terkenaHunusanPedangKanan(arahKiriKananSekarang, karakterA, musuhE)){
                        tampilPopupSkor(musuhE.ambilX() + musuhE.ambilLebar() * 0.7f, musuhE.ambilY() + 5);
                        musuhE.aturX(musuhE.ambilX() + 25);
                        musuhE.aturNilaiAZ(musuhE.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    if(terkenaHunusanPedangKiri(arahKiriKananSekarang, karakterA, musuhE)){
                        tampilPopupSkor(musuhE.ambilX() + musuhE.ambilLebar() * 0.7f, musuhE.ambilY() + 5);
                        musuhE.aturX(musuhE.ambilX() - 25);
                        musuhE.aturNilaiAZ(musuhE.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    // musuh E
                    // ======================================================//
                   
                   
                    // ======================================================//
                    // musuh F
                    if(terkenaHunusanPedangKanan(arahKiriKananSekarang, karakterA, musuhF)){
                        tampilPopupSkor(musuhF.ambilX() + musuhF.ambilLebar() * 0.7f, musuhF.ambilY() + 5);
                        musuhF.aturX(musuhF.ambilX() + 25);
                        musuhF.aturNilaiAZ(musuhF.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    if(terkenaHunusanPedangKiri(arahKiriKananSekarang, karakterA, musuhF)){
                        tampilPopupSkor(musuhF.ambilX() + musuhF.ambilLebar() * 0.7f, musuhF.ambilY() + 5);
                        musuhF.aturX(musuhF.ambilX() - 25);
                        musuhF.aturNilaiAZ(musuhF.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    // musuh F
                    // ======================================================//
                   
                   
                    // ======================================================//
                    // musuh G
                    if(terkenaHunusanPedangKanan(arahKiriKananSekarang, karakterA, musuhG)){
                        tampilPopupSkor(musuhG.ambilX() + musuhG.ambilLebar() * 0.7f, musuhG.ambilY() + 5);
                        musuhG.aturX(musuhG.ambilX() + 25);
                        musuhG.aturNilaiAZ(musuhG.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    if(terkenaHunusanPedangKiri(arahKiriKananSekarang, karakterA, musuhG)){
                        tampilPopupSkor(musuhG.ambilX() + musuhG.ambilLebar() * 0.7f, musuhG.ambilY() + 5);
                        musuhG.aturX(musuhG.ambilX() - 25);
                        musuhG.aturNilaiAZ(musuhG.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    // musuh G
                    // ======================================================//
                   
                   
                    // ======================================================//
                    // musuh H
                    if(terkenaHunusanPedangKanan(arahKiriKananSekarang, karakterA, musuhH)){
                        tampilPopupSkor(musuhH.ambilX() + musuhH.ambilLebar() * 0.7f, musuhH.ambilY() + 5);
                        musuhH.aturX(musuhH.ambilX() + 25);
                        musuhH.aturNilaiAZ(musuhH.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    if(terkenaHunusanPedangKiri(arahKiriKananSekarang, karakterA, musuhH)){
                        tampilPopupSkor(musuhH.ambilX() + musuhH.ambilLebar() * 0.7f, musuhH.ambilY() + 5);
                        musuhH.aturX(musuhH.ambilX() - 25);
                        musuhH.aturNilaiAZ(musuhH.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    // musuh H
                    // ======================================================//
                   
                   
                    // ======================================================//
                    // musuh I
                    if(terkenaHunusanPedangKanan(arahKiriKananSekarang, karakterA, musuhI)){
                        tampilPopupSkor(musuhI.ambilX() + musuhI.ambilLebar() * 0.7f, musuhI.ambilY() + 5);
                        musuhI.aturX(musuhI.ambilX() + 25);
                        musuhI.aturNilaiAZ(musuhI.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    if(terkenaHunusanPedangKiri(arahKiriKananSekarang, karakterA, musuhI)){
                        tampilPopupSkor(musuhI.ambilX() + musuhI.ambilLebar() * 0.7f, musuhI.ambilY() + 5);
                        musuhI.aturX(musuhI.ambilX() - 25);
                        musuhI.aturNilaiAZ(musuhI.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    // musuh I
                    // ======================================================//
                   
                   
                    // ======================================================//
                    // musuh J
                    if(terkenaHunusanPedangKanan(arahKiriKananSekarang, karakterA, musuhJ)){
                        tampilPopupSkor(musuhJ.ambilX() + musuhJ.ambilLebar() * 0.7f, musuhJ.ambilY() + 5);
                        musuhJ.aturX(musuhJ.ambilX() + 25);
                        musuhJ.aturNilaiAZ(musuhJ.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    if(terkenaHunusanPedangKiri(arahKiriKananSekarang, karakterA, musuhJ)){
                        tampilPopupSkor(musuhJ.ambilX() + musuhJ.ambilLebar() * 0.7f, musuhJ.ambilY() + 5);
                        musuhJ.aturX(musuhJ.ambilX() - 25);
                        musuhJ.aturNilaiAZ(musuhJ.ambilNilaiAZ() - 10);
                        exp++;
                    }
                    // musuh J
                    // ======================================================//
     
                    modeHunusPedang--;
                    if(modeHunusPedang == 0)
                        if(arahKiriKananSekarang == 1)
                            resetGambarKarakter(1);
                        else
                            resetGambarKarakter(2);
                   
                    karakterA.aturNilaiZA(karakterA.ambilNilaiZA() - 1);
                }
     
                if((modePopupSkor > 0)){
                     if(skor1.ambilAnimasiPopupSkor() > 0){
                            skor1.aturY(skor1.ambilY() - 0.2f);
                            skor1.aturAnimasiPopupSkor(skor1.ambilAnimasiPopupSkor() - 1);
                            if(skor1.ambilAnimasiPopupSkor() == 0){
                                 modePopupSkor--;
                                 skor1.ambilPosisiAwal();
                            }
                     }
     
                     if(skor2.ambilAnimasiPopupSkor() > 0){
                            skor2.aturY(skor2.ambilY() - 0.2f);
                            skor2.aturAnimasiPopupSkor(skor2.ambilAnimasiPopupSkor() - 1);
                            if(skor2.ambilAnimasiPopupSkor() == 0){
                                 modePopupSkor--;
                                 skor2.ambilPosisiAwal();
                            }
                     }
     
                     if(skor3.ambilAnimasiPopupSkor() > 0){
                            skor3.aturY(skor3.ambilY() - 0.2f);
                            skor3.aturAnimasiPopupSkor(skor3.ambilAnimasiPopupSkor() - 1);
                            if(skor3.ambilAnimasiPopupSkor() == 0){
                                 modePopupSkor--;
                                 skor3.ambilPosisiAwal();
                            }
                     }
     
                     if(skor4.ambilAnimasiPopupSkor() > 0){
                            skor4.aturY(skor4.ambilY() - 0.2f);
                            skor4.aturAnimasiPopupSkor(skor4.ambilAnimasiPopupSkor() - 1);
                            if(skor4.ambilAnimasiPopupSkor() == 0){
                                 modePopupSkor--;
                                 skor4.ambilPosisiAwal();
                            }
                     }
     
                     if(skor5.ambilAnimasiPopupSkor() > 0){
                            skor5.aturY(skor5.ambilY() - 0.2f);
                            skor5.aturAnimasiPopupSkor(skor5.ambilAnimasiPopupSkor() - 1);
                            if(skor5.ambilAnimasiPopupSkor() == 0){
                                 modePopupSkor--;
                                 skor5.ambilPosisiAwal();
                            }
                     }
     
                     if(skor6.ambilAnimasiPopupSkor() > 0){
                            skor6.aturY(skor6.ambilY() - 0.2f);
                            skor6.aturAnimasiPopupSkor(skor6.ambilAnimasiPopupSkor() - 1);
                            if(skor6.ambilAnimasiPopupSkor() == 0){
                                 modePopupSkor--;
                                 skor6.ambilPosisiAwal();
                            }
                     }
                }
               // baca penjelasan void ini !
               if(boolGerakKeAtas)
                   gerakKeAtas(4);
               if(boolGerakKeBawah)
                   gerakKeBawah(4);
               if(boolGerakKeKanan)
                   gerakKeKanan(6);
               if(boolGerakKeKiri)
                   gerakKeKiri(6);
               if(boolMinumRamuan)
                   minumRamuan();
     
               // baca penjelasan void ini !
               if(latarA.ambilX() < -480)
                   latarA.aturX( latarC.ambilX() + 480 );
               if(latarB.ambilX() < -480)
                   latarB.aturX( latarA.ambilX() + 480 );      
               if(latarC.ambilX() < -480)
                   latarC.aturX( latarB.ambilX() + 480 );
               if(latarA.ambilX() > 480)
                   latarA.aturX( latarB.ambilX() - 480 );      
               if(latarB.ambilX() > 480)
                   latarB.aturX( latarC.ambilX() - 480 );
               if(latarC.ambilX() > 480)
                   latarC.aturX( latarA.ambilX() - 480 );
            }
             
       }
       
       // Mengecek sentuhan pada layar apakah menyentuh suatu objekGambar "gbr"
       // dengan cara menganalisis posisi sentuhan di layar dan posisi objekGambar
       
       // | ???
       // v
       @Override
       public boolean onTouchEvent(MotionEvent e) {
            // variabel x dan y adalah posisi dari sentuhan pengguna
           float x = e.getX();
           float y = e.getY();
            switch (e.getAction()) {
               //saat sentuhan dilayar
               case MotionEvent.ACTION_DOWN:
                    if(skenarioMenuUtama && sembunyikanMenuUtama == 0){
                        if(apakahMenyentuh(x, y, tombolMulai)){
                            musiktik.pause();
                            musiktik.seekTo(0);
                            musiktik.start();
                            tombolMulai.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbmulai));
                        }
                        if(apakahMenyentuh(x, y, tombolBantuan)){
                            musiktik.pause();
                            musiktik.seekTo(0);
                            musiktik.start();
                            tombolBantuan.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbbantuan));
                        }
                        if(apakahMenyentuh(x, y, tombolKredit)){
                            musiktik.pause();
                            musiktik.seekTo(0);
                            musiktik.start();
                            tombolKredit.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbkredit));
                        }
                        // skenarioMain = true; dipindahkan ke void gesetMenuUtamaDenganStepA20();
                    }
                    if(skenarioBantuan){
                        if(apakahMenyentuh(x, y, tombolSebelum)){
                            musiktik.pause();
                            musiktik.seekTo(0);
                            musiktik.start();
                            tombolSebelum.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbsebelumd));
                        }
                        if(apakahMenyentuh(x, y, tombolSesudah)){
                            musiktik.pause();
                            musiktik.seekTo(0);
                            musiktik.start();
                            tombolSesudah.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbsesudahd));
                        }
                        // skenarioMenuUtama = true; dipindahkan ke void geserMenuUtamaDenganStepB40();
                    }
                    if(skenarioKredit){
                        if(apakahMenyentuh(x, y, tombolSebelum)){
                            musiktik.pause();
                            musiktik.seekTo(0);
                            musiktik.start();
                            tombolSebelum.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbsebelumd));
                        }
                        // skenarioMenuUtama = true; dipindahkan ke void geserMenuUtamaDenganStepB40();
                    }
                    if(skenarioMain){
                        if(modePause){
                            if(apakahMenyentuh(x, y, tKembali)){
                                musiktik.pause();
                                musiktik.seekTo(0);
                                musiktik.start();
                                tKembali.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tkembalid));
                            }
                            if(apakahMenyentuh(x, y, tReset) && !munculkanMenuUtama){
                                musiktik.pause();
                                musiktik.seekTo(0);
                                musiktik.start();
                                tReset.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tresetd));
                            }
                            if(apakahMenyentuh(x, y, tKeluar) && !munculkanMenuUtama){
                                musiktik.pause();
                                musiktik.seekTo(0);
                                musiktik.start();
                                tKeluar.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tkeluard));
                                // skenarioMenuUtama = true; dipindahkan ke void geserMenuUtamaDenganStepB40();
                            }
                            if(apakahMenyentuh(x, y, tombolPause)){
                                musiktik.pause();
                                musiktik.seekTo(0);
                                musiktik.start();
                                tombolPause.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.paused));
                            }
                        }else{
                             if(apakahMenyentuh(x, y, tombolKanan)){
                                 musiklari.pause();
                                 musiklari.seekTo(0);
                                 musiklari.start();
                                 tombolKanan.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.kanand));
                                 arahKiriKananSekarang = 1;
                                 boolGerakKeKanan = true;
                                 modeBerjalanKeKanan = 22;
                                 arahSekarang = 1;
                             }
                             if(apakahMenyentuh(x, y, tombolKiri)){
                                 musiklari.pause();
                                 musiklari.seekTo(0);
                                 musiklari.start();
                                 tombolKiri.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.kirid));
                                 arahKiriKananSekarang = 0;
                                  boolGerakKeKiri = true;
                                 modeBerjalanKeKiri = 20;
                                 arahSekarang = 2;
                             }
                             if(apakahMenyentuh(x, y, tombolAtas)){
                                 musiklari.pause();
                                 musiklari.seekTo(0);
                                 musiklari.start();
                                 tombolAtas.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.atasd));
                                 boolGerakKeAtas = true;
                                 modeBerjalanKeAtas = 22;
                                 arahSekarang = 3;
                             }
                             if(apakahMenyentuh(x, y, tombolBawah)){
                                 musiklari.pause();
                                 musiklari.seekTo(0);
                                 musiklari.start();
                                 tombolBawah.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bawahd));
                                 boolGerakKeBawah = true;
                                 modeBerjalanKeBawah = 21;
                                 arahSekarang = 4;
                             }
                             if(apakahMenyentuh(x, y, tombolA)){
                                 tombolA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ad));
                                 boolMinumRamuan = true;
                                 if(modeMinumRamuan == -1)
                                     modeMinumRamuan = 11;
                                 //tampilPopupSkor();
                             }
                             if(apakahMenyentuh(x, y, tombolB)){
                                 tombolB.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bd));
                                 musikmemukul.pause();
                                 musikmemukul.seekTo(0);
                                 musikmemukul.start();
                                 if(modeHunusPedang == 0 && (karakterA.ambilNilaiZA() > 5))
                                     modeHunusPedang = 10;
                             }
                             if(apakahMenyentuh(x, y, tombolC)){
                                 tombolC.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.cd_1));
                                 if(modeHunusPedang == 0 && (karakterA.ambilNilaiZA() > 0))
                                     modeHunusPedang = 10;
                             }
                             if(apakahMenyentuh(x, y, tombolPause)){
                                musiktik.pause();
                                musiktik.seekTo(0);
                                musiktik.start();
                                tombolPause.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.paused));
                             }  
                        }
                    }
                   break;
               case MotionEvent.ACTION_UP:
                   boolGerakKeAtas = false;
                   boolGerakKeBawah = false;
                   boolGerakKeKanan = false;
                   boolGerakKeKiri = false;  
                   
                   musiklari.pause();
                   musiklari.seekTo(0);
                   if(skenarioMenuUtama && sembunyikanMenuUtama == 0){
                        if(apakahMenyentuh(x, y, tombolMulai)){
                            resetSemua();
                            sembunyikanMenuUtama = 1;
                            resetKanvasSkenarioFalse();
                            kanvasSkenarioMain = true;
                            resetSkenarioFalse();
                            modePause = false;
                            tombolMulai.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbmulaid));
                            musiklatar.pause();
                            musiklatar.seekTo(0);
                            musikmain.start();
                        }
                        if(apakahMenyentuh(x, y, tombolBantuan)){
                            sembunyikanMenuUtama = 2;
                            resetKanvasSkenarioFalse();
                            kanvasSkenarioBantuan = true;
                            resetSkenarioFalse();
                            tampilBantuan(1);
                            tombolBantuan.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbbantuand));
                        }
                        if(apakahMenyentuh(x, y, tombolKredit)){
                            sembunyikanMenuUtama = 3;
                            resetKanvasSkenarioFalse();
                            kanvasSkenarioKredit = true;
                            resetSkenarioFalse();
                            tombolKredit.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbkreditd));
                        }
                        // skenarioMain = true; dipindahkan ke void gesetMenuUtamaDenganStepA20();
                    }
                    if(skenarioBantuan){
                        if(apakahMenyentuh(x, y, tombolSebelum) && dataBantuan.ambilR() == 1){
                            munculkanMenuUtama = true;
                            resetSkenarioFalse();
                            tombolSebelum.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbsebelum));
                        }
                        if(apakahMenyentuh(x, y, tombolSebelum) && dataBantuan.ambilR() > 1){
                            dataBantuan.aturR(dataBantuan.ambilR() - 1);
                            tampilBantuan(dataBantuan.ambilR());
                            tombolSebelum.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbsebelum));
                        }
                        if(apakahMenyentuh(x, y, tombolSesudah) && dataBantuan.ambilR() <= 5){
                            dataBantuan.aturR(dataBantuan.ambilR() + 1);
                            if(dataBantuan.ambilR() > 5){
                                dataBantuan.aturR(1);
                                tombolSesudah.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbsesudah));
                                munculkanMenuUtama = true;
                                resetSkenarioFalse();
                            }else{
                                tampilBantuan(dataBantuan.ambilR());
                                tombolSesudah.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbsesudah));
                            }
                        }
                        // skenarioMenuUtama = true; dipindahkan ke void geserMenuUtamaDenganStepB40();
                    }
                    if(skenarioKredit){
                        if(apakahMenyentuh(x, y, tombolSebelum)){
                            munculkanMenuUtama = true;
                            resetSkenarioFalse();
                            tombolSebelum.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tbsebelum));
                        }
                        // skenarioMenuUtama = true; dipindahkan ke void geserMenuUtamaDenganStepB40();
                    }
                    if(skenarioMain){  
                        if(modePause){
                            if(apakahMenyentuh(x, y, tKembali)){
                                modePause = false;
                                tKembali.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tkembali));
                            }
                            if(apakahMenyentuh(x, y, tReset)){
                                resetSemua();
                                modePause = false;
                                tReset.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.treset));
                            }
                            if(apakahMenyentuh(x, y, tKeluar) && !munculkanMenuUtama){
                                tKeluar.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.tkeluar));
                                munculkanMenuUtama = true;
                                resetSkenarioFalse();
                                musikmain.pause();
                                musikmain.seekTo(0);
                                musiklatar.start();
                            }
                            if(apakahMenyentuh(x, y, tombolPause)){
                                tombolPause.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pausen));
                                modePause = false;
                            }
                        }else
                            if(apakahMenyentuh(x, y, tombolPause)){
                                tombolPause.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pausen));
                                modePause = true;
                            }
                    }
                    if(skenarioGameOver){ // Tambahan
                        musiktik.pause();
                        musiktik.seekTo(0);
                        musiktik.start();
                        musikmain.pause();
                        musikmain.seekTo(0);
                        musiklatar.start();
                        skenarioGameOver = false;
                        munculkanMenuUtama = true;
                        resetSkenarioFalse();
                        resetSemua();
                        skenarioMenuUtama = true;
                        resetSemua();
                    }
                    if(x < 200 && y > 200){
                        tombolAtas.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.atas));
                        tombolBawah.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bawah));
                        tombolKanan.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.kanan));
                        tombolKiri.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.kiri));
                    }
                    if(apakahMenyentuh(x, y, tombolAtas)){
                        resetGambarKarakter(3);
                    }
                    if(apakahMenyentuh(x, y, tombolBawah)){
                        resetGambarKarakter(4);
                    }
                    if(apakahMenyentuh(x, y, tombolKanan)){
                        resetGambarKarakter(1);
                    }
                    if(apakahMenyentuh(x, y, tombolKiri)){
                        resetGambarKarakter(2);
                    }
                   
                   
                   
                       modeBerjalanKeKiri = 0;
                       modeBerjalanKeKanan = 0;
                   //if(apakahMenyentuh(x, y, tombolA))
                       tombolA.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.an));
                   //if(apakahMenyentuh(x, y, tombolB))
                       tombolB.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bn));
                       tombolC.aturBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.cn));
                   break;
           }
            return true;
       }
       
       // memberi nilai variabel public xMax dan yMax sebagai koordinat ujung layar <lebar(xMax), tinggi(yMax)>
       // onSizeChanged dipanggil saat pertama kali dan saat pengubahan orientasi layar (portrait -> landscape atau sebaliknya)
       // | ???
       // v
       @Override
       public void onSizeChanged(int w, int h, int oldW, int oldH) {
          xMax = w-1;
          yMax = h-1;
       }
    }
