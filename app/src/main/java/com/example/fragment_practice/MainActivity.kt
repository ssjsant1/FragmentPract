package com.example.fragment_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import com.example.fragment_practice.databinding.ActivityMainBinding
import androidx.fragment.app.add
import com.example.fragment_practice.FirstFragment.Companion.ADDRESS_BUNDLE
import com.example.fragment_practice.FirstFragment.Companion.NAME_BUNDLE

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState==null){
            val bundle = bundleOf(NAME_BUNDLE to "locochon",
                ADDRESS_BUNDLE to "Via Giovanni Spano" )

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FirstFragment>(R.id.fragment_container, args = bundle)
                add<SecondFragment>(R.id.second_container)
            }
        }
    }
}