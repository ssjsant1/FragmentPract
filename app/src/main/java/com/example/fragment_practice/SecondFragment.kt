package com.example.fragment_practice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val valor1 = "param1"
private const val valor2 = "param2"

class SecondFragment : Fragment() {

    private var firstValue: String? = "lol"
    private var secondValue: String? = "que paso"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            firstValue = it.getString(FIRST_BUNDLE)
            secondValue = it.getString(SECOND_BUNDLE)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val text = view.findViewById<TextView>(R.id.hola)

        text.text = firstValue + secondValue

        return view
    }

    companion object {
        const val FIRST_BUNDLE = "name_bundle"
        const val SECOND_BUNDLE = "address_bundle"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
//                arguments = Bundle().apply {
//                    putString(valor1, param1)
//                    putString(valor2, param2)
//                }
            }
    }
}