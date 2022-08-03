package com.forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.daos.KisiDAO;
import com.enums.Cinsiyet;
import com.pojos.Kisi;
import com.pojos.Okul;
import com.tools.VeriButunleyici;

//BackBean / Controller
public class AnaEkran extends JFrame {

	private JPanel contentPane;
	private JTextField txtAd;
	private JTextField txtSoyad;
	private JTextField txtTc;
	private JComboBox cmbCinsiyet;
	private List<Okul> okulBilgisi = new ArrayList<>();

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox chckbxBinicilik;
	private JCheckBox chckbxAtclk;
	private JCheckBox chckbxYzme;
	private JRadioButton rdbtnEvet;
	private JRadioButton rdbtnHayr;
	private TextArea txtAdres;
	private JButton btnTemizle;
	private JButton btnVeriOku;
	private JTextField txtOkulAdi;
	private JTextField txtBolumAdi;
	private JTextField txtGpu;
	private JTable table;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaEkran frame = new AnaEkran();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AnaEkran buSinifiVer() {
		return this;
	}

	/**
	 * Create the frame.
	 */
	public AnaEkran() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AnaEkran.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAd = new JLabel("Ad:");
		lblAd.setBounds(10, 11, 25, 14);
		contentPane.add(lblAd);

		txtAd = new JTextField();
		txtAd.setBounds(45, 8, 86, 20);
		contentPane.add(txtAd);
		txtAd.setColumns(10);

		JLabel lblSoyad = new JLabel("Soyad:");
		lblSoyad.setBounds(10, 39, 34, 14);
		contentPane.add(lblSoyad);

		txtSoyad = new JTextField();
		txtSoyad.setBounds(45, 36, 86, 20);
		contentPane.add(txtSoyad);
		txtSoyad.setColumns(10);

		JLabel lblTc = new JLabel("Tc:");
		lblTc.setBounds(10, 67, 25, 14);
		contentPane.add(lblTc);

		txtTc = new JTextField();
		txtTc.setBounds(45, 64, 86, 20);
		contentPane.add(txtTc);
		txtTc.setColumns(10);

		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VeriButunleyici vb = new VeriButunleyici().ready(buSinifiVer());
				vb.getKisi().setOkulBilgileri(okulBilgisi);
				if (new KisiDAO().create(vb.getKisi())) {
					JOptionPane.showMessageDialog(null, "Kayýt iþlemi baþarýlý !");
				} else {
					JOptionPane.showMessageDialog(null, "Kayýt iþlemi baþarýsýz !");
				}

			}
		});
		btnKaydet.setBounds(212, 326, 89, 23);
		contentPane.add(btnKaydet);

		cmbCinsiyet = new JComboBox();
		cmbCinsiyet.setModel(new DefaultComboBoxModel(Cinsiyet.values()));
		cmbCinsiyet.setBounds(55, 95, 76, 20);
		contentPane.add(cmbCinsiyet);

		JLabel lblCinsiyet = new JLabel("Cinsiyet:");
		lblCinsiyet.setBounds(10, 98, 46, 14);
		contentPane.add(lblCinsiyet);

		JLabel lblHobiler = new JLabel("Hobiler:");
		lblHobiler.setBounds(141, 11, 46, 14);
		contentPane.add(lblHobiler);

		chckbxBinicilik = new JCheckBox("Binicilik");
		chckbxBinicilik.setBounds(193, 7, 97, 23);
		contentPane.add(chckbxBinicilik);

		chckbxAtclk = new JCheckBox("At\u0131c\u0131l\u0131k");
		chckbxAtclk.setBounds(193, 35, 97, 23);
		contentPane.add(chckbxAtclk);

		chckbxYzme = new JCheckBox("Y\u00FCzme");
		chckbxYzme.setBounds(193, 63, 97, 23);
		contentPane.add(chckbxYzme);

		JLabel lblSigaraKullanyorMusunuz = new JLabel("Sigara Kullan\u0131yor musunuz ?");
		lblSigaraKullanyorMusunuz.setBounds(141, 98, 149, 14);
		contentPane.add(lblSigaraKullanyorMusunuz);

		rdbtnEvet = new JRadioButton("Evet");
		buttonGroup.add(rdbtnEvet);
		rdbtnEvet.setBounds(141, 119, 53, 23);
		contentPane.add(rdbtnEvet);

		rdbtnHayr = new JRadioButton("Hay\u0131r");
		rdbtnHayr.setSelected(true);
		buttonGroup.add(rdbtnHayr);
		rdbtnHayr.setBounds(218, 119, 76, 23);
		contentPane.add(rdbtnHayr);

		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setBounds(10, 138, 34, 14);
		contentPane.add(lblAdres);

		txtAdres = new TextArea();
		txtAdres.setBounds(10, 158, 291, 114);
		contentPane.add(txtAdres);

		btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				resetTable();

				getTxtAd().setText("");
				getTxtSoyad().setText("");
				getTxtTc().setText("");

				getTxtAdres().selectAll();
				getTxtAdres().setText("");

				getCmbCinsiyet().setSelectedItem(Cinsiyet.valueOf("Erkek"));

				getChckbxAtclk().setSelected(false);
				getChckbxBinicilik().setSelected(false);
				getChckbxYzme().setSelected(false);

				getRdbtnHayr().setSelected(true);

				getTxtOkulAdi().setText("");
				getTxtBolumAdi().setText("");
				getTxtGpu().setText("");

			}
		});
		btnTemizle.setBounds(10, 326, 89, 23);
		contentPane.add(btnTemizle);

		btnVeriOku = new JButton("Veri Oku");
		btnVeriOku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Kisi kisi = new KisiDAO().read(0L);
				new VeriButunleyici(kisi).formReady(buSinifiVer());
				addRowInTable(kisi.getOkulBilgileri());

			}
		});
		btnVeriOku.setBounds(113, 326, 89, 23);
		contentPane.add(btnVeriOku);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(309, 11, 218, 338);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("E\u011Fitim bilgileri",
				new ImageIcon(AnaEkran.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")),
				panel, null);
		panel.setLayout(null);

		JLabel lblOkulAd = new JLabel("Okul Ad\u0131:");
		lblOkulAd.setBounds(10, 11, 46, 14);
		panel.add(lblOkulAd);

		txtOkulAdi = new JTextField();
		txtOkulAdi.setBounds(54, 8, 86, 20);
		panel.add(txtOkulAdi);
		txtOkulAdi.setColumns(10);

		JLabel lblBlm = new JLabel("B\u00F6l\u00FCm:");
		lblBlm.setBounds(10, 36, 46, 14);
		panel.add(lblBlm);

		txtBolumAdi = new JTextField();
		txtBolumAdi.setBounds(54, 33, 86, 20);
		panel.add(txtBolumAdi);
		txtBolumAdi.setColumns(10);

		JLabel lblGpu = new JLabel("GPU:");
		lblGpu.setBounds(10, 61, 46, 14);
		panel.add(lblGpu);

		txtGpu = new JTextField();
		txtGpu.setBounds(54, 61, 86, 20);
		panel.add(txtGpu);
		txtGpu.setColumns(10);

		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String okul = txtOkulAdi.getText().toString();
				String bolum = txtBolumAdi.getText().toString();
				Double gpu = new Double(txtGpu.getText());

				okulBilgisi.add(new Okul(okul, bolum, gpu));
				addRowInTable(okulBilgisi);
			}
		});
		btnNewButton.setBounds(150, 20, 51, 47);
		panel.add(btnNewButton);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "E\u011Fitimler",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(4, 98, 203, 204);
		panel.add(panel_2);
		panel_2.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 191, 181);
		panel_2.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Okul", "B\u00F6l\u00FCm", "GPU" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u0130\u015F bilgileri",
				new ImageIcon(AnaEkran.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")), panel_1,
				null);
	}

	public void addRowInTable(List<Okul> okulBilgileri) {

		// Veri ekleme için model oluþtur
		DefaultTableModel dtm = new DefaultTableModel();

		// Tablo baþlýklarýný gir
		String[] basliklar = { "Okul", "Bölüm", "GPU" };
		dtm.setColumnIdentifiers(basliklar);

		if (okulBilgileri != null)
			// Tablo verilerini set et
			okulBilgileri.forEach(okul -> {

				dtm.addRow(new Object[] { okul.getOkulAdi(), okul.getBolumAdi(), okul.getGpu() });

			});

		// Verileri tabloya uygula
		table.setModel(dtm);

	}

	public void resetTable() {

		// Veri ekleme için model oluþtur
		DefaultTableModel dtm = new DefaultTableModel();

		// Tablo baþlýklarýný gir
		String[] basliklar = { "Okul", "Bölüm", "GPU" };
		dtm.setColumnIdentifiers(basliklar);

		// Verileri tabloya uygula
		table.setModel(dtm);

	}

	public JTextField getTxtAd() {
		return txtAd;
	}

	public void setTxtAd(JTextField txtAd) {
		this.txtAd = txtAd;
	}

	public JTextField getTxtSoyad() {
		return txtSoyad;
	}

	public void setTxtSoyad(JTextField txtSoyad) {
		this.txtSoyad = txtSoyad;
	}

	public JTextField getTxtTc() {
		return txtTc;
	}

	public void setTxtTc(JTextField txtTc) {
		this.txtTc = txtTc;
	}

	public JComboBox getCmbCinsiyet() {
		return cmbCinsiyet;
	}

	public void setCmbCinsiyet(JComboBox cmbCinsiyet) {
		this.cmbCinsiyet = cmbCinsiyet;
	}

	public JCheckBox getChckbxBinicilik() {
		return chckbxBinicilik;
	}

	public void setChckbxBinicilik(JCheckBox chckbxBinicilik) {
		this.chckbxBinicilik = chckbxBinicilik;
	}

	public JCheckBox getChckbxAtclk() {
		return chckbxAtclk;
	}

	public void setChckbxAtclk(JCheckBox chckbxAtclk) {
		this.chckbxAtclk = chckbxAtclk;
	}

	public JCheckBox getChckbxYzme() {
		return chckbxYzme;
	}

	public void setChckbxYzme(JCheckBox chckbxYzme) {
		this.chckbxYzme = chckbxYzme;
	}

	public JRadioButton getRdbtnEvet() {
		return rdbtnEvet;
	}

	public void setRdbtnEvet(JRadioButton rdbtnEvet) {
		this.rdbtnEvet = rdbtnEvet;
	}

	public JRadioButton getRdbtnHayr() {
		return rdbtnHayr;
	}

	public void setRdbtnHayr(JRadioButton rdbtnHayr) {
		this.rdbtnHayr = rdbtnHayr;
	}

	public TextArea getTxtAdres() {
		return txtAdres;
	}

	public void setTxtAdres(TextArea txtAdres) {
		this.txtAdres = txtAdres;
	}

	public JTextField getTxtOkulAdi() {
		return txtOkulAdi;
	}

	public void setTxtOkulAdi(JTextField txtOkulAdi) {
		this.txtOkulAdi = txtOkulAdi;
	}

	public JTextField getTxtBolumAdi() {
		return txtBolumAdi;
	}

	public void setTxtBolumAdi(JTextField txtBolumAdi) {
		this.txtBolumAdi = txtBolumAdi;
	}

	public JTextField getTxtGpu() {
		return txtGpu;
	}

	public void setTxtGpu(JTextField txtGpu) {
		this.txtGpu = txtGpu;
	}

}
