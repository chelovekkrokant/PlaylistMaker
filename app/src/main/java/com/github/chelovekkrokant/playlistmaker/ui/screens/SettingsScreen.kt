package com.github.chelovekkrokant.playlistmaker.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.chelovekkrokant.playlistmaker.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(onBackClick: () -> Unit) {
    CommonScaffold(
        titleId = R.string.settings,
        onBackClick = onBackClick,
        content = { SettingsScreenContent() },
    )
}

@Composable
fun SettingsScreenContent() {
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        ScreensColumnItem(
            Icons.Default.ToggleOff,
            R.string.dark_theme,
        )
        ScreensColumnItem(
            Icons.Default.Share,
            R.string.share_app,
        )
        ScreensColumnItem(
            Icons.Default.SupportAgent,
            R.string.write_to_support,
        )
        ScreensColumnItem(
            Icons.AutoMirrored.Filled.ArrowForwardIos,
            R.string.user_agreement,
        )
    }
}

@Composable
fun ScreensColumnItem(
    endIcon : ImageVector,
    textId: Int = R.string.favorites,
    onClick: () -> Unit = {}
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(61.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(textId),
            modifier = Modifier
                .weight(1f)
                .height(19.dp)
                .padding(start = 16.dp),
            fontFamily = FontFamily(Font(R.font.yandex_text_medium)),
            fontWeight = FontWeight.Medium,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
            )
        )
        Image(
            modifier = Modifier
                .padding(end = 16.dp)
                .clickable(onClick = { onClick() })
                .fillMaxHeight(),
            imageVector = endIcon,
            contentDescription = null,
        )
    }
}

@Preview(name = "portrait", showSystemUi = true,
    device = "spec:width=360dp,height=800dp, orientation=portrait")
@Preview(name = "landscape", showSystemUi = true,
    device = "spec:width=360dp,height=800dp, orientation=landscape")
@Composable
fun SettingsScreenPreview() {
    SettingsScreen {}
}