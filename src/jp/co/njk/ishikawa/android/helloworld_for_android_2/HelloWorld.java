package jp.co.njk.ishikawa.android.helloworld_for_android_2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;

// プログラム本体となるクラス
public class HelloWorld extends Activity {

	// ActivityクラスのonCreate()メソッドは、アプリ起動時に最初に呼び出される
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 特徴IDを「タイトルなし」に設定
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 表示するビューの指定
		setContentView(new HelloView(this));
	}

}
