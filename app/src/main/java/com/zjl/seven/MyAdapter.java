package com.zjl.seven;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import javax.xml.namespace.QName;

public class MyAdapter extends BaseAdapter {
    private List<PhoneInfo> list;
    private Context context;

    public MyAdapter(List<PhoneInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        /*if(convertView==null){
            ViewHolder viewHolder=new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.item, parent,false);
            viewHolder.name=(TextView) convertView.findViewById(R.id.name);
            viewHolder.number=(TextView) convertView.findViewById(R.id.number);
            viewHolder.name.setText(list.get(position).getName());
            viewHolder.number.setText(list.get(position).getNumber());
            convertView.setTag(viewHolder);
            Log.e(TAG, "getView: "+ list.get(position).getName()+list.get(position).getNumber());
        }
        return convertView;*/
        View view=View.inflate(context, R.layout.item, null);
        TextView name=(TextView) view.findViewById(R.id.name);
        TextView number=(TextView) view.findViewById(R.id.number);
        TextView image=( TextView) view.findViewById(R.id.image);

        double r = Math.random();
        int num = (int) (r*7 + 1);
        int[] color = new int[]{Color.BLUE,Color.GREEN,Color.YELLOW,Color.LTGRAY,Color.RED,Color.GREEN,Color.YELLOW};
        image.setBackgroundColor(color[num-1]);
        char[] words = list.get(position).getName().toCharArray();
        String text= String.valueOf(words[0]);
        image.setText(String.valueOf(words[0]));
        name.setText(list.get(position).getName());
        number.setText(list.get(position).getNumber());
        return view;

    }
}