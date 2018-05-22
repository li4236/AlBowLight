package com.al.bowlight.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by li4236 on 2016/5/3.
 */
public class AlRViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> viewHolder;

    public AlRViewHolder(View itemView) {
        super(itemView);

        viewHolder = new SparseArray<View>();
    }

    public <T extends View> T get(int id) {
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = itemView.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }

    public TextView getTextView(int id) {

        return get(id);
    }

    public Button getButton(int id) {

        return get(id);
    }

    public ImageView getImageView(int id) {
        return get(id);
    }

    public void setTextView(int id, CharSequence charSequence) {
        getTextView(id).setText(charSequence);
    }



    public void setImageResource(int id, int charSequence) {
        getImageView(id).setImageResource(charSequence);
    }

}