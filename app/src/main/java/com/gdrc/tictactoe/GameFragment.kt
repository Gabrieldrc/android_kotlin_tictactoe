package com.gdrc.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.gdrc.tictactoe.databinding.FragmentGameBinding
import com.gdrc.tictactoe.game.TicTacToe

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private lateinit var game: TicTacToe
    lateinit var turn: String
    lateinit var board: Array<Array<String>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        newGame()
        binding.game = this

        binding.button00.setOnClickListener{play(0,0)}
        binding.button01.setOnClickListener{play(0,1)}
        binding.button02.setOnClickListener{play(0,2)}
        binding.button10.setOnClickListener{play(1,0)}
        binding.button11.setOnClickListener{play(1,1)}
        binding.button12.setOnClickListener{play(1,2)}
        binding.button20.setOnClickListener{play(2,0)}
        binding.button21.setOnClickListener{play(2,1)}
        binding.button22.setOnClickListener{play(2,2)}
        return binding.root
    }
    private fun newGame() {
        game = TicTacToe()
        turn = game.getTurn()
        board = game.getBoard()
    }
    private fun play(i: Int, j: Int) {
        val couldItPlay = game.play(i, j)
        if (couldItPlay) {
            if (game.xWon()) {
                this.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameoverFragment("x"))
            }
            if (game.oWon()) {
                this.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameoverFragment("o"))
            }
            if (game.tie()) {
                this.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameoverFragment("No one"))
            }
            turn = game.getTurn()
            board = game.getBoard()
            binding.invalidateAll()
        }
    }
}