package jp.co.njk.ishikawa.android.helloworld_for_android_2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;

// �v���O�����{�̂ƂȂ�N���X
public class HelloWorld extends Activity {

	// Activity�N���X��onCreate()���\�b�h�́A�A�v���N�����ɍŏ��ɌĂяo�����
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ����ID���u�^�C�g���Ȃ��v�ɐݒ�
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// �\������r���[�̎w��
		setContentView(new HelloView(this));
	}

}
