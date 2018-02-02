package edu.rvc.student.randomguess

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get random number 1-100001
        var number = ((Math.random () * 100001) + 1) .toInt()
        //get random number 0-100000
        //var number = (Math.random () * 100001) .toInt()

        //use toast to alert user
        Toast.makeText ( this, "Number to remember: ${number}", Toast.LENGTH_LONG) .show ()

        val txtGuess = findViewById<EditText>(R.id.txtGuess)
        val btnGuess = findViewById<Button>(R.id.btnGuess)
        val btnToast = findViewById<Button>(R.id.btnToast)

        btnGuess.setOnClickListener {
            if (number == txtGuess.text.toString (). toInt ()) {
                Toast.makeText ( this, "Correct, great job remembering.", Toast.LENGTH_LONG) .show()
                txtGuess.setText("")
            }
            else {
                Toast.makeText ( this, "Incorrect, it's not the number shown.", Toast.LENGTH_LONG) .show()
                txtGuess.setText("")
            }

            hideKeyboard()

        }

        btnToast.setOnClickListener{
            number = ((Math.random () * 100001) + 1) .toInt ()
            println(number)
            Toast.makeText ( this, "Number to remember: ${number}", Toast.LENGTH_LONG) .show()
        }

    }

    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }

}
