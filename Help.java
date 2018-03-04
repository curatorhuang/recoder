import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Help {
	JFrame jf = new JFrame("help");
	//JLabel jl1 = new JLabel("记录 0 没用\r\n记录 1 有用\r\n记录 2 杂事\r\n事项 0 小说\r\n事项 1 游戏\r\n事项 2 拖延焦虑"); 
	JLabel jl1 = new JLabel("记录 0 没用"); 
	JLabel jl2 = new JLabel("记录 1 有用"); 
	JLabel jl3 = new JLabel("记录 2 杂事"); 
	JLabel jl4 = new JLabel("事项 0 无"); 
	JLabel jl5 = new JLabel("事项 1 游戏"); 
	JLabel jl6 = new JLabel("事项 3 拖延焦虑"); 
	JLabel jl8 = new JLabel("事项 2 小说"); 
	JLabel jl9 = new JLabel("事项 4 睡懒觉"); 
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
