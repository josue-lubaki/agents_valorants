//package presentation.common
//
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.compose.animation.slideInHorizontally
//import androidx.compose.animation.slideOutHorizontally
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.material.Icon
//import androidx.compose.material.IconButton
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//
///**
// * created by Josue Lubaki
// * date : 2023-04-30
// * version : 1.0.0
// */
//
//@Composable
//fun MovieAppBar(
//    modifier: Modifier = Modifier,
//    background: Color = MaterialTheme.colors.onBackground,
//    title: String,
//    iconVisible: Boolean = true,
//    onNavigateBack: () -> Unit
//) {
//
//    Surface(
//        modifier = modifier
//            .fillMaxWidth()
//            .height(56.dp),
//        elevation = 1.dp,
//        color = background
//    ){
//
//        Row(
//            modifier = Modifier
//                .padding(start = 8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            AnimatedVisibility(
//                visible = iconVisible,
//                enter = fadeIn() + slideInHorizontally(),
//                exit = fadeOut() + slideOutHorizontally()
//            ) {
//                IconButton(onClick = onNavigateBack) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = "Back",
//                        tint = Color.White,
//                    )
//                }
//                Spacer(modifier = Modifier.width(24.dp))
//            }
//
//            Text(
//                text = title,
//                style = MaterialTheme.typography.h6,
//                modifier = Modifier.padding(12.dp),
//                color = Color.White
//            )
//        }
//    }
//}