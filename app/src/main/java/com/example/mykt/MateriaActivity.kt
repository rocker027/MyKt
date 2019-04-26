package com.example.mykt

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_materia.*
import kotlinx.android.synthetic.main.content_materia.*

class MateriaActivity : AppCompatActivity() {
    val secretNumber = SecretNumber()
    val TAG = MateriaActivity::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materia)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        btn_send.setOnClickListener{
            v: View? ->
            check(v!!)
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
        }
//        showToast()
        showDialogMsg(msg)

    }

    private fun showDialogMsg(msg: String) {
        AlertDialog.Builder(this)
            .setTitle("Results")
            .setMessage(msg)
            .setPositiveButton("OK", null)
            .show()
    }

    private fun showToast(msg: String) {
        // toast show msg
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}
