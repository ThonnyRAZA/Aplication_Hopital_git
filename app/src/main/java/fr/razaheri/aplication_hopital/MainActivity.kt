package fr.razaheri.aplication_hopital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import android.app.DatePickerDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mPickTimeBtn = findViewById<Button>(R.id.pickDateBtn)
        val textView     = findViewById<TextView>(R.id.dateTv)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        mPickTimeBtn.setOnClickListener {

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                textView.setText("$dayOfMonth, ${monthOfYear + 1}, $year")
            }, year, month, day)
            dpd.show()

        }



    }
}