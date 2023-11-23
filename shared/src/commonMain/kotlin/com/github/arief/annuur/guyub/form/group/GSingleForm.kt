package com.github.arief.annuur.guyub.form.group

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.github.arief.annuur.guyub.form.GDatePicker
import com.github.arief.annuur.guyub.form.GRadioButton
import com.github.arief.annuur.guyub.form.GTextField
import com.github.arief.annuur.guyub.form.GTextFieldOption
import com.github.arief.annuur.guyub.form.ModifierForm
import com.github.arief.annuur.guyub.model.FormField

@Composable
fun GSingleForm(listData: List<FormField>) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        val viewModel = SingleFormViewModel()
        viewModel.init(listData)

        LazyColumn {
            items(viewModel.datas.value) {form ->
                when (form) {
                    is FormField.TextField -> GTextField(data = form) {
                        viewModel.checkButton(it, form)
                    }
                    is FormField.TextFieldOption -> GTextFieldOption(data = form) {
                        form.isError = it
                        viewModel.checkButton(it, form)
                    }
                    is FormField.DatePicker -> GDatePicker(data = form) {
                        form.isError = it
                        viewModel.checkButton(it, form)
                    }
                    is FormField.RadioButton -> GRadioButton(data = form) {
                        viewModel.checkButton(it, form)
                    }
                }
            }
            item {
                Button(modifier = ModifierForm.fillMaxWidth(), onClick = {

                }, enabled = viewModel.enableButton.collectAsState().value) {
                    Text(text = "Submit")
                }
            }
        }
    }
}