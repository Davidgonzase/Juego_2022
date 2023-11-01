package Launch;
import javax.swing.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Launch game
 * Stores date in a txt document
 */
public class launch {
    public static void main(String[] args){
        game Game=new game();
        Game.start();
        File reg=new File("log.txt");
        FileWriter fich=null;
        try {
            fich=new FileWriter(reg,true);
            DateFormat fech=new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
            Date hour=new Date(System.currentTimeMillis());
            PrintWriter pw=new PrintWriter(fich);
            pw.println(hour);
        } catch (IOException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }finally {
            try {
                if (null!=fich)
                    fich.close();
            }catch (Exception e2){
                System.err.println(e2);
            }
        }
    }
}