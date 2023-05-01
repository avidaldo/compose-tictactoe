package com.example.tictactoe.view

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tictactoe.viewmodel.TresEnRayaViewModel

private val SPACE_DEFAULT = 8.dp
private val BOARD_PADDING = 25.dp

@Composable
fun VerticalBoard(viewModel: TresEnRayaViewModel) {

   // val gameUiState by viewModel.uiState.collectAsState()
  //  val boardState by viewModel.board.collectAsState()

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
                    ) {
                        Log.d("---", "($row,$column)")
                        Text(text = viewModel.getBoardValueString(row,column))

                      //  Text(text = viewModel.board.get(row+column)?.stringValue ?: "")
                    }
                }
            }
        }

    }
}
