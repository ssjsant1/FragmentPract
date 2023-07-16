package com.example.fragment_practice

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import com.example.fragment_practice.SecondFragment.Companion.FIRST_BUNDLE
import com.example.fragment_practice.SecondFragment.Companion.SECOND_BUNDLE
import org.w3c.dom.Text

class FirstFragment : Fragment() {

    private var name: String? = null
    private var address: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME_BUNDLE)
            address = it.getString(ADDRESS_BUNDLE)
            Log.i("valori", name.orEmpty())
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val button = view.findViewById<Button>(R.id.button_fragment)

        val bundle = bundleOf(FIRST_BUNDLE to "loco chon",
            SECOND_BUNDLE to "Funcionan 2" )

        button.setOnClickListener {
            val secondF = SecondFragment()
            secondF.arguments = bundle
            fragmentManager?.beginTransaction()?.commit()
        }


        return view
    }

    companion object {

        const val NAME_BUNDLE = "name_bundle"
        const val ADDRESS_BUNDLE = "address_bundle"


        @JvmStatic
        fun newInstance(name: String, address: String) =
            FirstFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }
}