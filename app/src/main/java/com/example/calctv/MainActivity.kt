package com.example.calctv

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {

    companion object{
        private const val MAX_INPUT_DIGITS = 8
    }

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 画面のレイアウトを設定
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.number_text)
        textView.text = ""

        findViewById<Button>(R.id.btn_0).setOnClickListener(clickNumberListener)
        findViewById<Button>(R.id.btn_1).setOnClickListener(clickNumberListener)
        findViewById<Button>(R.id.btn_2).setOnClickListener(clickNumberListener)
        findViewById<Button>(R.id.btn_3).setOnClickListener(clickNumberListener)
        findViewById<Button>(R.id.btn_4).setOnClickListener(clickNumberListener)
        findViewById<Button>(R.id.btn_5).setOnClickListener(clickNumberListener)
        findViewById<Button>(R.id.btn_6).setOnClickListener(clickNumberListener)
        findViewById<Button>(R.id.btn_7).setOnClickListener(clickNumberListener)
        findViewById<Button>(R.id.btn_8).setOnClickListener(clickNumberListener)
        findViewById<Button>(R.id.btn_9).setOnClickListener(clickNumberListener)
    }

    private val clickNumberListener = View.OnClickListener { view ->
        val btn = view as Button
        val num = btn.text.toString() + btn.text
        if (num.length <= MAX_INPUT_DIGITS) {
            textView.text = num
        }
    }
}