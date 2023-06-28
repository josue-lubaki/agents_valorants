package presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberAsyncImagePainter
import domain.model.Agent
import presentation.common.Fonts
import utils.Colors

/**
 * created by Josue Lubaki
 * date : 2023-05-02
 * version : 1.0.0
 */

@Composable
fun DetailScreen(
    viewModel : DetailViewModel,
    modifier: Modifier = Modifier,
    agentUuid : String
) {

    val state by viewModel.state.collectAsState()
    val agentDetails = remember { viewModel.agentDetails }

    LaunchedEffect(key1 = agentUuid) {
        viewModel.loadMovie(agentUuid)
    }

    Box(
        contentAlignment = Alignment.Center,
    ){
        agentDetails.value.let { agent ->
            if (agent != null) {
                DetailContent(
                    agent = agent,
                    modifier = modifier,
                )
            }

        }

        if(state is DetailState.Loading){
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ){
                CircularProgressIndicator(
                    color = Colors.Red
                )
            }
        }
    }
}

@Composable
fun DetailContent(
    agent: Agent,
    modifier: Modifier
) {
    val colors = listOf(
        MaterialTheme.colorScheme.onBackground,
        MaterialTheme.colorScheme.secondaryContainer
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors))
    ) {

        Image(
            painter = rememberAsyncImagePainter(
                url = agent.fullPortrait!!,
            ),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
        ){
            Text (
                text = agent.displayName!!,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.background,
                fontFamily = Fonts.valorant()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Role : ${agent.role}".uppercase(),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = agent.description!!,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Justify
            )
        }
    }
}