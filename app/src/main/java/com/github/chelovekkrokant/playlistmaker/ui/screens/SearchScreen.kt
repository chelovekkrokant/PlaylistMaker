package com.github.chelovekkrokant.playlistmaker.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(onBackClick: () -> Unit) {
    СommomScaffold(
        titleId = R.string.search,
        onBackClick = onBackClick,
        content = { SearchScreenContent() },
    )
}

@Composable
fun SearchScreenContent() {
    var searchText by remember { mutableStateOf("") }
    TextField(
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFE6E8EB),
            unfocusedContainerColor = Color(0xFFE6E8EB),
            disabledContainerColor = Color(0xFFE6E8EB),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        label = { Text("Поиск") },
        value = searchText,
        onValueChange = { searchText = it },
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(R.font.yandex_text_medium)),
            fontWeight = FontWeight.Medium,
            color = Color(0xFFAEAFB4),
            fontSize = 22.sp,
        ),
        leadingIcon = {
            Icon(Icons.Default.Search, "Поиск", tint = Color(0xFFAEAFB4))
        },
        trailingIcon = {
            if(searchText.isNotEmpty()) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    tint = Color(0xFFAEAFB4),
                    contentDescription = "Очистить",
                    modifier = Modifier
                        .clickable(onClick = { searchText = "" })
                )
            }
        },
    )
}

@Preview(name = "portrait", showSystemUi = true,
    device = "spec:width=360dp,height=800dp, orientation=portrait")
@Preview(name = "landscape", showSystemUi = true,
    device = "spec:width=360dp,height=800dp, orientation=landscape")
@Composable
fun SearchScreenPreview() {
    SearchScreen {}
}