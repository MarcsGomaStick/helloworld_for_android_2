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

// ビューとなるクラス
public class HelloView extends View{
	private Bitmap image;

	// constructor
	public HelloView(Context context){
		super(context);
		setBackgroundColor(Color.WHITE);
		
		// 画像の読み込み
		Resources r = context.getResources();
		image = BitmapFactory.decodeResource(r, R.drawable.ic_launcher);
		
	}

	// 描画
	@Override
	protected void onDraw(Canvas canvas){
		// 文字列"Hello World!"の生成
		String str = new String("Hello World!");

		// 描画オブジェクトの生成
		Paint infoPaint = new Paint();							// 情報表示用
		Paint strPaint = new Paint();							// 文字列"Hello World!"表示用
		Paint framePaint = new Paint();							// 枠描画用

		// アンチエイリアスの指定（true：有効＝滑らかに）
		infoPaint.setAntiAlias(true);
		strPaint.setAntiAlias(true);
		framePaint.setAntiAlias(true);

		// 情報表示用描画オブジェクトに文字サイズと文字色の指定
		infoPaint.setTextSize(24);
		infoPaint.setColor(Color.rgb(0, 0, 0));

		// 画面サイズの取得
		canvas.drawText("画面サイズ：" + getWidth() + " x " + getHeight(), 0, 30, infoPaint);

		// 文字列"Hello World!"表示用描画オブジェクトに文字サイズと文字色の指定
		strPaint.setTextSize(72);
		strPaint.setColor(Color.rgb(0, 0, 255));

		// 文字列"Hello World!"のFontMetricsの取得
		FontMetrics strFontMetrics = strPaint.getFontMetrics();
		float strAscent = strFontMetrics.ascent;				// アセントの取得（注：負値）
		float strDescent = strFontMetrics.descent;				// ディセントの取得（注：正値）
		canvas.drawText("アセント　：" + strAscent, 0, 30*2, infoPaint);
		canvas.drawText("ディセント：" + strDescent, 0, 30*3, infoPaint);

		// 文字列"Hello World!"の幅の取得
		int strLength = (int)strPaint.measureText(str);
		canvas.drawText("文字列幅　：" + strLength, 0, 30*4, infoPaint);

		// 文字列"Hello World!"の表示
		canvas.drawText(str, getWidth()/2 - strLength/2, getHeight()/2, strPaint);

		// 枠用描画オブジェクトに線の太さ、スタイル、色を指定
		framePaint.setStrokeWidth(5);
		framePaint.setStyle(Paint.Style.STROKE);
		framePaint.setColor(Color.argb(255, 255, 0, 0));

		// 枠用の四角形情報(float型)の生成( RectF(left, top, right, bottom) )
		RectF frameRect = new RectF(getWidth()/2 - strLength/2 - 20, getHeight()/2 + strAscent - 20,
									getWidth()/2 + strLength/2 + 20, getHeight()/2 + strDescent + 20);
		// 枠の描画
		canvas.drawRoundRect(frameRect, 20, 20, framePaint);
		
		// 画像の描画
		canvas.drawBitmap(image, 0, getHeight()/2 + strDescent + 40, null);

	}
}
