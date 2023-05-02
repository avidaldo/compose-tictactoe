package com.example.tictactoe.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private val SPACE_DEFAULT = 8.dp
private val BOARD_PADDING = 25.dp

@Composable
fun VerticalBoard(
    onClick: (Int, Int) -> Unit,
    getCellString: (Int, Int) -> String,
) {

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
                        onClick = { onClick(row, column) },
                        Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                    ) {
                        //Log.d("---", "($row,$column)")
                        Text(text = getCellString(row, column))
                    }
                }
            }
        }

    }
}
