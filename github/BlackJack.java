import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BlackJack {
	public static void main(String args[]) throws IOException{
		//�ŏ���2���̃J�[�h��ramdom���\�b�h�Ő���
		int f = (int)(Math.random()*10)+1;
		int b = (int)(Math.random()*10)+1;
		//�J�[�h�̍��v
		int total = f + b ;
		//�ŏ��̎���o�͂���
		System.out.println("1���ڂ̃J�[�h : " + f);
		System.out.println("2���ڂ̃J�[�h : "  + b);
		System.out.println("���Ȃ��̎� : "+ total);
		//�ǉ��Ŏ󂯎��J�[�h���i�[���邽�߂�ArrayList��p�ӂ���
		ArrayList<Integer> array = new ArrayList<Integer>();

		//�ǉ��Ŏ󂯎��J�[�h�̐����񐔂Ȃ��Ƒz�肷��
		for(int i = 0 ; ; i++) {
			//�ǉ��Ŏ󂯎�����J�[�h��ramdom���\�b�h�Ő���
			int card  = (int)(Math.random()*10)+1;
			//add���\�b�h�Œǉ��Ŏ󂯎�����J�[�h��ArrayList�Ɋi�[����
			array.add(card);
			//�ǉ��Ŏ󂯎�����J�[�h��get���\�b�h��ArrayList������o���č��v�_���ɑ���
			total = total + array.get(i);
			System.out.println("�X�ɃJ�[�h���󂯎��܂����H");
			System.out.println("HIT or STAND ����͂���Enter ");
			//�J�[�h���󂯎�邩�̔��f�����郁�b�h���Ăяo���A������󂯎��
			String judge = getScore();

			//HIT��I�����A�J�[�h���󂯎�����ꍇ�̃R�����g���o��
			if (judge.equals("HIT")) {
				System.out.println("HIT!!" + "\n");
				System.out.println("����1���J�[�h���󂯎��܂�");
				System.out.println(i + 3 + "���ڂ̃J�[�h : " + card);
				//���v�_�����o�͂���
				System.out.println("���Ȃ��̍��v�_�� : " + total );
				//���v�_���ʂ̃R�����g�p���\�b�h���Ăяo��
				String result = BlackJack.getTotal(total);
				System.out.println(result);
					//���v�_����21�ȏ�Ȃ�I������
					if (total >= 21) {
						break;
					}
			//STAND��I�����A�J�[�h���󂯎��Ȃ������ꍇ�̍��v�_�����o��
			} else if(judge.equals("STAND")){
				System.out.println("STAND!!");
				System.out.println("���Ȃ��̍��v�_�� : " + (total - card));
				//���v�_���ʂ̃R�����g�p���\�b�h���Ăяo��
				String result = BlackJack.getTotal(total - card);
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