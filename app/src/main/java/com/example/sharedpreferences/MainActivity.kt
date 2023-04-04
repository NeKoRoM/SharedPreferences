package com.example.sharedpreferences

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityMainBinding

const val APP_PREFERENCES="APP_PREFERENCES"
const val PREF_CONST_VALUE="PREF_CONST_VALUE"

class MainActivity : AppCompatActivity() {

    private lateinit var preferences: SharedPreferences

     lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        preferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)

        binding.button.setOnClickListener {
            val set :MutableSet<String> = preferences.getStringSet(PREF_CONST_VALUE, setOf(""))?: mutableSetOf<String>()
            val setTo= set +binding.editText.text.toString()

            preferences.edit().putStringSet(PREF_CONST_VALUE,setTo).apply()
            binding.textView.text = preferences.getStringSet(PREF_CONST_VALUE, setOf("")).toString()
        }


    }
}