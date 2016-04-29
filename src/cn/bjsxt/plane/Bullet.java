package cn.bjsxt.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cn.bjsxt.util.Constant;

public class Bullet {
	double x,y;
	int speed=3;
	double degree;
	int width = 10;
	int height = 10;
	
	
	
	public  Rectangle getRect(){
		
		return new Rectangle((int)x, (int)y, width, height);
	}
	
	
	public  Bullet(){
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HEIGHT/2;
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if (y>Constant.GAME_HEIGHT-height||y<30) {
			degree = -degree;
		}
		
		if (x<0||x>Constant.GAME_WIDTH-width) {
			degree = Math.PI-degree;
		}
		
		
		
		g.setColor(c);
	}

}
