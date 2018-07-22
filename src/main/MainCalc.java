package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MainCalc {
//	/**入力＞計算文字列インデックス*/
//	public static final int INDEX_CALC_INPUT = 0;

	public static void main(String[] args) {
		/**入力＞入力文字列*/
		String strInput = "";

        // 標準入力を取得
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        	strInput = br.readLine();
            // 入力終了
            br.close();
        } catch (IOException e) {
            // 読み込み中にエラー
            System.out.println("読み込みエラーです。");
            System.exit(1);
        }

        // 入力文字列の格納
        List<String> inputCalcList = Arrays.asList(strInput.split(" "));

        //入力文字列が規約に沿っているか確認
        try {
	        for(String s : inputCalcList) {
	        	//２文字以上で先頭文字にAが設定されている場合
	        	String CheckInput = s.substring(0,1);
	        	if (s.length() > 1) {
	        		if (CheckInput.equals("A")) {
	        			System.out.println("2桁以上の数字入力する場合は先頭文字はA以外に設定してください。");
	        			System.exit(1);
	        		}
	        	}
	        	//入力が10文字を超える場合
	        	if(s.length() > 10) {
	    			System.out.println("入力は10文字以内にして下さい。");
	    			System.exit(1);
	        	}
	        }
        } catch (StringIndexOutOfBoundsException e) {
        	System.out.println("入力文字列は２つ入力して下さい。");
			System.exit(1);
        }

        //計算するメソッド呼び出し
        String strCalcResult = new Calc_Number().CalcMethod(inputCalcList);

        //出力する
        System.out.println(strCalcResult);

	}
}
