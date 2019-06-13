package com.example.mykt

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_materia.*
import kotlinx.android.synthetic.main.content_materia.*
import kotlinx.android.synthetic.main.guess_game_fragment.*
import org.jetbrains.anko.alert

class MateriaActivity : AppCompatActivity() {
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
            alert {
                title = "Replay Game"
                message = "Are you sure"
                positiveButton("Yes",{
                    secretNumber.reset()
                    edt_input.setText("")
                })
                negativeButton("Cancel",{})
            }.show()
//            AlertDialog.Builder(this)
//                .setTitle("Replay Game")
//                .setMessage("Are you sure")
//                 inner class lamda
//                .setPositiveButton("Yes", { dialog, which ->
//                    secretNumber.reset()
//                    edt_input.setText("")
//                })
//                .setNeutralButton("Cancel", null)
//                .show()
        }
    }
}
