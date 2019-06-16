package com.example.mykt.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mykt.R
import com.example.mykt.viewmodel.SeatViewModel
import kotlinx.android.synthetic.main.seat_fragment.*
import kotlinx.coroutines.delay

class SeatFragment : Fragment() , View.OnClickListener{
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun newInstance() = SeatFragment()
    }

    private lateinit var viewModel: SeatViewModel
    lateinit var layout : ViewGroup

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.seat_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SeatViewModel::class.java)
        // TODO: Use the ViewModel
        layoutSeat
    }

}
