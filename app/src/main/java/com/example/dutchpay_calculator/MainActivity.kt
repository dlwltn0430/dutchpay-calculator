package com.example.dutchpay_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentContainer: FrameLayout
    private lateinit var radioGroup: RadioGroup
    private lateinit var dutchpayV1: RadioButton
    private lateinit var dutchpayV2: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
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
        return inflater.inflate(R.layout.dutchpay_ver1, container, false)
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