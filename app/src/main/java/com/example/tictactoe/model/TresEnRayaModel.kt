package com.example.tictactoe.model


class TresEnRayaModel {

    enum class Player { X, O }

    var tablero = Array(3) { Array<Player?>(3) { null } }
    var ganador: Player? = null
    var playerEnTurno = Player.X


    fun reiniciar() {
        clearCells()
        ganador = null
        playerEnTurno = Player.X
    }


    fun marcar(row: Int, col: Int): TresEnRayaModel {
        ganador?.let { return this } // No se sigue marcando si el juego ha terminado
        if (!isValida(row, col)) return this// Celda inválida (la vista ya no debería permitirlo

        tablero[row][col] = playerEnTurno
        if (isMovimientoGana(playerEnTurno, row, col)) ganador = playerEnTurno
        else cambiarTurno() // Cambia el Jugador en turno

        return this

    }


    private fun clearCells() {
        tablero = arrayOf()
        for (i in 0..2) for (j in 0..2) tablero[i][j] = null
    }

    private fun isValida(row: Int, col: Int) =
        !(isOutOfBounds(row) || isOutOfBounds(col) || isCeldaConValor(row, col))


    private fun isOutOfBounds(idx: Int) = idx < 0 || idx > 2

    private fun isCeldaConValor(row: Int, col: Int) = tablero[row][col] != null


    /** Devuelve true si el movimiento gana  */
    private fun isMovimientoGana(player: Player, fila: Int, columna: Int) =
        // 3-in-the-row
        (tablero[fila][0] == player
                && tablero[fila][1] == player
                && tablero[fila][2] == player)
                || // 3-in-the-column
                (tablero[0][columna] == player
                        && tablero[1][columna] == player
                        && tablero[2][columna] == player)
                || // 3-in-the-diagonal
                (fila == columna
                        && tablero[0][0] == player
                        && tablero[1][1] == player
                        && tablero[2][2] == player)
                || // 3-in-the-opposite-diagonal
                (fila + columna == 2
                        && tablero[0][2] == player
                        && tablero[1][1] == player
                        && tablero[2][0] == player)


    private fun cambiarTurno() {
        playerEnTurno = if (playerEnTurno == Player.X) Player.O else Player.X
    }


}