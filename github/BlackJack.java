package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BlackJack {
	public static void main(String args[]) throws IOException{
		/**
		 *	最初の2枚のカードをramdomメソッドで生成
		 */
		int card_1 = (int)(Math.random()*10)+1;
		int card_2 = (int)(Math.random()*10)+1;
		/**
		 *	カードの合計
		 */
		int total = card_1 + card_2 ;
		/**
		 *	最初の手を出力する
		 */
		System.out.println("1枚目のカード : " + card_1);
		System.out.println("2枚目のカード : "  + card_2);
		System.out.println("あなたの手 : "+ total);
		/**
		 *	追加で受け取るカードを格納するためにArrayListを用意する
		 */
		ArrayList<Integer> array = new ArrayList<Integer>();

		/**
		 *	追加で受け取るカードの制限回数なしと想定する
		 */
		for(int i = 0 ; ; i++) {
			/**
			 *	追加で受け取ったカードをramdomメソッドで生成
			 */
			int card_add  = (int)(Math.random()*10)+1;
			/**
			 *	addメソッドで追加で受け取ったカードをArrayListに格納する
			 */
			array.add(card_add);
			/**
			 *	追加で受け取ったカードをgetメソッドでArrayListから取り出して合計点数に足す
			 */
			total = total + array.get(i);
			System.out.println("更にカードを受け取りますか？");
			System.out.println("HIT or STAND を入力してEnter ");
			/**
			 *	カードを受け取るかの判断をするメッドを呼び出し、判定を受け取る
			 */
			String judge = getScore();

			/**
			 *	HITを選択し、カードを受け取った場合のコメントを出力
			 */
			if (judge.equals("HIT")) {
				System.out.println("HIT!!" + "\n");
				System.out.println("もう1枚カードを受け取ります");
				System.out.println(i + 3 + "枚目のカード : " + card_add);
				/**
				 *	合計点数を出力する
				 */
				System.out.println("あなたの合計点数 : " + total );
				/**
				 *	合計点数別のコメント用メソッドを呼び出す
				 */
				String result = BlackJack.getTotal(total);
				System.out.println(result);
					/**
					 *	合計点数が21以上なら終了する
					 */
					if (total >= 21) {
						break;
					}
			/**
			 *	STANDを選択し、カードを受け取らなかった場合の合計点数を出力
			 */
			} else if(judge.equals("STAND")){
				System.out.println("STAND!!");
				System.out.println("あなたの合計点数 : " + (total - card_add));
				/**
				 *	合計点数別のコメント用メソッドを呼び出す
				 */
				String result = BlackJack.getTotal(total - card_add);
				System.out.println(result);
				break;
			} else {
				System.out.println("不正行為は禁止されています");
				break;
			}
		}
	}

	/**
	 *	カードを受け取るかを判断するメソッド
	 *	コンソール画面でHITかSTANDを入力し、入力した値を返す
	 */
	public static String getScore() throws IOException {
		String jg;
		/**
		 *	コンソール画面に入力された文字を取得する
		 */
		BufferedReader br =
			new BufferedReader(new InputStreamReader(System.in));
				jg = br.readLine();
	return jg;
	}

	/**
	 *	合計点数によって出力するコメントを判定する
	 */
	public static String getTotal(int subtotal) {
		String result;
		if (subtotal == 21) {
			result = "BlackJack!!";
		} else if (subtotal > 21) {
			result = "Pig!!";
		} else if ((subtotal >= 16)&&(subtotal <= 20)) {
			result = "STAND!!";
		} else {
			result = "HIT!!";
		}
		return result;
	}
}