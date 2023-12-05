package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.github.arief.annuur.guyub.model.FormField

@Composable
fun GTextFieldOption(data: FormField.TextFieldOption, validField: ((Boolean) -> Unit)? = null) {
    var text by remember { mutableStateOf(data.value) }
    var showDialog by remember { mutableStateOf(false) }

    Column {
        Box(modifier = ModifierForm) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().onFocusChanged {
                    if (it.isFocused) {
                        showDialog = true
                    }
                },
                value = text,
                onValueChange = {
                    text = it
                    validField?.invoke(it.isNotEmpty())
                },
                readOnly = true,
                label = { Text(data.label) },
                isError = text.isEmpty()
            )
            IconButton(modifier = Modifier.align(Alignment.CenterEnd), onClick = {
                showDialog = true
            } ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = ""
                )
            }
        }
        if (text.isEmpty() && data.required)
            Text(data.message, modifier = Modifier.padding(start = 16.dp, end = 16.dp), color = Color.Red)
    }

    if (showDialog) {
        BottomSheetOption(onDismiss = { showDialog = false },
            options = data.options, onSelected = {
                data.value = it
                text = it
            }
        )
    }
}

@Composable
fun BottomSheetOption(onDismiss: () -> Unit, options: List<String>, onSelected: (String) -> Unit) {
    AlertDialog(
        onDismissRequest = {
        onDismiss.invoke()
    }, properties = DialogProperties(usePlatformDefaultWidth = false),
        text = {
            LazyColumn  {
                items(options) {
                     Text(it, fontSize = 14.sp, modifier =  Modifier.fillMaxWidth().padding(8.dp).clickable {
                         onSelected.invoke(it)
                         onDismiss.invoke()
                     })
                }
            }
        },
       confirmButton = {},
       modifier = Modifier.customDialogModifier(CustomDialogPosition.BOTTOM).padding(start = 8.dp, end = 8.dp),
       shape = RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp)
    )
}