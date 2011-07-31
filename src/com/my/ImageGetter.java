package com.my;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class ImageGetter {
	
	private final String TAG = getClass().getSimpleName();
	
	
	
	
	public Bitmap traerImagenDeHttp(String direccionWeb){
		Log.v(TAG,"Estoy en ImageGetter: traerImagenDeHttp");
		//Entrada: Direccion web de la imagen en String
		//Salida: Devuelve imagen en bitmap para poder mostrar en ImageView
	
		try {
        	Log.e("src",direccionWeb);
        	//Crear un objeto URL con una dirección
        	URL url = new URL(direccionWeb);
        	//Abrir conexión
        	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        	connection.setDoInput(true);
        	connection.connect();
        	//Una clase de flujo de bytes(se puede usar para todo, no solo imagenes)
        	InputStream input = connection.getInputStream();
        	//Otra forma de reprecentar una imagen
        	Bitmap miBitmap = BitmapFactory.decodeStream(input);
        	//Cerrar flujo
        	input.close();
        	return miBitmap;
    	} catch (IOException e) {
        	e.printStackTrace();
        	Log.e("Exception",e.getMessage());
        	return null;
    	}

	}

	public Bitmap traerImagenDeResource(String nombreImg, Context context){
		Log.v(TAG,"Estoy en ImageGetter: traerImagenDeResource");
		int id = context.getResources().getIdentifier(nombreImg, "drawable", context.getPackageName());
		Bitmap miBitmap = BitmapFactory.decodeResource(context.getResources(), id);
		
		return miBitmap;
	}
	
	public Bitmap traerImagenDeAssets(String nombreImg, Context context){
		Log.v(TAG,"Estoy en ImageGetter: traerImagenDeAssets");
		
		AssetManager manager = context.getAssets();
		
		try{
			InputStream is = manager.open(nombreImg);
			Bitmap bitmap = BitmapFactory.decodeStream(is);
			is.close();
			return bitmap;
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}		

	}

	

}
