package com.example.practicalw2g124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceImage :ImageView //lateinit variables can be reused, can treat it like global object
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //Load our activity, and link to our resources, layout.

        val rollBtn: Button = findViewById(R.id.Rollbtn)
        rollBtn.setOnClickListener { rollDice() }

        diceImage = findViewById(R.id.DiceImage)
    }

    private fun rollDice() {
        val randomInt = (1 .. 6).random()
        val numberTxt: TextView = findViewById(R.id.NumberTxt) // Creating a variable with type of TextView and linking it to Number text.
        Toast.makeText(this, "Dice is rolled",
            Toast.LENGTH_SHORT).show()

        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource((drawableResource))
        numberTxt.text = randomInt.toString()
    }
}