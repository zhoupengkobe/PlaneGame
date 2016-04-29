package cn.bjsxt.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import cn.bjsxt.util.Constant;
import cn.bjsxt.util.GameUtil;
import cn.bjsxt.util.MyFrame;
import sun.util.logging.resources.logging;

public class PlaneGameFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	Plane p = new Plane("images/plane.png",50,50);
	
	ArrayList bulletList = new ArrayList();//泛型暂时未学暂不加，以后学了强烈建议加上
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		//重复生成子弹
		for(int i=0;i<bulletList.size();i++){
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			
			//检测跟飞机的碰撞
			boolean peng = b.getRect().intersects(p.getRect());
			if (peng) {
				System.out.println("###########################peng");
			}
		}
	}
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	
	public void launchFrame(){
		super.launchFrame();
		//增加键盘监听
		addKeyListener(new KeyMoniter());
		
		//生成一堆子弹
		for(int i=0;i<50;i++){
			Bullet b = new Bullet();
			bulletList.add(b);
		}
	}
	
	

	//定义为内部类,可以方便的使用外部类的属性
	class KeyMoniter extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("释放："+e.getKeyCode());
			p.minusDirection(e);
		}
		
	}

}
