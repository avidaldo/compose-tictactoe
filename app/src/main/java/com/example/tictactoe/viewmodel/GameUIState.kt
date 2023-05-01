package com.example.tictactoe.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.tictactoe.model.TresEnRayaModel


/*
data class Board(
    val button00: Player = NONE,
    val button01: Player = NONE,
    val button02: Player = NONE,
    val button10: Player = NONE,
    val button11: Player = NONE,
    val button12: Player = NONE,
    val button20: Player? = NONE,
    val button21: Player? = NONE,
    val button22: Player? = NONE,
)
*/





data class GameUIState(
    val board: Array<Array<TresEnRayaModel.Player?>> =
        Array(3) { Array<TresEnRayaModel.Player?>(3) { null } },
    var winner: Player? = null,
    var playerInTurn: Player = Player.X,
) {


/*    fun marcar(row: Int, col: Int): GameUIState {
        winner?.let { return this } // No se sigue marcando si el juego ha terminado
        //if (!isValida(row, col)) return // Celda inválida (la vista ya no debería permitirlo

        board[row][col] = playerInTurn
        if (isWinningMove(playerInTurn, row, col)) winner = playerInTurn
        else flipCurrentTurn()

        return this
    }*/

/*    private fun isWinningMove(player: Player, row: Int, col: Int) =
        // 3-in-the-row
        (board[row][0] == player && board[row][1] == player && board[row][2] == player)
                || // 3-in-the-column
                (board[0][col] == player && board[1][col] == player && board[2][col] == player)
                || // 3-in-the-diagonal
                (row == col && board[0][0] == player && board[1][1] == player && board[2][2] == player)
                || // 3-in-the-opposite-diagonal
                (row + col == 2 && board[0][2] == player && board[1][1] == player && board[2][0] == player)*/


    private fun flipCurrentTurn() {
        playerInTurn = if (playerInTurn === Player.X) Player.O else Player.X
    }

}
