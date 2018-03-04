import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class LoggerFrame {

	JFrame jf = new JFrame("��¼��");
	JButton jb = new JButton("ȷ��");
	TextField tf1 = new TextField(1);
	TextField tf2 = new TextField(1);
	TextField tf3 = new TextField(1);
	TextField tf4 = new TextField(1);
	TextField tf5 = new TextField(1);
	TextField tf6 = new TextField(1);
	TextField tf7 = new TextField(1);
	TextField tf8 = new TextField(1);
	TextField tf9 = new TextField(1);
	TextField tf10 = new TextField(1);
	TextField tf11 = new TextField(1);
	TextField tf12 = new TextField(1);

	JLabel jl1 = new JLabel("��");
	JLabel jl2 = new JLabel("��");
	JLabel jl3 = new JLabel("��");
	JLabel jl7 = new JLabel("ʧ��");
	JLabel jl8 = new JLabel("�ɹ�");
	JLabel jl9 = new JLabel("����");
	JLabel jl11 = new JLabel("���ֱ���");
	JLabel jl12 = new JLabel("���ֱ���");
	JLabel jl13 = new JLabel("��");
	JLabel jl14 = new JLabel("��");

	Box vertical1 = Box.createVerticalBox();
	Box vertical2 = Box.createVerticalBox();
	Box vertical3 = Box.createVerticalBox();
	Box vertical4 = Box.createVerticalBox();
	Box h1 = Box.createHorizontalBox();

	JMenuBar jmb = new JMenuBar();
	JMenu jm = new JMenu("help");
	JMenuItem jmi = new JMenuItem("ok");

	SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void init() {
		jf.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));

		vertical1.add(jl1);
		vertical1.add(tf1);
		vertical1.add(tf2);
		vertical1.add(jl7);
		vertical1.add(tf7);

		vertical2.add(jl2);
		vertical2.add(tf3);
		vertical2.add(tf4);
		vertical2.add(jl8);
		vertical2.add(tf8);

		vertical3.add(jl3);
		vertical3.add(tf5);
		vertical3.add(tf6);
		vertical3.add(jl9);
		vertical3.add(tf9);

		vertical4.add(jb);
		vertical4.add(jl11);
		vertical4.add(tf10);
		vertical4.add(jl12);
		vertical4.add(tf11);

		h1.add(jl13);
		h1.add(tf12);
		h1.add(jl14);

		jm.add(jmi);
		jmb.add(jm);
		jf.add(jmb);

		jf.add(h1);
		jf.add(vertical1);
		jf.add(vertical2);
		jf.add(vertical3);
		jf.add(vertical4);
		jf.pack();
		jf.setVisible(true);

		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		jmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help().init();
			}
		});

		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (RandomAccessFile raf = new RandomAccessFile("F:/recoder/recoder.txt", "rw");) {
					int date;
					date = (int) ((System.currentTimeMillis() - 1515945615112l) / 86400000) + 1;// ��¼������տ�ʼ��¼���������

					if (!tf1.getText().equals("")) {// �ж��������޼�¼
						raf.seek(raf.length());
						// raf.write((nowtime.format(new Date()) + "
						// ").getBytes());
						// raf.write((date+" "+System.currentTimeMillis()+ "
						// ").getBytes());
						raf.write((date + " " + nowtime.format(new Date()) + " ").getBytes());// ���������������д��浵
						raf.write((tf1.getText() + " ").getBytes());// ������ļ�¼д��浵
						// if (!tf2.getText().equals("")) {
						raf.write((tf2.getText() + "\r\n").getBytes());// �����������д��浵
						// } else {
						// raf.write((0+"\r\n").getBytes());
						// }

					}
					if (!tf3.getText().equals("")) {
						raf.seek(raf.length());
						raf.write((date + " " + nowtime.format(new Date()) + " ").getBytes());
						raf.write((tf3.getText() + " ").getBytes());
						// if (!tf4.getText().equals("")) {
						raf.write((tf4.getText() + "\r\n").getBytes());
						// } else {
						// raf.write((0+"\r\n").getBytes());
						// }
					}
					if (!tf5.getText().equals("")) {
						raf.seek(raf.length());
						raf.write((date + " " + nowtime.format(new Date()) + " ").getBytes());
						raf.write((tf5.getText() + " ").getBytes());
						// if (!tf6.getText().equals("")) {
						raf.write((tf6.getText() + "\r\n").getBytes());
						// } else {
						// raf.write((0+"\r\n").getBytes());
						// }
					}
					raf.seek(0);
					read(raf);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

	}

	public void read(RandomAccessFile r) throws IOException {

		RandomAccessFile raterecode = new RandomAccessFile("F:/recoder/rate.txt", "rw");
		int datesub, reco, cont;// �������ڣ���¼����������������
		int size;
		int dateB=0;//��¼�����Ǽ�λ��
		int fal = 0, tru = 0, sum = 0;// �������ã�û���Լ��ܴ���
		double rate = 0.0;// ����
		int time = Integer.parseInt(tf12.getText());// ��ȡ��һ���е�����
		List<Storage> st = new ArrayList<>();
		byte[] b = new byte[291600];
		r.read(b);
		for (int i = 0; i < r.length(); i = i + 27) {// �ֱ���������¼�����ݴ������
			if (b[i+1]!=' '){//��dateΪ��λ��ʱ
				i++;
				dateB++;
				
			}
			if (b[i+1] != ' ') {//��date����Ϊ��λ��ʱ    ���Ժ��������ӣ�����Ҳ����һ��������ȥ
 				i++;
 				dateB++;
			}	
			datesub = Integer.parseInt(new String(b, i-dateB, 1+dateB));
			dateB=0;
			reco = Integer.parseInt(new String(b, i + 22, 1));
			cont = Integer.parseInt(new String(b, i + 24, 1));
			st.add(new Storage(datesub, reco, cont));
		}
		size = st.size() - 1;
		for (int i = size; i > -1 && st.get(size).date - st.get(i).date < time; i--)// ��¼һ���ڵ�����û�ô���
		{
			if (st.get(i).reco == 0)
			{
				fal++;
				//System.out.println(fal);
			}
			if (st.get(i).reco == 1)
				tru++;
			sum++;
		}
		rate = (double) tru / sum;
		BigDecimal rate1 = new BigDecimal(rate);
		double f1 = rate1.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(); // ���ʱ�����λС��
		tf7.setText(fal + "");
		tf8.setText(tru + "");
		tf9.setText(sum + "");
		tf11.setText(f1 + "");// ���ֱ���

		raterecode.seek(raterecode.length());
		raterecode.write(
				(new DecimalFormat("#,##0.000").format(new Double(f1)) + " " + tf12.getText() + "\r\n").getBytes());// �洢����С����3λ�����㲹0

		raterecode.seek(0);
		byte[] b1 = new byte[54000];
		raterecode.read(b1);
		long i = raterecode.length() - 3;
		while (!(b1[(int) i + 15] == '1' && b1[(int) i + 6] == '7')) {
			--i;
		}
		tf10.setText(new String(b1, (int) i, 5));//���ֱ���

		raterecode.close();

	}

	public static void main(String[] args) {
		new LoggerFrame().init();

	}

}
