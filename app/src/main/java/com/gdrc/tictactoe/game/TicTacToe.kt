package com.gdrc.tictactoe.game

class TicTacToe {
    private val x: String = "x"
    private val o: String = "o"
    private var turn: String = "x"
    private var board= arrayOf(
        arrayOf("", "", ""),
        arrayOf("", "", ""),
        arrayOf("", "", ""),
    )

    fun getBoard(): Array<Array<String>> {
        return this.board
    }

    fun getTurn(): String {
        return this.turn
    }
    fun play(i: Int, j: Int): Boolean {
        if (board[i][j] != "") {
            return false
        }
        board[i][j] = turn
        turn = if (turn == x) o else x
        return true
    }
    fun xWon(): Boolean {
        return itWon(x)
    }
    fun oWon(): Boolean {
        return itWon(o)
    }
    fun tie(): Boolean {
        if (
            board[0].indexOf("") == -1
            && board[1].indexOf("") == -1
            && board[2].indexOf("") == -1
        ) {
            return true
        }
        return false
    }
    private fun itWon(it: String): Boolean {
        //opossite to "it"
        val op = if (it == x) o else x
        //row 0
        if (board[0].indexOf(op) == -1 && board[0].indexOf("") == -1) {
            return true
        }
        //row 1
        if (board[1].indexOf(op) == -1 && board[1].indexOf("") == -1) {
            return true
        }
        //row 2
        if (board[2].indexOf(op) == -1 && board[2].indexOf("") == -1) {
            return true
        }
        //column 0
        if (board[0][0] == it && board[1][0] == it && board[2][0] == it) {
            return true
        }
        //column 1
        if (board[0][1] == it && board[1][1] == it && board[2][1] == it) {
            return true
        }
        //column 2
        if (board[0][2] == it && board[1][2] == it && board[2][2] == it) {
            return true
        }
        //diagonal 00 to 22
        if (board[0][0] == it && board[1][1] == it && board[2][2] == it) {
            return true
        }
        //diagonal 20 to 02
        if (board[2][0] == it && board[1][1] == it && board[0][2] == it) {
            return true
        }
        return false
    }
}