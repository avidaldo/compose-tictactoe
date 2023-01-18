package com.example.tictactoe.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceEvenly
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import com.example.tictactoe.R
import com.example.tictactoe.viewmodel.TresEnRayaViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun Game(viewModel : TresEnRayaViewModel = viewModel()) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.tictactoe)) },
            actions = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Favorito")
                }
            }
        )
    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            when (LocalConfiguration.current.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> VerticalTicTacToe()
                Configuration.ORIENTATION_LANDSCAPE -> HorizontalTicTacToe()
                else -> throw RuntimeException()
            }
        }
    }
}

@Composable
fun HorizontalTicTacToe() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = SpaceEvenly,
        verticalAlignment = CenterVertically
    ) {
        HorizontalBoard()
        WinnerBlock()
    }
}


@Composable
fun VerticalTicTacToe() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = SpaceEvenly,
        horizontalAlignment = CenterHorizontally
    ) {
        VerticalBoard(onButtonSelecte)
        WinnerBlock()
    }
}

