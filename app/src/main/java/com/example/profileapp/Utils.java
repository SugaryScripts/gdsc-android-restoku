package com.example.profileapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class Utils {

    public static Drawable getDrawable(Context context, String name){
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(name, "drawable",
                context.getPackageName());
        return resources.getDrawable(resourceId);
    }
}
