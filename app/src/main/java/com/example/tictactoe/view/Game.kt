package com.example.tictactoe.view

import androidx.compose.foundation.layout.Arrangement.SpaceEvenly
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tictactoe.R
import com.example.tictactoe.viewmodel.TresEnRayaViewModel


@Composable
fun Game(viewModel: TresEnRayaViewModel = viewModel()) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.tictactoe)) },
            actions = {
                IconButton(onClick = { viewModel.onReset() }) {
                    Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Favorito")
                }
            }
        )
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = SpaceEvenly,
            horizontalAlignment = CenterHorizontally
        ) {
            VerticalBoard(viewModel)
        }

    }
}



