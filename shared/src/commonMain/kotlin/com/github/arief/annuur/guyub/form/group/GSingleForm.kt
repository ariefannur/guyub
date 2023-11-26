package com.github.arief.annuur.guyub.form.group

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.github.arief.annuur.guyub.form.GButton
import com.github.arief.annuur.guyub.form.GDatePicker
import com.github.arief.annuur.guyub.form.GEmail
import com.github.arief.annuur.guyub.form.GLabel
import com.github.arief.annuur.guyub.form.GPassword
import com.github.arief.annuur.guyub.form.GPhoneNumber
import com.github.arief.annuur.guyub.form.GRadioButton
import com.github.arief.annuur.guyub.form.GTextField
import com.github.arief.annuur.guyub.form.GTextFieldOption
import com.github.arief.annuur.guyub.model.FormField

@Composable
fun GSingleForm(listData: List<FormField>, outputData: (Map<String, String>) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        val viewModel = SingleFormViewModel()
        viewModel.init(listData)

        val listData by viewModel.datas.collectAsState()

        LazyColumn {
            items(listData) {form ->
                when (form) {
                    is FormField.Label -> GLabel(data = form)
                    is FormField.TextField -> GTextField(data = form) {
                        viewModel.validationForm(it, form)
                    }
                    is FormField.TextFieldOption -> GTextFieldOption(data = form) {
                        form.isError = it
                        viewModel.validationForm(it, form)
                    }
                    is FormField.DatePicker -> GDatePicker(data = form) {
                        form.isError = it
                        viewModel.validationForm(it, form)
                    }
                    is FormField.RadioButton -> GRadioButton(data = form) {
                        viewModel.validationForm(it, form)
                    }
                    is FormField.Password -> GPassword(data = form) {
                        viewModel.validationForm(it.isEmpty(), form)
                        viewModel.setPassword(it, form.type)
                    }
                    is FormField.PhoneNumber -> GPhoneNumber(data = form) {
                        viewModel.validationForm(it, form)
                    }
                    is FormField.Email -> GEmail(data = form) {
                        viewModel.validationForm(it, form)
                    }
                    is FormField.Button -> GButton(data = form) {
                        outputData.invoke(viewModel.getSubmittedValue())
                    }
                }
            }
        }
    }
}