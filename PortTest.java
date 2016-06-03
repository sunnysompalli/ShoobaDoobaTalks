import java.lang.*;
import java.io.*;
import java.net.*;


public class PortTest {
    public static void main (String[] args){
	try {
		String dog = "netstat -a | grep LISTEN";
    Process p = Runtime.getRuntime().exec(dog);
    p.waitFor();
    BufferedReader reader = 
    new BufferedReader(new InputStreamReader(p.getInputStream()));
    for (line : reader){
    System.out.println(line);
	}
	catch (Exception ex){
	    ex.printStackTrace();}

    
    }}