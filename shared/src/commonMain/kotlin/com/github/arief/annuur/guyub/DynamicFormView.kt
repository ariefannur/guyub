package com.github.arief.annuur.guyub

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.field.StyledTextField

/**
 * Created by Arief Maffrudin A N on 12/09/23.
 */

@Composable
fun DynamicFormView() {
    MaterialTheme {
        var clickText by remember {
            mutableStateOf("Halo:")
        }
        var text by remember { mutableStateOf(TextFieldValue("")) }
        var text1 by remember { mutableStateOf(TextFieldValue("")) }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize().padding(16.dp),
        ) {
            // Add a single item
            item {
                Column() {
                    OutlinedTextField(
                        value = text,
                        onValueChange = { newValue ->
                            text = newValue
                        },
                        label = {
                            Text("Title label")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        isError = true,
                    )
                    Text("error message", color = Color.Red)
                }
            }

            // Add 5 items
            items(5) { index ->
                Text(text = "Item: $index")
            }

            // Add another single item
            item {
                StyledTextField(
                    label = "Form Sample",
                    value = text1,
                    onValueChange = { newValue ->
                        text1 = newValue
                    },
                    errorMessage = "",
                    modifier = Modifier.fillMaxWidth(),
                    option = listOf("Ini", "Itu")
                )
            }
        }
    }
}