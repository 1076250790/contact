package com.zjl.seven;

import static android.content.ContentValues.TAG;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public  class contacts extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private ListView lv;
    private MyAdapter adapter;
    private GetNum getPhoneNumberFromMobile;
    private List<PhoneInfo> list = new ArrayList<PhoneInfo>();
    private Context context;
    protected void onCreate(Bundle savedInstanceState) {
        context=this;
        permission();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.contents_view);
        getPhoneNumberFromMobile = new GetNum();
        list = getPhoneNumberFromMobile.getPhoneNumberFromMobile(this);
        adapter = new MyAdapter(list, this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)  {
        PhoneInfo thislist = list.get(position);
        Mydialog1 mydialog1 =new Mydialog1(this,thislist);
        mydialog1.show();
    }
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(this, "delete", Toast.LENGTH_LONG).show();
        Mydialog3 mydialog3=new Mydialog3(this, list.get(position).getName(),list.get(position).getNumber());
        mydialog3.show();
        return true;
    }
    @Override
    public void onBackPressed() {   //清除缓存
        list.clear();
        super.onBackPressed();
        return;
    }
    public void add(View view) {
        Mydialog2 mydialog2=new Mydialog2(this);
        mydialog2.show();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void permission(){
        //1.先请求判断是否具有对应权限
        if(ContextCompat.checkSelfPermission
                (this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
        //根据返回的结果，判断对应的权限是否有。
        {
            ActivityCompat.requestPermissions
                    (this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            0);
        }
        if(ContextCompat.checkSelfPermission
                (this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED)
        //根据返回的结果，判断对应的权限是否有。
        {
            ActivityCompat.requestPermissions
                    (this,
                            new String[]{Manifest.permission.READ_CONTACTS},
                            0);
        }
        if(ContextCompat.checkSelfPermission
                (this, Manifest.permission.WRITE_CONTACTS)
                != PackageManager.PERMISSION_GRANTED)
        //根据返回的结果，判断对应的权限是否有。
        {
            ActivityCompat.requestPermissions
                    (this,
                            new String[]{Manifest.permission.WRITE_CONTACTS},
                            0);
        }
        if(ContextCompat.checkSelfPermission
                (this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED)
        //根据返回的结果，判断对应的权限是否有。
        {
            ActivityCompat.requestPermissions
                    (this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            0);
        }
        if(ContextCompat.checkSelfPermission
                (this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED)
        //根据返回的结果，判断对应的权限是否有。
        {
            ActivityCompat.requestPermissions
                    (this,
                            new String[]{Manifest.permission.SEND_SMS},
                            0);
        }
    }
    public void restart(View v) {
        getPhoneNumberFromMobile = new GetNum();
        list = getPhoneNumberFromMobile.getPhoneNumberFromMobile(this);
        adapter = new MyAdapter(list, this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
    }
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    protected void onRestart(){
        super.onRestart();
    }

}