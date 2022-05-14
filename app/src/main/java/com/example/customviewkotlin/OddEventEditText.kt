package com.example.customviewkotlin

import android.content.Context
import android.graphics.BlendMode
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged

class OddEventEditText : AppCompatEditText {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        inputType = InputType.TYPE_CLASS_NUMBER

        addTextChangedListener{
            doAfterTextChanged {
                if (!text.isNullOrEmpty()) {
                    if (text.toString().toDouble() % 2  == 0.0) {
                        var color: Int = ResourcesCompat.getColor(resources, R.color.blue, null)
                        background.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(color, BlendModeCompat.SRC_IN)
                    } else {
                        var color: Int = ResourcesCompat.getColor(resources, R.color.red, null)
                        background.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(color, BlendModeCompat.SRC_IN)
                    }
                }
            }

            doBeforeTextChanged { text, start, count, after ->  }

            doOnTextChanged { text, start, before, count ->  }
        }
    }
}