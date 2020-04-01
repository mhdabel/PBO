package Film;

public class Loginpackage Film;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;

public class login extends JFrame implements ActionListener {

    Container konten = getContentPane();
    private JLabel lblUser = new JLabel("Username   ");
    private JTextField txtUser = new JTextField();
    private JLabel lblPassword = new JLabel("Password   ");
    private JPasswordField pfPassword = new JPasswordField();
    private JButton btnMasuk = new JButton("Masuk");
    private JButton btnKeluar = new JButton("Keluar");

    public login() {
        super("Login");
        setVisible(true);
        setSize(355, 305);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        konten.setLayout(null);
        konten.add(lblUser);
        konten.add(txtUser);
        konten.add(lblPassword);
        konten.add(pfPassword);
        konten.add(btnMasuk);
        konten.add(btnKeluar);

        lblUser.setBounds(130, 10, 100, 25);
        lblPassword.setBounds(130, 95, 100, 25);
        txtUser.setBounds(70, 50, 200, 25);
        pfPassword.setBounds(70, 135, 200, 25);
        btnMasuk.setBounds(60, 200, 100, 25);
        btnKeluar.setBounds(190, 200, 100, 25);
        txtUser.setToolTipText("Masukkan Username");
        pfPassword.setToolTipText("Masukkan Password");
        btnMasuk.addActionListener(this);
        btnKeluar.addActionListener(this);
    }
    public void actionPerformed(ActionEvent act) {
        Object obj = act.getSource();
        if (obj == btnMasuk) {
            String user_app = txtUser.getText();
            String password_app = pfPassword.getText();
            if (user_app.equalsIgnoreCase("informatika") && password_app.equalsIgnoreCase("17")) {
                JOptionPane.showMessageDialog(null, "Login Berhasil !!!");
                login.this.setVisible(false); // agar tampilan loginnya hilang
                // setelah main menu muncul
                new MainMenu().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Password atau Username anda salah");
                login.this.setVisible(false);
            }
        } else if (obj == btnKeluar) {
            JOptionPane.showMessageDialog(null, "Berhasil Keluar");
            System.exit(0);
        }
        txtUser.setText(" ");
        pfPassword.setText(" ");
        txtUser.setRequestFocusEnabled(true);
    }

    private String pfPassword() {
        return null;
    }
} {
}
