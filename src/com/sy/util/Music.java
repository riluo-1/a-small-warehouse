
package com.sy.util;
import java.applet.AudioClip; 
import java.io.*; 
import java.applet.Applet; 
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL; 
/**
 *—≠ª∑≤•∑≈“Ù¿÷
 * @author sunset
 *
 */
public class Music { 
     File f = new File("D:\\bgm.wav"); 
     URL url; 
     URI uri;
     AudioClip clip; 
   public Music(){     
     try
     {  
        uri=f.toURI();
        url = uri.toURL();
        clip = Applet.newAudioClip(url); 
        clip.loop();//—≠ª∑≤•∑≈
        //clip.play();//≤•∑≈
        //clip.stop();//Õ£÷π≤•∑≈
    }
     catch (MalformedURLException e) { 
            e.printStackTrace(); 
            System.out.println("≤•∑≈¥ÌŒÛ£°");
        }
    }
   /**
    * Õ£÷π≤•∑≈“Ù¿÷
    */
   public void stopMusic()//Õ£÷π≤•∑≈
   {
       clip.stop();
   }
   /**
    * ≤•∑≈“Ù¿÷
    */
   public void playMusic()//≤•∑≈
   {
       clip.play();
   }
   /**
    * —≠ª∑≤•∑≈“Ù¿÷
    */
   public void loopMusic()//—≠ª∑≤•∑≈
   {
       clip.loop();
   }
} 