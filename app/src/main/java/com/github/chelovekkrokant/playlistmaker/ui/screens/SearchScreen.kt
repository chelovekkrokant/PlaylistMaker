package com.github.chelovekkrokant.playlistmaker.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.chelovekkrokant.playlistmaker.R
import com.github.chelovekkrokant.playlistmaker.ui.viewmodels.SearchTextViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(onBackClick: () -> Unit) {
    val searchTextViewModel: SearchTextViewModel = viewModel ()
    CommonScaffold(
        titleId = R.string.search,
        onBackClick = onBackClick,
        content = { SearchScreenContent(searchTextViewModel) },
    )
}

@Composable
fun SearchScreenContent(searchTextViewModel: SearchTextViewModel) {
    val searchTextState = searchTextViewModel.searchText.collectAsState().value
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
        value = searchTextState,
        onValueChange = { searchTextViewModel.updateSearchText(it) },
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
            if(searchTextState.isNotEmpty()) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    tint = Color(0xFFAEAFB4),
                    contentDescription = "Очистить",
                    modifier = Modifier
                        .clickable(onClick = { searchTextViewModel.clearSearchText() })
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