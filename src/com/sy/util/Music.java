
package com.sy.util;
import java.applet.AudioClip; 
import java.io.*; 
import java.applet.Applet; 
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL; 
/**
 *ѭ����������
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
        clip.loop();//ѭ������
        //clip.play();//����
        //clip.stop();//ֹͣ����
    }
     catch (MalformedURLException e) { 
            e.printStackTrace(); 
            System.out.println("���Ŵ���");
        }
    }
   /**
    * ֹͣ��������
    */
   public void stopMusic()//ֹͣ����
   {
       clip.stop();
   }
   /**
    * ��������
    */
   public void playMusic()//����
   {
       clip.play();
   }
   /**
    * ѭ����������
    */
   public void loopMusic()//ѭ������
   {
       clip.loop();
   }
} 