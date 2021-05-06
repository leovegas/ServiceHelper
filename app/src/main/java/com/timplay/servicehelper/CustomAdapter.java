package com.timplay.servicehelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String>
{
    Context context;
    String[] title;


    CustomAdapter(Context c, String[] title)
    {

        super(c, R.layout.listitem2,title);
        this.context = c;
        this.title=title;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = vi.inflate(R.layout.listitem2, parent, false);
        TextView titlee = (TextView) row.findViewById(R.id.textView1);
        int pos = position+1;
        titlee.setText(+pos + ". " + title[position]);
        pos++;
        return row;
    }

}
