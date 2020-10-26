package com.example.reloginapp

import Extensions.isEmailValid
import Extensions.isNamevalid
import Extensions.isPassWordValid
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when(item.itemId){
            R.id.back -> {
                var intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    fun Validate(view: View) {

        var name:String = etFname.text.toString()
        var lasname:String = etLname.text.toString()
        var email: String = etEmail.text.toString()
        var password: String = etPassword.text.toString()
        var cpassword: String = etCpassword.text.toString()

        if(name.isEmpty())
        {
            etFname?.error = getString(R.string.name_empty)

        } else if(name.isNamevalid() != true){

            etFname?.error = getString(R.string.enter_valid_name)

        }else if(lasname.isEmpty())
        {

            etLname?.error = getString(R.string.last_name_empty)

        }  else if(lasname.isNamevalid() != true){

            etLname?.error = getString(R.string.enter_the_valid_last_name)

        } else if(email.isEmpty())
        {

            etEmail?.error = getString(R.string.email_empty)

        }else if(email.isEmailValid() != true){

            etEmail?.error = getString(R.string.enter_valid_email_address)

        }else  if(password.isEmpty()) {

            etPassword?.error = getString(R.string.password_empty)

        } else if (password.isPassWordValid() != true){

            etPassword?.error = getString(R.string.enter_valid_password)

        }
        else  if(cpassword.isEmpty()) {

            etCpassword?.error = getString(R.string.confirm_password_empty)

        } else if (cpassword.equals(password)){

            etCpassword?.error = getString(R.string.passwords_are_not_matching)

        }else if (email.isEmailValid() && password.isPassWordValid() && cpassword.equals(password)) {
            Toast.makeText(
                applicationContext, R.string.signup_success, Toast.LENGTH_SHORT
            ).show()

        }



    }

    fun backtologin(view: View) {
        finish()
    }
}