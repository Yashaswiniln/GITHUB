package GenericUtility;

import java.util.Random;

public class Java_Utility {
/**
 * *THIS METHOD IS USED TO AVOID DUPLICATES**
 * @return
 */
	public int getRandomNum() {
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		// TODO Auto-generated method stub
		return ranNum;
	}

}
