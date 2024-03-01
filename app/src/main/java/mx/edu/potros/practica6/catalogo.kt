package mx.edu.potros.practica6

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class catalogo : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var seriesAdapter: PeliculaAdapter? = null
    var peliculas=ArrayList<Pelicula>()
    var series=ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()
        cargarSeries()

        adapter = PeliculaAdapter(this, peliculas)
        seriesAdapter = PeliculaAdapter(this, series)
        var gridPelis: GridView = findViewById(R.id.movies_catalogo)
        var gridSeries: GridView = findViewById(R.id.mseries_catalogo)

        gridPelis.adapter = adapter
        gridSeries.adapter = seriesAdapter
    }

    fun cargarPeliculas(){
        peliculas.add(Pelicula("Demon Slayer: Kimetsu no Yaiba -To the Hashira Training", R.drawable.demon, R.drawable.demo, "el episodio 11 del Arco de la Aldea de los Herreros, mostrando así la conclusión de la feroz batalla entre Tanjiro y la Cuarta Luna Creciente, Hatengu, además de cómo Nezuko logra caminar bajo el sol. Le seguirá el episodio 1 del Arco del Entrenamiento de los Pilares, donde veremos el inicio del entrenamiento de los Pilares para prepararse de cara a la próxima batalla contra Muzan Kibutsuji, que se podrá ver por primera vez."))
        peliculas.add(Pelicula("Dune",R.drawable.dune, R.drawable.dune2, "\"Duna: Parte Dos\" Paul Atreides se une a Chani y a los Fremen mientras busca venganza contra los conspiradores que destruyeron a su familia. Enfrentándose a una elección entre el amor de su vida y el destino del universo, debe evitar un futuro terrible."))
        peliculas.add(Pelicula("Ghostbusters Apocalipsis", R.drawable.ghostbuster, R.drawable.ghostbusters,"la familia Spengler regresa al lugar donde empezó todo- el icónico parque de bomberos de Nueva York- para formar equipo con los Cazafantasmas originales, que han desarrollado un laboratorio de investigación ultrasecreto para llevar la caza de fantasmas al siguiente nivel."))
        peliculas.add(Pelicula("Heroe por encargo", R.drawable.heroexencargo, R.drawable.heroeencargo, "Un ex agente de las fuerzas especiales acepta un trabajo para brindar seguridad a una periodista mientras entrevista a un dictador, pero estalla un golpe militar en medio de la entrevista y se ven obligados a escapar a la jungla donde deben sobrevivir."))
        peliculas.add(Pelicula("Madame Web", R.drawable.madameweb, R.drawable.madame, "En un cambio del típico género, Madame Web cuenta la historia independiente del origen de una de las heroínas más enigmáticas de la editorial Marvel. El thriller de suspenso protagonizado por Dakota Johnson como Cassandra Webb, una paramédico de Manhattan que puede tener habilidades clarividentes. Forzada a enfrentarse a revelaciones de su pasado, ella forja una relación con tres mujeres jóvenes destinadas a tener poderosos futuros... si pueden sobrevivir a un presente mortal."))
        peliculas.add(Pelicula("Vidas pasadas", R.drawable.vidaspasadas, R.drawable.vidaspasadas1, "Nora y Hae Sung, dos amigos de la infancia profundamente conectados, se separan cuando la familia de Nora emigra de Corea del Sur. Décadas más tarde, se reencuentran durante una fatídica semana mientras enfrentan el destino, el amor y las decisiones que marcan la vida."))
    }

    fun cargarSeries(){
        series.add(Pelicula("Avatar: La leyenda de Aang", R.drawable.ant, R.drawable.avatar, "La serie se centra en el viaje de Aang, de 12 años, el Avatar actual y último superviviente de su nación, los Nómadas del Aire, junto con sus amigos Sokka, Katara y más tarde Toph, mientras se esfuerzan por poner fin a la guerra de la Nación del Fuego contra las otras naciones del mundo."))
        series.add(Pelicula("Halo", R.drawable.halo, R.drawable.halos, "La historia principal se centra en un conflicto interestelar entre los humanos y unos alienígenas guiados por unos profetas obsesionados con una antigua especie conocida como los Forerunners."))
        series.add(Pelicula("Leveling", R.drawable.sololeveling, R.drawable.sololevelings, "En un mundo en el que ciertos humanos llamados «cazadores» poseen habilidades mágicas, estos deben luchar contra monstruos para proteger a la raza humana de una aniquilación segura. Un cazador muy débil llamado Sung Jinwoo se encuentra en una lucha en la que solo puede tratar de sobrevivir.\n"))
        series.add(Pelicula("Mi adorable demonio", R.drawable.adorabledemonio, R.drawable.adorabledemonios, "Un día las cosas comienzan a cambiar para ella, pues por obra de magia termina cruzando caminos con Jung Koo Won, quien en realidad es un demonio que termina perdiendo sus poderes por lo tanto ahora se ha vuelto como cualquier hombre más en la Tierra."))
        series.add(Pelicula("El Monstruo de la Vieja Seúl", R.drawable.elmonstruo, R.drawable.elmonstruovieja, "Gyeongseong, 1945. En la oscura era colonial de Seúl, un empresario y una investigadora luchan por sobrevivir y se enfrentan a un monstruo nacido de la avaricia humana. Ve todo lo que quieras."))
        series.add(Pelicula("Witcher", R.drawable.thewitcher, R.drawable.thewitchers, "Geralt de Rivia, un cazador de monstruos mutante, viaja en pos de su destino por un mundo turbulento en el que, a menudo, los humanos son peores que las bestias. Ve todo lo que quieras. Henry Cavill protagoniza esta saga épica de monstruos, magia y destino basada en las novelas de Andrzej Sapkowski."))
    }
}

class PeliculaAdapter: BaseAdapter {
    var peliculas = ArrayList<Pelicula>()
    var context: Context? = null

    constructor(context: Context, peliculas: ArrayList<Pelicula>): super(){
        this.peliculas = peliculas
        this.context = context
    }

    override fun getCount(): Int {
        return peliculas.size
    }

    override fun getItem(position: Int): Any {
        return peliculas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(pe: Int, p1: View?, p2: ViewGroup?): View {
        var pelicula = peliculas[pe]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.peliculas, null)
        var image: ImageView = vista.findViewById(R.id.image_movie_cell)
        var title: TextView = vista.findViewById(R.id.movie_title_cell)

        image.setImageResource(pelicula.image)
        title.setText(pelicula.titulo)

        image.setOnClickListener(){
            val intento = Intent(context, detalle_pelicula::class.java)
            intento.putExtra("titulo", pelicula.titulo)
            intento.putExtra("imagen", pelicula.image)
            intento.putExtra("header", pelicula.header)
            intento.putExtra("sinopsis", pelicula.sinopsis)
            context!!.startActivity(intento)
        }
        return vista
    }
}
