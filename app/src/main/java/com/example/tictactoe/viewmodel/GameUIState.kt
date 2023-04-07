package com.example.tictactoe.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


data class GameUIState(
    val board: Array<Array<MutableState<Player?>>> = Array(3) { Array(3) { mutableStateOf(null) } },
    var winner: Player? = null,
    var playerInTurn: Player = Player.X,
) {

    companion object {
        enum class Player { X, O }
    }  // TODO: companion object?


    fun marcar(row: Int, col: Int): GameUIState {
        winner?.let { return this } // No se sigue marcando si el juego ha terminado
        //if (!isValida(row, col)) return // Celda inválida (la vista ya no debería permitirlo

        board[row][col].value = playerInTurn
        if (isWinningMove(playerInTurn, row, col)) winner = playerInTurn
        else flipCurrentTurn()

        return this


    }

    private fun isWinningMove(player: Player, row: Int, col: Int) =
        // 3-in-the-row
        (board[row][0].value!! == player && board[row][1].value == player && board[row][2].value == player)
                || // 3-in-the-column
                (board[0][col].value == player && board[1][col].value == player && board[2][col].value == player)
                || // 3-in-the-diagonal
                (row == col && board[0][0].value == player && board[1][1].value == player && board[2][2].value == player)
                || // 3-in-the-opposite-diagonal
                (row + col == 2 && board[0][2].value == player && board[1][1].value == player && board[2][0].value == player)


    private fun flipCurrentTurn() {
        playerInTurn = if (playerInTurn === Player.X) Player.O else Player.X
    }

}
