package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import listener.GameKeyListener;

public class MainPanel extends JPanel{
	/** プレイヤー*/
	private Player player;
	/** ボール*/
	private Ball[] ball;
	/** ゴール */
	private Goal goal;
	/** パネルの縦幅*/
	private double panelHeight;
	/** パネルの横幅*/
	private double panelWidth;
	/** Match point*/
	private static final int Match_Point= 3;

	private Image image;


	int NUM=6;
	int a=1,i;
	//Thread thread;


	//生成したインスタンスを保持するためのフィールド
	private MainFrame mf;
	private GameKeyListener gkl;
    private ImageIcon icon;

	//文字の大きさや種類を変えるためのクラスとその生成
	Font f = new Font("ＭＳ 明朝",Font.PLAIN, 50);


		// TODO 自動生成されたコンストラクター・スタブ
public MainPanel(MainFrame mf) {



	// TODO 自動生成されたコンストラクター・スタブ

	  setBackground(Color.GREEN);
	//Panelの背景を設定するメソッド
		this.mf = mf;
		gkl = new GameKeyListener();//GameKeyListenerの生成
		mf.addKeyListener(gkl);//MainPanelにキー入力を受け付けるようにするメソッド
		mf.requestFocusInWindow();


		panelWidth = mf.getFrameWidth();//MainPanelの横幅を初期化
		panelHeight = mf.getFrameHeight();//MainPanelの縦幅を初期化

		//各クラスの生成
		player = new Player(this, gkl);
		ball = new Ball[NUM];
		ball[0]=new Ball();
		ball[1]=new Ball();
		ball[2]=new Ball();
		ball[3]=new Ball();
		ball[4]=new Ball();
		ball[5]=new Ball();

		goal = new Goal(this);




	 	icon= new ImageIcon("ho.png");
		image=icon.getImage();



	}


	//Panel内で処理をする必要のある機能を書く。
	public void run(){
		for(i=0;i<a;i++) {
		//プレイヤーがマッチポイントを満たして、ゲーム終了しているかを判断する。
		if(player.getScorePlayerA() == Match_Point || player.getScorePlayerB() == Match_Point){

		}else{//Gameが修了していない場合、Gameの処理を行う。
			//Playerの移動処理を呼び出す
			player.movePlayer(this);
			//ballの移動処理を呼び出す。
			ball[i].moveBall(this);

			//BallとPlayerAが接触しているか判定
			if(IsHit.isHit(ball[i].getX(), ball[i].getY(), ball[i].getX()+ball[i].getSize(), ball[i].getY()+ball[i].getSize(),
					(int)player.getPlayer_a_position_x(),(int)player.getPlayer_a_position_y(),(int)(player.getPlayer_a_position_x()+player.getPlayerWidth()),(int)(player.getPlayer_a_position_y()+player.getPlayerHeight()))){
				if(ball[i].getSpeedX() <= 0){//Ballが左向きの時のみ向きを変える
					ball[i].setSpeedX(ball[i].getSpeedX() * -1);
				}
			}

			//BallとPlayerBが接触しているか判定
			if(IsHit.isHit(ball[i].getX(), ball[i].getY(), ball[i].getX()+ball[i].getSize(), ball[i].getY()+ball[i].getSize(),
					(int)player.getPlayer_b_position_x(),(int)player.getPlayer_b_position_y(),(int)(player.getPlayer_b_position_x()+player.getPlayerWidth()),(int)(player.getPlayer_b_position_y()+player.getPlayerHeight()))){
				if(ball[i].getSpeedX() >= 0){//Ballが右向きの時のみ向きを変える
					ball[i].setSpeedX(ball[i].getSpeedX() * -1);
				}
			}

			//BallがGoalAに入った時の処理
			if(IsHit.isHit(ball[i].getX(), ball[i].getY(), ball[i].getX()+ball[i].getSize(), ball[i].getY()+ball[i].getSize(),
					(int)goal.getGoal_a_position_x() ,(int)goal.getGoal_a_position_y(),(int)(goal.getGoal_a_position_x()+goal.getGoalWidth()),(int)(goal.getGoal_a_position_y()+goal.getGoalHeight()))){
				player.setScorePlayerB(player.getScorePlayerB() + 1);//PlayerBに加点
				ball[i].setSpeedX(ball[i].getSpeedX() * -1);
				ball[i].setBallPosition(300, 300);//Ballの位地を初期化

				ball[i].setSpeedX(ball[i].getSpeedX()+5);
				ball[i].setSpeedY(ball[i].getSpeedY()+5);
				a++;

			}

			//BallがGoalBに入った時の処理
			if(IsHit.isHit(ball[i].getX(), ball[i].getY(), ball[i].getX()+ball[i].getSize(), ball[i].getY()+ball[i].getSize(),
					(int)goal.getGoal_b_position_x() ,(int)goal.getGoal_b_position_y(),(int)(goal.getGoal_b_position_x()+goal.getGoalWidth()),(int)(goal.getGoal_b_position_y()+goal.getGoalHeight()))){
				player.setScorePlayerA(player.getScorePlayerA() + 1);//PlayerBに加点
				ball[i].setBallPosition(300, 300);

				ball[i].setSpeedX(ball[i].getSpeedX()+5);
				ball[i].setSpeedY(ball[i].getSpeedY()+5);
				a++;
			}


		}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO 自動生成されたメソッド・スタブ
		super.paintComponent(g);

		g.drawImage(image,0,0, 700,600,null);


		//描画の色を設定
		g.setColor(Color.WHITE);

		//文字の変更を適用
		g.setFont(f);

		//Scoreの描画
		for(i=0;i<a;i++) {
		g.drawString("ScoreA:"+player.getScorePlayerA(),10,35);
		g.drawString("ScoreA:"+player.getScorePlayerB(),350,35);
		}

		//各クラスでの描画を呼び出して摘要
		goal.goalGraphics(g);
		for(i=0;i<a;i++) {
		ball[i].ballGraphics(g);
		}
		player.playerGraphics(g);

	}


	/** Panelの縦幅を取得 */
	public double getPanelHeight() {
		return panelHeight;
	}

	/** Panelの横幅を取得 */
	public double getPanelWeight() {
		return panelWidth;
	}

}
