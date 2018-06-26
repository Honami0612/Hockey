package main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	/** ballのx座標 */
	private int x;
	/** ballのy座標 */
	private int y;

	/** ballの大きさ */
	private int size;

	/** ballのX軸の速度
	 * -で左に移動
	 * +で右に移動*/
	private int speedX;

	/** ballのY軸の速度
	 * -で上に移動
	 * +で下に移動*/
	private int speedY;

	/** Player's Score */
//	private int scorePlayerA;
//	private int scorePlayerB;




	public Ball() {
		// TODO 自動生成されたコンストラクター・スタブ

//		scorePlayerA=0;
//		scorePlayerB=0;
		x = 300;
		y = 300;
		speedX = 10;
		speedY = 10;
		size = 20;


	}

//	/** プレイヤーAの得点を取得する */
//	public int getScorePlayerA() {
//		return scorePlayerA;
//	}
//	/** プレイヤーBの得点を取得する */
//	public int getScorePlayerB() {
//		return scorePlayerB;
//	}

//	/** PlayerAの得点を設定する */
//	public void setScorePlayerA(int scorePlayerA) {
//		this.scorePlayerA = scorePlayerA;
//	}
//
//	/** PlayerBの得点を設定する */
//	public void setScorePlayerB(int scorePlayerB) {
//		this.scorePlayerB = scorePlayerB;
//	}


	/** ボールを移動させる */
	public void moveBall(MainPanel mp) {

		//ballが画面の枠から外に出た時、内側に移動するように制限する。
		if(x<0){
			if(speedX < 0){
				speedX *=-1;
			}
		}else if(x>(mp.getPanelWeight()-45)){
			if(speedX > 0){
				speedX *=-1;
			}
		}

		if(y<0){
			if(speedY < 0){
				speedY *= -1;
			}
		}else if(y>(mp.getPanelHeight()-68)){
			if(speedY > 0){
				speedY *= -1;
			}
		}

		//ballの左右の動きを決定
		x += speedX;
//		System.out.println("SpeedX="+speedX);

		//ballの上下の動きを決定
		y += speedY;

	}

	/* ballの左右移動と速度の変更
	 * -で左に、+で右に移動
	 */
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	/* ballの上下移動と速度の変更
	 * -で上に、+で下に移動
	 */
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public int getSpeedX() {
		return speedX;
	}
	public int getSpeedY() {
		return speedY;
	}

	/**
	 * @param x
	 * @param y
	 *  */
	public void setBallPosition(int x,int y){
		this.x = x;
		this.y = y;;

	}

	//BallのX座標を取得するメソッド
	public int getX() {
		return x;
	}
	//BallのY座標を取得するメソッド
	public int getY() {
		return y;
	}


	//Ballの大きさを取得するメソッド
	public int getSize() {
		return size;
	}




	/**Player Graphics
	 * @param g Graphics Class*/
	public void ballGraphics(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRoundRect(x, y, size,size, 20, 20);//Ballの描画をする
	}

}
