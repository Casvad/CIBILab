/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cibi_lab;

import cibi_lab.aplicacion.Mundo;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author carlos.sanchez-v
 */
public class CIBI_Lab extends JFrame {

    public CIBI_Lab() {
        setTitle("CIBI LABORATORY");
	setSize(100,100);
	setLocationRelativeTo(null);
    }
    
    public int getRes(){
        return JOptionPane.showConfirmDialog(this,"Continuar con el laboratorio de cibi?");
    }

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Mundo m = new Mundo(50, 50);
        m.colision();
        m.getAltura();
        m.getBrecha();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter password: ");
        if (br.readLine().trim().equals("CIBI_LABORATORY")) {
            try {
                System.out.println("Correct password");
                CIBI_Lab cl = new CIBI_Lab();
                cl.setVisible(true);
                int ans = cl.getRes();
                if(ans ==JOptionPane.YES_OPTION){
                    System.out.println("Getting data...");
                    System.out.println(getHTML("https://www.meetup.com/HackLab-Bogota/"));
                    System.out.println("ups...");
                    System.out.println("your system has been corrupted :)");
                    System.exit(0);
                }else{
                    System.out.println("Maybe this is a sandbox");
                    System.exit(0);
                }
                
            } catch (Exception ex) {
              
            }
        } else {
            System.out.println("Password invalid");
            System.exit(0);
        }

    }

}
