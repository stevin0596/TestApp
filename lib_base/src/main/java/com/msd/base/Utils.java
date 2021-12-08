package com.msd.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;


import java.util.Random;


/**
 * @author Android
 * @date 2020-11-16
 * @des
 */
public class Utils {



    @SuppressLint("StaticFieldLeak")
    private static Context context;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(@NonNull final Context context) {
        Utils.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) {
            return context;
        }
        throw new NullPointerException("should be initialized in application");
    }


    /**
     * 获取最终的activity action
     * @param activityAction
     * @return
     */
    public static String getUltimatelyActivityAction(String activityAction)
    {
        StringBuffer ultimatelyActivityAction = new StringBuffer()
                .append("BuildConfig.APPLICATION_ID")
                .append(".")
                .append(activityAction);
        return ultimatelyActivityAction.toString();
    }






    //隐藏虚拟键盘
    public static void HideKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    /**
     * 显示软键盘
     * @param view
     */
    public static void showKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            view.requestFocus();
            imm.showSoftInput(view, 0);
        }
    }

    /**
     * 显示软件盘并且获取焦点
     * @param activity
     * @param editText
     */
    public static void showKeyboardAndGetFocus(Activity activity, EditText editText)
    {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }
///获取string
    public static String getString(int id)
    {
//        String languageKey = Utils.getContext().getResources().getString(id);
//        String string=LanguageManagement.getInstance().getCorrespondenceLanguage(languageKey);
//        if(TextUtils.isEmpty(string)){
//            string=languageKey;
//        }
        return "string";
    }

    public static int getRandom()
    {
        int max=2000;
        int min=0;
        Random random = new Random();
        return random.nextInt(max)%(max-min+1) + min;
    }


    /**
     * 设置弹出popup，背景alpha值
     *
     * @param bgAlpha 0f - 1f
     */
    public static void setbackgroundAlpha(Activity activity,float bgAlpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        activity.getWindow().setAttributes(lp);
    }
}

