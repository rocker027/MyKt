package com.example.mykt.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mykt.R
import com.example.mykt.viewmodel.CoroutineViewModel
import kotlinx.coroutines.*

class CoroutineFragment : Fragment() {

    companion object {
        fun newInstance() = CoroutineFragment()
    }

    private lateinit var viewModel: CoroutineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.coroutine_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CoroutineViewModel::class.java)
        // TODO: Use the ViewModel

        GlobalScope.launch (Dispatchers.IO){
            println("test")
        }
    }

}
