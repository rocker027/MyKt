package com.example.mykt

import android.content.Context
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_guess.*
import kotlinx.android.synthetic.main.fragment_guess.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [GuessFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [GuessFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class GuessFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private var secretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    fun check(view: View) {
        val n = edt_input.text.toString().toInt()
        println("number : $n")
        val diff = secretNumber.validate(n)
        var msg = "yes , you got it"
        if (diff < 0) {
            msg = "Bigger"
        } else if (diff > 0) {
            msg = "Smaller"
        } else {

        }
        counter.setText(secretNumber.count.toString())

        showDialogMsg(msg)

    }

    private fun showDialogMsg(msg: String) {
        AlertDialog.Builder(this!!.context!!)
            .setTitle("Results")
            .setMessage(msg)
            .setPositiveButton("OK", DialogInterface.OnClickListener {
                    dialog, which ->
                val bundle = bundleOf("test_arg1" to "yes i am" , "test_arg2" to "monkey is monkey")
                view?.let { Navigation.findNavController(it).navigate(R.id.action_guessFragment_to_guessResultFragment , bundle) }
            })
            .show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_guess, container, false)
        view.btn_send.setOnClickListener { v -> check(v) }
//        view.btn_send.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_guessFragment_to_guessResultFragment) }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GuessFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GuessFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
