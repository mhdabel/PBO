package Film;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Film extends JFrame {

    private JPanel contentPane;
    private JTextField txtkode;
    private JTextField txtjenis;
    String[] judul = {"-Pilih-"};

    private JTextField txttipe;
    private JTextField txtgenre;
    private JTable tabel;
    String fieldTabel[] = { "kode film", "Judul film", "Tipe", "genre" }; // membuat
    JComboBox cmbjudul = new JComboBox(judul);                                                                                                                                                                                                            // dimensi
    DefaultTableModel tabelModel;

    /**
     * create the frame.
     */
    /*
     * Konstruktor adalah method yang dipanggil pertama kali ketika program
     * dijalankan konstruktor namanya sama dengan nama class
     */

    public Film() {

        Mdlfilm MdlB = new Mdlfilm();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 685, 620);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        // Buat object tabelModel dengan syntax new
        tabelModel = new DefaultTableModel(null, fieldTabel);
        /*
         * null akan diisi data yang diambil dari database fieldTabel adalah
         * nama field tabel
         */
        JLabel lblData = new JLabel("FORM ENTRY FILM");
        JLabel lblkode = new JLabel("ID film : ");
        JLabel lbljudul = new JLabel("Judul Film          : ");
        JLabel lbltipe = new JLabel("Tipe film        : ");
        JLabel lblgenre = new JLabel("genre          : ");

        lblData.setBounds(230, 25, 300, 25);

        lblkode.setBounds(15, 67, 70, 15);
        lbljudul.setBounds(15, 95, 70, 15);
        lbltipe.setBounds(15, 123, 70, 15);
        lblgenre.setBounds(15, 151, 70, 15);

        contentPane.add(lblData);
        contentPane.add(lblkode);
        contentPane.add(lbljudul);
        contentPane.add(lbltipe);
        contentPane.add(lblgenre);

        //txtID = new JTextField();
        //txtjudul = new JTextField();
        txttipe = new JTextField();
        txtgenre = new JTextField();

        txtkode.setBounds(100, 65, 150, 19);
        cmbjudul.setBounds(100, 95, 150, 19);
        txttipe.setBounds(100, 124, 150, 19);
        txtgenre.setBounds(100, 151, 150, 19);

        contentPane.add(txtkode);
        contentPane.add(cmbjudul);
        contentPane.add(txttipe);
        contentPane.add(txtgenre);

        txtkode.setColumns(10);
        // jenis.setColumns(10);
        // cmbjenis.setColumns(10);
        txttipe.setColumns(10);
        txtgenre.setColumns(10);

        setTitle("FORM ENTRY BUKU");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblDaftar = new JLabel("DAFTAR film");
        lblDaftar.setBounds(280, 230, 500, 15);
        contentPane.add(lblDaftar);



        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(70, 250, 525, 260);
        contentPane.add(scrollPane);

        tabel = new JTable();
        tabel.setModel(tabelModel);
        scrollPane.setViewportView(tabel);
        tabel.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                int a = tabel.getSelectedRow();
                if (a < 0) {
                    return;
                }
                String kode = (String) tabelModel.getValueAt(a, 0);
                txtkode.setText(kode);
                String judul = (String) tabelModel.getValueAt(a, 1);
                cmbjudul.setSelectedItem(judul);
                String tipe = (String) tabelModel.getValueAt(a, 2);
                txttipe.setText(tipe);
                String genre = (String) tabelModel.getValueAt(a, 3);
                txtgenre.setText(genre);
            }
        });

        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(70, 530, 160, 25);

        contentPane.add(btnSimpan);

        btnSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // fungsi simpan
                String kode = txtkode.getText();
                // String jenis = cmbjenis.getText();
                String jenis = cmbjudul.getSelectedItem().toString();
                String tanggal = txttipe.getText();
                String pengarang = txtgenre.getText();
                if (!txtkode.getText().isEmpty() && !cmbjudul.getSelectedItem().toString().isEmpty() && !txttipe.getText().isEmpty()
                        && !txtgenre.getText().isEmpty()) {
                    MdlB.simpanfilm (kode, jenis, tanggal, pengarang);
                    txtkode.setText("");
                    cmbjudul.setSelectedItem("");
                    txttipe.setText("");
                    txtgenre.setText("");
                    tabel();
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(245, 530, 160, 25);

        contentPane.add(btnUpdate);

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // fungsi update
                String kode = txtkode.getText();
                String jenis = cmbjudul.getSelectedItem().toString();
                String tanggal = txttipe.getText();
                String pengarang = txtgenre.getText();
                if (!txtkode.getText().isEmpty() && !cmbjudul.getSelectedItem().toString().isEmpty() && !txttipe.getText().isEmpty()
                        && !txtgenre.getText().isEmpty()) {
                    MdlB.updatefilm(kode, jenis, tanggal, pengarang);
                    txtkode.setText("");
                    cmbjudul.setSelectedItem("");
                    txttipe.setText("");
                    txtgenre.setText("");
                    tabel();
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton btnHapus = new JButton("Hapus");
        btnHapus.setBounds(420, 530, 160, 25);

        contentPane.add(btnHapus);

        btnHapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // fungsi hapus
                if (!txtkode.getText().isEmpty()) {
                    String kode = txtkode.getText();
                    if (JOptionPane.showConfirmDialog(rootPane, "Yakin Menghapus?", "Hapus", 1) == 0) {
                        MdlB.hapusfilm(kode);
                        txtkode.setText("");
                        cmbjudul.setSelectedItem("");
                        txttipe.setText("");
                        txtgenre.setText("");
                        tabel();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        tabel();

    } // Akhir Konstruktor

    private void tabel() {
        tabelModel.getDataVector().removeAllElements();
        tabelModel.fireTableDataChanged();
        try {
            java.sql.Connection con; //METHOD MEMBUAT KONEKSI
            con = new Koneksi().connect();
            String sql = "SELECT * FROM `bukuu`";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                tabelModel.addRow(new Object[] { rs.getString("kode"), rs.getString("jenis"),
                        rs.getString("tanggal"), rs.getString("pengarang"), });
            }
        } catch (Exception s) {
        }

    }
}
