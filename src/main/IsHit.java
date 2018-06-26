package main;


/**
 * 二つの物体の4点を比較して当たり判定を返す
 */
public class IsHit {

	public static boolean isHit(int X1,int Y1,int X2,int Y2,int X3,int Y3,int X4,int Y4){
		if(X1 < X4 && X3 < X2 && Y1 < Y4 && Y3 < Y2)
		{
			return true;
		}
		return false;
	}

}



