package main;

import java.awt.Color;
import java.awt.Graphics;

public class Goal{

	/** Goal A Position X*/
	private double goal_a_position_x;

	/** Goal B Position X*/
	private double goal_b_position_x;

	/** Goal A  Position Y*/
	private double goal_a_position_y;

	/** Goal B  Position Y*/
	private double goal_b_position_y;

	/** Goalの横幅 */
	private double goalWidth;

	/** Goalの縦幅 */
	private double goalHeight;

	public Goal(MainPanel mp) {
		// TODO 自動生成されたコンストラクター・スタブ

		//Goalのx座標をMainPanelの横幅から決定
		goal_a_position_x = mp.getPanelWeight() * 0.1/ 10;
		goal_b_position_x = mp.getPanelWeight() * 9.5 / 10;

		//Goalのy座標をMainPanelの縦幅から決定
		goal_a_position_y = mp.getPanelHeight() * 3.5 / 10;
		goal_b_position_y = mp.getPanelHeight() * 3.5 / 10;

		//goalの横幅の決定
		goalWidth = 10;

		//Goalの縦幅の決定
		goalHeight = 150;

	}

	//GoalAのX座標を取得する
	public double getGoal_a_position_x() {
		return goal_a_position_x;
	}

	//GoalAのY座標を取得する
	public double getGoal_a_position_y() {
		return goal_a_position_y;
	}

	//GoalBのX座標を取得する
	public double getGoal_b_position_x() {
		return goal_b_position_x;
	}

	//GoalBのY座標を取得する
	public double getGoal_b_position_y() {
		return goal_b_position_y;
	}

	//Goalの縦幅を取得するメソッド
	public double getGoalHeight() {
		return goalHeight;
	}

	//Goalの横幅を取得するメソッド
	public double getGoalWidth() {
		return goalWidth;
	}


	public void goalGraphics(Graphics g){
		g.setColor(Color.WHITE);
		//goalAの描画
		g.fillRect((int) goal_a_position_x, (int) goal_a_position_y, (int)goalWidth, (int)goalHeight);
		//goalBの描画
		g.fillRect((int) goal_b_position_x, (int) goal_b_position_y, (int)goalWidth, (int)goalHeight);
	}

}