package com.example.popupwindowwithmask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by kk on 2017/7/22.
 */

public class TestPopupWindow extends BasePopupWindowWithMask {
    private int[] mIds;
    private View contentView;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void OnItemClick(View v);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public TestPopupWindow(Context context, int[] mIds) {
        super(context);
        this.mIds = mIds;

        initListener();
    }

    @Override
    protected View initContentView() {
        contentView = LayoutInflater.from(context).inflate(R.layout.pop_layout, null, false);
        return contentView;
    }

    private void initListener() {
        for (int i = 0; i < mIds.length; i++) {
            contentView.findViewById(mIds[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != listener) {
                        listener.OnItemClick(v);
                    }
                    dismiss();
                }
            });
        }
    }

    @Override
    protected int initHeight() {
        return WindowManager.LayoutParams.WRAP_CONTENT;
    }

    @Override
    protected int initWidth() {
        return (int) (0.5 * UIUtils.getScreenWidth(context));
    }
}
