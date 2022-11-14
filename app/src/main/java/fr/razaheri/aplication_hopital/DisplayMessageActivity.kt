package fr.razaheri.aplication_hopital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val messageDate = intent.getStringExtra("EXTRA_MESSAGE_DATE")
        val messageIntensite = intent.getStringExtra("EXTRA_MESSAGE_INTENSITE")

        val date = findViewById<TextView>(R.id.Date).apply {
            text = messageDate
        }

        val intensite = findViewById<TextView>(R.id.Intensite).apply {
            text = messageIntensite
        }



    }
}