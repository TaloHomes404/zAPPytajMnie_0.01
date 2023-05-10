package wolf.north.zappytajmnie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text


class EndScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_screen)
        //DEKLARACJA ELEMENTÓW UI
        var textNazwaUzytkownika: TextView? = null
        var textWynikPytan: TextView? = null
        var buttonZakoncz: Button? = null

        textNazwaUzytkownika = findViewById(R.id.tekstNazwaGracza)
        textWynikPytan = findViewById(R.id.tekstWynikKoncowy)
        buttonZakoncz = findViewById(R.id.bttnZakoncz)

        textNazwaUzytkownika?.setText(intent.getStringExtra(Constants.NAZWA_UŻYTKOWNIKA))
        val liczbaPytan = intent.getIntExtra(Constants.WSZYSTKIE_PYTANIA, 0)
        val poprawneOdpowiedzi = intent.getIntExtra(Constants.POPRAWNE_ODPOWIEDZI, 0)
        textWynikPytan.setText("Odpowiedziałeś poprawnie na $poprawneOdpowiedzi z $liczbaPytan pytań.")

        buttonZakoncz.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}