package com.my;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class Prueba_ImagenActivity extends Activity {
    /** Called when the activity is first created. */
	
	ImageView iv1;
	ImageView iv2;
	ImageView iv3;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        iv1 = (ImageView)findViewById(R.id.iv1);
        iv2 = (ImageView)findViewById(R.id.iv2);
        iv3 = (ImageView)findViewById(R.id.iv3);
        
        ImageGetter myGetter = new ImageGetter();
        
        String nombreAsset="a.jpg";
        String nombreRes="b";
        String url="http://knol.google.com/k/-/-/14dmp09oqdm08/n6csqi/google-simple.jpg";
        
        iv1.setImageBitmap(myGetter.traerImagenDeAssets(nombreAsset, this));
        iv2.setImageBitmap(myGetter.traerImagenDeResource(nombreRes, this));
        iv3.setImageBitmap(myGetter.traerImagenDeHttp(url));
    }
}