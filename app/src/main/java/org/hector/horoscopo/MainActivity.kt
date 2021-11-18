package org.hector.horoscopo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import org.hector.horoscopo.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()

        binding.sendButton.setOnClickListener {
            if (isValidate()) {
                Toast.makeText(this, "validated", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupListeners() {
        binding.userName.addTextChangedListener(TextFieldValidation(binding.userName))
        binding.userBdate.addTextChangedListener(TextFieldValidation(binding.userBdate))
        binding.userCount.addTextChangedListener(TextFieldValidation(binding.userCount))
        binding.userEmail.addTextChangedListener(TextFieldValidation(binding.userEmail))
    }

    private fun isValidate(): Boolean = validateUserName() && validateEmail() && validateCount()

    private fun validateUserName(): Boolean {
        when {
            binding.userName.text.toString().trim().isEmpty() -> {
                binding.userNameTil.error = "Required Field!"
                binding.userName.requestFocus()
                return false
            }
            else -> {
                binding.userNameTil.isErrorEnabled = false
            }
        }
        return true
    }

    private fun validateEmail(): Boolean {
        when {
            binding.userEmail.text.toString().trim().isEmpty() -> {
                binding.userEmailTil.error = "Required Field!"
                binding.userEmail.requestFocus()
                return false
            }
            !FieldValidators.isValidEmail(binding.userEmail.text.toString()) -> {
                binding.userEmailTil.error = "Invalid Email!"
                binding.userEmail.requestFocus()
                return false
            }
            else -> {
                binding.userEmailTil.isErrorEnabled = false
            }
        }
        return true
    }

    private fun validateCount(): Boolean {
        when {
            binding.userCount.text.toString().trim().isEmpty() -> {
                binding.userCountTil.error = "Required Field!"
                binding.userCount.requestFocus()
                return false
            }
            !FieldValidators.isValidCount(binding.userCount.text.toString()) -> {
                binding.userCountTil.error = "Only digits are required"
                binding.userCount.requestFocus()
                return false
            }
            binding.userCount.text.toString().length != 9 -> {
                binding.userCountTil.error = "Your count need to be 9 numbers"
                binding.userCount.requestFocus()
                return false
            }
            else -> {
                binding.userCountTil.isErrorEnabled = false
            }
        }
        return true
    }

    /**
     * applying text watcher on each text field
     */
    inner class TextFieldValidation(private val view: View) : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // checking ids of each text field and applying functions accordingly.
            when (view.id) {
                R.id.user_name -> {
                    validateUserName()
                }
                R.id.user_email -> {
                    validateEmail()
                }
                R.id.user_count -> {
                    validateCount()
                }
            }
        }
    }
}