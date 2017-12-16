package com.example.pb221.vendaq.main.uihelper;

/**
 * Created by Manifest on 12/16/2017.
 */

/**
 * File : MyCustomProgressDialog
 * Purpose: use custom progress bar
 * Date: 10-Apr-2017
 * Author: OP112
 * Project : Guidanz
 * <p/>
 * Revision History
 *
 */

        import android.annotation.SuppressLint;
        import android.app.ProgressDialog;
        import android.content.Context;
        import android.os.Bundle;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import com.example.pb221.vendaq.R;
        import com.example.pb221.vendaq.main.utils.Utils;


public class CustomProgressDialog extends ProgressDialog {

    String messageStr;
    static Context context;
    TextView txtvwProgressMsg;

    public static CustomProgressDialog getInstance() {
        CustomProgressDialog dialog = new CustomProgressDialog(context);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        return dialog;
    }

    public CustomProgressDialog(Context context) {
        super(context);
        this.context = context;
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_progress);
        Utils.setAllTextView(context.getApplicationContext(), (ViewGroup)this.findViewById( R.id.customDialogProgress ) );
        txtvwProgressMsg = (TextView)findViewById(R.id.txtvwProgressMsg);
        txtvwProgressMsg.setText(messageStr);
    }

    @Override
    public void show() {
        super.show();

    }

    @Override
    public void setMessage(CharSequence message) {
        super.setMessage(message);
        messageStr = message.toString();

        if(txtvwProgressMsg!=null)
            txtvwProgressMsg.setText(messageStr);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}