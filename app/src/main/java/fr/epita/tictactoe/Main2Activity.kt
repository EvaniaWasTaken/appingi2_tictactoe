package fr.epita.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {

            }
            var message :String = "player"
            var explicitIntent = Intent(this, Main3Activity::class.java)
            explicitIntent.putExtra("winner", message)

            startActivity(explicitIntent)
        }
    }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main2)
            var originIntent = intent
            val name = originIntent.getStringExtra("name")
            game_player_name.text = "O (" + name + ")"

            imageView1.setOnClickListener(this@Main2Activity)
            imageView2.setOnClickListener(this@Main2Activity)
            imageView3.setOnClickListener(this@Main2Activity)

            imageView4.setOnClickListener(this@Main2Activity)
            imageView5.setOnClickListener(this@Main2Activity)
            imageView6.setOnClickListener(this@Main2Activity)

            imageView7.setOnClickListener(this@Main2Activity)
            imageView8.setOnClickListener(this@Main2Activity)
            imageView9.setOnClickListener(this@Main2Activity)

        }
}
