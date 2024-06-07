import java.awt.*;
import java.awt.event.*;

public class FacesAWT {

	public static void main(String[] args){
		new FacesAWT();
	}

    FacesAWT(){
		FaceFrame f = new FaceFrame();
		f.setSize(800,800);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
			System.exit(0);}});
		f.setVisible(true);
	}

	// インナークラスを定義
	class FaceFrame extends Frame{

		private int w;
		private int h;
		private int xStart;
		private int yStart;
		private FaceObj fobj1;
	
		FaceFrame(){
			fobj1= new FaceObj();
		}

		public void paint(Graphics g) {
	// この中には、g.drawLine というのは入ってこない
	// Graphicsクラス(型のようなもの---今は--)のgという変数はメソッドに渡す
		w = 200;
		h = 200;
		xStart=50;
		yStart=50;

		FaceObj fobj= new FaceObj();
		//fobj.drawRim();
		
		drawRim(g);
		drawBrow(g, 30); 
		drawEye(g, 35);
		drawEye(g, 35);
		drawNose(g, 40);
		drawMouth(g, 100);
		}
	
	public void drawRim(Graphics g) {  // wが横幅、hが縦幅
		g.drawLine(50, 50, 50+w, 50);
		g.drawLine(50, 50, 50, 50+h);
		g.drawLine(50, 50+h, 50+w, 50+h);
		g.drawLine(50+w, 50, 50+w, 50+h);	
	}

	public void drawBrow(Graphics g,int updown) { // xは目の幅 呼ばれる方(=定義する方)
		int wx1 = xStart + w*2/8;
		int wx2 = xStart + w*5/8;
		int wy = yStart + h/5;
		g.drawLine(wx1, wy+updown, wx1+w*1/8, wy);
		g.drawLine(wx2, wy, wx2+w*1/8, wy+updown);
	}

	public void drawNose(Graphics g, int nx) { // xは鼻の長さ
		int xMiddle = 50 + w/2;
		int yMiddle = 50 + h/2;
		g.drawLine(xMiddle, yMiddle, xMiddle-nx/2, yMiddle + nx);
		g.drawLine(xMiddle - nx/2, yMiddle + nx, xMiddle + nx/2, yMiddle + nx);
	}

	public void drawEye(Graphics g, int r) { // rは目の半径
		g.drawOval(xStart+45,yStart+65,r,r);
		g.drawOval(w-45,yStart+65,r,r);
	}

	public void drawMouth(Graphics g, int mx) { // xは口の幅
		int xMiddle = 50 + w/2;
		int yMiddle = 50 + h - 30;
		g.drawLine(xMiddle - mx/2, yMiddle, xMiddle + mx/2, yMiddle);
	}
	}//FaceFrame end

	//Faceクラスを作ってみよう。
	private class FaceObj{

	}

}