package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackJack {
	public static void main(String args[]) throws IOException{
		//�ŏ��̓񖇂̃J�[�h��ramdom���\�b�h�Ő���
		int f = (int)(Math.random()*10)+1;
		int b = (int)(Math.random()*10)+1;
		//�J�[�h�̍��v
		int total = f + b ;
		//�ǉ��ň����J�[�h��19�񕪗p�ӂ���
		int card[] = new int[19];
		//�ŏ��̎���o�͂���
		System.out.println("�ꖇ�ڂ̃J�[�h : " + f);
		System.out.println("�񖇖ڂ̃J�[�h : "  + b);
		System.out.println("���Ȃ��̎� : "+ total);

		for(int i =0 ; i < 20; i++) {
			//�ǉ��̃J�[�h��ramdom���\�b�h�Ő���
			card[i] = (int)(Math.random()*10)+1;
			//�ǉ��̃J�[�h�̓_���𑫂�
			total = total + card[i];
			System.out.println("�X�ɃJ�[�h���󂯎��܂����H");
			System.out.println("HIT or STAND ����͂���Enter ");
			//�J�[�h���󂯎�邩�̔��f�����郁�b�h���Ăяo���A������󂯎��
			String judge = getScore();

				//HIT��I�����A�J�[�h���󂯎�����ꍇ�̃R�����g���o��
				if (judge.equals("HIT")) {
					System.out.println("HIT!!" + "\n");
					System.out.println("�����ꖇ�J�[�h���󂯎��܂�");
					System.out.println(i + 2 + "���ڂ̃J�[�h : " + card[i]);
					//���v�_�����o�͂���
					System.out.println("���Ȃ��̍��v�_�� : " + total );
					//���v�_���ʂ̃R�����g�p���\�b�h���Ăяo��
					String result = BlackJack.getTotal(total);
					System.out.println(result);
						//���v�_����21�ȏ�Ȃ�I������
						if (total >= 21) {
							break;
						}
				//�󂯎��Ȃ������ꍇ�̍��v���o��
				} else if(judge.equals("STAND")){
					System.out.println("STAND!!");
					System.out.println("���Ȃ��̍��v�_�� : " + (total - card[i]));
					//���v�_���ʂ̃R�����g�p���\�b�h���Ăяo��
					String result = BlackJack.getTotal(total - card[i]);
					System.out.println(result);
					break;
				} else {
					System.out.println("�s���s�ׂ͋֎~����Ă��܂�");
					break;
				}
		}
	}

	/*�J�[�h���󂯎�邩�𔻒f���郁�\�b�h
	�R���\�[����ʂ�HIT��STAND����͂��A���͂����l��Ԃ�*/
	public static String getScore() throws IOException {
		String jg;
		//�R���\�[����ʂɓ��͂��ꂽ�������擾����
		BufferedReader br =
			new BufferedReader(new InputStreamReader(System.in));
				jg = br.readLine();
	return jg;
	}

	//���v�_���ɂ���ďo�͂���R�����g�𔻒肷��
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