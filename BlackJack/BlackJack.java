package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
* ブラックジャックをプレイするクラス
* @author saga
* @version 1.0
*/
public class BlackJack {
	public static void main(String args[]) throws IOException{
		// 初めに配布カードを2枚用意
		int myCard_1 = (int)(Math.random()*10)+1;
		int myCard_2 = (int)(Math.random()*10)+1;
		int total = myCard_1 + myCard_2 ;
		// 配布した2枚のカードと合計を表示
		System.out.println("1枚目のカード : " + myCard_1);
		System.out.println("2枚目のカード : "  + myCard_2);
		System.out.println("あなたの手 : "+ total);
		ArrayList<Integer> array = new ArrayList<Integer>();

		for(int i = 0 ; ; i++) {
			//追加の配布カードを用意
			int addCard  = (int)(Math.random()*10)+1;
			//配布したカードを配列にセット
			array.add(addCard);
			//配布カードを足した合計をセット
			total = total + array.get(i);
			System.out.println("更にカードを受け取りますか？");
			System.out.println("HIT or STAND を入力してEnter ");
			//コンソール画面に入力した文字列
			String resultConsolVal = getConsolVal();
			// HITを入力し、配布カードを受け取った場合
			if (resultConsolVal.equals("HIT")) {
				System.out.println("HIT!!" + "\n");
				System.out.println("もう1枚カードを受け取ります");
				System.out.println(i + 3 + "枚目のカード : " + addCard);
				System.out.println("あなたの合計点数 : " + total );
				//合計点数の判定結果
				String resultComment = BlackJack.getTotal(total);
				System.out.println(resultComment);
					//合計点数が21以上なら終了する
					if (total >= 21) {
						break;
					}
			//STANDを入力し、配布カードを受け取らない場合
			} else if(resultConsolVal.equals("STAND")){
				System.out.println("STAND!!");
				System.out.println("あなたの合計点数 : " + (total - addCard));
				//合計点数の判定結果
				String resultComment = BlackJack.getTotal(total - addCard);
				System.out.println(resultComment);
				break;
			//HIT、STAND以外を入力した場合
			} else {
				System.out.println("不正行為は禁止されています");
				break;
			}
		}
	}

	/**
	 * コンソール画面に入力した文字列を返すメソッド
	 *
	 * @return コンソール画面に入力した文字列を返します
	 * @throws IOException 入力エラーがあった場合の例外
	 */
	public static String getConsolVal() throws IOException {
		String val;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		val = br.readLine();
		return val;
	}

	/**
	 * 合計点数を判定し、結果を表示するメソッド
	 *
	 * @param subtotal 合計点数
	 * @return 判定結果を返します
	 */
	public static String getTotal(int subtotal) {
		String comment;
		if (subtotal == 21) {
			comment = "BlackJack!!";
		} else if (subtotal > 21) {
			comment = "Pig!!";
		} else if ((subtotal >= 16)&&(subtotal <= 20)) {
			comment = "STAND!!";
		} else {
			comment = "HIT!!";
		}
		return comment;
	}
}