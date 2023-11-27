package com.github.arief.annuur.guyub.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.form.ModifierForm
import com.github.arief.annuur.guyub.model.ItemBasic
import com.github.arief.annuur.guyub.model.UIField
import com.seiko.imageloader.rememberImagePainter

@Composable
fun GItemList(data: ItemBasic, onItemClick: ((ItemBasic) -> Unit)? = null) {
    val painterUser = rememberImagePainter(data.userField.imgAvatar)

    Row (modifier = ModifierForm.clickable {
        onItemClick?.invoke(data)
    }){
        Image(
            painter = painterUser,
            modifier = Modifier.width(32.dp).height(32.dp)
                .clip(CircleShape),
            contentDescription = "avatar"
        )
        Column {
            Text(text = data.title, modifier = Modifier.padding(start = 8.dp), style = MaterialTheme.typography.subtitle1)
            Text(text = data.userField.username, modifier = Modifier.padding(start = 8.dp), style = MaterialTheme.typography.caption)
        }
        Spacer(Modifier.weight(1f))
        Text(text = "4.m")

    }
}