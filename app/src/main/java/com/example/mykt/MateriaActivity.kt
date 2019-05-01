package com.example.mykt

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_materia.*

class MateriaActivity : AppCompatActivity(), GuessFragment.OnFragmentInteractionListener , GuessResultFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val secretNumber = SecretNumber()
    /**
     * MateriaActivity
     */
    val TAG = MateriaActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materia)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle("Replay Game")
                .setMessage("Are you sure")
                // inner class lamda
                .setPositiveButton("Yes", { dialog, which ->
                    secretNumber.reset()
                })
                .setNeutralButton("Cancel", null)
                .show()
        }


    }


}
