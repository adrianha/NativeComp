package com.nativecomp.widgetOne;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nativecomp.R;

public class WidgetOne extends LinearLayout {
    WidgetOneGroupManager manager;

    private Button btnToggleView;
    private TextView textViewToggled;

    public WidgetOne(Context context, WidgetOneGroupManager widgetOneGroupManager) {
        super(context);
        manager = widgetOneGroupManager;

        setupView();
        setupListener();
    }

    private void setupView() {
        View view = inflate(getContext(), R.layout.widget_one_view, null);
        addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        btnToggleView = findViewById(R.id.btn_toggle);
        textViewToggled = findViewById(R.id.text_view_toggled);
    }

    private void setupListener() {
        btnToggleView.setOnClickListener(view -> {
            textViewToggled.setVisibility(textViewToggled.getVisibility() == GONE ? VISIBLE : GONE);

            if (manager != null) {
                manager.relayout(this);
            }
        });
    }
}
