package com.example.chenhaoqiang.test.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenhaoqiang.test.R;

import java.util.List;

/**
 * 适配器：RecyclerView.Adapter的子类，负责提供表示数据集中项目的视图
 * 用于 数据 与 Item进行绑定
 *
 * @author chenhaoqiang
 * @date 2018/7/11
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    private List<String> database;
    private RecyclerViewItemClickCallBack recyclerViewItemClickCallBack;

    public MyAdapter(List<String> database) {
        this.database = database;
    }

    /*在RecyclerView需要一个新的被给定类型的ViewHolder来显示Item的时候调用*/
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_item, parent, false);
        MyHolder myHolder = new MyHolder(rootView);
        return myHolder;
    }

    /*Position: 位置代表y一个数据项在适配器adapter中的位置
     * Binding：绑定是从准备子视图到显示适配器中相应位置上数据的过程
     * 回收(视图)recycler(view)：之前在适配器中某个位置的用于显示数据的view可以存放在cache中以便稍后重用
     * 脏(视图)dirty(view)：一个子视图，在显示之前需要适配器adapter重新绑定
     * 碎片(视图)scrap(view)：一个子视图但是在布局过程中暂时进入了分离状态，碎片视图有可能被RecyclerView重用而不是完全的分离
     *                      如果没有绑定需求则不需要修改，若该碎片被视为脏视图则需要适配器进行修改
     * */
    /*在RecyclerView在特定位置显示数据的时候调用*/
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        holder.getShowText().setText(database.get(position));
        holder.getShowText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewItemClickCallBack.onItemclick(position);
            }
        });
        holder.getShowText().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                recyclerViewItemClickCallBack.onTiemLongClick(position);
                return true;
            }
        });
    }

    /*必须返回Item的数量否则会产生不显示任何Item的情况*/
    @Override
    public int getItemCount() {
        return database.size();
    }

    /*RecyclerView中有一些列的item位置变化方法。此处以删除为例*/
    public void deleteItem(int position) {
        database.remove(position);
        notifyItemRemoved(position);//单独加这一句话是删除Item，但是其他Item没有被重新绑定从而导致位置与Item应该更新的位置不符合
        notifyItemRangeChanged(0, getItemCount()); //若单独使用此方法则会产生最后一个Item删除时崩溃的问题
        //notifyDataSetChanged(); //这个方法使LayoutManager强制重新绑定和布局所有可见的view 会影响效率
    }

    /*添加Item*/
    public void addItem(int position) {
        database.add(position, "New Item");
        notifyItemInserted(position);
        notifyItemRangeChanged(0, getItemCount());
    }

    public void setRecyclerViewItemClickCallBack(RecyclerViewItemClickCallBack recyclerViewItemClickCallBack) {
        this.recyclerViewItemClickCallBack = recyclerViewItemClickCallBack;
    }
}
