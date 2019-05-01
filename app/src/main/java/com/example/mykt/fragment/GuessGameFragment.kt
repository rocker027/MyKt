package com.example.mykt.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.mykt.R
import com.example.mykt.databinding.GuessGameFragmentBinding
import com.example.mykt.viewmodel.GuessGameViewModel


class GuessGameFragment : Fragment() {

    companion object {
        fun newInstance() = GuessGameFragment()
    }

    private lateinit var viewModel: GuessGameViewModel
    private lateinit var binding: GuessGameFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.guess_game_fragment, container, false)
        return binding.root
    }

    private fun showDialog(title: String, msg: String) {
        AlertDialog.Builder(this.context)
            .setTitle(title)
            .setMessage(msg)
            .setPositiveButton("OK", null)
            .show()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GuessGameViewModel::class.java)
        binding.btnSend.setOnClickListener { v ->
            if (binding.edtInput.text.isEmpty()) {
                showDialog("Error", "Please input number")
            } else {
                var diff = viewModel.validateNumber(binding.edtInput.text.toString().toInt())
                if (diff > 0) {
                    showDialog("Message", "Bigger")
                } else if (diff < 0) {
                    showDialog("Message", "smaller")
                } else {
                    showDialog("Congratulations", "You win")
                    viewModel.resetSecretNumber()
                }
            }
        }
    }

}
