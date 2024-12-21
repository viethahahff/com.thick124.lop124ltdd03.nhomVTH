package home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class CustomViewPager extends ViewPager {
    private boolean enabled;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Không xử lý sự kiện vuốt
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        // Không xử lý sự kiện vuốt
        return false;
    }

}
