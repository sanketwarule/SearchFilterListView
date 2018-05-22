package com.androsys.snkt.searchfilterlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    private List<String> arrayListState = null;
    private ArrayList<String> arraylist;
    private Context context;


    public ListViewAdapter(Context context , ArrayList<String> arrayListState){
        this.context = context;
        this.arrayListState = arrayListState;
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(arrayListState);
    }

    @Override
    public int getCount() {
        return arrayListState.size();
    }

    @Override
    public String getItem(int position) {
        return arrayListState.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(android.R.layout.simple_list_item_1,null);
        TextView textView = view.findViewById(android.R.id.text1);

        textView.setText(arrayListState.get(position));

        return view;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        this.arrayListState.clear();
        if (charText.length() == 0) {
            this.arrayListState.addAll(arraylist);
        }
        else
        {
            for (String wp : arraylist)
            {
                if (wp.toLowerCase(Locale.getDefault()).contains(charText))
                {
                    arrayListState.add(wp);

                }
            }
        }
        notifyDataSetChanged();
    }
}
