package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.arief.annuur.guyub.model.FormField

@Composable
fun GRadioButton(data: FormField.RadioButton, validField: ((Boolean) -> Unit)? = null) {
    var value by remember { mutableStateOf("") }

    Column(modifier = ModifierForm) {
        Text(data.label, fontSize = 17.sp)
        if (data.options.size <= 4) {
            val list = mutableListOf<Pair<String, String>>()
            val iterator = data.options.iterator()
            while (iterator.hasNext()) {
                val start = iterator.next()
                val end = if (iterator.hasNext()) iterator.next() else ""
                list.add(Pair(start, end))
            }

            list.forEach {
                val first = it.first
                val second = it.second
                Row {
                    if (first.isNotEmpty())
                        GItemRadio(first, value == first) {
                            value = it
                            data.value = it
                            validField?.invoke(true)
                        }
                    Spacer(Modifier.padding(start = 16.dp))
                    if (second.isNotEmpty())
                        GItemRadio(second, value == second) {
                            value = it
                            data.value = it
                            validField?.invoke(true)
                        }
                }
            }

        } else {
            data.options.forEach {
                GItemRadio(it, value == it) {
                    value = it
                    data.value = it
                    validField?.invoke(true)
                }
            }
        }
        if (value.isEmpty() && data.required) {
            Text(data.message, color = Color.Red)
        }
    }
}

@Composable
private fun GItemRadio(text: String, isSelected: Boolean, selected: (String)-> Unit) {
    val radioModifier =  if (isSelected) {
        Modifier.size(16.dp).clip(CircleShape).background(Color.Gray)
    } else {
        Modifier.size(16.dp).clip(CircleShape).border(0.2.dp, Color.LightGray)
    }

    Row (modifier = Modifier.padding(top = 12.dp, bottom = 12.dp).clickable { selected.invoke(text) }){
        Box(modifier = radioModifier)
        Text(text, Modifier.padding(start = 10.dp))
    }
}

