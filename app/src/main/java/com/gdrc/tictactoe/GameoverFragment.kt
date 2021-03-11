package com.gdrc.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.gdrc.tictactoe.databinding.FragmentGameBinding
import com.gdrc.tictactoe.databinding.FragmentGameoverBinding

/**
 * A simple [Fragment] subclass.
 * Use the [GameoverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameoverFragment : Fragment() {
    private lateinit var binding: FragmentGameoverBinding
    lateinit var winner: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gameover, container, false)
        val args = GameoverFragmentArgs.fromBundle(requireArguments())
        winner = "${args.winner} Won".capitalize()
        binding.gameOver = this
        binding.newGameButton.setOnClickListener { view: View ->
            view.findNavController().navigate(GameoverFragmentDirections.actionGameoverFragmentToGameFragment())
        }
        return binding.root
    }

}