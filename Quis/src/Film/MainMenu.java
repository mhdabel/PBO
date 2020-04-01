package Film;

//import javax.activation.DataSource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener {// implements


    public String judul, subjudul, garis, identitas;


    private static JButton btnfilm;


    Container konten = getContentPane(); // menambahkan konten


    public MainMenu() {

        getComponents();
        Koneksi kon = new Koneksi();
        kon.connect();
        JLabel lbjudul = new JLabel("=====MAIN MENU=====");
        JLabel lbsubjudul = new JLabel("=======FORM ENTRY FILM=======");
        JLabel lbgaris = new JLabel(
                "===================================================");


        btnfilm = new JButton("FILM");


        setLayout(null);
        Dimension sizelbjudul = lbjudul.getPreferredSize();
        Dimension sizelbsubjudul = lbsubjudul.getPreferredSize();
        Dimension sizelbgaris = lbgaris.getPreferredSize();


        Dimension sizebtnMahasiswa = btnfilm.getPreferredSize();


        lbjudul.setBounds(150, 20, 200, 50);
        lbsubjudul.setBounds(40, 65, 500, 50);
        lbgaris.setBounds(20, 90, 500, 50);


        btnfilm.setBounds(150, 220, 120, sizebtnMahasiswa.height);


        add(lbjudul);
        add(lbsubjudul);
        add(lbgaris);

        add(btnfilm);


        btnfilm.addActionListener(this);

        setSize(500, 380);
        setTitle("INFORMATIKA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnfilm) {
            try {
                // form di close - dispose();
                new Film().setVisible(true);
            } catch (Exception es) {
                es.printStackTrace();
            }
        }


    }

    // public static void main(String args[]) throws Exception {
    login s = new login();
    //  s.setVisible(true);

    }
