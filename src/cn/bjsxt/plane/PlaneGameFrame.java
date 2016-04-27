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
		//���Ӽ��̼���
		addKeyListener(new KeyMoniter());
	}
	
	//����Ϊ�ڲ���,���Է����ʹ���ⲿ�������
	class KeyMoniter extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("���£�"+e.getKeyCode());
			p.move(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("�ͷţ�"+e.getKeyCode());
		}
		
	}

}
