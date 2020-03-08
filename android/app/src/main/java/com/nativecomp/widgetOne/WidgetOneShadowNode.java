package com.nativecomp.widgetOne;

import android.view.View;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;

public class WidgetOneShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
    private boolean mMeasured = false;
    private int mWidth;
    private int mHeight;

    public WidgetOneShadowNode() {
        setMeasureFunction(this);
    }

    @Override
    public long measure(YogaNode node, float width, YogaMeasureMode widthMode, float height, YogaMeasureMode heightMode) {
        if (!mMeasured) {
            mMeasured = true;

            WidgetOne dummyWidget = new WidgetOne(getThemedContext(), null);
            dummyWidget.measure(0, 0);
            mWidth = dummyWidget.getMeasuredWidth();
            mHeight = dummyWidget.getMeasuredHeight();
        }

        return YogaMeasureOutput.make(mWidth, mHeight);
    }

    public void relayout() {
        // make sure measure function called first before relayout
        if (!mMeasured) return;

        getThemedContext().runOnUiQueueThread(() -> {
            View widget = getThemedContext()
                            .getNativeModule(UIManagerModule.class)
                            .resolveView(getReactTag());

            int widthSpec = View.MeasureSpec.makeMeasureSpec(getScreenWidth(), View.MeasureSpec.EXACTLY);
            int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            widget.measure(widthSpec, heightSpec);

            mWidth = widget.getMeasuredWidth();
            mHeight = widget.getMeasuredHeight();

            getThemedContext().runOnNativeModulesQueueThread(() -> getThemedContext()
                .getNativeModule(UIManagerModule.class)
                .invalidateNodeLayout(getReactTag()));
        });
    }

    @Override
    public boolean isYogaLeafNode() {
        return true;
    }
}
