package com.example.calctv

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import kotlin.math.pow

class MainActivity : FragmentActivity() {

    companion object{
        private const val MAX_INPUT_DIGITS = 40
    }

    private lateinit var textView: TextView
    private lateinit var btnPlus: Button
    private lateinit var btnMinus: Button
    private lateinit var btnMulti: Button
    private lateinit var btnDiv: Button
    private lateinit var btnEqual: Button
    private lateinit var btnRem: Button
    private lateinit var btnAC: Button
    private lateinit var btnDouble: Button

    private var firstNumber: Int = 0
    private var operatorId: Int = 0
    private var isInputOperator: Boolean = false

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

        btnPlus = findViewById(R.id.btn_puls)
        btnPlus.setOnClickListener(clickOperatorListener)

        btnMinus = findViewById(R.id.btn_minus)
        btnMinus.setOnClickListener(clickOperatorListener)

        btnMulti = findViewById(R.id.btn_multi)
        btnMulti.setOnClickListener(clickOperatorListener)

        btnEqual = findViewById(R.id.btn_equal)
        btnEqual.setOnClickListener(clickEqualListener)

        btnDiv = findViewById(R.id.btn_div)
        btnDiv.setOnClickListener(clickOperatorListener)

        btnRem = findViewById(R.id.btn_rem)
        btnRem.setOnClickListener(clickOperatorListener)

        btnAC = findViewById(R.id.btn_ac)
        btnAC.setOnClickListener(clickAllClearListener)

        btnDouble = findViewById(R.id.btn_double)
        btnDouble.setOnClickListener(clickDoubleListener)
        btnDouble.isEnabled = false

        btnDouble.setOnClickListener(view -> )

    }

    private fun setEnableOperatorButton(isEnable: Boolean) {
        btnPlus.isEnabled = isEnable
        btnMinus.isEnabled = isEnable
        btnMulti.isEnabled = isEnable
        btnDiv.isEnabled = isEnable
        btnRem.isEnabled = isEnable
    }

    private val clickNumberListener = View.OnClickListener { view ->
        val btn = view as Button
        if (operatorId != 0 && !isInputOperator) {
            textView.text = btn.text
            isInputOperator = true
            btnEqual.isEnabled = true
        } else {
            val num = textView.text.toString() + btn.text
            if (num.length <= MAX_INPUT_DIGITS) {
                textView.text = num
            }
        }

        if (operatorId == 0) {
            setEnableOperatorButton(true)
        }

        btnDouble.isEnabled = true
    }

    private val clickOperatorListener = View.OnClickListener { view ->
        val btn = view as Button
        firstNumber = textView.text.toString().toInt()
        operatorId = btn.id

        setEnableOperatorButton(false)
        textView.text = ""
        btnDouble.isEnabled = false
    }

    private val clickDoubleListener = View.OnClickListener { _ ->
//        firstNumber = textView.text.toString().toDouble().pow(2.0).toInt()
//        textView.text = firstNumber.toString()
//        operatorId = 0
//        setEnableOperatorButton(true)
//        btnEqual.isEnabled = false
//        isInputOperator = false

        val n: Int = textView.text.toString().toInt()
        val binary: String = Integer.toBinaryString(n)
        textView.text = binary

        setEnableOperatorButton(false)
        btnEqual.isEnabled = false
        btnDouble.isEnabled = false

    }

    private val clickEqualListener = View.OnClickListener {
        val number = textView.text.toString().toInt()
        val result = when (operatorId) {
            R.id.btn_puls -> firstNumber + number
            R.id.btn_minus -> firstNumber - number
            R.id.btn_multi -> firstNumber * number
            R.id.btn_div -> firstNumber / number
            R.id.btn_rem -> firstNumber % number
            else -> 0
        }
        textView.text = result.toString()
        operatorId = 0
        setEnableOperatorButton(true)
        btnEqual.isEnabled = false
        isInputOperator = false
        btnDouble.isEnabled = true
    }

    private val clickAllClearListener = View.OnClickListener {
        textView.text = ""
        firstNumber = 0
        operatorId = 0
        isInputOperator = false
        setEnableOperatorButton(true)
        btnEqual.isEnabled = false
        btnDouble.isEnabled = false
    }
}