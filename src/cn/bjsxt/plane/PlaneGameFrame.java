package cn.bjsxt.plane;

import java.awt.Graphics;
import java.awt.Image;

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

}
