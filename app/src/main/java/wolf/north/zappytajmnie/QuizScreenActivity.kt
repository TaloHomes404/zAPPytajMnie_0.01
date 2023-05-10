package wolf.north.zappytajmnie

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizScreenActivity : AppCompatActivity(), View.OnClickListener {
    private var mObecnePytanie: Int = 1
    private var mListaPytan:ArrayList<Question>? = null
    private var mWybranaOdpowiedzPytania: Int = 0

    //ELEMENTY UI- DEKLARACJE
    private var trescPytania: TextView? = null
    private var zdjFlagi: ImageView? = null
    private var pasekProgess: ProgressBar? = null
    private var numerPytania: TextView? = null
    private var odpowiedz1: TextView? = null
    private var odpowiedz2: TextView? = null
    private var odpowiedz3: TextView? = null
    private var odpowiedz4: TextView? = null
    private var btnZatwierdz: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_screen)

        trescPytania = findViewById(R.id.trescPytania)
        zdjFlagi = findViewById(R.id.imgFlaga)
        pasekProgess = findViewById(R.id.progressBarPytania)
        numerPytania = findViewById(R.id.textNumerPytania)
        odpowiedz1 = findViewById(R.id.textOpcjaJeden)
        odpowiedz2 = findViewById(R.id.textOpcjaDwa)
        odpowiedz3 = findViewById(R.id.textOpcjaTrzy)
        odpowiedz4 = findViewById(R.id.textOpcjaCztery)
        btnZatwierdz = findViewById(R.id.btnZatwierdz)

        mListaPytan = Constants.dodajPytanie()
        ustawPytania()
        //PONIEWAŻ DODALIŚMY DO ACTIVITY ONCLICKLISTENER MOŻEMY UŻYĆ THIS
        //THIS -> VIEW.ONCLICKLISTENER = AKTYWUJE METODE onClick
        odpowiedz1?.setOnClickListener(this)
        odpowiedz2?.setOnClickListener(this)
        odpowiedz3?.setOnClickListener(this)
        odpowiedz4?.setOnClickListener(this)
        btnZatwierdz?.setOnClickListener{
            funkcjonalnoscPrzyciskuOdpowiedz()
        }

    }

    private fun ustawPytania() {

        //PRZYPISANIE ELEMENTÓW UI DO DATA-CLASS Z PYTANIAMI
        //obecnePytanie - FLAGA - ustawiona globalnie na 1 żeby wczytała pierwsze pytanie
        //UŻYCIE- flaga używana jest w OnClick na przycisku do nastepnej odpowiedzi, (flaga++)
        //ZAŁADOWANIE PYTANIA - czyści UI do normalnych layoutów
        domyslnyStylPytania()
        val pytanie: Question = mListaPytan!![mObecnePytanie - 1]
        zdjFlagi?.setImageResource(pytanie.zdjecie)
        pasekProgess?.progress = mObecnePytanie
        numerPytania?.text = "$mObecnePytanie/${pasekProgess?.max}"
        trescPytania?.text = pytanie.trescPytania
        odpowiedz1?.text = pytanie.opcjaPierwsza
        odpowiedz2?.text = pytanie.opcjaDruga
        odpowiedz3?.text = pytanie.opcjaTrzecia
        odpowiedz4?.text = pytanie.opcjaCzwarta

        if(mObecnePytanie == mListaPytan!!.size){
            btnZatwierdz?.text = "Ukończ"
        }else{
            btnZatwierdz?.text = "Odpowiedz"
        }
    }

    private fun domyslnyStylPytania(){
        val odpowiedzi = ArrayList<TextView>()
        odpowiedz1?.let { odpowiedzi.add(0,it) }
        odpowiedz2?.let { odpowiedzi.add(1,it) }
        odpowiedz3?.let { odpowiedzi.add(2,it) }
        odpowiedz4?.let { odpowiedzi.add(3,it) }

        for(odp in odpowiedzi){
            odp.setTextColor(Color.parseColor("#000000"))
            odp.setTypeface(Typeface.DEFAULT)
            odp.background = (ContextCompat.getDrawable(this,R.drawable.default_background_border_question))
        }
    }

    private fun zaznaczonyStylPytania(pytanie:TextView, wybranePytanie:Int){
        domyslnyStylPytania()
        mWybranaOdpowiedzPytania = wybranePytanie
        pytanie.setTextColor(Color.parseColor("#363A43"))
        pytanie.setTypeface(pytanie.typeface,Typeface.BOLD)
        pytanie.background = (ContextCompat.getDrawable(this,R.drawable.selected_answer_border_bg))
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.textOpcjaJeden -> {
                odpowiedz1?.let { zaznaczonyStylPytania(it, 1) }
            }
            R.id.textOpcjaDwa -> {
                odpowiedz2?.let { zaznaczonyStylPytania(it, 2) }
            }
            R.id.textOpcjaTrzy -> {
                odpowiedz3?.let { zaznaczonyStylPytania(it, 3) }
            }
            R.id.textOpcjaCztery -> {
                odpowiedz4?.let { zaznaczonyStylPytania(it, 4) }
            }
            R.id.btnZatwierdz -> {
                    funkcjonalnoscPrzyciskuOdpowiedz()
            }
        }
    }
    private fun funkcjonalnoscPrzyciskuOdpowiedz(){
        //WARTOŚĆ JEST USTAWIANA NA 0 PO WCIŚNIĘCIU PRZYCISKU ZATWIERDŹ ODPOWIEDŹ
        //SPELNIAJĄC WARUNEK WCZYTUJEMY KOLEJNE PYTANIE DO QUIZU
        if(mWybranaOdpowiedzPytania == 0) {
            mObecnePytanie++

            //PÓKI MAMY PYTANIA W LIŚCIE WCZYTUJEMY JE DO QUIZU
            when {
                (mObecnePytanie <= mListaPytan!!.size) -> {
                    ustawPytania()
                }
                //W WYPADKU GDY PYTANIA SIĘ SKOŃCZĄ
                //WYŚWIETLAMY WIADOMOŚĆ
            else ->{
                Toast.makeText(this, "Odpowiedziałeś na wszystkie pytania!", Toast.LENGTH_SHORT).show()
            }
            }
        }else{
            val pytanie = mListaPytan?.get(mObecnePytanie -1)
            //JEŻELI ODPOWIEDZ JEST NIEPOPRAWNA TO KOLORUJE JĄ NA CZERWONO, A POPRAWNĄ ZAZNACZA
            //NA ZIELONO
            //ELSE - WYBRANO POPRAWNĄ ODPOWIEDŹ - PODŚWIETLA JĄ NA ZIELONO
            if(pytanie!!.poprawnaOdpowiedz != mWybranaOdpowiedzPytania){
                odpowiedzNaPytanieView(mWybranaOdpowiedzPytania, R.drawable.incorrect_answer_border_bg)
                odpowiedzNaPytanieView(pytanie.poprawnaOdpowiedz, R.drawable.correct_answer_border_bg)
            }else{
                odpowiedzNaPytanieView(pytanie.poprawnaOdpowiedz, R.drawable.correct_answer_border_bg)
            }
            //JEŻELI DOTARLIŚMY DO OSTATNIEGO PYTANIA WYBRANIE ODPOWIEDZI ZMIENIA TEKST PRZYCISKU
            if(mObecnePytanie == mListaPytan!!.size){
                btnZatwierdz?.text = "UKOŃCZ QUIZ"
            }else{
                btnZatwierdz?.text = "NASTĘPNE PYTANIE"
            }
            //WAŻNY RESET ODPOWIEDZI, PO KAŻDYM WCIŚNIĘCIU PRZYCISKU USTAWIANA JEST NA 0
            //NOWE PYTANIE - NOWA ODPOWIEDŹ
            mWybranaOdpowiedzPytania = 0
        }
    }
    private fun odpowiedzNaPytanieView(odpowiedz: Int, drawableView: Int){
        when(odpowiedz){
            1 -> {
                odpowiedz1?.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                odpowiedz2?.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                odpowiedz3?.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                odpowiedz4?.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}