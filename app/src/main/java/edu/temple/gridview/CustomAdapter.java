package edu.temple.gridview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Rich on 11/14/2015.
 */
public class CustomAdapter extends BaseAdapter {

    String[] result;
    Context context;
    int x;
    int z = 0;
    int y = 0;

    private static LayoutInflater inflater = null;
    public CustomAdapter(Context context, String number) {
        this.context = context;
        Resources res = context.getResources();
        switch (number)
        {
            case "Two":
                result = res.getStringArray(R.array.numbers_Two) ;
                x = 2;
                break;

            case "Four":
                result = res.getStringArray(R.array.numbers_Four) ;
                x = 4;
                break;

            case "Six":
                result = res.getStringArray(R.array.numbers_Six) ;
                x = 6;
                break;

            case "Eight":
                result = res.getStringArray(R.array.numbers_Eight) ;
                x = 8;
                break;

            case "Ten":
                result = res.getStringArray(R.array.numbers_Ten) ;
                x = 10;
                break;
        }
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.grid_cell, null);
        holder.tv = (TextView) rowView.findViewById(R.id.gridCellNumber);
        holder.tv.setText(result[position]);
            if ((z + y)% 2 == 0)
            {
                rowView.setBackgroundColor(Color.BLACK);
                holder.tv.setTextColor(Color.WHITE);
                String f = z + "";
                String g = y + "";
                //holder.tv.setText(f + "," + g);
            }else {
                String f = z + "";
                String g = y + "";
                //holder.tv.setText(f + "," + g);
                rowView.setBackgroundColor(Color.WHITE);
            }
        if(y == 0 || y==1){
            if ((z + y)% 2 == 0)
            {
                rowView.setBackgroundColor(Color.WHITE);
                holder.tv.setTextColor(Color.BLACK);
                String f = z + "";
                String g = y + "";
                //holder.tv.setText(f + "," + g);
            }
            if ((z + y)% 2 != 0)
            {
                rowView.setBackgroundColor(Color.BLACK);
                holder.tv.setTextColor(Color.WHITE);
                String f = z + "";
                String g = y + "";
                //holder.tv.setText(f + "," + g);
            }
        }

            y++;

            if(y==x)
            {
                y = 0;
                z++;

            }

        return rowView;
    }

}
