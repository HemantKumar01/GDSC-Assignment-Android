package com.example.gdscassignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var username:TextInputEditText;
    lateinit private var password:EditText;
    lateinit var loginButton:Button;
    lateinit var forgetPassword:TextView;
    lateinit var register:TextView;

    //function for checking passwords
    // returns true if the password is OK else false
    private fun validatePassword(password:String):Boolean{
        if(password.length==0){
            //if password is not given
            Toast.makeText(this,"Password Required", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(password.length < 6){
            //weak password (less than 6 characters
            Toast.makeText(this, "Password should be Atleast 6 characters long", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    //validating username
    // returns false if username is invalid, else true
    private fun validateUsername(username:String):Boolean{
        if(username.length == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false
        }
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        username = findViewById<TextInputEditText>(R.id.username)
        password = findViewById<EditText>(R.id.password)
        loginButton = findViewById<Button>(R.id.loginButton)
        forgetPassword = findViewById<TextView>(R.id.forgetPassword)
        register = findViewById<TextView>(R.id.register_link)

        //underlining the links
        forgetPassword.setText(Html.fromHtml("<u>Forget Password?</u>"))
        register.setText(Html.fromHtml("<u>Don't Have an Account? Register</u>"))

        //login button click logic
        loginButton.setOnClickListener({
            var usernameOK:Boolean = validateUsername(username.text.toString())
            var passwordOK:Boolean = validatePassword(password.text.toString())

            if(usernameOK && passwordOK){
                Toast.makeText(this, "Logged In Successfully!", Toast.LENGTH_SHORT).show();
            }
        })
        //forget Password click logic
        forgetPassword.setOnClickListener({
            Toast.makeText(this,"Do We Have to Make this Also?", Toast.LENGTH_SHORT).show()
        })

        register.setOnClickListener({
            startActivity(Intent(this, RegisterActivity::class.java))
        })
    }
}