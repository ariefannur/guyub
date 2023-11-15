package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
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
fun GRadioButton(data: FormField.RadioButton) {
    var value by remember { mutableStateOf("") }

    Column {
        Text(data.label, modifier = ModifierForm, fontSize = 17.sp)
        if (data.options.size <= 4) {
            LazyVerticalGrid(modifier = ModifierForm, columns = GridCells.Fixed(2)) {
                items(data.options) {
                    GItemRadio(it, value == it) {
                        value = it
                    }
                }
            }
        } else {
            LazyColumn(modifier = ModifierForm) {
                items(data.options) {
                    GItemRadio(it, value == it) {
                        value = it
                    }
                }
            }
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

    Row (modifier = Modifier.padding(top = 8.dp, bottom = 8.dp).clickable { selected.invoke(text) }){
        Box(modifier = radioModifier)
        Text(text, Modifier.padding(start = 10.dp))
    }
}

