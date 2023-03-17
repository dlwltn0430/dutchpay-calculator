package com.example.dutchpay_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentContainer: FrameLayout
    private lateinit var radioGroup: RadioGroup
    private lateinit var dutchpayV1: RadioButton
    private lateinit var dutchpayV2: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        //선택하는 radio button에 따라 다른 fragment 보여주기
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentContainer = findViewById(R.id.fragment_container)
        radioGroup = findViewById(R.id.radio_group)
        dutchpayV1 = findViewById(R.id.ver1)
        dutchpayV2 = findViewById(R.id.ver2)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.ver1 -> showV1()
                R.id.ver2 -> showV2()
            }
        }
    }

    private fun showV1() {
        val v1Fragment = V1()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, v1Fragment)
            .commit()
    }

    private fun showV2() {
        val v2Fragment = V2()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, v2Fragment)
            .commit()
    }

}

class V1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dutchpay_ver1, container, false)
        // {정산 요청 금액 / 요청 인원} 값 보여주기
        val showResult = view.findViewById<Button>(R.id.showResult)
        val requestedNum = view.findViewById<EditText>(R.id.requestedNum)
        val requestedAmount = view.findViewById<EditText>(R.id.requestedAmount)
        val dutchpay_result = view.findViewById<TextView>(R.id.dutchpay_result)

        showResult?.setOnClickListener {
            val input1 = requestedNum.text.toString().toIntOrNull()
            val input2 = requestedAmount.text.toString().toIntOrNull()
            if (input1 != null && input2 != null) {
                val result = input2 / input1
                dutchpay_result.text = "인당 " + result.toString() + "원"
            } else {
                Toast.makeText(requireContext(), "입력값이 유효하지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}

class V2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dutchpay_ver2, container, false)
    }
}