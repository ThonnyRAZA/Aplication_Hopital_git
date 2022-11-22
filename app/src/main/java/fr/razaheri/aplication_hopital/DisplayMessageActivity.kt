package fr.razaheri.aplication_hopital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val messageDate = intent.getStringExtra("EXTRA_MESSAGE_DATE")
        val messageIntensite = intent.getStringExtra("EXTRA_MESSAGE_INTENSITE")
        val messageAins = intent.getStringExtra("EXTRA_MESSAGE_AINS")
        val messageTripan = intent.getStringExtra("EXTRA_MESSAGE_TRIPAN")
        val messageTdf = intent.getStringExtra("EXTRA_MESSAGE_TDF")
        val messageObs = intent.getStringExtra("EXTRA_MESSAGE_OBS")

        val date = findViewById<TextView>(R.id.Date).apply {
            text = messageDate
        }

        val intensite = findViewById<TextView>(R.id.Intensite).apply {
            text = messageIntensite
        }

        val spnAINS = findViewById<TextView>(R.id.spnAins).apply {
            text = messageAins
        }


       val spnTripan = findViewById<TextView>(R.id.spnTripan).apply {
            text = messageTripan
        }

        val spnTdf = findViewById<TextView>(R.id.spnTDF).apply {
            text = messageTdf
        }

        val Observations = findViewById<TextView>(R.id.Observations).apply {
            text = messageObs
        }


    }
}