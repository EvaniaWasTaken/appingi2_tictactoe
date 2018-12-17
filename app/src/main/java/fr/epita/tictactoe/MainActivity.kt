package fr.epita.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
// Create the fragment we want to display
        var message = nameinput.text
        var explicitIntent = Intent(this, Main2Activity::class.java)
        explicitIntent.putExtra("name", message)

        startActivity(explicitIntent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startbutton.setOnClickListener(this@MainActivity)
    }
}
