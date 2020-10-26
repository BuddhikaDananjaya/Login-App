package com.example.reloginapp
import Extensions.isEmailValid
import Extensions.isPassWordValid
import android.app.ProgressDialog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class LoginActivity : AppCompatActivity() {
    var mProgress: ProgressDialog? = null
    var runnable: Runnable? = null
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mProgress = ProgressDialog(this);
        mProgress!!.setTitle("Processing...");
        mProgress!!.setMessage("Please wait...");
        mProgress!!.setCancelable(false);
        mProgress!!.setIndeterminate(true);
    }
    fun Validate(view: View) {

        var email: String = etEmail.text.toString()
        var password: String = etPassword.text.toString()

        if(email.isEmpty())
        {
            etEmail?.error =  getString(R.string.email_empty)

        }else if(email.isEmailValid() != true){

            etEmail?.error = getString(R.string.enter_valid_email_address)

        }else  if(password.isEmpty()) {


            etPassword?.error = getString(R.string.password_empty)

        } else if (password.isPassWordValid() != true){

            etPassword?.error = getString(R.string.enter_valid_password)

        } else if (email.isEmailValid() && password.isPassWordValid()) {
            Toast.makeText(
                applicationContext,
                R.string.login_success, Toast.LENGTH_SHORT
            ).show()

            runnable = Runnable {
                if (!isFinishing) {
                    var intent = Intent(this, Home_navAvtivity::class.java)
                    startActivity(intent)
                    mProgress!!.dismiss()
                    finish()
                }
            }
            mProgress!!.show();
            handler.postDelayed(runnable!!, 1000)
        }





    }

    fun btnSignup(view: View) {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }

}