package com.example.tictactoe.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tictactoe.model.TresEnRayaModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class TresEnRayaViewModel() : ViewModel() {

    private val _uiState = MutableStateFlow(GameUIState())
    val uiState = _uiState.asStateFlow()


    fun onClick(row: Int, col: Int) {
        _uiState.value = _uiState.value.copy(board = _uiState.value.board.apply {
            this[1][1].value = GameUIState.Companion.Player.X
        })
 /*       _uiState.update {
            it.marcar(row, col)
            it.copy(board = it.board)
        }*/
    }

    fun onReset() {
        //_uiState.update { it.apply { reiniciar() } }
    }

}

