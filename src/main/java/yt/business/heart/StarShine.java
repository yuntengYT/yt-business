package yt.business.heart;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class StarShine extends JComponent {
	private List<Shape> stars=new LinkedList<Shape>();
	private static Random random=new Random();
	private static Color[][] colors={
			{Color.WHITE, Color.ORANGE},
			{Color.WHITE, Color.BLUE},
			{Color.ORANGE, Color.PINK},
			{Color.ORANGE, Color.green},
			{Color.PINK,Color.green},
			{Color.WHITE,Color.PINK}
	};
	private String menInfo="";
	public StarShine(){
		setBackground(Color.WHITE);

		//new Timer(delay,taskPerformer).start();
		//构造Timer时要指定一个延迟参数和一个ActionListener
		//这里每100ms重绘一次图。
		new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				//随机五角星
				int centerX =random.nextInt(getWidth() > 0 ? getWidth() : 5);
				//以显示图形框的宽度为上限产生随机整数，作为五角星中心点的横坐标。

				int centerY =random.nextInt(getHeight()> 0 ? getHeight() : 5);
				//以显示图形框的高度为上限产生随机整数，作为五角星中心点的纵坐标。

				double innerSize = 1 + (5 * Math.random());

				double outerSize = innerSize + 5 + (15 * Math.random());

				stars.add(getStar(centerX,centerY,innerSize,outerSize,5));
				//内存信息
				long tm=Runtime.getRuntime().totalMemory();
				long mm=Runtime.getRuntime().maxMemory();
				long fm=Runtime.getRuntime().freeMemory();
				long um=tm-fm;
				menInfo=String.format("%d / %d MB  %d", um/(1024*1024),mm/(1024*1024),stars.size());
				repaint();
			}
		}).start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		//天空背景
		GradientPaint background = new GradientPaint(0f, 0f, Color.GRAY.darker(),
				0f, (float)getHeight(), Color.GRAY.brighter());
		//GradientPaint类提供了使用线性颜色渐变模式填充 Shape 的方法，分周期渐变和非周期渐变两种。
		//我们定义的天空是从上到下由深灰到浅灰渐变，地面是从距底部五分一处到底部由黑到深灰渐变。
		// GradientPaint (float x1, float y1, Color  color1, float x2, float y2, Color  color2, boolean cyclic)

		g2d.setPaint(background);
		g2d.fillRect(0, 0, getWidth(), 4*getHeight()/5);
		//地面背景
		background = new GradientPaint(0f, (float)4*getHeight()/5,
				Color.BLACK,
				0f, (float)getHeight(), Color.GRAY.darker());
		g2d.setPaint(background);
		g2d.fillRect(0, 4*getHeight()/5, getWidth(), getHeight()/5);

		//导入图片
		Image img = Toolkit.getDefaultToolkit().getImage("D:\\java\\java工作区\\test\\src\\test2\\表白图片.png");
		g2d.drawImage(img, 0, 230, 500, 600, Color.LIGHT_GRAY, this);

		//开启抗锯齿
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		//画所有的星星
		for (Shape star : stars) {
			Rectangle rect = star.getBounds();
			Point2D center = new Point2D.Float(
					rect.x + (float)rect.width / 2.0f,
					rect.y + (float)rect.height / 2.0f);
			float radius = (float)rect.width / 2.0f;
			float[] dist = {0.1f, 0.9f};
			//圆形辐射颜色渐变模式
			RadialGradientPaint paint = new RadialGradientPaint(center, radius,
					dist, colors[random.nextInt(colors.length)]);
			//RadialGradientPaint 类提供使用圆形辐射颜色渐变模式填充某一形状的方式。
			//用户可以指定两种或多种渐变颜色，此绘制将在颜色与颜色之间提供一个插值。星星就是采用这种渐变方式进行渲染的。
			//这是一种非常有趣的渐变方式，通过不同的参数，可以实现绚丽多彩的图形。
			g2d.setPaint(paint);
			g2d.fill(star);
			g2d.clipRect(0,0,1000,520);//限定显示区域

			//写字
			g2d.setColor(Color.PINK);
			g2d.setFont(new Font("华文新魏", 2, 66));
			g2d.drawString("亲    爱   的   ~", 170, 120);
			g2d.setFont(new Font("华文新魏", 3, 100));
			g2d.drawString("你", 580, 250);
			g2d.drawString("去", 800, 350);
			g2d.drawString("死", 600, 420);
			g2d.drawString("吧", 800, 500);
		}
		g2d.drawString(menInfo,10, 10);
	}

	/**
	 * 获得一个随机边的多边形
	 * x 中心点X
	 *  y 中心点Y
	 * innerRadius 内圆半径
	 * outerRadius 外圆半径
	 * pointsCount 角数
	 *  一个多边形
	 */
	private static Shape getStar(double x, double y,
								 double innerRadius, double outerRadius,int pointsCount) {
		GeneralPath path = new GeneralPath();
		double outerAngleIncrement = 2 * Math.PI / pointsCount;
		double outerAngle = 0.0;
		double innerAngle = outerAngleIncrement / 2.0;
		x += outerRadius;
		y += outerRadius;
		float x1 = (float) (Math.cos(outerAngle) * outerRadius + x);
		float y1 = (float) (Math.sin(outerAngle) * outerRadius + y);
		float x2 = (float) (Math.cos(innerAngle) * innerRadius + x);
		float y2 = (float) (Math.sin(innerAngle) * innerRadius + y);
		path.moveTo(x1, y1);
		//moveTo (float x, float y)： 通过移动到指定的坐标（以 float 精度指定），将一个点添加到路径中。
		path.lineTo(x2, y2);
		//lineTo (float x, float y)： 通过绘制一条从当前坐标到指定新坐标（以 float 精度指定）的直线，
		//将一个点添加到路径中。
		outerAngle += outerAngleIncrement;
		innerAngle += outerAngleIncrement;
		for (int i = 1; i < pointsCount; i++) {
			x1 = (float) (Math.cos(outerAngle) * outerRadius + x);
			y1 = (float) (Math.sin(outerAngle) * outerRadius + y);
			path.lineTo(x1, y1);
			x2 = (float) (Math.cos(innerAngle) * innerRadius + x);
			y2 = (float) (Math.sin(innerAngle) * innerRadius + y);
			path.lineTo(x2, y2);
			outerAngle += outerAngleIncrement;
			innerAngle += outerAngleIncrement;
		}
		path.closePath();
		//closePath ()： 通过绘制一条向后延伸到最后一个 moveTo 的坐标的直线，封闭当前子路径。
		return path;
	}
	/** 创建界面 */
	private static void createAndShowGUI() {
		final JFrame f = new JFrame("亲爱的~");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 800);
		f.add(new StarShine());
		f.setVisible(true);
		f.setLocationRelativeTo(f.getOwner());
	}
	public static void main(String args[]) {
		createAndShowGUI();
	}
}