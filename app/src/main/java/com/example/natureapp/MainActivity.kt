package com.example.natureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.natureapp.ui.theme.NatureAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NatureApp()
        }
    }
}


data class NaturalPlace(
    val name: String,
    val description: String,
    val imageUrl: String
)

val naturalPlaces = listOf(
    NaturalPlace(
        "Dorne",
        "Region ubicada al sur de Westeros, La región es cálida y desértica en muchas áreas, pero también cuenta con zonas más fértiles, como las tierras alrededor del río Sangreverde.",
        "https://oyster.ignimgs.com/mediawiki/apis.ign.com/game-of-thrones/2/2e/Dorne_GoT.png"
    ),
    NaturalPlace(
        "Bosque Prohibido",
        "Denso y misterioso bosque ubicado en los terrenos de la Escuela Hogwarts. Lleno de criaturas mágicas y peligrosas, como centauros, acromántulas (arañas gigantes), unicornios, y thestrals. Los estudiantes tienen estrictamente prohibido entrar en el bosque, debido a los numerosos peligros que alberga.",
        "https://pm1.aminoapps.com/7770/85b31130b8a3dcf52d95e106e5d68726f1a3ee96r4-736-368_00.jpg"
    ),
    NaturalPlace(
        "Naboo",
        "Conocido por su belleza natural y su importancia política. Tiene vastos paisajes, desde llanuras verdes y montañas hasta extensos lagos y ciudades bajo el agua. La capital, Theed, es famosa por su arquitectura elegante y palacios.",
        "https://static.wikia.nocookie.net/esstarwars/images/7/7e/Attack_of_the_clones_3.jpg/revision/latest?cb=20181117021622"
    ),
    NaturalPlace(
        "Hobbiton",
        "Es el hogar de los hobbits, una raza pequeña y pacífica que disfruta de la vida tranquila, la buena comida, y la naturaleza. Hobbiton está rodeado de verdes colinas, con caminos sinuosos, jardines y ríos. Las casas de los hobbits están construidas dentro de colinas.",
        "https://st2.depositphotos.com/3542763/9941/i/450/depositphotos_99412300-stock-photo-bilbo-baggins-home.jpg"
    ),
    NaturalPlace(
        "Arrakis",
        "Arido, cubierto casi completamente por vastas dunas de arena y escasa vegetación, donde el agua es el recurso más valioso. A pesar de sus condiciones extremas, Arrakis es crucial debido a su monopolio sobre la producción de la especia melange, una sustancia que otorga longevidad, habilidades mentales mejoradas y es fundamental para la navegación interestelar.",
        "https://pbs.twimg.com/media/Exo_lKBVgAAwdWS.jpg"
    )
)



@Composable
fun NatureApp() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn {
                items(naturalPlaces) { place ->
                    NaturalPlaceCard(place)
                }
            }
        }
    }
}

@Composable
fun NaturalPlaceCard(place: NaturalPlace) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column {
            Image(
                painter = rememberImagePainter(place.imageUrl),
                contentDescription = place.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = place.name,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = place.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}