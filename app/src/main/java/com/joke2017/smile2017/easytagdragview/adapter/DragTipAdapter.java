package com.joke2017.smile2017.easytagdragview.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.joke2017.smile2017.R;
import com.joke2017.smile2017.easytagdragview.bean.Tip;
import com.joke2017.smile2017.easytagdragview.widget.DragDropGirdView;
import com.joke2017.smile2017.easytagdragview.widget.TipItemView;

public class DragTipAdapter extends AbsTipAdapter implements View.OnLongClickListener, TipItemView.OnDeleteClickListener{
    private boolean  isEditing =false;
    private static final ClipData EMPTY_CLIP_DATA = ClipData.newPlainText("", "");
    private TipItemView.OnSelectedListener mListener;
    private TipItemView.OnDeleteClickListener deleteClickListener;
    private OnFirstDragStartCallback callback;
    public DragTipAdapter(Context context, DragDropListener dragDropListener, TipItemView.OnDeleteClickListener deleteClickListener) {
        super(context, dragDropListener);
        this.deleteClickListener =deleteClickListener;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TipItemView view =null;
        if(convertView!=null&&convertView instanceof TipItemView){
            view =(TipItemView)convertView;
        }else{
            view = (TipItemView)View.inflate(mContext, R.layout.view_tag_item, null);
        }
        if(isEditing){
            view.showDeleteImg();
        }else{
            view.hideDeleteImg();
        }
        //设置点击监听
        view.setItemListener(position, mListener);
        view.setOnLongClickListener(this);
        //设置删除监听
        view.setDeleteClickListener(position, deleteClickListener);
        //绑定数据
        view.renderData(getItem(position));
        return view;
    }

    @Override
    protected Tip getDragEntity(View view) {
        return ((TipItemView)view).getDragEntity();
    }

    public void setItemSelectedListener(TipItemView.OnSelectedListener mListener){
        this.mListener =mListener;
    }
    @Override
    public boolean onLongClick(View v) {
        //开启编辑模式
        startEdittingStatus(v);
        return true;
    }
    //删除按钮点击时
    @Override
    public void onDeleteClick(Tip entity, int position, View view) {
        tips.remove(position);
        refreshData();

    }
    public void refreshData(){
        notifyDataSetChanged();
        mDragDropListener.onDataSetChangedForResult(tips);
    }
    public ArrayList<Tip> getData(){
        return tips;
    }
    public void setFirtDragStartCallback(OnFirstDragStartCallback callback) {
        this.callback = callback;
    }

    public interface OnFirstDragStartCallback {
        void firstDragStartCallback();
    }

    public boolean isEditing() {
        return isEditing;
    }

    public void cancelEditingStatus(){
        isEditing =false;
        notifyDataSetChanged();
    }
    private  void startEdittingStatus(View v){
        if(!isEditing){
            isEditing =true;
            if(callback!=null){
                callback.firstDragStartCallback();
            }
            notifyDataSetChanged();

        }
        v.startDrag(EMPTY_CLIP_DATA, new View.DragShadowBuilder(),
                DragDropGirdView.DRAG_FAVORITE_TILE, 0);
    }
}
