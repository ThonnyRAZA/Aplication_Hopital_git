package fr.razaheri.aplication_hopital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import android.app.DatePickerDialog
import android.content.Intent
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.*

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

        textView.setText("$day / ${month + 1} / $year")

        mPickTimeBtn.setOnClickListener {

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView

                textView.setText("$dayOfMonth / ${monthOfYear + 1} / $year")
            }, year, month, day)
            dpd.show()

        }

        // access the items of the list
        val Intensité = resources.getStringArray(R.array.Intensite_Migraine)
        val AINS = resources.getStringArray(R.array.AINS)
        val Tripan = resources.getStringArray(R.array.Tripan)
        val Traitement_de_fond = resources.getStringArray(R.array.Traitement_de_fond)


        // access the spinner
        var spinner = findViewById<Spinner>(R.id.migraine)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, Intensité)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        spinner = findViewById<Spinner>(R.id.spnAINS)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, AINS)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        spinner = findViewById<Spinner>(R.id.spnTripan)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, Tripan)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        spinner = findViewById<Spinner>(R.id.spnTDF)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, Traitement_de_fond)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        val button = findViewById<Button>(R.id.bttnEnvoyer)

        button.setOnClickListener{
            sendMessage()
        }
    }

    /** Called when the user taps the Send button */
    private fun sendMessage() {
        val Date = findViewById<TextView>(R.id.dateTv)
        val messageDate = Date.text.toString()

        val intensite = findViewById<Spinner>(R.id.migraine)
        val messageIntensite = intensite.selectedItem.toString()

        val ains = findViewById<Spinner>(R.id.spnAINS)
        val messageAins = intensite.selectedItem.toString()

        val intent = Intent(this, DisplayMessageActivity::class.java).also {
            it.putExtra("EXTRA_MESSAGE_DATE", messageDate)
            it.putExtra("EXTRA_MESSAGE_INTENSITE", messageIntensite)
            it.putExtra("EXTRA_MESSAGE_AINS", messageAins)
            startActivity(it)
        }

    }
}