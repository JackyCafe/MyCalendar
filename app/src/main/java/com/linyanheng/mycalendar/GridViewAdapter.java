package com.linyanheng.mycalendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    List<String> data;
    Context context;
    LayoutInflater inflater;
    public GridViewAdapter(Context context,List<String> data)
    {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TextView tv;
        if (convertView == null){
            //inflater  = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.items,null);
        }
        tv = v.findViewById(R.id.tv);
        tv.setText(data.get(position).toString());
        return v;
    }
}
