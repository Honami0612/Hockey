package main;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	private MainPanel mp;

	//Frameの大きさ
	private int frameWidth;
	private int frameHeight;

	public MainFrame() {
		// TODO 自動生成されたコンストラクター・スタブ

		//Frameの大きさを初期化
		frameWidth = 720;
		frameHeight = 640;

		mp = new MainPanel(this);
		add(mp);

		setDefaultCloseOperation(EXIT_ON_CLOSE);//×ボタンで消えるように設定するメソッド
		setBounds(10, 10, frameWidth, frameHeight);//Frameの表示位置と大きさを設定するメソッド
		setVisible(true);//見えるように可視化するメソッド
	}

	//実際にゲームの処理を繰り返すメソッド
	public void run() {
		while(true){
			try {
				Thread.sleep(1000/30);
				mp.run();//MeinPanelの処理を行う
				mp.repaint();//Panelを描画する
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	//Frameの横幅を取得するメソッド
	public int getFrameWidth() {
		return frameWidth;
	}

	//Frameの縦幅を取得するメソッド
	public int getFrameHeight() {
		return frameHeight;
	}
}

