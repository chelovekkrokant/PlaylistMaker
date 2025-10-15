package com.github.chelovekkrokant.playlistmaker.ui.screens

import android.widget.Toast
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
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
import com.github.chelovekkrokant.playlistmaker.R

@Composable
fun MainScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF3772E7))
    )
    {
        // Panel header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(304.dp)
                    .wrapContentHeight()
                    .padding(top = 4.dp, start = 4.dp)
            ){
                Box(
                    modifier = Modifier
                        .width(208.dp)
                        .height(48.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        modifier = Modifier
                            .padding(4.dp)
                            .wrapContentSize(),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 22.sp,
                        ),
                        fontFamily = FontFamily(Font(R.font.yandex_text_medium)),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        // Menu
        Column(
            Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
                .weight(1f)
        )
        {
            Column(
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                CustomBoxRow(
                    Icons.Default.Search,
                    Icons.AutoMirrored.Default.KeyboardArrowRight,
                    R.string.search
                ) {}
                CustomBoxRow(
                    Icons.Default.LibraryMusic,
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    R.string.playlists
                ) {
                    Toast.makeText(
                        context,
                        "Нажата кнопка ${context.getString(R.string.playlists)}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                CustomBoxRow(
                    Icons.Default.FavoriteBorder,
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    R.string.favorites
                ) {
                    Toast.makeText(
                        context,
                        "Нажата кнопка ${context.getString(R.string.favorites)}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                CustomBoxRow(
                    Icons.Default.Settings,
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    R.string.settings
                ) {}
            }
        }
    }
}

@Composable
fun CustomBoxRow(
    startIcon: ImageVector,
    endIcon : ImageVector,
    textId: Int = R.string.favorites,
    onClick : () -> Unit
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp),
        shape = RoundedCornerShape(0.dp),
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black),
        contentPadding = PaddingValues(0.dp)
    ) {
        // Row with info
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 18.dp, bottom = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                modifier = Modifier,
                alignment = Alignment.CenterStart,
                imageVector = startIcon,
                contentDescription = null
            )
            Text(
                text = stringResource(textId),
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically)
                    .weight(1f),
                fontFamily = FontFamily(Font(R.font.yandex_text_medium)),
                fontWeight = FontWeight.Medium,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 22.sp,
                )
            )
            Image(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically),
                imageVector = endIcon,
                contentDescription = null
            )
        }
    }
}

@Preview(name = "portrait", showSystemUi = true,
    device = "spec:width=360dp,height=800dp, orientation=portrait")
@Preview(name = "landscape", showSystemUi = true,
    device = "spec:width=360dp,height=800dp, orientation=landscape")
@Composable
fun MainScreenPreview() {
    MainScreen()
}