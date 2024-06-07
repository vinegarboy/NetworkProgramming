package guichat;

import java.awt.Color;
import java.awt.Graphics;

class GUIAnimatinFaceLook {// 顔のオブジェクト

	int h = 100;
	int w = 100;

	int xStart = 0;
	int yStart = 0;

    float eyebrowAngle = 0;

	public void setXY(int x, int y) {
		this.xStart = x;
		this.yStart = y;
	}

	public void setSize(int h, int w) {
		this.h = h;
		this.w = h;
	}

	public GUIAnimatinFaceLook() {

	}

	void makeFace(Graphics g) {
		// makeRim(g);
		makeEyes(g, w / 5);
		makeNose(g, h / 5);
		makeMouth(g, w / 2);
	}

	public void setEyebrowAngle(float angle) {
        eyebrowAngle = angle;
    }
    
    void makeFace(Graphics g, String emotion) {
        switch (emotion) {
            case "smile":
                eyebrowAngle = 10; //微笑む時の眉毛の角度
                break;
            case "angly":
                eyebrowAngle = -10; //怒るときの眉毛の角度
                break;
            default:
                eyebrowAngle = 0; //普通の時の眉毛の角度
                break;
        }
        // ここに他の面の描画コードを追加
    }

	/*
	 * public void makeRim(Graphics g) { g.drawLine(xStart, yStart, xStart + h,
	 * yStart); g.drawLine(xStart, yStart, xStart, yStart + w);
	 * g.drawLine(xStart, yStart + w, xStart + h, yStart + w); g.drawLine(xStart
	 * + h, yStart, xStart + h, yStart + w); }
	 */

	void makeEyes(Graphics g, int eyeSize) {
		// setColor(Color.red);
		// g.fillRect(xStart + (h * 1 / 3) - 20, yStart + (w * 1 / 3) - 10,
		// 10, 10);

		g.setColor(Color.blue);

		// g.fillRoundRect()
		// g.fillOval()
		g.fillArc(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize,
				0, 300);
		g.setColor(Color.black);

		// g.drawLine(xStart + (h * 1 / 3) - 20, yStart + (w * 1 / 3) - 10,
		// xStart + (h * 1 / 3) + 20, yStart + (w * 1 / 3) - 10);
		// g.drawLine(xStart + (h * 2 / 3) - 20, yStart + (w * 1 / 3) - 10,
		// xStart + (h * 2 / 3) + 20, yStart + (w * 1 / 3) - 10);

		g.drawOval(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
		g.drawOval(xStart + (h * 4 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
	}// makeEyes()

    void drawEyebrows(Graphics g) {
        // 眉毛の描画
        g.setColor(Color.BLACK);
        
        // 角度をラジアンに変換し、cosとsinを使用してxとyの変化量を計算
        double radians = Math.toRadians(eyebrowAngle);
        int dx = (int) (Math.cos(radians) * 10); // 10は眉毛の長さを表す。必要に応じて調整してください。
        int dy = (int) (Math.sin(radians) * 10); // ここではdyを0に設定して水平線を描画しますが、必要に応じて調整してください。
        
        // xStartとyStartを眉毛の開始点とし、dxとdyを加算して終点を計算
        g.drawLine(xStart, yStart, xStart + dx, yStart + dy);
    }

	public void makeNose(Graphics g, int noseSize) {
		g.drawLine(xStart + (h * 1 / 2), yStart + (w * 2 / 4), xStart
				+ (h * 1 / 2), yStart + (w * 2 / 4) + noseSize);
	}// makeNose() end

	public void makeMouth(Graphics g, int mouseSize) {
		int xMiddle = xStart + h / 2;
		int yMiddle = yStart + 3 * w / 4;
		g.drawLine(xMiddle - mouseSize / 2, yMiddle, xMiddle + mouseSize / 2,
				yMiddle);
	}
}// FaceObj End