package com.example.mykt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mykt.R
import com.example.mykt.viewmodel.MainFunViewModel
import kotlinx.android.synthetic.main.main_fun_fragment.*
import kotlinx.android.synthetic.main.row_item_main_func.view.*
import org.jetbrains.anko.AnkoLogger

class MainFunFragment : Fragment(), AnkoLogger {

    companion object {
        fun newInstance() = MainFunFragment()
    }

    private lateinit var viewModel: MainFunViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fun_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainFunViewModel::class.java)
        val adapter = MainFunAdapter()
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = GridLayoutManager(context, 3)
        recyclerview.adapter = adapter

    }

    inner class MainFunAdapter : RecyclerView.Adapter<MainFunAdapter.MainFunViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFunViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_main_func, parent, false)
            return MainFunViewHolder(view)
        }

        override fun getItemCount(): Int {
            return viewModel.funList.size
        }

        override fun onBindViewHolder(holder: MainFunViewHolder, position: Int) {
            holder.bindView(viewModel.funList.get(position))

            holder.imgIv.setOnClickListener {
                NavHostFragment.findNavController(this@MainFunFragment)
                    .navigate(R.id.action_mainFunFragment_to_guessGameFragment)
            }
        }

        inner class MainFunViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bindView(title: String) {
                titleTv.text = title
            }

            val imgIv = itemView.iv_func_img
            val titleTv = itemView.tv_title
        }

    }
}
