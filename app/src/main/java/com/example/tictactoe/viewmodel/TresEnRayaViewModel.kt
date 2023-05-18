package com.example.tictactoe.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

enum class Player { X, O }

class TresEnRayaViewModel() : ViewModel() {

    private val _board = mutableStateMapOf<List<Int>, Player?>(
        listOf(0, 0) to null,
        listOf(0, 1) to null,
        listOf(0, 2) to null,
        listOf(1, 0) to null,
        listOf(1, 1) to null,
        listOf(1, 2) to null,
        listOf(2, 0) to null,
        listOf(2, 1) to null,
        listOf(2, 2) to null,
    )
    val board get() = _board.toMap()




    private var _playerInTurn by mutableStateOf(Player.X)
    val playerInTurn get() = _playerInTurn

    private var _winner by mutableStateOf<Player?>(null)
    val winner get() = _winner


    fun onClick(row: Int, column: Int) {
        _winner?.let { return }
        if (isCellValueAlreadySet(row, column)) return
        _board[listOf(row, column)] = _playerInTurn
        if (isWinningMove(playerInTurn, row, column)) _winner = playerInTurn
        else changeTurn()
    }

    private fun changeTurn() {
        _playerInTurn = if (_playerInTurn == Player.X) Player.O else Player.X
    }

    private fun isCellValueAlreadySet(row: Int, col: Int) = _board[listOf(row, col)] != null

    fun onReset() {
        _board.mapValuesTo(_board) { null }
        // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map-values-to.html
        //https://www.bezkoder.com/kotlin-map-transform/
        _winner = null
        _playerInTurn = Player.X
    }


    private fun isWinningMove(player: Player, row: Int, col: Int) =
        // 3-in-the-row
        (board[listOf(row, 0)] == player
                && board[listOf(row, 1)] == player
                && board[listOf(row, 2)] == player)
                || // 3-in-the-column
                (board[listOf(0, col)] == player
                        && board[listOf(1, col)] == player
                        && board[listOf(2, col)] == player)
                || // 3-in-the-diagonal
                (row == col && board[listOf(0, 0)] == player
                        && board[listOf(1, 1)] == player
                        && board[listOf(2, 2)] == player)
                || // 3-in-the-opposite-diagonal
                (row + col == 2 && board[listOf(0, 2)] == player
                        && board[listOf(1, 1)] == player
                        && board[listOf(2, 0)] == player)


}

