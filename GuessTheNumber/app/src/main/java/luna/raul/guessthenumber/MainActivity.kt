package luna.raul.guessthenumber

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.min
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var maxNumber=100
    var minNumber=0
    var num: Int =0
    var won: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessings: TextView = findViewById(R.id.guessings)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.up)
        val generate: Button = findViewById(R.id.generate)
        val guessed: Button = findViewById(R.id.guessed)

        generate.setOnClickListener{
            num = Random.nextInt(minNumber, maxNumber)
            guessings.setText(num.toString())
            generate.visibility = View.INVISIBLE
            generate.visibility = View.VISIBLE
        }

        up.setOnClickListener{
            minNumber = num

            if(checkingLimits()){
                num = Random.nextInt(minNumber,maxNumber)
                guessings.setText(num.toString())
            }else{
                guessings.setText("No puede ser :c Me ganaste")
            }
        }

        down.setOnClickListener{
            maxNumber = num

            if(checkingLimits()){
                num = Random.nextInt(minNumber,maxNumber)
                guessings.setText(num.toString())
            }else{
                guessings.setText("No puede ser :c Me ganaste")
            }
        }


        guessed.setOnClickListener{
            if(!won) {
                guessings.setText("Adiviné, tu número es el " + num)
                guessed.setText("Volver a jugar")
                won = true
            }else{
                generate.visibility = View.VISIBLE
                guessings.setText("Tap on generate to start")
                guessed.visibility = View.GONE
                resetValues()
            }
        }


    }
    fun resetValues(){
        minNumber = 0
        maxNumber = 100
        num=0
        won= false
    }
    fun checkingLimits():Boolean{
        return minNumber != maxNumber
    }
}