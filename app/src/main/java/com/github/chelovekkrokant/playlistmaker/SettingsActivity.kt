package com.github.chelovekkrokant.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.github.chelovekkrokant.playlistmaker.MainActivity
import com.github.chelovekkrokant.playlistmaker.R

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsScreen()
        }
    }


    @Composable
    fun SettingsScreen() {

        val context = LocalContext.current
        HeaderWithBackToHomeButton(R.string.settings)
        AnotherCustomBoxRow(
            80,
            Icons.Default.ToggleOff,
            com.github.chelovekkrokant.playlistmaker.R.string.dark_theme,
            {
                Toast.makeText(
                    context,
                    "Нажата кнопка ${context.getString(com.github.chelovekkrokant.playlistmaker.R.string.search)}",
                    Toast.LENGTH_SHORT
                ).show()
            })
        AnotherCustomBoxRow(
            141,
            Icons.Default.Share,
            com.github.chelovekkrokant.playlistmaker.R.string.share_app,
            {
                Toast.makeText(
                    context,
                    "Нажата кнопка ${context.getString(com.github.chelovekkrokant.playlistmaker.R.string.search)}",
                    Toast.LENGTH_SHORT
                ).show()
            })
        AnotherCustomBoxRow(
            202,
            Icons.Default.SupportAgent,
            com.github.chelovekkrokant.playlistmaker.R.string.write_to_support,
            {
                Toast.makeText(
                    context,
                    "Нажата кнопка ${context.getString(com.github.chelovekkrokant.playlistmaker.R.string.search)}",
                    Toast.LENGTH_SHORT
                ).show()
            })
        AnotherCustomBoxRow(
            263,
            Icons.AutoMirrored.Filled.ArrowForwardIos,
            com.github.chelovekkrokant.playlistmaker.R.string.user_agreement,
            {
                Toast.makeText(
                    context,
                    "Нажата кнопка ${context.getString(com.github.chelovekkrokant.playlistmaker.R.string.search)}",
                    Toast.LENGTH_SHORT
                ).show()
            })


    }

    @Composable
    fun AnotherCustomBoxRow(
        topPadding : Int,
        endIcon : ImageVector,
        textId: Int = com.github.chelovekkrokant.playlistmaker.R.string.favorites,
        onClick : () -> Unit
    ){
        // Row with info
        Row(
            modifier = Modifier
                .padding(top = topPadding.dp)
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
                fontFamily = FontFamily(Font(com.github.chelovekkrokant.playlistmaker.R.font.yandex_text_medium)),
                fontWeight = FontWeight.Medium,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                )
            )
            Image(
                modifier = Modifier
                    .padding(end = 16.dp),
                imageVector = endIcon,
                contentDescription = null,
                alignment = Alignment.BottomEnd
            )
        }
    }

    @Composable
    fun HeaderWithBackToHomeButton(
        textId : Int
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .padding(top = 4.dp, start = 4.dp, bottom = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                onClick = {
                    val displayIntent = Intent(this@SettingsActivity, MainActivity::class.java)
                    startActivity(displayIntent)
                },
                content = {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                },
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(0.dp)
            )
            Text(
                text = stringResource(textId),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp),
                fontFamily = FontFamily(Font(com.github.chelovekkrokant.playlistmaker.R.font.yandex_text_medium)),
                fontWeight = FontWeight.Medium,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 22.sp,
                )
            )
        }
    }

    @Preview(name = "portrait", showSystemUi = true,
        device = "spec:width=360dp,height=800dp, orientation=portrait")
    @Preview(name = "landscape", showSystemUi = true,
        device = "spec:width=360dp,height=800dp, orientation=landscape")
    @Composable
    fun SettingsScreenPreview() {
        SettingsScreen()
    }
}
