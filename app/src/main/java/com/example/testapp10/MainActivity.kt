package com.example.testapp10

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
const val KEY_1:String = "text"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.apply { text = "Text"
            isVisible= false
        setTextColor(getColor(R.color.colorAccent))}

        button.setTextColor(getColor(R.color.colorAccent))
        editText.apply { hint = "Enterr Something"
            addTextChangedListener {
//                Log.i("ViewBinding",it.toString())
              textView.setText(it.toString())
                button.isEnabled = it.toString().length in 5..20
                textView.isVisible = it.toString().length in 6..20

            }
            }

        button.setOnClickListener {
            val text1 = editText.text.toString()
            val i = Intent(this, MainActivity2::class.java)
            i.putExtra(KEY_1, "$text1")
            startActivity(i)
        }
        Dial.setOnClickListener {
            val mobile = editText.text.toString()
            val i = Intent()
            i.action = Intent.ACTION_DIAL
            i.data = Uri.parse("tel:$mobile")
            startActivity(i)
        }
        mail.setOnClickListener {
            val email = editText.text.toString()
            val i = Intent()
            i.action = Intent.ACTION_SENDTO
            i.data = Uri.parse("mailto:$email")
            startActivity(i)
        }

        }


    }
