package com.example.bc_parking1beta.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bc_parking.R
import com.example.bc_parking1beta.ParkItemViewModel
import com.example.bc_parking1beta.domain.ParkItem
import com.google.android.material.textfield.TextInputLayout

class ParkItemActivity: AppCompatActivity(), ParkItemFragment.OnEditingFinishedListener {

    private lateinit var viewModel: ParkItemViewModel
    private lateinit var onEditingFinishedListener: ParkItemFragment.OnEditingFinishedListener

    private lateinit var tilName: TextInputLayout
    private lateinit var tilFirm: TextInputLayout
    private lateinit var tilDateFrom: TextInputLayout
    private lateinit var tilDateTo: TextInputLayout
    private lateinit var tilAbout: TextInputLayout
    private lateinit var etName: EditText
    private lateinit var etFirm: EditText
    private lateinit var etDateFrom: EditText
    private lateinit var etDateTo: EditText
    private lateinit var tvDateToMain: TextView
    private lateinit var etAbout: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonClear: Button

    private var screenMode = MODE_UNKNOWN
    private var parkItemId = ParkItem.UNDEFINED_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_park_item)
        parseIntent()
        viewModel = ViewModelProvider(this)[ParkItemViewModel::class.java]
        initViews()
        addTextChangeListeners()
        launchEditMode()
        observeViewModel()
//        if (savedInstanceState== null) {
//            launchEditMode()
//        }
    }



//    private fun launchRightMode() {
//        val fragment = when (screenMode) {
//            MODE_EDIT -> ParkItemFragment.newInstanceEditItem(parkItemId)
//            MODE_ADD -> ParkItemFragment.newInstanceAddItem()
//            else -> throw RuntimeException("Unknown screen mode $screenMode")
//        }
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.p_item_container_item_container, fragment)
//            .commit()
//    }

    private fun launchEditMode() {
        viewModel.getParkItem(parkItemId)
//        Set Enabled if EtName is Busy   with <t>
        val t : Boolean = etName.textSize < 1
        viewModel.parkItem.observe(this) {
            etName.setText(it.name)
            etFirm.setText(it.firm)
            etDateFrom.setText(it.dateFrom)
            etDateTo.setText(it.dateTo)
//            tvDateToMain.text = it.dateTo
            etAbout.setText(it.about)
        }
        buttonSave.setOnClickListener {
            viewModel.editParkItem(
                etName.text?.toString(),
                etFirm.text?.toString(),
                etDateFrom.text?.toString(),
                etDateTo.text?.toString(),
                etAbout.text?.toString(),
                enabled = t
            )
//            tvDateToMain.text?.toString()
        }
        buttonClear.setOnClickListener {
            viewModel.parkItem.observe(this) {
                etName.setText(TEXT)
                etFirm.setText(TEXT)
                etDateFrom.setText(TEXT)
                etDateTo.setText(TEXT)
//                tvDateToMain.text = "CLEAR"
            }
//            tvDateToMain.text?.toString()
        }
    }

    private fun observeViewModel() {
        viewModel.errorInputName.observe(this) {
            val message = if (it) {
                getString(R.string.error_input_name)
            } else {
                null
            }
            tilName.error = message
        }
        viewModel.errorInputFirm.observe(this) {
            val message = if (it) {
                getString(R.string.error_input_name)
            } else {
                null
            }
            tilFirm.error = message
        }
        viewModel.errorInputDateFrom.observe(this) {
            val message = if (it) {
                getString(R.string.error_input_name)
            } else {
                null
            }
            tilDateFrom.error = message
        }
        viewModel.errorInputDateTo.observe(this) {
            val message = if (it) {
                getString(R.string.error_input_name)
            } else {
                null
            }
            tilDateTo.error = message
        }
        viewModel.errorInputAbout.observe(this) {
            val message = if (it) {
                getString(R.string.error_input_count)
            } else {
                null
            }
            tilAbout.error = message
        }
//        viewModel.shouldCloseScreen.observe(this) {
//
//        }
    }

    override fun onEditingFinished() {
        finish()
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
    }

    private fun addTextChangeListeners() {
        etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputName()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        etFirm.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputFirm()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        etDateFrom.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputDateFrom()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        etDateTo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputDateTo()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        etAbout.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputCount()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun parseIntent() {
        if (!intent.hasExtra(SCREEN_MODE)) {
            throw RuntimeException("Param screen mode is absent")
        }
        val mode = intent.getStringExtra(SCREEN_MODE)
        if (mode != MODE_EDIT && mode != MODE_ADD) {
            throw RuntimeException("Unknown screen mode $mode")
        }
        screenMode = mode
        if (screenMode == MODE_EDIT) {
            if (!intent.hasExtra(PARK_ITEM_ID)) {
                 throw RuntimeException("Param park item id is absent")
            }
            parkItemId = intent.getIntExtra(PARK_ITEM_ID, ParkItem.UNDEFINED_ID)
        }
    }

    private fun initViews() {
        tilName = findViewById(R.id.til_name)
        tilFirm = findViewById(R.id.til_firm)
        tilAbout = findViewById(R.id.til_about)
        tilDateFrom =findViewById(R.id.til_date_from)
        tilDateTo =findViewById(R.id.til_date_to)
        etName = findViewById(R.id.et_name)
        etFirm = findViewById(R.id.et_firm)
        etDateFrom = findViewById(R.id.et_date_from)
        etDateTo = findViewById(R.id.et_date_to)
//        tvDateToMain = findViewById(R.id.tv_date_to_main)
        etAbout =findViewById(R.id.et_about)
        buttonSave = findViewById(R.id.save_button)
        buttonClear = findViewById(R.id.clear_button)
    }

    companion object {
        private const val TEXT = "clear"
        private const val SCREEN_MODE = "extra_mode"
        private const val PARK_ITEM_ID = "extra_park_item_Id"
        private const val MODE_EDIT = "mode_edit"
        private const val MODE_ADD = "mode_add"
        private const val MODE_UNKNOWN = ""

        fun newIntentAddItem(context: Context): Intent {
            val intent = Intent(context, ParkItemActivity::class.java)
            intent.putExtra(SCREEN_MODE, MODE_ADD)
            return intent
        }

        fun newIntentEditItem(context: Context, parkItemId: Int): Intent {
            val intent = Intent(context, ParkItemActivity::class.java)
            intent.putExtra(SCREEN_MODE, MODE_EDIT)
            intent.putExtra(PARK_ITEM_ID, parkItemId)
            return intent
        }

    }
}
