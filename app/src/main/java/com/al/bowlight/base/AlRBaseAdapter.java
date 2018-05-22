package com.al.bowlight.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.al.bowlight.impl.AlOnItemLongClickListener;
import com.al.bowlight.impl.onAlItemClickListener;

import java.util.List;

/**
 * Created by li4236 on 2016/5/3
 * <p>
 * Recyclerview适配器
 */
public abstract class AlRBaseAdapter<T> extends RecyclerView.Adapter<AlRViewHolder> {


    protected onAlItemClickListener mOnItemClickListener;

    protected AlOnItemLongClickListener mOnItemLongClickListener;

    protected List<T> mList;

    private Context mContext;

    public AlRBaseAdapter(Context context, List<T> list) {

        this.mContext = context;

        this.mList = list;

    }

    protected T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    @Override
    public AlRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(onCreateViewLayoutID(viewType), null);

        return new AlRViewHolder(view);
    }


    @Override
    public final void onBindViewHolder(AlRViewHolder vh, int position) {
        final T item = getItem(position);
        bindDataToItemView(vh, item, position);
        bindItemViewClickListener(vh, item);
    }

    /**
     * 点击事件
     */
    protected final void bindItemViewClickListener(RecyclerView.ViewHolder vh, final T item) {
        if (mOnItemClickListener != null) {
            vh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onClick(view, item);
                }
            });
        }
        if (mOnItemLongClickListener != null) {
            vh.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemLongClickListener.onLongClick(v, item);
                    return true;
                }
            });
        }
    }


    public void setOnItemLongClickListener(AlOnItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }

    //设置点击事件
    public void setOnItemClickListener(onAlItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    //抽象绑定数据
    protected abstract void bindDataToItemView(AlRViewHolder viewHolder, T item, int position);

    //抽象布局id
    public abstract int onCreateViewLayoutID(int viewType);

}