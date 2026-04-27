package com.example.diceapp2024_xml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.media.MediaPlayer
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var drawableRes1 = 0
    var drawableRes2 = 0
    var drawableRes3 = 0
    var drawableRes4 = 0
    var drawableRes5 = 0
    var drawableRes6 = 0

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btRoll: Button = findViewById(R.id.btRoll)

        val dice1: ImageView = findViewById(R.id.dice1)
        val dice2: ImageView = findViewById(R.id.dice2)
        val dice3: ImageView = findViewById(R.id.dice3)
        val dice4: ImageView = findViewById(R.id.dice4)
        val dice5: ImageView = findViewById(R.id.dice5)
        val dice6: ImageView = findViewById(R.id.dice6)

        // Inicializa som
        mediaPlayer = MediaPlayer.create(this, R.raw.dice_roll)

        btRoll.setOnClickListener {

            // Evita bug se clicar rápido
            if (mediaPlayer.isPlaying) {
                mediaPlayer.seekTo(0)
            }
            mediaPlayer.start()

            val r1 = rollDice()
            val r2 = rollDice()
            val r3 = rollDice()
            val r4 = rollDice()
            val r5 = rollDice()
            val r6 = rollDice()

            // TOPO = AMARELO
            drawableRes1 = getDiceYellow(r1)
            drawableRes2 = getDiceYellow(r2)
            drawableRes3 = getDiceYellow(r3)

            // BAIXO = VERMELHO
            drawableRes4 = getDiceRed(r4)
            drawableRes5 = getDiceRed(r5)
            drawableRes6 = getDiceRed(r6)

            dice1.setImageResource(drawableRes1)
            dice2.setImageResource(drawableRes2)
            dice3.setImageResource(drawableRes3)

            dice4.setImageResource(drawableRes4)
            dice5.setImageResource(drawableRes5)
            dice6.setImageResource(drawableRes6)
        }
    }

    private fun rollDice(): Int {
        return Random.nextInt(6) + 1
    }

    private fun getDiceYellow(random: Int): Int {
        return when (random) {
            1 -> R.drawable.dice_yellow_1
            2 -> R.drawable.dice_yellow_2
            3 -> R.drawable.dice_yellow_3
            4 -> R.drawable.dice_yellow_4
            5 -> R.drawable.dice_yellow_5
            6 -> R.drawable.dice_yellow_6
            else -> R.drawable.empty_dice
        }
    }

    private fun getDiceRed(random: Int): Int {
        return when (random) {
            1 -> R.drawable.dice_red_1
            2 -> R.drawable.dice_red_2
            3 -> R.drawable.dice_red_3
            4 -> R.drawable.dice_red_4
            5 -> R.drawable.dice_red_5
            6 -> R.drawable.dice_red_6
            else -> R.drawable.empty_dice
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("PDM25", "onStart -> $drawableRes1 | $drawableRes2 | $drawableRes3 | $drawableRes4 | $drawableRes5 | $drawableRes6")
    }

    override fun onResume() {
        super.onResume()
        Log.d("PDM25", "onResume -> $drawableRes1 | $drawableRes2 | $drawableRes3 | $drawableRes4 | $drawableRes5 | $drawableRes6")
    }

    override fun onPause() {
        super.onPause()
        Log.d("PDM25", "onPause -> $drawableRes1 | $drawableRes2 | $drawableRes3 | $drawableRes4 | $drawableRes5 | $drawableRes6")
    }

    override fun onStop() {
        super.onStop()
        Log.d("PDM25", "onStop -> $drawableRes1 | $drawableRes2 | $drawableRes3 | $drawableRes4 | $drawableRes5 | $drawableRes6")
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
        Log.d("PDM25", "onDestroy -> $drawableRes1 | $drawableRes2 | $drawableRes3 | $drawableRes4 | $drawableRes5 | $drawableRes6")
    }
}