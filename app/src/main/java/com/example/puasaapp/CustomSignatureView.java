package com.example.puasaapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;

public class CustomSignatureView extends AppCompatImageView {
    private int selectedImageResource = -1;

    public CustomSignatureView(Context context) {
        super(context);
    }

    public void setSelectedImageResource(int resourceId) {
        selectedImageResource = resourceId;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (selectedImageResource != -1) {
            Drawable drawable = getResources().getDrawable(selectedImageResource);
            drawable.setBounds(0, 0, getWidth(), getHeight());
            drawable.draw(canvas);
        }
    }
}
