package org.hector.horoscopo.ui

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*

class DatePickerFragment : DialogFragment() {

    private var listener: DatePickerDialog.OnDateSetListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Selected date (initial value)
        val datePickerDialog = DatePickerDialog(activity as Context, listener, year - 0, month, day)

        // Min and max date
        calendar.set(Calendar.YEAR, year - 100)
        datePickerDialog.datePicker.minDate = calendar.timeInMillis
        calendar.set(Calendar.YEAR, year)
        datePickerDialog.datePicker.maxDate = calendar.timeInMillis

        return datePickerDialog

    }

    companion object {
        fun newInstance(listener: DatePickerDialog.OnDateSetListener): DatePickerFragment {
            val fragment = DatePickerFragment()
            fragment.listener = listener
            return fragment
        }
    }

}