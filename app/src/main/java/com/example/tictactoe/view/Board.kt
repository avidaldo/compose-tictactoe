package com.example.tictactoe.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tictactoe.viewmodel.TresEnRayaViewModel




private val SPACE_DEFAULT = 8.dp
private val BOARD_PADDING = 25.dp

@Composable
fun VerticalBoard(viewModel: TresEnRayaViewModel) {

    val gameUiState by viewModel.uiState.collectAsState()

    Column(
        Modifier.padding(BOARD_PADDING),
        verticalArrangement = Arrangement.spacedBy(
            space = SPACE_DEFAULT,
            alignment = Alignment.CenterVertically
        )
    ) {

        repeat(3) { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(SPACE_DEFAULT)) {
                repeat(3) { column ->
                    Button(
                        onClick = { viewModel.onClick(row, column) },
                        Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                    ) { gameUiState.board[row][column] }
                }
            }
        }

    }
}

@Composable
fun HorizontalBoard() {
    Row(
        Modifier.padding(BOARD_PADDING),
        horizontalArrangement = Arrangement.spacedBy(
            space = SPACE_DEFAULT,
            alignment = Alignment.CenterHorizontally
        )
    ) {

        repeat(3) {
            Column(verticalArrangement = Arrangement.spacedBy(SPACE_DEFAULT)) {
                repeat(3) {
                    Button(
                        onClick = { /*TODO*/ },
                        Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                    ) { /*TODO*/ }
                }
            }
        }

    }
}