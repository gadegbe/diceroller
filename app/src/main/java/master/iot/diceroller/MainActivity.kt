package master.iot.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import master.iot.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.rollButton.text = "Lançons ces dés"
        binding.rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        var randomInt: Int? = 0
        val randomRepeat: Int = Random.nextInt(20) + 1

        repeat(randomRepeat) { index ->
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                randomInt = Random.nextInt(6) + 1
                binding.resultText.text = randomInt.toString()
                binding.diceImage.setImageResource(
                    when (randomInt) {
                        1 -> R.drawable.dice_1
                        2 -> R.drawable.dice_2
                        3 -> R.drawable.dice_3
                        4 -> R.drawable.dice_4
                        5 -> R.drawable.dice_5
                        else -> R.drawable.dice_6
                    }
                )
            }, index.toLong()*100)

        }



    }
}
