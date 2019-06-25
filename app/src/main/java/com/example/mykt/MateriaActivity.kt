package com.example.mykt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_materia.*
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

        fab.setOnClickListener {
            alert {
                title = "Replay Game"
                message = "Are you sure"
                positiveButton("Yes", {
                    secretNumber.reset()
                    edt_input.setText("")
                })
                negativeButton("Cancel", {})
            }.show()
        }
    }
}
