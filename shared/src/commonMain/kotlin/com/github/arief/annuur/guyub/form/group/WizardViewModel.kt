package com.github.arief.annuur.guyub.form.group

import com.github.arief.annuur.guyub.model.FormField
import com.github.arief.annuur.guyub.model.PasswordType
import kotlinx.coroutines.flow.MutableStateFlow

class WizardViewModel {
    var datas = MutableStateFlow(listOf<FormField>())
    var selectedPage = MutableStateFlow(0)
    private var mapData = mutableMapOf<String, FormField>()
    private var password = ""
    private var buttonField: FormField.Button? = null
    var enableButtonState = MutableStateFlow(false)
    private var dataWizard: MutableList<List<FormField>> = mutableListOf()

    private var values: MutableList<Map<String, String>> = mutableListOf()

    fun init(data: List<List<FormField>>) {
        this.dataWizard = data.toMutableList()
        datas.value = dataWizard[selectedPage.value]
    }

    fun validationForm(isError: Boolean, form: FormField) {
        // convert to map
        mapData = dataWizard[selectedPage.value].associateBy { it.key }.toMutableMap()
        val updateField = mapData[form.key]
        updateField?.let {
            it.isError = isError
            mapData[form.key] = it
        }

        val enableButton = if (isError) false
        else {
            for (i in 0.until(datas.value.size)) {
                if (datas.value[i].isError) false
                else continue
            }
            true
        }

        buttonField?.let {
//            update the button
            val updateButton = mapData[it.key] as FormField.Button
            buttonField = FormField.Button(updateButton.label, updateButton.key, updateButton.required, enableButton)
            mapData[it.key] = buttonField!!
        }

        enableButtonState.value = enableButton

        println("MAP : ${mapData.values.size}")

//    update list based on map
        datas.value = mapData.values.toList()
    }

    fun setPassword(pass: String, type: PasswordType): Boolean {
        return if (type == PasswordType.PASSWORD) {
            password = pass
            true
        } else {
            val isCorrect = pass == password
            updatePasswordComponent(isCorrect)
            isCorrect
        }
    }

    private fun updatePasswordComponent(correct: Boolean) {
        val data = datas.value
        data.forEach {
            if (it is FormField.Password) {
                it.isError = !correct
                it.message = "Please recheck your password"
            }
        }
        datas.value = data
    }

    fun nextPage() {
        if (selectedPage.value < dataWizard.size) {
            // save value
            values.add(
                dataWizard[selectedPage.value].associate {
                    it.key to it.value
                }
            )
            println("VALUE :: $values")

            selectedPage.value += 1
            enableButtonState.value = false

            datas.value = dataWizard[selectedPage.value]
        }

    }

    private fun getValues(page: Int): Map<String, String> {
        return values[page]
    }

    fun getAllValues(): Map<String, String> {
        val map = mutableMapOf<String, String>()
        values.forEach {
            map.putAll(it)
        }
        return map
    }

    private fun resetValue() {
        val value = getValues(selectedPage.value)
        for (i in 0.until(dataWizard[selectedPage.value].size)) {
            dataWizard[selectedPage.value][i].apply {
                if (this !is FormField.Label || this !is FormField.Button)
                this.value = value.getValue(this.key)
            }
        }
        datas.value = dataWizard[selectedPage.value]
    }

    fun backPage() {
        if (selectedPage.value > 0) {
            selectedPage.value -= 1
            enableButtonState.value = false
            datas.value = dataWizard[selectedPage.value]
            resetValue()
        }
    }
}