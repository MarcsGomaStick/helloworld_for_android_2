package jp.co.njk.ishikawa.android.helloworld_for_android_2;

import jp.co.njk.ishikawa.helloworld_for_Android_2.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.view.View;

// �r���[�ƂȂ�N���X
public class HelloView extends View{
	private Bitmap image;

	// constructor
	public HelloView(Context context){
		super(context);
		setBackgroundColor(Color.WHITE);
		
		// �摜�̓ǂݍ���
		Resources r = context.getResources();
		image = BitmapFactory.decodeResource(r, R.drawable.ic_launcher);
		
	}

	// �`��
	@Override
	protected void onDraw(Canvas canvas){
		// ������"Hello World!"�̐���
		String str = new String("Hello World!");

		// �`��I�u�W�F�N�g�̐���
		Paint infoPaint = new Paint();							// ���\���p
		Paint strPaint = new Paint();							// ������"Hello World!"�\���p
		Paint framePaint = new Paint();							// �g�`��p

		// �A���`�G�C���A�X�̎w��itrue�F�L�������炩�Ɂj
		infoPaint.setAntiAlias(true);
		strPaint.setAntiAlias(true);
		framePaint.setAntiAlias(true);

		// ���\���p�`��I�u�W�F�N�g�ɕ����T�C�Y�ƕ����F�̎w��
		infoPaint.setTextSize(24);
		infoPaint.setColor(Color.rgb(0, 0, 0));

		// ��ʃT�C�Y�̎擾
		canvas.drawText("��ʃT�C�Y�F" + getWidth() + " x " + getHeight(), 0, 30, infoPaint);

		// ������"Hello World!"�\���p�`��I�u�W�F�N�g�ɕ����T�C�Y�ƕ����F�̎w��
		strPaint.setTextSize(72);
		strPaint.setColor(Color.rgb(0, 0, 255));

		// ������"Hello World!"��FontMetrics�̎擾
		FontMetrics strFontMetrics = strPaint.getFontMetrics();
		float strAscent = strFontMetrics.ascent;				// �A�Z���g�̎擾�i���F���l�j
		float strDescent = strFontMetrics.descent;				// �f�B�Z���g�̎擾�i���F���l�j
		canvas.drawText("�A�Z���g�@�F" + strAscent, 0, 30*2, infoPaint);
		canvas.drawText("�f�B�Z���g�F" + strDescent, 0, 30*3, infoPaint);

		// ������"Hello World!"�̕��̎擾
		int strLength = (int)strPaint.measureText(str);
		canvas.drawText("�����񕝁@�F" + strLength, 0, 30*4, infoPaint);

		// ������"Hello World!"�̕\��
		canvas.drawText(str, getWidth()/2 - strLength/2, getHeight()/2, strPaint);

		// �g�p�`��I�u�W�F�N�g�ɐ��̑����A�X�^�C���A�F���w��
		framePaint.setStrokeWidth(5);
		framePaint.setStyle(Paint.Style.STROKE);
		framePaint.setColor(Color.argb(255, 255, 0, 0));

		// �g�p�̎l�p�`���(float�^)�̐���( RectF(left, top, right, bottom) )
		RectF frameRect = new RectF(getWidth()/2 - strLength/2 - 20, getHeight()/2 + strAscent - 20,
									getWidth()/2 + strLength/2 + 20, getHeight()/2 + strDescent + 20);
		// �g�̕`��
		canvas.drawRoundRect(frameRect, 20, 20, framePaint);
		
		// �摜�̕`��
		canvas.drawBitmap(image, 0, getHeight()/2 + strDescent + 40, null);

	}
}
