import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Help {
	JFrame jf = new JFrame("help");
	//JLabel jl1 = new JLabel("��¼ 0 û��\r\n��¼ 1 ����\r\n��¼ 2 ����\r\n���� 0 С˵\r\n���� 1 ��Ϸ\r\n���� 2 ���ӽ���"); 
	JLabel jl1 = new JLabel("��¼ 0 û��"); 
	JLabel jl2 = new JLabel("��¼ 1 ����"); 
	JLabel jl3 = new JLabel("��¼ 2 ����"); 
	JLabel jl4 = new JLabel("���� 0 ��"); 
	JLabel jl5 = new JLabel("���� 1 ��Ϸ"); 
	JLabel jl6 = new JLabel("���� 3 ���ӽ���"); 
	JLabel jl8 = new JLabel("���� 2 С˵"); 
	JLabel jl9 = new JLabel("���� 4 ˯����"); 
	JLabel jl7 = new JLabel("********************"); 
	Box b = Box.createVerticalBox();
	
	
	public void init() {
		b.add(jl1);
		b.add(jl2);
		b.add(jl3);
		b.add(jl7);
		b.add(jl4);
		b.add(jl5);		
		b.add(jl8);
		b.add(jl6);
		b.add(jl9);
		jf.add(b);
		jf.setLocation(0, 0);
		jf.pack();
		jf.setVisible(true);

	}

}
