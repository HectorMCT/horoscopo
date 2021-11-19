package org.hector.horoscopo

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.google.android.material.datepicker.MaterialDatePicker
import org.hector.horoscopo.databinding.ActivityMainBinding
import java.util.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val ARG_USERNAME = "USERNAME"
        const val ARG_EMAIL = "EMAIL"
        const val ARG_COUNT = "COUNT"
        const val ARG_DATE = "DATE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()

        binding.userBdate.setOnClickListener { showDatePickerDialog()  }

        binding.sendButton.setOnClickListener {
            if (isValidate()) {
                val arguments = Bundle().apply {
                    putString(ARG_USERNAME, binding.userName.text.toString())
                    putString(ARG_EMAIL, binding.userEmail.text.toString())
                    putString(ARG_COUNT, binding.userCount.text.toString())
                    putString(ARG_DATE, binding.userBdate.text.toString())
                }
                Toast.makeText(this, "validated", Toast.LENGTH_SHORT).show()
                intent = Intent(this, HoroscopeActivity::class.java)
                intent.putExtras(arguments)
                startActivity(intent)
            }
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
        val calendar = Calendar.getInstance()
        val myDay= calendar.get(Calendar.DAY_OF_MONTH)
        val myMonth = calendar.get(Calendar.MONTH)
        val myYear = calendar.get(Calendar.YEAR)

        val datePicker = DatePickerDialog(this, { _, year, month, dayOfMonth ->
            binding.userBdate.setText(getString(R.string.date_format, dayOfMonth, month, year))
        }, myYear, myMonth, myDay)
        datePicker.show()
    }

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

    private fun validateDate(): Boolean {
        when {
            binding.userBdate.text.toString().trim().isEmpty() -> {
                binding.userBdateTil.error = "Required Field!"
                binding.userBdate.requestFocus()
                return false
            }
            !FieldValidators.isValidDate(binding.userBdate.text.toString()) -> {
                binding.userBdateTil.error = "Bad format date!"
                binding.userBdate.requestFocus()
                return false
            }
            else -> {
                binding.userBdateTil.isErrorEnabled = false
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
                R.id.user_bdate -> {
                    validateDate()
                }
            }
        }
    }
}