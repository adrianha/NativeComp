package com.nativecomp.widgetOne;

import android.os.Handler;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;

public class WidgetOneShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
    private boolean mMeasured = false;
    private int mWidth;
    private int mHeight;
    private WidgetOne widget;

    public WidgetOneShadowNode() {
        setMeasureFunction(this);
    }

    @Override
    public long measure(YogaNode node, float width, YogaMeasureMode widthMode, float height, YogaMeasureMode heightMode) {
        if (!mMeasured) {
            mMeasured = true;

            if (widget != null) {
                mWidth = widget.getMeasuredWidth();
                mHeight = widget.getMeasuredHeight();
            } else {
                WidgetOne v = new WidgetOne(getThemedContext(), null);
                v.measure(0, 0);
                mWidth = v.getMeasuredWidth();
                mHeight = v.getMeasuredHeight();
            }
        }

        return YogaMeasureOutput.make(mWidth, mHeight);
    }

    public void relayout(WidgetOne widget) {
        // Layout updates should be invoked on NativeModulesQueueThread
        getThemedContext().runOnNativeModulesQueueThread(() -> {
            this.widget = widget;
            mMeasured = false;

            // Tell Yoga to remeasure node on next layout phase
            dirty();

            // Trigger re-render; View hierarchy will be updated
            getThemedContext()
                .getNativeModule(UIManagerModule.class)
                .getUIImplementation()
                .dispatchViewUpdates(-1);

        });

//        getThemedContext().getJSModule(RCTEventEmitter.class).receiveEvent(
//            widget.getId(),
//            "relayout",
//                null
//        );
    }

    @Override
    public boolean isYogaLeafNode() {
        return true;
    }
}
