package listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener{

	//PlayerA'S Key
	private static final int UP_Key = KeyEvent.VK_W;
	private static final int Down_Key = KeyEvent.VK_S;

	//PlayerB'S Key
	private static final int UP2_Key = KeyEvent.VK_O;
	private static final int Down2_Key = KeyEvent.VK_L;

	//Keyの入力状態を保持する
	private boolean upkeypressed;
	private boolean downkeypressed;
	private boolean upkeypressed2;
	private boolean downkeypressed2;

	public GameKeyListener() {
		// TODO 自動生成されたコンストラクター・スタブ

		//初期値は押されていないFalse
		upkeypressed = false;
		downkeypressed = false;

		upkeypressed2 = false;
		downkeypressed2 = false;

	}

	@Override//キーを押したときの処理
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ


	}

	@Override//キーを押しているときの処理
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

		//キーが押されている間はキーを入力されているに変更する。
		if(e.getKeyCode() == UP_Key){
			upkeypressed = true;
		}else if(e.getKeyCode() == Down_Key){
			downkeypressed = true;
		}

		if(e.getKeyCode() == UP2_Key){
			upkeypressed2 = true;
		}else if(e.getKeyCode() == Down2_Key){
			downkeypressed2 = true;
		}

	}

	@Override//キーを離したときの処理
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//キー入力が離れた時に、キー入力されていないと変更する。
		if(e.getKeyCode() == UP_Key){
			upkeypressed = false;
		}else if(e.getKeyCode() == Down_Key){
			downkeypressed = false;
		}

		if(e.getKeyCode() == UP2_Key){
			upkeypressed2 = false;
		}else if(e.getKeyCode() == Down2_Key){
			downkeypressed2 = false;
		}

	}


	//PlayerAの下への入力がされているかを取得するメソッド
	public boolean isDownkeypressed() {
		return downkeypressed;
	}

	//PlayerAの上への入力がされているかを取得するメソッド
	public boolean isUpkeypressed() {
		return upkeypressed;
	}
	//PlayerBの下への入力がされているかを取得するメソッド
	public boolean isDownkeypressed2() {
		return downkeypressed2;
	}
	//PlayerBの上への入力がされているかを取得するメソッド
	public boolean isUpkeypressed2() {
		return upkeypressed2;
	}

}


