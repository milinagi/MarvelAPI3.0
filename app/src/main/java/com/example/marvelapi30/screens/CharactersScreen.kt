package com.example.marvelapi30.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.marvelapi30.components.CharacterCardView
import com.example.marvelapi30.model.MarvelDb

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharactersScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar() {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Personajes")
            }
        }
    ) {
        CharacterBodyContent()
    }
}

@Composable
fun CharacterBodyContent() {
    CharacterCardView(MarvelDb.getAllCharacters())
}