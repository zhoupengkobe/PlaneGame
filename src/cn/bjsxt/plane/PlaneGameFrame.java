package cn.bjsxt.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import cn.bjsxt.util.GameUtil;
import cn.bjsxt.util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	Plane p = new Plane("images/plane.png",50,50);
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
	}
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	
	public void launchFrame(){
		super.launchFrame();
		//增加键盘监听
		addKeyListener(new KeyMoniter());
	}
	
	//定义为内部类,可以方便的使用外部类的属性
	class KeyMoniter extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("按下："+e.getKeyCode());
			p.move(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("释放："+e.getKeyCode());
		}
		
	}

}
