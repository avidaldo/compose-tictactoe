package com.example.tictactoe.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


enum class Player(val stringValue: String) { X("X"), O("O"), NONE("NONE") } // TODO: companion object?


class TresEnRayaViewModel() : ViewModel() {




    private val _board = mutableStateMapOf(
        listOf(0, 0) to Player.NONE,
        listOf(0, 1) to Player.NONE,
        listOf(0, 2) to Player.NONE,
        listOf(1, 0) to Player.NONE,
        listOf(1, 1) to Player.NONE,
        listOf(1, 2) to Player.NONE,
        listOf(2, 0) to Player.NONE,
        listOf(2, 1) to Player.NONE,
        listOf(2, 2) to Player.NONE,
    )

    val board get() = _board


    fun getBoardValueString(row: Int, column: Int): String {
        return board[listOf(row,column)]?.stringValue ?: "shit"
    }

    private var _playerInTurn by mutableStateOf(Player.X)
    val playerInTurn get() = _playerInTurn

    /*private val _uiState = MutableStateFlow(GameUIState())
    val uiState = _uiState.asStateFlow()*/


    fun onClick(row: Int, column: Int) {
        // Log.d("---", "($row,$col):${board[intArrayOf(row,col)]?.stringValue}")

        _board[listOf(row,column)] = _playerInTurn
        //Log.d("---", _board[intArrayOf(row, col)]!!.stringValue)
        changeTurn()
    }

    private fun changeTurn() {
        _playerInTurn = if (_playerInTurn == Player.X) Player.O else Player.X
    }

    fun onReset() {
        //_uiState.update { it.apply { reiniciar() } }
    }

    /*    fun marcar(row: Int, col: Int): GameUIState {
            //winner?.let { return this } // No se sigue marcando si el juego ha terminado
            //if (!isValida(row, col)) return // Celda inválida (la vista ya no debería permitirlo


            _board = playerInTurn
            if (isWinningMove(playerInTurn, row, col)) winner = playerInTurn
            else flipCurrentTurn()

            return this


        }*/

}

