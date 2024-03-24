import javax.sound.sampled.*;
import java.io.*;
import java.net.Socket;
public class clientSide {
	public static void main(String[] args) {
      try {
    	  String serverIp="10.160.67.58"; //this IP is your system IP
    	  int serverPort=12345;
    	  AudioFormat audioFormat=new AudioFormat(16000,16,1,true,true);
    	  DataLine.Info info=new DataLine.Info(TargetDataLine.class, audioFormat);
    	  TargetDataLine targetDataLine=(TargetDataLine)AudioSystem.getLine(info);
    	  targetDataLine.start();
    	  System.out.println("Microphone Opened. \nConnecting to the Server...");
    	  System.out.println(" ");
    	  
    	  Socket socket=new Socket(serverIp,serverPort);
    	  OutputStream outputStream=socket.getOutputStream();
    	  
    	  System.out.println("Connected to the server. \nStarting audio transmission...");
    	  byte[] buffer=new byte[1024];
    	  
    	  while(true)
    	  {
    		  int bytesRead=targetDataLine.read(buffer,0,buffer.length);
    		  outputStream.write(buffer,0,bytesRead);
    	  }
    	  
    	  
    	  }
      catch(Exception e)
      {
    	  e.printStackTrace();
      }
	
	}

}
