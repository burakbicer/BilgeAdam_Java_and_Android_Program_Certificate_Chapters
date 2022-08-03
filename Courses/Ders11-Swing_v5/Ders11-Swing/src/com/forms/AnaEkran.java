package com.forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.daos.KisiDAO;
import com.enums.Cinsiyet;
import com.pojos.Is;
import com.pojos.Kisi;
import com.pojos.Okul;
import com.tools.VeriButunleyici;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;

//BackBean / Controller
public class AnaEkran extends JFrame {

	private JPanel contentPane;
	private JTextField txtAd;
	private JTextField txtSoyad;
	private JTextField txtTc;
	private JComboBox cmbCinsiyet;
	private List<Okul> okulBilgisi = new ArrayList<>();
	private List<Is> isBilgileri = new ArrayList<>();

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
	private JTable tblIsBilgileri;
	private JTextField txtIstenAyrilmaTar;
	private JTextField txtFirmaAdi;
	private JTextField txtPozisyon;
	private JTextField txtGirisZamani;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton rdbtnIseDevamEvet;
	private JRadioButton rdbtnIseDevamHayir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaEkran frame = new AnaEkran();
					frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		setBackground(Color.GRAY);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AnaEkran.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 456);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnDosya = new JMenu("Dosya");
		menuBar.add(mnDosya);

		JMenuItem mntmKaydet = new JMenuItem("Kaydet");
		mntmKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VeriButunleyici vb = new VeriButunleyici().ready(buSinifiVer());
				vb.getKisi().setOkulBilgileri(okulBilgisi);
				vb.getKisi().setIsBilgileri(isBilgileri);
				if (new KisiDAO().create(vb.getKisi())) {
					JOptionPane.showMessageDialog(null, "Kayýt iþlemi baþarýlý !");
				} else {
					JOptionPane.showMessageDialog(null, "Kayýt iþlemi baþarýsýz !");
				}

			}
		});
		mntmKaydet.setIcon(new ImageIcon(
				AnaEkran.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		mntmKaydet.setSelectedIcon(
				new ImageIcon(AnaEkran.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mnDosya.add(mntmKaydet);

		JMenu mnExport = new JMenu("Export");
		mnExport.setIcon(new ImageIcon(
				AnaEkran.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-capslock-button.png")));
		mnDosya.add(mnExport);

		JMenuItem mntmTxtFormatnda = new JMenuItem("Txt format\u0131nda");
		mntmTxtFormatnda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Kisi kisi = new KisiDAO().read(0L);
				String veri = "Ad:" + kisi.getAd() + " \r\n" + " Soyad:" + kisi.getSoyad() + "\r\n";
				veri += "Tc:" + kisi.getTc() + " \r\n" + " Adres:" + kisi.getAdres() + "\r\n";
				veri += "Cinsiyet:" + kisi.getCinsiyet() + " \r\n";
				veri += "Hobiler: \r\n";
				for (String str : kisi.getHobiler()) {
					veri += str + " \r\n";
				}

				veri += "Okul Blilgileri: \r\n";
				veri += "Okul Adý| Bölüm Adý| GPU \r\n";
				for (Okul okul : kisi.getOkulBilgileri()) {
					veri += okul.getOkulAdi() + "-";
					veri += okul.getBolumAdi() + "-";
					veri += okul.getGpu();
				}

				veri += "Ýþ Deneyimleri: \r\n";
				veri += "Firma Adý | Pozisyon | Giriþ Zamaný | Çýkýþ Zamaný \r\n";
				for (Is is : kisi.getIsBilgileri()) {
					veri += is.getFirmaAdi() + "-";
					veri += is.getPozisyon() + "-";
					veri += is.getGirisZamani() + "-";
					veri += is.getCikisZamani();
				}
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter("export.txt"));
					out.write(veri);
					out.close();
					
					JOptionPane.showMessageDialog(null, "Ýþlem Baþarýlý");
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ýþlem Baþarýsýz !");
				}

			}
		});
		mntmTxtFormatnda.setIcon(new ImageIcon(AnaEkran.class.getResource("/com/resources/addIcon.jpg")));
		mnExport.add(mntmTxtFormatnda);

		JMenuItem mntmk = new JMenuItem("\u00C7\u0131k\u0131\u015F");
		mntmk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int sonuc = JOptionPane.showConfirmDialog(null, "Çýkmaktan Emin misiniz?");
				if (sonuc == JOptionPane.YES_OPTION) {
					System.exit(ABORT);
				} else {
					// TODO Nothing
				}

			}
		});
		mntmk.setIcon(new ImageIcon(
				AnaEkran.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		mnDosya.add(mntmk);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
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
				vb.getKisi().setIsBilgileri(isBilgileri);
				if (new KisiDAO().create(vb.getKisi())) {
					JOptionPane.showMessageDialog(null, "Kayýt iþlemi baþarýlý !");
				} else {
					JOptionPane.showMessageDialog(null, "Kayýt iþlemi baþarýsýz !");
				}

			}
		});
		btnKaydet.setBounds(212, 360, 89, 23);
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
				resetIsTable();

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

				getTxtFirmaAdi().setText("");
				getTxtPozisyon().setText("");
				getTxtGirisZamani().setText("");
				getTxtIstenAyrilmaTar().setText("");

				getRdbtnIseDevamHayir().setSelected(true);

			}
		});
		btnTemizle.setBounds(10, 360, 89, 23);
		contentPane.add(btnTemizle);

		btnVeriOku = new JButton("Veri Oku");
		btnVeriOku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Kisi kisi = new KisiDAO().read(0L);
				new VeriButunleyici(kisi).formReady(buSinifiVer());
				addRowInTable(kisi.getOkulBilgileri());
				addRowInIsTable(kisi.getIsBilgileri());

			}
		});
		btnVeriOku.setBounds(113, 360, 89, 23);
		contentPane.add(btnVeriOku);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(309, 11, 227, 383);
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
		panel_1.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0130\u015F Bilgileri",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(10, 206, 205, 134);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 16, 193, 117);
		panel_4.add(scrollPane_1);

		tblIsBilgileri = new JTable();
		scrollPane_1.setViewportView(tblIsBilgileri);
		tblIsBilgileri.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Fir.Ad", "Poz.", "Gir.Tar.", "Ayr.Tar." }) {
					Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});

		JLabel lblFirmaAd = new JLabel("Firma ad\u0131:");
		lblFirmaAd.setBounds(10, 11, 62, 14);
		panel_1.add(lblFirmaAd);

		JLabel lblPozisyon = new JLabel("Pozisyon:");
		lblPozisyon.setBounds(10, 36, 62, 14);
		panel_1.add(lblPozisyon);

		JLabel lblGiriZaman = new JLabel("Giri\u015F Zaman\u0131:");
		lblGiriZaman.setBounds(10, 61, 62, 14);
		panel_1.add(lblGiriZaman);

		JPanel panelIseDevamPaneli = new JPanel();
		panelIseDevamPaneli.setBorder(new TitledBorder(null, "\u0130\u015Fe devam ediyor mu?", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelIseDevamPaneli.setBounds(9, 79, 193, 91);
		panel_1.add(panelIseDevamPaneli);
		panelIseDevamPaneli.setLayout(null);

		JPanel panelIseDevam = new JPanel();
		panelIseDevam.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelIseDevam.setBounds(9, 37, 177, 43);
		panelIseDevamPaneli.add(panelIseDevam);
		panelIseDevam.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u0130\u015F.Ayr.Tar:");
		lblNewLabel.setBounds(10, 11, 86, 14);
		panelIseDevam.add(lblNewLabel);

		txtIstenAyrilmaTar = new JTextField();
		txtIstenAyrilmaTar.setBounds(70, 8, 97, 20);
		panelIseDevam.add(txtIstenAyrilmaTar);
		txtIstenAyrilmaTar.setColumns(10);

		rdbtnIseDevamHayir = new JRadioButton("Hay\u0131r");
		rdbtnIseDevamHayir.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				if (rdbtnIseDevamHayir.isSelected()) {
					panelIseDevamPaneli.setBounds(9, 79, 193, 91);
					panelIseDevam.setVisible(true);
				} else {
					panelIseDevamPaneli.setBounds(9, 79, 193, 39);
					panelIseDevam.setVisible(false);
				}

			}
		});

		rdbtnIseDevamEvet = new JRadioButton("Evet");
		rdbtnIseDevamEvet.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				if (rdbtnIseDevamEvet.isSelected()) {

					panelIseDevamPaneli.setBounds(9, 79, 193, 39);
					panelIseDevam.setVisible(false);

				} else {
					panelIseDevamPaneli.setBounds(9, 79, 193, 91);
					panelIseDevam.setVisible(true);
				}

			}
		});
		buttonGroup_1.add(rdbtnIseDevamEvet);
		rdbtnIseDevamEvet.setBounds(6, 15, 66, 23);
		panelIseDevamPaneli.add(rdbtnIseDevamEvet);
		rdbtnIseDevamHayir.setSelected(true);
		buttonGroup_1.add(rdbtnIseDevamHayir);
		rdbtnIseDevamHayir.setBounds(74, 15, 71, 23);
		panelIseDevamPaneli.add(rdbtnIseDevamHayir);

		txtFirmaAdi = new JTextField();
		txtFirmaAdi.setBounds(93, 8, 110, 20);
		panel_1.add(txtFirmaAdi);
		txtFirmaAdi.setColumns(10);

		txtPozisyon = new JTextField();
		txtPozisyon.setBounds(93, 33, 110, 20);
		panel_1.add(txtPozisyon);
		txtPozisyon.setColumns(10);

		txtGirisZamani = new JTextField();
		txtGirisZamani.setBounds(93, 58, 110, 20);
		panel_1.add(txtGirisZamani);
		txtGirisZamani.setColumns(10);

		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String firmaAdi = getTxtFirmaAdi().getText();
				String pozisyon = getTxtPozisyon().getText();
				String girisZamani = getTxtGirisZamani().getText();
				String cikisZamani = getTxtIstenAyrilmaTar().getText();

				isBilgileri.add(new Is(firmaAdi, pozisyon, girisZamani, cikisZamani));
				addRowInIsTable(isBilgileri);
			}
		});
		btnEkle.setIcon(null);
		btnEkle.setBounds(93, 172, 109, 23);
		panel_1.add(btnEkle);
		
		JButton btnVarlkYnetimi = new JButton("Varl\u0131k Y\u00F6netimi");
		btnVarlkYnetimi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Varliklar frame = new Varliklar();
							frame.setVisible(true);
							UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				
			}
		});
		btnVarlkYnetimi.setBounds(113, 326, 188, 23);
		contentPane.add(btnVarlkYnetimi);
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

	public void addRowInIsTable(List<Is> isBilgileri) {

		// Veri ekleme için model oluþtur
		DefaultTableModel dtm = new DefaultTableModel();

		// Tablo baþlýklarýný gir
		String[] basliklar = { "Fir.Ad", "Poz.", "Gir.Tar.", "Ayr.Tar." };
		dtm.setColumnIdentifiers(basliklar);

		if (isBilgileri != null)
			// Tablo verilerini set et
			isBilgileri.forEach(is -> {

				dtm.addRow(
						new Object[] { is.getFirmaAdi(), is.getPozisyon(), is.getGirisZamani(), is.getCikisZamani() });

			});

		// Verileri tabloya uygula
		tblIsBilgileri.setModel(dtm);

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

	public void resetIsTable() {

		// Veri ekleme için model oluþtur
		DefaultTableModel dtm = new DefaultTableModel();

		// Tablo baþlýklarýný gir
		String[] basliklar = { "Fir.Ad", "Poz.", "Gir.Tar.", "Ayr.Tar." };
		dtm.setColumnIdentifiers(basliklar);

		// Verileri tabloya uygula
		tblIsBilgileri.setModel(dtm);

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

	public JTextField getTxtIstenAyrilmaTar() {
		return txtIstenAyrilmaTar;
	}

	public void setTxtIstenAyrilmaTar(JTextField txtIstenAyrilmaTar) {
		this.txtIstenAyrilmaTar = txtIstenAyrilmaTar;
	}

	public JTextField getTxtFirmaAdi() {
		return txtFirmaAdi;
	}

	public void setTxtFirmaAdi(JTextField txtFirmaAdi) {
		this.txtFirmaAdi = txtFirmaAdi;
	}

	public JTextField getTxtPozisyon() {
		return txtPozisyon;
	}

	public void setTxtPozisyon(JTextField txtPozisyon) {
		this.txtPozisyon = txtPozisyon;
	}

	public JTextField getTxtGirisZamani() {
		return txtGirisZamani;
	}

	public void setTxtGirisZamani(JTextField txtGirisZamani) {
		this.txtGirisZamani = txtGirisZamani;
	}

	public JRadioButton getRdbtnIseDevamEvet() {
		return rdbtnIseDevamEvet;
	}

	public void setRdbtnIseDevamEvet(JRadioButton rdbtnIseDevamEvet) {
		this.rdbtnIseDevamEvet = rdbtnIseDevamEvet;
	}

	public JRadioButton getRdbtnIseDevamHayir() {
		return rdbtnIseDevamHayir;
	}

	public void setRdbtnIseDevamHayir(JRadioButton rdbtnIseDevamHayir) {
		this.rdbtnIseDevamHayir = rdbtnIseDevamHayir;
	}
}
