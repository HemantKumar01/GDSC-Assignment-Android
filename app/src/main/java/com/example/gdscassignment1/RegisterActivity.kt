package com.example.gdscassignment1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var username = findViewById<TextInputEditText>(R.id.username_reg)
        var email = findViewById<EditText>(R.id.email_reg)
        var password = findViewById<EditText>(R.id.password_reg)
        var confirm_password = findViewById<EditText>(R.id.password_reg_conf)
        var password_feedback = findViewById<TextView>(R.id.password_feedback);
        var register_button = findViewById<Button>(R.id.register_button)
        var login_link = findViewById<TextView>(R.id.login_link);

        login_link.setOnClickListener({
            startActivity(Intent(this, MainActivity::class.java));
        })

        confirm_password.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var password_val = s.toString();
                if(password.text.toString() != confirm_password.text.toString()){
                    password_feedback.text = "Passwords do not match"
                }else{
                    password_feedback.setTextColor(Color.parseColor("#00cc55"));
                    password_feedback.text = "Both Passwords Match"
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })



        register_button.setOnClickListener {
            var username_OK = true;
            var email_OK = true;
            var password_OK = true;
            if(username.text.toString().length == 0){
                Toast.makeText(this, "Username required", Toast.LENGTH_SHORT).show();
                username_OK = false
            }
            if(email.text.toString().length == 0){
                Toast.makeText(this, "Email required", Toast.LENGTH_SHORT).show();
                email_OK = false
            }
            var password_validation_text = "";

            if(password.text.toString() != confirm_password.text.toString()){
                password_validation_text = "Passwords do not match";
                password_OK = false
            }
            if(password.text.toString().length< 6){
                password_validation_text = "Password must be atleast 6 characters long";
                password_OK = false
            }
            if(password.text.toString().length == 0){
                password_validation_text = "Password Required";
                password_OK = false
            }
            if(!password_OK){
                Toast.makeText(this, password_validation_text, Toast.LENGTH_SHORT).show();
            }
            if(username_OK && email_OK && password_OK)
            {
                Toast.makeText(this, "Registered Successfully.", Toast.LENGTH_SHORT).show();
            }
        }





    }
}