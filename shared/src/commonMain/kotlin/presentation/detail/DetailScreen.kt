//package presentation.detail
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.requiredHeight
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.Button
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.CircularProgressIndicator
//import androidx.compose.material.Icon
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import com.seiko.imageloader.rememberAsyncImagePainter
//import org.jetbrains.compose.resources.ExperimentalResourceApi
//import org.jetbrains.compose.resources.painterResource
//import utils.Colors
//
///**
// * created by Josue Lubaki
// * date : 2023-05-02
// * version : 1.0.0
// */
//
//@Composable
//fun DetailScreen(
//    viewModel : DetailViewModel,
//    modifier: Modifier = Modifier,
//    movieId : Int
//) {
//
//    val state by viewModel.state.collectAsState()
//    val movieDetail = remember { viewModel.movieDetails }
//
//    LaunchedEffect(key1 = movieId) {
//        viewModel.loadMovie(movieId)
//    }
//
//    Box(
//        contentAlignment = Alignment.Center,
//    ){
//        movieDetail.value.let { movie ->
//            if (movie != null) {
//                DetailContent(
//                    movie = movie,
//                    modifier = modifier,
//                )
//            }
//
//        }
//
//        if(state is DetailState.Loading){
//            Row(
//                modifier = Modifier.fillMaxSize(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center,
//            ){
//                CircularProgressIndicator(
//                    color = Colors.Red
//                )
//            }
//        }
//    }
//
//}
//
//@OptIn(ExperimentalResourceApi::class)
//@Composable
//fun DetailContent(
//    movie: Movie,
//    modifier: Modifier
//) {
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .background(color = MaterialTheme.colors.onBackground)
//    ) {
//
//        Image(
//            painter = rememberAsyncImagePainter(
//                url = movie.posterImage,
//            ),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .fillMaxWidth()
//                .requiredHeight(440.dp)
//        )
//
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(1f)
//                .padding(20.dp)
//                .verticalScroll(rememberScrollState())
//        ){
//            Text (
//                text = movie.title,
//                style = MaterialTheme.typography.h5,
//                modifier = Modifier.align(Alignment.CenterHorizontally),
//                fontWeight = FontWeight.Bold,
//                color = MaterialTheme.colors.background
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            Button(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(48.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = Colors.Red,
//                    contentColor = Color.White
//                ),
//                elevation = ButtonDefaults.elevation(0.dp),
//                onClick = { /*TODO*/ }
//            ) {
//                Icon(
//                    painter = painterResource("play_button.xml"),
//                    contentDescription = null,
//                    tint = Color.White,
//                )
//
//                Spacer(modifier = Modifier.width(8.dp))
//
//                Text(text = "Start watching now")
//
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Text(
//                text = "Released in ${movie.releaseDate}".uppercase(),
//                style = MaterialTheme.typography.overline,
//                color = MaterialTheme.colors.background
//            )
//
//            Spacer(modifier = Modifier.height(4.dp))
//
//            Text(
//                text = movie.overview,
//                style = MaterialTheme.typography.body2,
//                color = MaterialTheme.colors.background
//            )
//        }
//    }
//}