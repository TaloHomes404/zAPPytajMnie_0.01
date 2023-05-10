package wolf.north.zappytajmnie
//ODNOŚNIE PROJEKTU
//zAPPytaj mnie - aplikacja ala Quiz pozwalająca sprawdzić naszą wiedzę odnośnie FLAG państw
//layout - liniowy, bez systemu logowania,

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DEKLARACJA ELEMENTÓW UJ
        val bttnStart: Button = findViewById(R.id.bttnStart)
        val eTextImie: EditText = findViewById(R.id.eTxtImie)
        //

        bttnStart.setOnClickListener {
            //JEŻELI TEKST JEST PUSTY TO WYŚWIETLA POWIADOMIENIE
            //JEŚLI JEST WPROWADZONY TEKST - OTWIERA NASTĘPNĄ AKTYWNOŚĆ Z QUIZEM
            if(eTextImie.text.isEmpty()){
                Toast.makeText(this, "Wpisz swoje imie!", Toast.LENGTH_SHORT).show()
            }else{
                //TWORZYMY ZMIENNĄ intent - PRZEJŚCIE Z JEDNEGO EKRANU NA DRUGI
                //METODA startActivity - uruchamia nową aktywność
                val intent = Intent(this, QuizScreenActivity::class.java)
                startActivity(intent)
                finish()
            }

        }


    }
}