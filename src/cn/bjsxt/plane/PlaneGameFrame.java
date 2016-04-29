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
	
	ArrayList bulletList = new ArrayList();//������ʱδѧ�ݲ��ӣ��Ժ�ѧ��ǿ�ҽ������
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		//�ظ������ӵ�
		for(int i=0;i<bulletList.size();i++){
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			
			//�����ɻ�����ײ
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
		//���Ӽ��̼���
		addKeyListener(new KeyMoniter());
		
		//����һ���ӵ�
		for(int i=0;i<50;i++){
			Bullet b = new Bullet();
			bulletList.add(b);
		}
	}
	
	

	//����Ϊ�ڲ���,���Է����ʹ���ⲿ�������
	class KeyMoniter extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("�ͷţ�"+e.getKeyCode());
			p.minusDirection(e);
		}
		
	}

}
