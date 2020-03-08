package com.nativecomp.widgetOne;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;

import java.util.Map;

public class WidgetOneGroupManager extends ViewGroupManager<WidgetOne> {
    @NonNull
    @Override
    public String getName() {
        return "WidgetOne";
    }

    @NonNull
    @Override
    protected WidgetOne createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new WidgetOne(reactContext, this);
    }

    @Override
    public LayoutShadowNode createShadowNodeInstance() {
        return new WidgetOneShadowNode();
    }

    @Override
    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return WidgetOneShadowNode.class;
    }

    public void relayout(WidgetOne widget) {
        ThemedReactContext reactContext = (ThemedReactContext) widget.getContext();
        reactContext.runOnNativeModulesQueueThread(() -> {
            WidgetOneShadowNode shadowNode = (WidgetOneShadowNode) reactContext
                .getNativeModule(UIManagerModule.class)
                .getUIImplementation()
                .resolveShadowNode(widget.getId());
            if (shadowNode != null) {
                shadowNode.relayout();
            }
        });
    }

    @Override
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Nullable
    @Override
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put(
                        "relayout",
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onRelayout")))
                .build();
    }
}
