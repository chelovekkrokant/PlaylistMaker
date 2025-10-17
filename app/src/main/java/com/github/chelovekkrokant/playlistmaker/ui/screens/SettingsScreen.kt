package com.github.chelovekkrokant.playlistmaker.ui.screens

import android.content.Intent
import android.content.Intent.createChooser
import android.util.Log
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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
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
    val context = LocalContext.current
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
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, context.getString(R.string.share_message))
                }
                val chooserIntent = createChooser(shareIntent, "")
                context.startActivity(chooserIntent)
            }
        )
        ScreensColumnItem(
            Icons.Default.SupportAgent,
            R.string.write_to_support,
            onClick =  {
                val writeToSupportIntent = Intent(Intent.ACTION_SENDTO)
                writeToSupportIntent.data = "mailto:".toUri()
                writeToSupportIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(context.getString(R.string.write_to_support_email)))
                writeToSupportIntent.putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.write_to_support_subject))
                writeToSupportIntent.putExtra(Intent.EXTRA_TEXT, context.getString(R.string.write_to_support_text))
                try {
                    context.startActivity(writeToSupportIntent)
                } catch (e: Exception) {
                    Log.e("EMAIL_ERROR", "Failed to open email: ${e.message}")
                }
            }
        )
        ScreensColumnItem(
            Icons.AutoMirrored.Filled.ArrowForwardIos,
            R.string.user_agreement,
            onClick = {
                val userAgreementIntent = Intent(Intent.ACTION_VIEW)
                userAgreementIntent.data = context.getString(R.string.user_agreement_uri).toUri()
                context.startActivity(userAgreementIntent)
            }
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
                .width(32.dp)
                .fillMaxHeight()
                .clickable(onClick = { onClick() }),
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