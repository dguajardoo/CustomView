package com.example.customviewkotlin

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import kotlinx.android.synthetic.main.email_validator.view.*
import java.util.regex.Pattern

class EmailValidatorView(context: Context, attrs: AttributeSet): RelativeLayout(context,attrs), TextWatcher {
    var successColor: Int
    var errorColor: Int

    init {
        inflate(context, R.layout.email_validator, this)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.MailValidator)
        tvErrorCode.text = attributes.getString(R.styleable.MailValidator_textError)
        errorColor = attributes.getColor(R.styleable.MailValidator_underlineErrorColor, ContextCompat.getColor(context, R.color.colorAccent))
        successColor = attributes.getColor(R.styleable.MailValidator_underlineSuccessColor, ContextCompat.getColor(context, R.color.colorAccent))
        attributes.recycle()

        etMail.addTextChangedListener(this)
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        //TODO("Not yet implemented")
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        //TODO("Not yet implemented")
        val pattern = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")
        val matcher = pattern.matcher(p0.toString())
        val valid = matcher.matches()

        if (valid) {
            tvErrorCode.visibility = View.INVISIBLE
            etMail.background.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(successColor, BlendModeCompat.SRC_IN)
        } else {
            tvErrorCode.visibility = View.VISIBLE
            etMail.background.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(errorColor, BlendModeCompat.SRC_IN)
        }
    }

    override fun afterTextChanged(p0: Editable?) {
        //TODO("Not yet implemented")
    }
}