package com.concordia.soen357;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FontHelper {

    public static void setCustomFont(View rootView, Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "font/poppins_regular.ttf");

        if (rootView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) rootView;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                setCustomFont(viewGroup.getChildAt(i), context);
            }
        } else if (rootView instanceof TextView) {
            ((TextView) rootView).setTypeface(typeface);
        }
    }
}
