/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import  java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
*
* http://clipart-library.com/clipart/rcjrpyEzi.htm
*/
/**
 *
 * @author odlaner
 */
public class PacketCarte {
 
    private Carte[] paquet;
    private int cartepointee;
    
    public PacketCarte() throws IOException
    {
        String[] faces = {"2","3","4","5","6","7","8","9","Valet","Reine" ,"Roi","Ace"};
        String[] sorte = {"Trefle","Pique","Coeur","Carreau"};
        paquet = new Carte[52];
        cartepointee =0;
        final int largeur = 61, hauteur = 85, ranges = 4, colonnes= 13;
        BufferedImage imageElargie = ImageIO.read(new File("rcjrpyEzi.png"));
       
        combinaisonImageCarte(ranges, hauteur, colonnes, largeur, imageElargie,
                faces,sorte,paquet);
    }
    
    public static void combinaisonImageCarte(int ranges, int hauteur,
                int colonnes, int largeur, BufferedImage imageElargie,
                String []faces,String[] sorte,
                Carte[] paquet)
    {
        BufferedImage tempImageCarte;
        for(int laSorte = 0; laSorte < ranges; laSorte++)
        {
            for(int numeroFace = 0; numeroFace < colonnes; numeroFace++ )
            {
                tempImageCarte = imageElargie.getSubimage
                            (numeroFace * largeur +(numeroFace*1),
                             laSorte * hauteur + (laSorte*2),largeur,hauteur);
            
                paquet[(numeroFace+ (laSorte * 13))] = new Carte(sorte[laSorte],
                    faces[numeroFace], numeroFace, tempImageCarte);
            }
        }
    }
    
      public static void vueGraphique(Carte uneCarte)
    {
        JFrame fenetre = new JFrame("Vue de la carte");
        fenetre.setSize(500,700);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel contenue = new JPanel(new BorderLayout());
        JLabel carteLabel = new JLabel(new ImageIcon(uneCarte.getCarteImage()));
        
        carteLabel.setSize(300, 400);
        contenue.add(carteLabel);
        fenetre.add(carteLabel);
        fenetre.setVisible(true); 
        
    }
    
    public void vueDesCartes()
    {
        for (Carte carte: paquet)
        {
            vueGraphique(carte);
        }
    }
    
    public static void main(String[] args)throws IOException
    {
        PacketCarte lePaquet = new PacketCarte();
        lePaquet.vueDesCartes();
        
    }
  
}
