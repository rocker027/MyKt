package com.example.mykt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mykt.R
import com.example.mykt.databinding.GuessGameFragmentBinding
import com.example.mykt.viewmodel.GuessGameViewModel
import org.jetbrains.anko.support.v4.alert


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
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GuessGameViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.isShowDailog.observe(this, Observer {
            if (it == false) {
                return@Observer
            }

            alert {
                title = viewModel.dataModel.msgTitle
                message = viewModel.dataModel.msgContent
            }.show()

        })

//        viewModel.guessNumberLiveData.observe(this, Observer {
//            binding.edtInput.setText(it)
//
//        })
    }
}
