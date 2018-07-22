package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calc_Number {
	/**基数変換*/
	public static final int FIVE_CONVERT = 5;

	public String CalcMethod(List<String> List) {
//		/**文字格納変数*/
//		List<String> calcNumberList  = new ArrayList<String>();
		/**５進数格納変数*/
		StringBuilder quinary = new StringBuilder();
		/**10進数格納変数*/
		int decimalNumber = 0;
		/**計算結果int変数*/
		int intResult = 0;
		/**計算結果StringStringBuilder変数*/
		StringBuilder strResult =new StringBuilder();
		/**５進数変換ハッシュマップ*/
		Map<String, String> quinaryMap = new HashMap<>();
		/**計算結果変換ハッシュマップ*/
		Map<String, String> resultMap = new HashMap<>();

		//マップにキーと値をセットする
		quinaryMap.put("A","0");
		quinaryMap.put("B","1");
		quinaryMap.put("C","2");
		quinaryMap.put("D","3");
		quinaryMap.put("E","4");

		resultMap.put("0", "A");
		resultMap.put("1", "B");
		resultMap.put("2", "C");
		resultMap.put("3", "D");
		resultMap.put("4", "E");

		//計算
		try {
			for (String s : List) {
				//１文字ずつ取り出して数字に変換
				for (int i=0; i < s.length() ; i++) {
					quinary.append(quinaryMap.get(String.valueOf(s.charAt(i))));
				}
				//５進数⇒１０進数
				decimalNumber = Integer.parseInt(quinary.toString(), FIVE_CONVERT);
				//数字を足す
				intResult += decimalNumber;
				//quinaryを初期化
				quinary.setLength(0);
			}
		//ABCDE以外の入力があった場合
		} catch (NumberFormatException e) {
			System.out.println("入力はABCDEのみ受け付けます。");
			System.exit(1);
		}

		//１０進数⇒５進数
		String strFive = Integer.toString(intResult, 5);
		//５進数⇒ABC表現
		for (int i=0; i < strFive.length() ; i++) {
			strResult.append(resultMap.get(String.valueOf(strFive.charAt(i))));
		}

		return String.valueOf(strResult);
	}
}
