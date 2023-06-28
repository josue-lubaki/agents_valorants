package presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberAsyncImagePainter
import domain.model.Agent
import org.jetbrains.compose.resources.ExperimentalResourceApi

/**
 * created by Josue Lubaki
 * date : 2023-04-30
 * version : 1.0.0
 */

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MovieListItem(
    modifier: Modifier = Modifier,
    agent: Agent,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .requiredHeight(320.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
    ){
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.85f))
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = rememberAsyncImagePainter(
                        url = agent.fullPortrait!!,
                        contentScale = ContentScale.Crop,
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(
                                bottomStart = 2.dp,
                                bottomEnd = 2.dp,
                            )
                        )
                )
            }

            Column(
                modifier = Modifier.padding(10.dp),
            ) {
                Text(
                    text = agent.displayName!!,
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.background
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = agent.description!!,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.background
                )
            }

        }
    }
}