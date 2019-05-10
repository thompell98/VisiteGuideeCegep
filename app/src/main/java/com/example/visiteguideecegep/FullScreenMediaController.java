package com.example.visiteguideecegep;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;

import java.util.ArrayList;

public class FullScreenMediaController extends MediaController {

    private ImageButton fullScreen;
    private String isFullScreen;


    public FullScreenMediaController(Context context) {
        super(context);
    }

    @Override
    public void setAnchorView(View view) {

        super.setAnchorView(view);
        fullScreen = new ImageButton(super.getContext());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.RIGHT;
        params.rightMargin = 80;
        addView(fullScreen, params);
        isFullScreen = ((Activity) getContext()).getIntent().getStringExtra("fullScreenInd");
        final String localA = ((Activity) getContext()).getIntent().getStringExtra("numeroLocalActuel");
        final ArrayList<Integer> posA = ((Activity) getContext()).getIntent().getIntegerArrayListExtra("positionActuelle");
        final String localV = ((Activity) getContext()).getIntent().getStringExtra("numeroLocalVoulu");
        final ArrayList<Integer> posV = ((Activity) getContext()).getIntent().getIntegerArrayListExtra("positionVoulue");


        if ("y".equals(isFullScreen)) {
            fullScreen.setImageResource(R.drawable.exitfulls);
        } else {
            fullScreen.setImageResource(R.drawable.fullscreen);
        }

        fullScreen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), AffichageLocal.class);

                if ("y".equals(isFullScreen)) {
                    intent.putExtra("fullScreenInd", "");
                    intent.putExtra("numeroLocalActuel", localA);
                    intent.putExtra("positionActuelle", posA);
                    intent.putExtra("numeroLocalVoulu", localV);
                    intent.putExtra("positionVoulue", posV);

                } else {
                    intent.putExtra("fullScreenInd", "y");
                    intent.putExtra("numeroLocalActuel", localA);
                    intent.putExtra("positionActuelle", posA);
                    intent.putExtra("numeroLocalVoulu", localV);
                    intent.putExtra("positionVoulue", posV);

                }
                (getContext()).startActivity(intent);
            }
        });
    }
}