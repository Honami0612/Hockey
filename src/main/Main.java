package main;

public class Main {

	public static void main(String[] args) {
		//meinメソッド内でのみの使用なのでフィールドではなく、mfの宣言をmainメソッド内にしている。
		MainFrame mf = new MainFrame();
		//MainFrameの中身を動かす
		mf.run();
	}
}
