package com.github.arief.annuur.guyub.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.form.ModifierForm
import com.github.arief.annuur.guyub.model.ItemFeed
import com.seiko.imageloader.rememberImagePainter

@Composable
fun GItemFeed(data: ItemFeed) {

    val painterFeed = rememberImagePainter(data.image)
    val painterUser = rememberImagePainter(data.userField.imgAvatar)

    Column (modifier = ModifierForm) {
        Image(painter = painterFeed,
            modifier = Modifier.fillMaxWidth().height(140.dp),
            contentScale = ContentScale.FillWidth,
            contentDescription = "img-feed")
        Spacer(Modifier.height(10.dp))
        Row {
            Image(
                painter = painterUser,
                modifier = Modifier.width(26.dp).height(26.dp)
                    .clip(CircleShape),
                contentDescription = "avatar"
            )
            Column {
                Text(text = data.title, modifier = Modifier.padding(start = 8.dp), style = MaterialTheme.typography.subtitle1)
                Text(text = data.userField.username, modifier = Modifier.padding(start = 8.dp), style = MaterialTheme.typography.caption)

            }

        }
    }
}