package gswierczynski.pl.noonnestedscrollduringflingonsupp28rc1

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View
import timber.log.Timber

class CustomBehavior<V : View> (context: Context, attrs: AttributeSet) :
        CoordinatorLayout.Behavior<V>(context, attrs) {

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: V, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        Timber.d(" axes: $axes type: $type")
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: V, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        Timber.d(" type: $type")
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: V, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        Timber.d(" type: $type")
    }

    override fun onNestedPreFling(coordinatorLayout: CoordinatorLayout, child: V, target: View, velocityX: Float, velocityY: Float): Boolean {
        Timber.d(" velocityX: $velocityX velocityY: $velocityY")
        return false
    }

    override fun onNestedFling(coordinatorLayout: CoordinatorLayout, child: V, target: View, velocityX: Float, velocityY: Float, consumed: Boolean): Boolean {
        Timber.d(" velocityX: $velocityX velocityY: $velocityY")
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed)
    }

    override fun onStopNestedScroll(coordinatorLayout: CoordinatorLayout, child: V, target: View, type: Int) {
        Timber.d(" type: $type")
        super.onStopNestedScroll(coordinatorLayout, child, target, type)
    }
}