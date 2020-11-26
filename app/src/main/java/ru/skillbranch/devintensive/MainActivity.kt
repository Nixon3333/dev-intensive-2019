package ru.skillbranch.devintensive

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.Touch.scrollTo
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.devintensive.extensions.hideKeyboard
import ru.skillbranch.devintensive.models.Bender

class MainActivity : AppCompatActivity(), View.OnClickListener, TextView.OnEditorActionListener {

    lateinit var benderImage: ImageView
    lateinit var tvText: TextView
    lateinit var etMessage: EditText
    lateinit var ivSend: ImageView
    lateinit var bender: Bender

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        benderImage = iv_bender
        tvText = tv_text
        etMessage = et_message
        etMessage.setOnEditorActionListener(this)
        ivSend = iv_send
        ivSend.setOnClickListener(this)

        val status = savedInstanceState?.getString("STATUS") ?: Bender.Status.NORMAL.name
        val question = savedInstanceState?.getString("QUESTION") ?: Bender.Question.NAME.name
        bender = Bender(Bender.Status.valueOf(status), Bender.Question.valueOf(question))

        val (r, g, b) = bender.status.color
        benderImage.setColorFilter(Color.rgb(r, g, b), PorterDuff.Mode.MULTIPLY)

        tvText.text = bender.askQuestion()
    }

    override fun onClick(v: View?) {
        if (v?.id == ivSend.id) {
            val (phrase, color) = bender.listenAnswer(etMessage.text.toString()/*.toLowerCase()*/)
            etMessage.setText("")
            val (r, g, b) = color
            benderImage.setColorFilter(Color.rgb(r, g, b), PorterDuff.Mode.MULTIPLY)
            tvText.text = phrase
        }
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)

        outState?.putString("STATUS", bender.status.name)
        outState?.putString("QUESTION", bender.question.name)
    }

    override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
        if (p1 == EditorInfo.IME_ACTION_DONE) {
            hideKeyboard()
            ivSend.callOnClick()
            return true
        }
        return false
    }
}
