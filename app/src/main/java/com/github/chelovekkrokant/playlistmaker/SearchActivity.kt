package com.github.chelovekkrokant.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
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


class SearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchScreen()
        }
    }

    @Composable
    fun SearchScreen() {
        val context = LocalContext.current

        Column() {
            HeaderWithBackToHomeButton(R.string.search)
            SearchComplexButton()
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
                    val displayIntent = Intent(this@SearchActivity, MainActivity::class.java)
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

    @Composable
    fun SearchComplexButton(){
        val context = LocalContext.current
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ){
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    Toast.makeText(
                        context,
                        "Выполняем поиск",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE6E8EB)
                ),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp)
            ){
                Row(
                    modifier = Modifier
                        .padding(start = 28.dp, top = 18.dp, bottom = 18.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ){
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = Color(0xFFAEAFB4)
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp),
                        text = stringResource(R.string.search),
                        fontFamily = FontFamily(Font(R.font.yandex_text_medium)),
                        fontWeight = FontWeight.Medium,
                        style = TextStyle(
                            color = Color(0xFFAEAFB4),
                            fontSize = 22.sp,
                        ))
                }
            }
        }
    }


    @Preview(name = "portrait", showSystemUi = true,
        device = "spec:width=360dp,height=800dp, orientation=portrait")
    @Preview(name = "landscape", showSystemUi = true,
        device = "spec:width=360dp,height=800dp, orientation=landscape")
    @Composable
    fun SearchScreenPreview() {
        SearchScreen()
    }
}
