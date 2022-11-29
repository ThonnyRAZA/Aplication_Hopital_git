package fr.razaheri.aplication_hopital

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import fr.razaheri.aplication_hopital.databinding.ActivityMainBinding
import java.util.*

const val CHOIX_DATE = ""
const val CHOIX_INTENSITE = ""
const val CHOIX_AINS = ""
const val CHOIX_TRIPAN = ""
const val CHOIX_TDF = ""
const val CHOIX_OBSERVATION = ""
const val PREF_NAME = "MIGRAINE_PREFS"


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var  sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        val sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        //dans votre onCreate par exemple pour récupérer une valeur
        val intensitePref = sharedPreferences?.getString(CHOIX_INTENSITE, "Modérée")

        //val adapterTdf = ArrayAdapter(this, android.R.layout.simple_spinner_item, intensitePref)

        // récupération de la valeur sauvegardée
        val intensite = sharedPreferences?.getString(CHOIX_INTENSITE, "")

        // recherche de sa position dans le spinner
        //val spinnerPosition: Int = adapter.getPosition(ains)

        // positionnement du spinner à la position souhaitée
        //spinnerAins.setSelection(spinnerPosition)

    }

    /** Called when the user taps the Send button */
    @SuppressLint("WrongViewCast")
    private fun sendMessage() {

        val Date = findViewById<TextView>(R.id.dateTv)
        val messageDate = Date.text.toString()

        val intensite = findViewById<Spinner>(R.id.migraine)
        val messageIntensite = intensite.selectedItem.toString()

        val Ains = findViewById<Spinner>(R.id.spnAINS)
        val messageAins = Ains.selectedItem.toString()

        val tripan = findViewById<Spinner>(R.id.spnTripan)
        val messageTripan = tripan.selectedItem.toString()

        val tdf = findViewById<Spinner>(R.id.spnTDF)
        val messageTdf = tdf.selectedItem.toString()

        val obs = findViewById<EditText>(R.id.editTextTextMultiLine)
        val messageObs = obs.text.toString()

        // dans votre fonction qui vous permet de passer à la vue suivante
        val sharedPreferences = this?.getSharedPreferences("fichier_de_preferences", Context.MODE_PRIVATE) ?: return
        with (sharedPreferences.edit()) {
            putString(CHOIX_DATE, messageDate)
            putString(CHOIX_AINS, messageAins)
            putString(CHOIX_TRIPAN, messageTripan)
            putString(CHOIX_TDF, messageTdf)
            putString(CHOIX_INTENSITE, messageIntensite)
            putString(CHOIX_OBSERVATION, messageObs)
            apply()
        }
        




        val intent = Intent(this, DisplayMessageActivity::class.java).also {
            it.putExtra("EXTRA_MESSAGE_DATE", messageDate)
            it.putExtra("EXTRA_MESSAGE_INTENSITE", messageIntensite)
            it.putExtra("EXTRA_MESSAGE_AINS", messageAins)
            it.putExtra("EXTRA_MESSAGE_TRIPAN", messageTripan)
            it.putExtra("EXTRA_MESSAGE_TDF", messageTdf)
            it.putExtra("EXTRA_MESSAGE_OBS", messageObs)
            startActivity(it)
        }

    }

}