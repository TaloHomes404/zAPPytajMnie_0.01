package wolf.north.zappytajmnie

object Constants {
    //STAŁE PROGRAMOWE - STAŁE WARTOŚCI
    const val NAZWA_UŻYTKOWNIKA: String = "nazwa_użytkownika"
    const val WSZYSTKIE_PYTANIA: String = "wszystkie_pytania"
    const val POPRAWNE_ODPOWIEDZI: String = "poprawne_odpowiedzi"
    fun dodajPytanie(): ArrayList<Question> {
        val listaPytan = ArrayList<Question>()

        val pytanie1 = Question(
            1, "Jakie państwo przedstawia ta flaga?", R.drawable.korea,
            "Chile", "Japonia", "Korea Pólnocna", "Korea Południowa",
            3
        )
        listaPytan.add(pytanie1)


        val pytanie2 = Question(
            2, "Jakie państwo przedstawia ta flaga?", R.drawable.boliwia,
            "Peru", "Boliwia", "Tanzania", "Mołdawia",
            2
        )
        listaPytan.add(pytanie2)

        val pytanie3 = Question(
            3, "Jakie państwo przedstawia ta flaga?", R.drawable.lichtenstein,
            "Liechtenstein", "Dania", "Luksemburg", "Irlandia",
            1
        )
        listaPytan.add(pytanie3)

        val pytanie4 = Question(
            4, "Jakie państwo przedstawia ta flaga?", R.drawable.bialorus,
            "Białoruś", "Rumunia", "Algieria", "Serbia",
            1
        )
        listaPytan.add(pytanie4)

        val pytanie5 = Question(
            5, "Jakie państwo przedstawia ta flaga?", R.drawable.indie,
            "Irlandia", "Indonezja", "Litwa", "Indie",
            4
        )
        listaPytan.add(pytanie5)

        val pytanie6 = Question(
            6, "Jakie państwo przedstawia ta flaga?", R.drawable.tunezja,
            "Portugalia", "Turcja", "Tunezja", "Szwajcaria",
            3
        )
        listaPytan.add(pytanie6)

        val pytanie7 = Question(
            7, "Jakie państwo przedstawia ta flaga?", R.drawable.gruzja,
            "Montenegro", "Gruzja", "Słowacja", "Chorwacja",
            2
        )
        listaPytan.add(pytanie7)

        val pytanie8 = Question(
            8, "Jakie państwo przedstawia ta flaga?", R.drawable.luksemburg,
            "Luksemburg", "Holandia", "San Marino", "Kazachstan",
            1
        )
        listaPytan.add(pytanie8)

        val pytanie9 = Question(
            9, "Jakie państwo przedstawia ta flaga?", R.drawable.albania,
            "Angola", "Cypr", "Łotwa", "Albania",
            4
        )
        listaPytan.add(pytanie9)

        val pytanie10 = Question(
            10, "Jakie państwo przedstawia ta flaga?", R.drawable.filipiny,
            "Malta", "Czechy", "Filipiny", "Francja",
            3
        )
        listaPytan.add(pytanie10)

        return listaPytan
    }

}