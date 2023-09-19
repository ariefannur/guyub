package com.github.arief.annuur.guyub.field

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

/**
 * Created by Arief Maffrudin A N on 13/09/23.
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StyledTextField(
    label: String,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    errorMessage: String,
    modifier: Modifier,
    option: List<String>
) {
    val isError = errorMessage.isNotEmpty()
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    Column {
        Text(label, modifier = Modifier.padding(bottom = 10.dp, top = 16.dp), style = MaterialTheme.typography.body1)
        Box {
            BasicTextField(
                value = value,
                textStyle = MaterialTheme.typography.body1,
                onValueChange = onValueChange,
                singleLine = true,
                modifier = modifier.border(
                    BorderStroke(
                        1.dp,
                        if (isError) Color.Red else Color(0xffc9c9c9)
                    ), RoundedCornerShape(4.dp)
                ).padding(top = 16.dp, start = 16.dp, bottom = 16.dp, end = if (option.isNotEmpty()) 32.dp else 16.dp),
            )
            if (option.isNotEmpty()) Icon(Icons.Filled.KeyboardArrowDown, "dropdown", Modifier.align(Alignment.CenterEnd).padding(end = 8.dp).clickable {
//                ModalBottomSheetLayout(
//                    sheetState = state,
//                    sheetContent = {
//                        LazyColumn {
//                            item(option.size) {
//                                Text()
//                            }
//                        }
//                    }
//                )
            })
        }
        if (isError)
            Text(errorMessage, color = Color.Red, style = MaterialTheme.typography.subtitle1)
    }
}