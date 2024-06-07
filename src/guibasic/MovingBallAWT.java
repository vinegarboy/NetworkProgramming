package guibasic;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.*;

//配列で5つのボールを動かしてみよう

public class MovingBallAWT {

    public static int width = 500;
    public static int height = 500;
    public static int fps = 60;
	public static void main(String[] args) {
		FFrame f = new FFrame();
		f.setSize(width, height);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.show();
	}


	static class FFrame extends Frame implements Runnable {

		Thread th;
		Ball myBall1;
		Ball myBall2;

		private boolean enable = true;
		private int counter = 0;

		FFrame() {
			th = new Thread(this);
			th.start();
		}

		public void run() {


			myBall1 = new Ball();
			myBall1.setPosition(200, 150);
			myBall1.setR(10);
			myBall1.setColor(Color.RED);

			myBall2 = new Ball();
			myBall2.setPosition(50, 250);
			myBall2.setR(20);
			myBall2.setColor(Color.GREEN);

			while (enable) {

				try {
					th.sleep(1000/fps);
					counter++;
				} catch (InterruptedException e) {
				}


				myBall1.move();
				myBall2.move();

				repaint();  // paint()メソッドが呼び出される
			}
		}


		public void paint(Graphics g) {
			myBall1.draw(g);
			myBall2.draw(g);
		}

		// Ball というインナークラスを作る
		class Ball {
            int y_speed = 10;
            int x_speed = 10;
			int x;
			int y;
			int r; // 半径
			Color c = Color.RED;
            private static List<Ball> balls = new ArrayList<>();

			int xDir = 1;  // 1:+方向  -1: -方向
			int yDir = 1;

            Ball(){
                balls.add(this);
            }

			void setColor(Color c) {
				this.c = c;
			}

            
			void move() {
                for (Ball other : balls) { // ballsは全てのBallオブジェクトのリスト
                    if (other!= this) {
                        int dx = this.x - other.x;
                        int dy = this.y - other.y;
                        double distance = Math.sqrt(dx*dx + dy*dy);
                        if (distance < this.r + other.r) {
                            if (dx > 0) {
                                this.xDir = -1;
                                x_speed *= 1.5;
                                x_speed += other.x_speed;
                            } else {
                                this.xDir = 1;
                                x_speed *= 1.5;
                                x_speed += other.x_speed;
                            }
                            if (dy > 0) {
                                this.yDir = -1;
                                y_speed *= 1.5;
                                y_speed += other.y_speed;
                            } else {
                                this.yDir = 1;
                                y_speed *= 1.5;
                                y_speed += other.y_speed;
                            }
                            break;
                        }
                    }
                }


                if ((xDir == 1) && (x >= width-r*2)) {
                    xDir = -1;
                    x_speed *= 0.8;
                }
                if ((xDir == -1) && (x <= 0+r * 2)) {
                    xDir = 1;
                    x_speed *= 0.8;
                }
            
                if (xDir == 1) {
                    x = (int)(x + x_speed);
                } else {
                    x = (int)(x - x_speed);
                }
            
            
                if ((yDir == 1) && (y >= height-r*2)) {
                    yDir = -1;
                    y_speed *= 0.8;
                }
                if ((yDir == -1) && (y <= 0+r*2)) {
                    yDir = 1;
                    y_speed *= 0.8;
                }
            
                if (yDir == 1) {
                    y = (int)(y + y_speed);
                } else {
                    y = (int)(y - y_speed);
                }
            }


			void setPosition(int x, int y) {
				this.x = x;
				this.y = y;
			}

			void setR(int r) {
				this.r = r;
			}

			void draw(Graphics g) {
				g.setColor(c);
				g.fillOval(x, y, 2 * r, 2 * r);  // rは半径なので2倍にする
			}

		}//innner class Ball end

	}

}
