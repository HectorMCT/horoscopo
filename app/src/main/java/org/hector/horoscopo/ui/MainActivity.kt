package org.hector.horoscopo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import org.hector.horoscopo.R
import org.hector.horoscopo.databinding.ActivityMainBinding
import org.hector.horoscopo.model.User
import org.hector.horoscopo.util.FieldValidators

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()

        binding.userBdate.setOnClickListener {
            showDatePickerDialog()
        }

        binding.sendButton.setOnClickListener {
            validate()
        }
    }

    private fun validate(){
        if (isValidate()) {

            val user = User(binding.userName.text.toString(),
                binding.userEmail.text.toString(),
                binding.userCount.text.toString(),
                binding.userBdate.text.toString())

            Toast.makeText(this, "validated", Toast.LENGTH_SHORT).show()

            intent = Intent(this, HoroscopeActivity::class.java)
            intent.putExtra("USER",user)

            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()
        }
    }

    private fun setupListeners() {
        binding.userName.addTextChangedListener(TextFieldValidation(binding.userName))
        binding.userBdate.addTextChangedListener(TextFieldValidation(binding.userBdate))
        binding.userCount.addTextChangedListener(TextFieldValidation(binding.userCount))
        binding.userEmail.addTextChangedListener(TextFieldValidation(binding.userEmail))
    }

    private fun isValidate(): Boolean = validateUserName() && validateEmail() && validateCount() && validateDate()

    private fun showDatePickerDialog() {

        val newFragment = DatePickerFragment.newInstance { _, year, month, dayOfMonth ->
            binding.userBdate.setText(getString(R.string.date_format, dayOfMonth, month+1, year))
        }
        newFragment.show(supportFragmentManager, "datePicker")
    }

    private fun validateUserName(): Boolean {
        when {
            binding.userName.text.toString().trim().isEmpty() -> {
                binding.userNameTil.error = getString(R.string.required_field)
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
                binding.userEmailTil.error = getString(R.string.required_field)
                binding.userEmail.requestFocus()
                return false
            }
            !FieldValidators.isValidEmail(binding.userEmail.text.toString()) -> {
                binding.userEmailTil.error = getString(R.string.invalid_email)
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
                binding.userCountTil.error = getString(R.string.required_field)
                binding.userCount.requestFocus()
                return false
            }
            !FieldValidators.isValidCount(binding.userCount.text.toString()) -> {
                binding.userCountTil.error = getString(R.string.only_digits)
                binding.userCount.requestFocus()
                return false
            }
            binding.userCount.text.toString().length != 9 -> {
                binding.userCountTil.error = getString(R.string.incorrect_count)
                binding.userCount.requestFocus()
                return false
            }
            else -> {
                binding.userCountTil.isErrorEnabled = false
            }
        }
        return true
    }

    private fun validateDate(): Boolean {
        when {
            binding.userBdate.text.toString().trim().isEmpty() -> {
                binding.userBdateTil.error = getString(R.string.required_field)
                binding.userBdate.requestFocus()
                return false
            }
            !FieldValidators.isValidDate(binding.userBdate.text.toString()) -> {
                binding.userBdateTil.error = getString(R.string.date_error)
                binding.userBdate.requestFocus()
                return false
            }
            else -> {
                binding.userBdateTil.isErrorEnabled = false
            }
        }
        return true
    }

    inner class TextFieldValidation(private val view: View) : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
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
                R.id.user_bdate -> {
                    validateDate()
                }
            }
        }
    }
}