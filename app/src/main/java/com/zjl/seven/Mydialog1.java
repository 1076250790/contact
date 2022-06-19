package com.zjl.seven;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.List;

public class Mydialog1 extends Dialog{
    private PhoneInfo thislist;
    private Intent intent;
    private Context context;
    public Mydialog1(@NonNull Context context, PhoneInfo thislist) {
        super(context);
        this.thislist=thislist;
        this.context=context;
    }

    protected void onCreate(Bundle onSaveInstanceState){
        super.onCreate(onSaveInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog1);
        TextView name=(TextView) findViewById(R.id.name);
        name.setText(thislist.getName());
        Button call=(Button) findViewById(R.id.call);
        call.setOnClickListener(this::call);
        Button imfo=(Button) findViewById(R.id.imfo);
        imfo.setOnClickListener(this::imfo);
    }
    public void call(View v){
        //call
        intent = new Intent();
        intent.setAction("android.intent.action.CALL");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("tel:"+thislist.getNumber()));
        context.startActivity(intent);
    }
    public void imfo(View v){
        //imfo
        intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+thislist.getNumber()));
        context.startActivity(intent);
    }

}