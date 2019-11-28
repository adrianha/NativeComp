package com.nativecomp.widgetOne;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

import java.util.Map;

public class WidgetOneGroupManager extends ViewGroupManager<WidgetOne> {
    private WidgetOne widget;
    private WidgetOneShadowNode shadowNode;

    @NonNull
    @Override
    public String getName() {
        return "WidgetOne";
    }

    @NonNull
    @Override
    protected WidgetOne createViewInstance(@NonNull ThemedReactContext reactContext) {
        widget = new WidgetOne(reactContext, this);
        return widget;
    }

    @Override
    public LayoutShadowNode createShadowNodeInstance() {
        shadowNode = new WidgetOneShadowNode();
        return shadowNode;
    }

    @Override
    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return WidgetOneShadowNode.class;
    }

    public void relayout() {
        shadowNode.relayout(widget);
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
