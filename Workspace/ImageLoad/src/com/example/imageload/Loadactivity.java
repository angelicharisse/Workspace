package com.example.imageload;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class Loadactivity extends Activity {
	 ProgressBar loadingProgressBar;
	 ImageView[] targetImage = new ImageView[5];


	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_loadactivity);
	        targetImage[0] = (ImageView)findViewById(R.id.image1);
	        targetImage[1] = (ImageView)findViewById(R.id.image2);
	        targetImage[2] = (ImageView)findViewById(R.id.image3);
	        targetImage[3] = (ImageView)findViewById(R.id.image4);
	        targetImage[4] = (ImageView)findViewById(R.id.image5);
	      
	        
	        loadingProgressBar = (ProgressBar)findViewById(R.id.loadingprogress);
	        
	        
	        String onLineImage0 = "http://ww1.prweb.com/prfiles/2010/05/11/1751474/gI_TodoforiPadAppIcon512.png.jpg";
	        String onLineImage1 = "http://cdn4.iosnoops.com/wp-content/uploads/2011/08/Icon-Gmail_large-250x250.png";
	        String onLineImage2 = "http://kelpbeds.files.wordpress.com/2012/02/lens17430451_1294953222linkedin-icon.jpg?w=450";
	        String onLineImage3 = "http://snapknot.com/blog/wp-content/uploads/2010/03/facebook-icon-copy.jpg";
	        String onLineImage4 = "https://lh3.googleusercontent.com/-ycDGy_fZVZc/AAAAAAAAAAI/AAAAAAAAAAc/Q0MmjxPCOzk/s250-c-k/photo.jpg";
	        URL onLineURL0, onLineURL1, onLineURL2, onLineURL3, onLineURL4;
	        
	  try {
	   onLineURL0 = new URL(onLineImage0);
	   onLineURL1 = new URL(onLineImage1);
	   onLineURL2 = new URL(onLineImage2);
	   onLineURL3 = new URL(onLineImage3);
	   onLineURL4 = new URL(onLineImage4);
	   new MyNetworkTask(5, targetImage, loadingProgressBar)
	    .execute(onLineURL0, onLineURL1, onLineURL2, onLineURL3, onLineURL4);
	  } catch (MalformedURLException e) {
	   e.printStackTrace();
	  }
	        
	    }
	    
	    private class MyNetworkTask extends AsyncTask<URL, Integer, Void>{
	     
	     ImageView[] tIV;
	     TextView[] tv;
	     Bitmap[] tBM;
	     ProgressBar tProgressBar;
	     
	     public MyNetworkTask(int numberOfImage, ImageView[] iv, ProgressBar pb){
	      
	      tBM = new Bitmap[numberOfImage];
	      
	      tIV = new ImageView[numberOfImage];
	      for(int i = 0; i < numberOfImage; i++){
	       tIV[i] = iv[i];
	      }
	      
	      tProgressBar = pb;
	     }

	  @Override
	  protected Void doInBackground(URL... urls) {

	   if (urls.length > 0){
	    for(int i = 0; i < urls.length; i++){
	     URL networkUrl = urls[i];
	     
	     try {
	      tBM[i] = BitmapFactory.decodeStream(
	        networkUrl.openConnection().getInputStream());
	     } catch (IOException e) {
	      e.printStackTrace();
	     }
	     
	     publishProgress(i);
	     
	     try {
	      Thread.sleep(500);
	     } catch (InterruptedException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	     }
	     
	    }
	   }
	   return null;
	  }

	  @Override
	  protected void onPostExecute(Void result) {
	   Toast.makeText(getBaseContext(), "Finished", Toast.LENGTH_LONG).show();
	  }

	  @Override
	  protected void onProgressUpdate(Integer... values) {

	   if(values.length > 0){
	    for(int i = 0; i < values.length; i++){
	     tIV[values[i]].setImageBitmap(tBM[values[i]]);
	     tProgressBar.setProgress(values[i]+1);
	    }
	   }
	   
	  }

	    }

	}
