package lari.terus;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity
{
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      View duniaBaru = new Dunia(this);
      setContentView(duniaBaru);
      duniaBaru.setBackgroundColor(Color.BLACK);
   }
}
