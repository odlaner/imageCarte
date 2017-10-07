
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import java.nio.Buffer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author odlaner
 */
class Carte {
    private String numeroFace, leType;
    private  int valeurDeLaFace;
    private BufferedImage carteImage;
    
    /**
     * 
     * @param leType
     * @param face
     * @param valeur
     * @param carte 
     */
    public Carte(String leType, String face, int valeur, BufferedImage carte)
    {
        this.leType = leType;
        this.numeroFace = face;
        valeurDeLaFace = valeur;
        carteImage = carte;
    }
    
    public String toString()
    {
        return numeroFace +"de"+ leType;
    }
    public BufferedImage getCarteImage()
    {
        return carteImage;
    }
    public int getValeurDeLaFace()
    {
        return valeurDeLaFace;
    }
    
  
}
