package ru.skillbranch.devintensive.ui.custom

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorRes
import androidx.annotation.Dimension
import ru.skillbranch.devintensive.R

/**
 * Created by Drygin Nikita on 30,Ноябрь,2020
 */
class CircleImageView @JvmOverloads constructor(
    context: Context, private var attrs: AttributeSet?, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyleAttr) {

    companion object {
        private const val DEF_BORDER_COLOR = 0
        private const val DEF_BORDER_WIDTH = 2
    }

    private var cvBorderColor = DEF_BORDER_COLOR
    private var cvBorderWidth = DEF_BORDER_WIDTH

    init {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
            cvBorderColor = a.getColor(R.styleable.CircleImageView_cv_borderColor, DEF_BORDER_COLOR)
            cvBorderWidth = a.getDimensionPixelSize(R.styleable.CircleImageView_cv_borderWidth, DEF_BORDER_WIDTH)
            a.recycle()
        }
    }

    @Dimension
    fun getBorderWidth(): Int = cvBorderWidth

    fun setBorderWidth(@Dimension dp: Int) {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
            cvBorderWidth = dp
            a.recycle()
        }
    }

    @Dimension
    fun getBorderColor(): Int = cvBorderColor

    fun setBorderColor(@ColorRes colorId: Int) {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
            cvBorderColor = colorId
            a.recycle()
        }
    }

    fun setBorderColor(hex: String) {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
            cvBorderColor = hex.toInt(16)
            a.recycle()
        }
    }
}