package com.github.arief.annuur.guyub.form.group

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.form.GButton
import com.github.arief.annuur.guyub.form.GDatePicker
import com.github.arief.annuur.guyub.form.GEmail
import com.github.arief.annuur.guyub.form.GLabel
import com.github.arief.annuur.guyub.form.GPassword
import com.github.arief.annuur.guyub.form.GPhoneNumber
import com.github.arief.annuur.guyub.form.GRadioButton
import com.github.arief.annuur.guyub.form.GTextField
import com.github.arief.annuur.guyub.form.GTextFieldOption
import com.github.arief.annuur.guyub.form.ModifierForm
import com.github.arief.annuur.guyub.model.ButtonType
import com.github.arief.annuur.guyub.model.FormField

@Composable
fun GWizardForm(dataWizard: List<List<FormField>>) {

    val viewModel = WizardViewModel()
    viewModel.init(dataWizard)

    val page by viewModel.selectedPage.collectAsState()


    Column (modifier = ModifierForm) {
        Box (modifier = Modifier.fillMaxWidth()
            .height(8.dp)
            .background(
            shape = RoundedCornerShape(size = 16.dp),
            color = Color.LightGray
        )) {
            LazyRow (Modifier.fillMaxWidth().padding(2.dp)){
                items(dataWizard.size) {pos ->
                    val size:Float = 1f / dataWizard.size
                    val startShape = if (pos == 0) 60 else 0
                    val endShape = if (pos == dataWizard.size -1) 60 else 0
                    Box(Modifier.height(6.dp)
                        .fillParentMaxWidth(size)
                        .background(
                            shape = RoundedCornerShape(topStartPercent = startShape, topEndPercent = endShape, bottomStartPercent = startShape, bottomEndPercent = endShape),
                        color = if (pos <= page) MaterialTheme.colors.primary else Color.LightGray
                    ))
                }
            }
        }

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
                    else -> Unit
                }
            }

            item {
                val enableButton by viewModel.enableButtonState.collectAsState()
                val isNext = page < dataWizard.size - 1
                Row (Modifier.padding(top = 20.dp)) {
                    if (page > 0) {
                        GButton(
                            modifier = Modifier.weight(1f),
                            data = FormField.Button(
                                label = "Back",
                                key = "btn_back",
                                required = true,
                                enable = true,
                                buttonType = ButtonType.SECONDARY
                            )
                        ) {
                            viewModel.backPage()
                        }

                        Spacer(Modifier.width(16.dp))
                    }
                    GButton(
                        modifier = if (page == 0) null else Modifier.weight(1f),
                        data = FormField.Button(
                            label = if (isNext) "Next" else "Submit",
                            key = "btn_wizard",
                            required = true,
                            enable = enableButton
                        )
                    ) {
                        if (isNext) viewModel.nextPage()
                    }
                }
            }
        }

    }

}