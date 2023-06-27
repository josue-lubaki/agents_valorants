package presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import platform.font

/**
 * created by Josue Lubaki
 * date : 2023-06-27
 * version : 1.0.0
 */

object Fonts {
    @Composable
    fun valorant() = FontFamily(
        font(
            "Valorant Font",
            "valorant_font",
            FontWeight.Normal,
            FontStyle.Normal
        ),
    )
}