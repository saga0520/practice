package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackJack {
	public static void main(String args[]) throws IOException{
		//最初の二枚のカードをramdomメソッドで生成
		int f = (int)(Math.random()*10)+1;
		int b = (int)(Math.random()*10)+1;
		//カードの合計
		int total = f + b ;
		//追加で引くカードを19回分用意する
		int card[] = new int[19];
		//最初の手を出力する
		System.out.println("一枚目のカード : " + f);
		System.out.println("二枚目のカード : "  + b);
		System.out.println("あなたの手 : "+ total);

		for(int i =0 ; i < 20; i++) {
			//追加のカードをramdomメソッドで生成
			card[i] = (int)(Math.random()*10)+1;
			//追加のカードの点数を足す
			total = total + card[i];
			System.out.println("更にカードを受け取りますか？");
			System.out.println("HIT or STAND を入力してEnter ");
			//カードを受け取るかの判断をするメッドを呼び出し、判定を受け取る
			String judge = getScore();

				//HITを選択し、カードを受け取った場合のコメントを出力
				if (judge.equals("HIT")) {
					System.out.println("HIT!!" + "\n");
					System.out.println("もう一枚カードを受け取ります");
					System.out.println(i + 2 + "枚目のカード : " + card[i]);
					//合計点数を出力する
					System.out.println("あなたの合計点数 : " + total );
					//合計点数別のコメント用メソッドを呼び出す
					String result = BlackJack.getTotal(total);
					System.out.println(result);
						//合計点数が21以上なら終了する
						if (total >= 21) {
							break;
						}
				//受け取らなかった場合の合計を出力
				} else if(judge.equals("STAND")){
					System.out.println("STAND!!");
					System.out.println("あなたの合計点数 : " + (total - card[i]));
					//合計点数別のコメント用メソッドを呼び出す
					String result = BlackJack.getTotal(total - card[i]);
					System.out.println(result);
					break;
				} else {
					System.out.println("不正行為は禁止されています");
					break;
				}
		}
	}

	/*カードを受け取るかを判断するメソッド
	コンソール画面でHITかSTANDを入力し、入力した値を返す*/
	public static String getScore() throws IOException {
		String jg;
		//コンソール画面に入力された文字を取得する
		BufferedReader br =
			new BufferedReader(new InputStreamReader(System.in));
				jg = br.readLine();
	return jg;
	}

	//合計点数によって出力するコメントを判定する
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