package cn.foxnickel.enterpriselearning.config;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.widget.TextView;

import com.mob.MobApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Night on 2017/7/4
 * Desc:全局设置
 */

public class Config extends MobApplication {
    public static final int WRITE_EXTERNAL_CODE = 0X01;
    public static SharedPreferences sSp;

    public static String KEY_REMEMBER_PAS = "KEY_REMEMBER_PAS";
    public static ExecutorService fixedThreadPool;

    @Override
    public void onCreate() {
        super.onCreate();
        sSp = PreferenceManager.getDefaultSharedPreferences(this);
        fixedThreadPool = Executors.newFixedThreadPool(5);
    }

    public static int getTextViewHeight(TextView pTextView) {
        Layout layout = pTextView.getLayout();
        int desired = layout.getLineTop(pTextView.getLineCount());
        int padding = pTextView.getCompoundPaddingTop() + pTextView.getCompoundPaddingBottom();
        return desired + padding;
    }
}
